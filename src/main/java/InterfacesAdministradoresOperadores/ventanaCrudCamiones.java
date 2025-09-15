package InterfacesAdministradoresOperadores;

import Clases.Camion;
import Clases.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ventanaCrudCamiones extends javax.swing.JFrame {

    public ventanaCrudCamiones(Menu menu) throws Exception {
        initComponents();
        setLocationRelativeTo(null);

        tbCamiones.getTableHeader().setReorderingAllowed(false);
        tbCamiones.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tbCamiones.getTableHeader().setForeground(new Color(0, 51, 102));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbCamiones.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        this.menu = menu;

        actualizarTabla();

        btnEditar.setEnabled(false);

        tbCamiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cargarDatosSeleccionados();
            }
        });

        limpiar();
    }
    
    
    // CRUDs
    
     public void agregar() throws Exception {
    String placa = textFieldPlaca.getText();
        String modeloCamion = textFieldModelo.getText();
        String capacidadStr = textFieldCapacidad.getText();

        if (placa.isEmpty() || modeloCamion.isEmpty() || capacidadStr.isEmpty()) {
            throw new Exception("Debe llenar todos los campos.");
        }

        double capacidad = Double.parseDouble(capacidadStr);

        Conexion conexion = new Conexion();
        try {
            String query = "INSERT INTO Camion (placa, modelo, capacidadMaxima) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(query);
            ps.setString(1, placa);
            ps.setString(2, modeloCamion);
            ps.setDouble(3, capacidad);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error al agregar: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        actualizarTabla();
        limpiar();
    }

    public void eliminar() throws Exception {
        int fila = tbCamiones.getSelectedRow();
        if (fila == -1) {
            throw new Exception("Debe seleccionar un camión para eliminar.");
        }

        int id = Integer.parseInt(tbCamiones.getValueAt(fila, 0).toString());

        Conexion conexion = new Conexion();
        try {
            String query = "DELETE FROM Camion WHERE id_Camion = ?";
            java.sql.PreparedStatement ps = conexion.crearConexion().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error al eliminar: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        actualizarTabla();
        limpiar();
    }


    public void editar() throws Exception {
        int fila = tbCamiones.getSelectedRow();
        if (fila == -1) {
            throw new Exception("Debe seleccionar un camión para editar.");
        }

        int id = Integer.parseInt(tbCamiones.getValueAt(fila, 0).toString());
        String placa = textFieldPlaca.getText();
        String modeloCamion = textFieldModelo.getText();
        String capacidadStr = textFieldCapacidad.getText();

        if (placa.isEmpty() || modeloCamion.isEmpty() || capacidadStr.isEmpty()) {
            throw new Exception("Debe llenar todos los campos.");
        }

        double capacidad = Double.parseDouble(capacidadStr);

        Conexion conexion = new Conexion();
        try {
            String query = "UPDATE Camion SET placa = ?, modelo = ?, capacidadMaxima = ? WHERE id_Camion = ?";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(query);
            ps.setString(1, placa);
            ps.setString(2, modeloCamion);
            ps.setDouble(3, capacidad);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error al modificar: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        actualizarTabla();
        limpiar();
    }



    public void limpiar() {
        textFieldPlaca.setText("");
        textFieldModelo.setText("");
        textFieldCapacidad.setText("");
        btnCrear.setEnabled(true);
        btnEditar.setEnabled(false);
    }

    public void actualizarTabla() throws Exception {
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID", "Placa", "Modelo", "Capacidad"}, 0);

        try {
            String query = "SELECT * FROM Camion";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_Camion"),
                    rs.getString("placa"),
                    rs.getString("modelo"),
                    rs.getDouble("capacidadMaxima")
                };
                modelo.addRow(fila);
            }
            tbCamiones.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    // Carga de Info 
    
    public void cargarDatosSeleccionados() {
        int fila = tbCamiones.getSelectedRow();
        btnEditar.setEnabled(true);
        btnCrear.setEnabled(false);

        textFieldPlaca.setText(tbCamiones.getValueAt(fila, 1).toString());
        textFieldModelo.setText(tbCamiones.getValueAt(fila, 2).toString());
        textFieldCapacidad.setText(tbCamiones.getValueAt(fila, 3).toString());
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldPlaca = new javax.swing.JTextField();
        textFieldModelo = new javax.swing.JTextField();
        textFieldCapacidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCamiones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("GESTION DE CAMIONES");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("PLACA");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("MODELO");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CAPACIDAD MAXIMA");

        textFieldPlaca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        textFieldModelo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        textFieldCapacidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textFieldCapacidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(textFieldModelo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textFieldPlaca, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(221, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 672, -1));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ACCIONES");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCrear, btnEditar, btnEliminar, btnLimpiar, btnRegresar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(134, 134, 134)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCrear, btnEditar, btnEliminar, btnLimpiar, btnRegresar});

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 0, -1, 591));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        tbCamiones.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCamiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCamionesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCamiones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 271, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        try {
            eliminar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tbCamionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCamionesMousePressed
        int fila = tbCamiones.getSelectedRow();
        if (fila != -1) {
            btnEditar.setEnabled(true);
            btnCrear.setEnabled(false);
            textFieldPlaca.setText(tbCamiones.getValueAt(fila, 1).toString());
            textFieldModelo.setText(tbCamiones.getValueAt(fila, 2).toString());
            textFieldCapacidad.setText(tbCamiones.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tbCamionesMousePressed
    
    // Instancia tipo Menu para poder regresar al Menu
    Menu menu = new Menu();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCamiones;
    private javax.swing.JTextField textFieldCapacidad;
    private javax.swing.JTextField textFieldModelo;
    private javax.swing.JTextField textFieldPlaca;
    // End of variables declaration//GEN-END:variables
    }
