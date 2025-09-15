package InterfacesAdministradoresOperadores;

import Clases.Conexion;
import Clases.Producto;
import Clases.Pedido;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ventanaCrudPedidos extends javax.swing.JFrame {

    public ventanaCrudPedidos(Menu menu) {
        try {
            initComponents();
            setLocationRelativeTo(null);

            textFieldPeso.setEditable(false);

            tbPedidos.getTableHeader().setReorderingAllowed(false);
            tbPedidos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
            tbPedidos.getTableHeader().setForeground(new Color(0, 51, 102));
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbPedidos.getTableHeader().getDefaultRenderer();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);

            this.menu = menu;

            cargarComboClientes();
            cargarComboCamiones();
            cargarProductos();

            DefaultTableModel modelo = Pedido.cargarTabla();
            tbPedidos.setModel(modelo);

            btnEditar.setEnabled(false);

            tbPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    cargarDatosSeleccionados();
                }
            });

            limpiar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en la inicialización: " + ex.getMessage());
        }
    }

    // CRUDs
    public void agregar() throws Exception {
        String idClienteStr = comboBoxIdCliente.getSelectedItem().toString();
        String direccion = textFieldDireccion.getText();
        calcularPesoTotal();
        String pesoStr = textFieldPeso.getText();
        String estado = comboBoxEstado.getSelectedItem().toString();
        String idCamionStr = comboBoxCamion.getSelectedItem().toString();

        if (idClienteStr.isEmpty() || direccion.isEmpty() || pesoStr.isEmpty()) {
            throw new Exception("Debe llenar todos los campos.");
        }

        int idCliente = Integer.parseInt(idClienteStr.split(" - ")[0]);
        double peso = Double.parseDouble(pesoStr);
        int idCamion = Integer.parseInt(idCamionStr.split(" - ")[0]);

        validarStockProductos();

        double capacidadCamion = obtenerCapacidadCamion(idCamion);
        if (peso > capacidadCamion) {
            throw new Exception("El peso excede la capacidad del camión (" + capacidadCamion + " kg).");
        }

        // Insertar el pedido principal
        Pedido nuevo = new Pedido(idCliente, direccion, peso);
        nuevo.setEstado(estado);
        nuevo.setIdCamion(idCamion);
        nuevo.agregarPedido();  // Insertas el pedido y se obtiene el ID generado

        // Insertar los productos asociados al pedido en Pedido_Producto
        Conexion conexion = new Conexion();
        try {
            String insertarProducto = "INSERT INTO Pedido_Producto (id_Pedido, id_Producto, cantidad) VALUES (?,?,?)";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(insertarProducto);

            for (int i = 0; i < tbProductos.getRowCount(); i++) {
                Object cantidadObj = tbProductos.getValueAt(i, 8);
                if (cantidadObj != null && !cantidadObj.toString().isEmpty()) {
                    int cantidad = Integer.parseInt(cantidadObj.toString());
                    if (cantidad > 0) {
                        int idProducto = Integer.parseInt(tbProductos.getValueAt(i, 0).toString());

                        ps.setInt(1, nuevo.getId());
                        ps.setInt(2, idProducto);
                        ps.setInt(3, cantidad);
                        ps.executeUpdate();

                        // Actualizar el stock del producto
                        actualizarStockProducto(idProducto, cantidad);
                    }
                }
            }

            JOptionPane.showMessageDialog(this, "Pedido creado con productos asociados correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al asociar productos: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        actualizarTabla();
        cargarProductos();
        limpiar();
    }

    public void editar() throws Exception {
        int fila = tbPedidos.getSelectedRow();
        if (fila == -1) {
            throw new Exception("Debe seleccionar un pedido para editar.");
        }

        int id = Integer.parseInt(tbPedidos.getValueAt(fila, 0).toString());
        String idClienteStr = comboBoxIdCliente.getSelectedItem().toString();
        String direccion = textFieldDireccion.getText();
        calcularPesoTotal();
        String pesoStr = textFieldPeso.getText();
        String estado = comboBoxEstado.getSelectedItem().toString();
        String idCamionStr = comboBoxCamion.getSelectedItem().toString();

        if (idClienteStr.isEmpty() || direccion.isEmpty() || pesoStr.isEmpty()) {
            throw new Exception("Debe llenar todos los campos.");
        }

        int idCliente = Integer.parseInt(idClienteStr.split(" - ")[0]);
        double peso = Double.parseDouble(pesoStr);
        int idCamion = Integer.parseInt(idCamionStr.split(" - ")[0]);

        validarStockProductos();

        double capacidadCamion = obtenerCapacidadCamion(idCamion);
        if (peso > capacidadCamion) {
            throw new Exception("El peso excede la capacidad del camión (" + capacidadCamion + " kg).");
        }

        Pedido pedido = new Pedido(id, idCliente, direccion, peso, estado, idCamion);
        pedido.modificarPedido();

        actualizarTabla();
        limpiar();
    }

    public void eliminar() {
        try {
            int fila = tbPedidos.getSelectedRow();
            if (fila == -1) {
                throw new Exception("Debe seleccionar un pedido para eliminar.");
            }

            int id = Integer.parseInt(tbPedidos.getValueAt(fila, 0).toString());
            Pedido pedido = new Pedido(id);
            pedido.eliminarPedido();

            actualizarTabla();
            limpiar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
        }
    }

    public void limpiar() {
        comboBoxIdCliente.setSelectedIndex(0);
        textFieldDireccion.setText("");
        textFieldPeso.setText("");
        comboBoxEstado.setSelectedIndex(0);
        comboBoxCamion.setSelectedIndex(0);
        btnCrear.setEnabled(true);
        btnEditar.setEnabled(false);
    }

    public void actualizarTabla() throws Exception {
        DefaultTableModel modelo = Pedido.cargarTabla();
        tbPedidos.setModel(modelo);
        tbPedidos.getColumnModel().getColumn(6).setPreferredWidth(250);
    }

    // Carga de Info
    private void actualizarStockProducto(int idProducto, int cantidadVendida) throws Exception {
        Conexion conexion = new Conexion();
        try {
            String updateStock = "UPDATE Producto SET cantidad = cantidad - ?, disponible = (CASE WHEN cantidad - ? > 0 THEN 1 ELSE 0 END) WHERE id_Producto = ?";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(updateStock);

            ps.setInt(1, cantidadVendida);
            ps.setInt(2, cantidadVendida);
            ps.setInt(3, idProducto);

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar stock: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    public void cargarDatosSeleccionados() {
        int fila = tbPedidos.getSelectedRow();
        btnEditar.setEnabled(true);
        btnCrear.setEnabled(false);

        comboBoxIdCliente.setSelectedItem(tbPedidos.getValueAt(fila, 1).toString());
        textFieldDireccion.setText(tbPedidos.getValueAt(fila, 2).toString());
        textFieldPeso.setText(tbPedidos.getValueAt(fila, 3).toString());
        comboBoxEstado.setSelectedItem(tbPedidos.getValueAt(fila, 4).toString());
        comboBoxCamion.setSelectedItem(tbPedidos.getValueAt(fila, 5) != null ? tbPedidos.getValueAt(fila, 5).toString() : "");
    }

    private void cargarComboClientes() throws Exception {
        comboBoxIdCliente.removeAllItems();
        Conexion conexion = new Conexion();
        try {
            String query = "SELECT id_Cliente, nombre FROM Clientes";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_Cliente");
                String nombre = rs.getString("nombre");
                comboBoxIdCliente.addItem(id + " - " + nombre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    private void cargarComboCamiones() throws Exception {
        comboBoxCamion.removeAllItems();
        Conexion conexion = new Conexion();
        try {
            String query = "SELECT id_Camion, placa FROM Camion";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_Camion");
                String placa = rs.getString("placa");
                comboBoxCamion.addItem(id + " - " + placa);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar camiones: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    private void cargarProductos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[]{"ID", "Nombre", "Descripción", "Cantidad Disponible", "Peso", "Unidad", "Precio", "Disponible", "Cantidad a Pedir"}, 0
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return column == 8;
                }
            };

            DefaultTableModel modeloBD = Producto.cargarTabla();
            for (int i = 0; i < modeloBD.getRowCount(); i++) {
                Object[] fila = new Object[9];
                for (int j = 0; j < 8; j++) {
                    fila[j] = modeloBD.getValueAt(i, j);
                }
                fila[8] = "";
                modelo.addRow(fila);
            }

            tbProductos.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
        }
    }

    // Calculos 
    public double obtenerCapacidadCamion(int idCamion) throws Exception {
        Conexion conexion = new Conexion();
        double capacidad = 0;
        try {
            String query = "SELECT capacidadMaxima FROM Camion WHERE id_Camion = ?";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(query);
            ps.setInt(1, idCamion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                capacidad = rs.getDouble("capacidadMaxima");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener capacidad del camión: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return capacidad;
    }

    private void calcularPesoTotal() {
        double pesoTotal = 0.0;
        for (int i = 0; i < tbProductos.getRowCount(); i++) {
            Object pesoObj = tbProductos.getValueAt(i, 4);
            Object cantidadObj = tbProductos.getValueAt(i, 8);
            if (pesoObj != null && cantidadObj != null && !cantidadObj.toString().isEmpty()) {
                try {
                    double peso = Double.parseDouble(pesoObj.toString());
                    int cantidad = Integer.parseInt(cantidadObj.toString());
                    pesoTotal += peso * cantidad;
                } catch (NumberFormatException ex) {
                }
            }
        }
        textFieldPeso.setText(String.valueOf(pesoTotal));
    }

    private void validarStockProductos() throws Exception {
        for (int i = 0; i < tbProductos.getRowCount(); i++) {
            Object cantidadObj = tbProductos.getValueAt(i, 8);
            if (cantidadObj != null && !cantidadObj.toString().isEmpty()) {
                int cantidad = Integer.parseInt(cantidadObj.toString());
                int disponible = Integer.parseInt(tbProductos.getValueAt(i, 3).toString());
                if (cantidad > disponible) {
                    throw new Exception("La cantidad pedida de " + tbProductos.getValueAt(i, 1)
                            + " excede la cantidad disponible (" + disponible + ").");
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboBoxIdCliente = new javax.swing.JComboBox<>();
        textFieldDireccion = new javax.swing.JTextField();
        textFieldPeso = new javax.swing.JTextField();
        comboBoxEstado = new javax.swing.JComboBox<>();
        comboBoxCamion = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSimularEntrega = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CREACION DE PEDIDOS");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID CLIENTE");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DIRECCION ENTREGA");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("PESO TOTAL");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ESTADO");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CAMION ASIGNADO");

        comboBoxIdCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        textFieldDireccion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        textFieldPeso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        textFieldPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPesoActionPerformed(evt);
            }
        });

        comboBoxEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDIENTE", "ASIGNADO", "ENTREGADO" }));

        comboBoxCamion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldPeso)
                                    .addComponent(comboBoxIdCliente, 0, 112, Short.MAX_VALUE))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addComponent(textFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBoxCamion, comboBoxEstado, comboBoxIdCliente, textFieldDireccion, textFieldPeso});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(textFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboBoxCamion, comboBoxEstado, comboBoxIdCliente, textFieldDireccion, textFieldPeso});

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 260));

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));

        btnCrear.setBackground(new java.awt.Color(255, 255, 255));
        btnCrear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 0, 0));
        btnCrear.setText("CREAR");
        btnCrear.setBorderPainted(false);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ACCIONES");

        btnSimularEntrega.setBackground(new java.awt.Color(255, 255, 255));
        btnSimularEntrega.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSimularEntrega.setForeground(new java.awt.Color(0, 0, 0));
        btnSimularEntrega.setText("SIMULACION");
        btnSimularEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSimularEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(76, 76, 76))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCrear, btnEditar, btnEliminar, btnLimpiar, btnRegresar});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(119, 119, 119)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimularEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addGap(161, 161, 161))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCrear, btnEditar, btnEliminar, btnLimpiar, btnRegresar});

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 250, 580));

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbProductos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 720, 330));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbPedidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbPedidosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbPedidos);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("GESTION DE PEDIDOS EXISTENTES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(169, 169, 169))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 700, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPesoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            agregar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            editar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tbPedidosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidosMousePressed
        int fila = tbPedidos.getSelectedRow();
        if (fila != -1) {
            btnEditar.setEnabled(true);
            btnCrear.setEnabled(false);

            // Cargar datos de la fila en los campos
            comboBoxIdCliente.setSelectedItem(tbPedidos.getValueAt(fila, 1).toString());
            textFieldDireccion.setText(tbPedidos.getValueAt(fila, 2).toString());
            textFieldPeso.setText(tbPedidos.getValueAt(fila, 3).toString());
            comboBoxEstado.setSelectedItem(tbPedidos.getValueAt(fila, 4).toString());

            String idCamion = (tbPedidos.getValueAt(fila, 5) != null) ? tbPedidos.getValueAt(fila, 5).toString() : "";
            comboBoxCamion.setSelectedItem(idCamion);
        }
    }//GEN-LAST:event_tbPedidosMousePressed

    private void btnSimularEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularEntregaActionPerformed

        SimulacionEntrega simulacion = new SimulacionEntrega(this);
        simulacion.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnSimularEntregaActionPerformed

    Menu menu = new Menu();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSimularEntrega;
    private javax.swing.JComboBox<String> comboBoxCamion;
    private javax.swing.JComboBox<String> comboBoxEstado;
    private javax.swing.JComboBox<String> comboBoxIdCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField textFieldDireccion;
    private javax.swing.JTextField textFieldPeso;
    // End of variables declaration//GEN-END:variables
}
