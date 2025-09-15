
package InterfacesAdministradoresOperadores;


import Clases.Producto;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class ventanaCrudProductos extends javax.swing.JFrame {

    /**
     * Creates new form ventanaCrudProductos
     */
    public ventanaCrudProductos(Menu menu) {
        menu = this.menu;
        initComponents();
        setLocationRelativeTo(null);
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        tablaProductos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tablaProductos.getTableHeader().setForeground(new Color(0, 51, 102));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tablaProductos.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        
        DefaultTableModel modelo= Producto.cargarTabla();
        tablaProductos.setModel(modelo);
        
        spinnerId.setEnabled(false);
        
       limpiar ();
        
        
        
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        botonCrear = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spinnerId = new javax.swing.JSpinner();
        textFieldNombre = new javax.swing.JTextField();
        textFieldPeso = new javax.swing.JTextField();
        textFieldCantidad = new javax.swing.JTextField();
        textFieldPrecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaDescripcion = new javax.swing.JTextArea();
        radioButtonDisponible = new javax.swing.JRadioButton();
        comboBoxUnidad = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Acciones");

        botonCrear.setBackground(new java.awt.Color(255, 255, 255));
        botonCrear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonCrear.setForeground(new java.awt.Color(0, 0, 0));
        botonCrear.setText("Crear");
        botonCrear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        botonEditar.setBackground(new java.awt.Color(255, 255, 255));
        botonEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEditar.setForeground(new java.awt.Color(0, 0, 0));
        botonEditar.setText("Editar");
        botonEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        botonLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonRegresar.setBackground(new java.awt.Color(255, 255, 255));
        botonRegresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonRegresar.setForeground(new java.awt.Color(0, 0, 0));
        botonRegresar.setText("Regresar");
        botonRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(167, 167, 167))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonLimpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonCrear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 250, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Gestión de Productos");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Descripcion:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cantidad:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Peso:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Precio:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ID:");

        TextAreaDescripcion.setColumns(20);
        TextAreaDescripcion.setRows(5);
        jScrollPane3.setViewportView(TextAreaDescripcion);

        radioButtonDisponible.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        radioButtonDisponible.setForeground(new java.awt.Color(0, 0, 0));
        radioButtonDisponible.setText("Disponible");

        comboBoxUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "g", "ml" }));
        comboBoxUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUnidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(196, 196, 196))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textFieldCantidad))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonDisponible)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioButtonDisponible))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(spinnerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(comboBoxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 310));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 590, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
      try{
          Agregar ();
      } catch (Exception exception){
          JOptionPane.showMessageDialog(null, "Error al agregar el producto, error:" + exception.getMessage());
      }
                
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
      try{
          Modificar ();
      } catch (Exception exception){
          JOptionPane.showMessageDialog(null, "Error al agregar el producto, error:" + exception.getMessage());
      }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
         limpiar ();

    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        menu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_botonRegresarActionPerformed

    private void comboBoxUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxUnidadActionPerformed

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
        botonCrear.setEnabled(false);
        botonEditar.setEnabled(true);
        int fila = tablaProductos.getSelectedRow();
        
        spinnerId.setValue(Integer.parseInt(tablaProductos.getValueAt(fila, 0).toString()));
        textFieldNombre.setText(tablaProductos.getValueAt(fila, 1).toString());
        TextAreaDescripcion.setText(tablaProductos.getValueAt(fila, 2).toString());
        textFieldCantidad.setText(tablaProductos.getValueAt(fila, 3).toString());
        textFieldPeso.setText(tablaProductos.getValueAt(fila, 4).toString());
        String unidad = tablaProductos.getValueAt(fila, 5).toString();
        if (unidad.equals("g")) {
            comboBoxUnidad.setSelectedIndex(0);
        } else {
            comboBoxUnidad.setSelectedIndex(1);
        }
        
        textFieldPrecio.setText(tablaProductos.getValueAt(fila, 6).toString());
        
        String disponibilidad = tablaProductos.getValueAt(fila, 7).toString();
        
        if (disponibilidad.equals("Sí")) {
            radioButtonDisponible.setSelected(true);
        } else {
            radioButtonDisponible.setSelected(false);
        }
        
        
        
    }//GEN-LAST:event_tablaProductosMousePressed

    // Metodo para limpiar
    
    public void limpiar (){
        
        textFieldNombre.setText("");
        textFieldCantidad.setText("");
        textFieldPeso.setText("");
        comboBoxUnidad.setSelectedIndex(0);
        textFieldPrecio.setText("");
        TextAreaDescripcion.setText("");
        radioButtonDisponible.setSelected(true);
        
        botonCrear.setEnabled(true);
        botonEditar.setEnabled(false);
    
        
        
    }
    
    
    // Metodo para agregar
    
    public void Agregar ()throws Exception{
        
        try {
            String nombre = textFieldNombre.getText();
            int cantidad = Integer.parseInt(textFieldCantidad.getText());
            Double peso = Double.parseDouble(textFieldPeso.getText());
            String unidad = comboBoxUnidad.getSelectedItem().toString();
            Double precio = Double.parseDouble(textFieldPrecio.getText());
            String descripcion = TextAreaDescripcion.getText();
            if (descripcion.isEmpty()){
                descripcion="N/A";
            }
            Boolean disponible;
            if (radioButtonDisponible.isSelected()) {
                disponible = true;
            } else {
                disponible = false;
            }

            if (nombre.isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            } else if (cantidad <= 0 || peso <= 0 || precio <= 0) {
                throw new Exception("La cantidad, peso o precio deben ser mayores a cero");
            }

            Producto producto = new Producto(nombre, descripcion, cantidad, peso, unidad, precio, disponible);
            producto.agregarProducto();
            DefaultTableModel modelo= Producto.cargarTabla();
             tablaProductos.setModel(modelo);
             limpiar();

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Los valores deben ser numericos");
        }

    }
    
    
    // Metodo para modificar, en donde tambien se puede inhabilitar producto
    public void Modificar () throws Exception{
        
        try {
            String nombre = textFieldNombre.getText();
            int cantidad = Integer.parseInt(textFieldCantidad.getText());
            Double peso = Double.parseDouble(textFieldPeso.getText());
            String unidad = comboBoxUnidad.getSelectedItem().toString();
            Double precio = Double.parseDouble(textFieldPrecio.getText());
            String descripcion = TextAreaDescripcion.getText();
            int id= (int)spinnerId.getValue();
            
              if (descripcion.isEmpty()){
                descripcion="N/A";
            }
            Boolean disponible;
            if (radioButtonDisponible.isSelected()) {
                disponible = true;
            } else {
                disponible = false;
            }

            if (nombre.isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            } else if (cantidad <= 0 || peso <= 0 || precio <= 0) {
                throw new Exception("La cantidad, peso o precio deben ser mayores a cero");
            }

            Producto producto = new Producto (id,nombre, descripcion, cantidad, peso, unidad, precio, disponible);
            producto.ModificarProducto();
             DefaultTableModel modelo= Producto.cargarTabla();
             tablaProductos.setModel(modelo);
             limpiar();

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Los valores deben ser numericos");
        }



            
}
            
            
    

    Menu menu= new Menu ();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextAreaDescripcion;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JComboBox<String> comboBoxUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioButtonDisponible;
    private javax.swing.JSpinner spinnerId;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField textFieldCantidad;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldPeso;
    private javax.swing.JTextField textFieldPrecio;
    // End of variables declaration//GEN-END:variables

    }
