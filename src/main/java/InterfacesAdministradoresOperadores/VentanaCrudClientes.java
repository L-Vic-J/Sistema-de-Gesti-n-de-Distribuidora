
package InterfacesAdministradoresOperadores;

import Clases.Administrador;
import Enum.Rol;
import Clases.Cliente;
import Clases.Operador;
import Clases.Producto;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaCrudClientes extends javax.swing.JFrame {

  
    public VentanaCrudClientes(Menu menu) {
        initComponents();
        // Se centra la pantalla  
        setLocationRelativeTo(null);
        // Se inhabilita acomodar columnas
         tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tablaClientes.getTableHeader().setForeground(new Color(0, 51, 102));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tablaClientes.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
      
         
        // Se inicializa atributo tipo Menu
        this.menu=menu;
       
        // Se carga modelo tabla
        modelo= Cliente.cargarTabla();
        tablaClientes.setModel(modelo);
        
        // Se desactiva Spinner de ID
        spinnerID.setEnabled(false);
        
        //  Se desactivan los botones de editar y eliminar
        botonEditar.setEnabled(false);
        botonEliminar.setEnabled(false);
        
        // Se aplica metodo
        limpiar ();
           
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupRol = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        BotonHola4 = new javax.swing.JLabel();
        textFieldCorreo = new javax.swing.JTextField();
        textFieldNombre = new javax.swing.JTextField();
        textFieldPassword = new javax.swing.JTextField();
        spinnerID = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botonCrear = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabelID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(0, 0, 0));
        jLabelID.setText("ID:");

        jLabelNombre.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNombre.setText("Nombre:");

        jLabelCorreo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCorreo.setText("Correo:");

        jLabelPassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPassword.setText("Contraseña:");

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestión de Clientes");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(200, 200, 200))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonHola4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelPassword)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelCorreo)
                                    .addGap(50, 50, 50))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelNombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelID)
                                .addGap(85, 85, 85)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(spinnerID)
                            .addComponent(textFieldCorreo)
                            .addComponent(textFieldPassword))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(spinnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonHola4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPassword)
                        .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 610, 320));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        botonCrear.setBackground(new java.awt.Color(255, 255, 255));
        botonCrear.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonCrear.setForeground(new java.awt.Color(0, 0, 0));
        botonCrear.setText("Crear");
        botonCrear.setBorder(null);
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        botonEditar.setBackground(new java.awt.Color(255, 255, 255));
        botonEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEditar.setForeground(new java.awt.Color(0, 0, 0));
        botonEditar.setText("Editar");
        botonEditar.setBorder(null);
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(255, 255, 255));
        botonEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(0, 0, 0));
        botonEliminar.setText("Eliminar");
        botonEliminar.setBorder(null);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonRegresar.setBackground(new java.awt.Color(255, 255, 255));
        botonRegresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonRegresar.setForeground(new java.awt.Color(0, 0, 0));
        botonRegresar.setText("Regresar");
        botonRegresar.setBorder(null);
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Acciones");

        botonLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        botonLimpiar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setBorder(null);
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(609, 0, 270, 560));

        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 314, 630, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
       eliminar ();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
         try {
             agregar  ();
         }   catch (Exception ex){
             JOptionPane.showMessageDialog(this, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
         }
        
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        try {
            Modificar();
        } catch (Exception ex) {
            Logger.getLogger(VentanaCrudClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_botonEditarActionPerformed

    private void tablaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMousePressed
       
        botonEditar.setEnabled(true);
        botonEliminar.setEnabled(true);
        botonCrear.setEnabled(false);
        
        int fila= tablaClientes.getSelectedRow();
        botonEditar.setEnabled(true);
        botonCrear.setEnabled(false);
        
        spinnerID.setValue(Integer.parseInt(tablaClientes.getValueAt(fila, 0).toString()));
        textFieldNombre.setText(tablaClientes.getValueAt(fila, 1).toString());
        textFieldCorreo.setText(tablaClientes.getValueAt(fila, 2).toString());
        textFieldPassword.setText(tablaClientes.getValueAt(fila, 3).toString());
        String rol=tablaClientes.getValueAt(fila, 4).toString();

    }//GEN-LAST:event_tablaClientesMousePressed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
       limpiar ();
    }//GEN-LAST:event_botonLimpiarActionPerformed

  
    // Metodo limpiarc inputs
    public void limpiar (){  
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        textFieldPassword.setText("");
        
        botonEditar.setEnabled(false);
        botonEliminar.setEnabled(false);
        
    }
  
    
// Metodo para agregar cliente
       
        public void agregar () throws Exception{
            
        // Se capturan datos 
        String nombre=textFieldNombre.getText();
        String correo=textFieldCorreo.getText();
        String password=textFieldPassword.getText();
     
        if (nombre.isEmpty() || correo.isEmpty() || password.isEmpty()){
            throw new Exception ("Debe llenar todos los espacios en el formulario");
        }
        
        // Se agrega cliente
        Cliente nuevoCliente= new Cliente (nombre,correo,password,Rol.Cliente);
        nuevoCliente.agregarCliente();
       
         // Limpia las entradas
          limpiar ();
          DefaultTableModel modelo=Cliente.cargarTabla();
          tablaClientes.setModel(modelo);
         
        
   }
        
        
       public void eliminar() {
        try {
            int id = (int) spinnerID.getValue();
            Cliente clienteEliminado = new Cliente(id);
            clienteEliminado.eliminarCliente();

            limpiar();
            botonEditar.setEnabled(false);
            botonCrear.setEnabled(true);
            DefaultTableModel modelo = Cliente.cargarTabla();
             tablaClientes.setModel(modelo);

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el usuario, error" + exception.getMessage());
        }

    }

       
        public void Modificar() throws Exception {

            String nombre = textFieldNombre.getText();
            String correo = textFieldCorreo.getText();
            String password = textFieldPassword.getText();
            int id = (int)spinnerID.getValue();

            if (nombre.isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            } else if (correo.isEmpty()) {
                throw new Exception("Debe ingresar un correo");   
            }else if (password.isEmpty()){
                 throw new Exception("Debe ingresar una contraseña");
            }

            Cliente clienteModificado = new Cliente (id,nombre,correo,password );
            clienteModificado.editarCliente();
            DefaultTableModel modelo = Cliente.cargarTabla();
            tablaClientes.setModel(modelo);
            limpiar();

    }
            
            
   
  
    // Instancia tipo Menu para poder regresar al Menu
    Menu menu= new Menu ();
     // Se instancia modelo y se inhabilta la edicion de celdas
     DefaultTableModel modelo= new DefaultTableModel ();

       
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonHola4;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.ButtonGroup buttonGroupRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerID;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField textFieldCorreo;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldPassword;
    // End of variables declaration//GEN-END:variables
}
