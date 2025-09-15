
package InterfacesAdministradoresOperadores;

import Enum.Rol;
import Clases.Operador;
import Clases.Administrador;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class VentanaCrudUsuarios extends javax.swing.JFrame {

    public VentanaCrudUsuarios(Menu menu) {
        
        menu= this.menu;
        initComponents();
        // Se centra la pantalla  
        setLocationRelativeTo(null);
        // Se inhabilita acomodar columnas
         tablaUsuarios.getTableHeader().setReorderingAllowed(false);
         tablaUsuarios.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
         tablaUsuarios.getTableHeader().setForeground(new Color(0,51,102));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)  tablaUsuarios.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
    
         // Se carga modelo de Consultar Usuarios
         
         DefaultTableModel modelo=Administrador.cargarTabla();
          tablaUsuarios.setModel(modelo);
         
         
        // Se inicializa atributo tipo Menu
        this.menu=menu;
      
         
         // Se agrupan Radio Button de rol
         buttonGroupRol.add(radioButtonAdministrador);
         buttonGroupRol.add(radioButtonOperador);
 
         
        // Se desactiva Spinner de ID
        spinnerID.setEnabled(false);
        botonEditar.setEnabled(false);

      
        // Se aplica metodo
        limpiar ();
             
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupRol = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spinnerID = new javax.swing.JSpinner();
        textFieldCorreo = new javax.swing.JTextField();
        textFieldNombre = new javax.swing.JTextField();
        textFieldPassword = new javax.swing.JTextField();
        radioButtonOperador = new javax.swing.JRadioButton();
        radioButtonAdministrador = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botonCrear = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        botonLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Correo:");

        radioButtonOperador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        radioButtonOperador.setForeground(new java.awt.Color(0, 0, 0));
        radioButtonOperador.setText("Operador");

        radioButtonAdministrador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        radioButtonAdministrador.setForeground(new java.awt.Color(0, 0, 0));
        radioButtonAdministrador.setText("Administrador");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Gestión de Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerID, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButtonOperador)
                            .addComponent(radioButtonAdministrador))
                        .addGap(66, 66, 66))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(198, 198, 198))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioButtonOperador))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioButtonAdministrador))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 590, 330));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));

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

        botonEditar.setBackground(new java.awt.Color(255, 255, 255));
        botonEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEditar.setForeground(new java.awt.Color(0, 0, 0));
        botonEditar.setText("Eliminar");
        botonEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Acciones");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, -2, 250, 500));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 322, 580, 376));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
         try {
             agregar  ();
         }   catch (Exception ex){
             JOptionPane.showMessageDialog(this, ex.getMessage());
         }
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        eliminar ();
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        menu.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_botonRegresarActionPerformed

    // Metodo mouse pressed para cargar datos a los inputs
    private void tablaUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMousePressed
        int fila= tablaUsuarios.getSelectedRow();
        botonEditar.setEnabled(true);
        botonCrear.setEnabled(false);
        
        spinnerID.setValue(Integer.parseInt(tablaUsuarios.getValueAt(fila, 0).toString()));
        textFieldNombre.setText(tablaUsuarios.getValueAt(fila, 1).toString());
        textFieldCorreo.setText(tablaUsuarios.getValueAt(fila, 2).toString());
        textFieldPassword.setText(tablaUsuarios.getValueAt(fila, 3).toString());
        String rol=tablaUsuarios.getValueAt(fila, 4).toString();
        
        
        if (rol.equals("Administrador")){
            radioButtonAdministrador.setSelected(true);
            radioButtonOperador.setEnabled(false);
        } else {
            radioButtonOperador.setSelected(true);
            radioButtonAdministrador.setEnabled(false);
        }    
    }//GEN-LAST:event_tablaUsuariosMousePressed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiar ();
  
        
    }//GEN-LAST:event_botonLimpiarActionPerformed
  
    
    
    public void limpiar (){  
        textFieldNombre.setText("");
        textFieldCorreo.setText("");
        textFieldPassword.setText("");
        radioButtonOperador.setSelected(true);
        botonCrear.setEnabled(true);
        botonEditar.setEnabled(false);
    }
   
  
        public void agregar () throws Exception{
        // Se crean instancias nulas de tipo adiministrador y operador
        Administrador nuevoAdministrador;
        Operador nuevoOperador;
        
        // Captura los input
        String nombre=textFieldNombre.getText();
        String correo=textFieldCorreo.getText();
        String password=textFieldPassword.getText();
        Rol rol;
        // Verifica el rol
        if (radioButtonOperador.isSelected()){
            rol= Rol.Operador;
            nuevoOperador= new Operador (nombre,correo,password,rol);
            nuevoOperador.agregarUsuario();
        } else {
            rol=Rol.Administrador;
            nuevoAdministrador= new Administrador (nombre,correo,password,rol);
            nuevoAdministrador.agregarUsuario();
        }
     
        if (nombre.isEmpty() || correo.isEmpty() || password.isEmpty()){
            throw new Exception ("Debe llenar todos los espacios en el formulario");
        }
       
         // Limpia las entradas
          limpiar ();
          DefaultTableModel modelo=Administrador.cargarTabla();
          tablaUsuarios.setModel(modelo);
         
        
   }
        
       public void eliminar (){
           try {
               int id= (int)spinnerID.getValue();
               if (radioButtonOperador.isSelected()){
                   Operador operador= new Operador (id);
                   operador.eliminarUsuario();
               } else {
                   Administrador administrador= new Administrador (id);
                   administrador.eliminarUsuario();
               }
               
       limpiar();
        botonEditar.setEnabled(false);
        botonCrear.setEnabled(true);
        DefaultTableModel modelo=Administrador.cargarTabla();
        tablaUsuarios.setModel(modelo);
             
    } catch (Exception exception){
        JOptionPane.showMessageDialog(null, "Error al eliminar el usuario, error"+exception.getMessage());
    }
           
           
       }
    
    

    
  // Instancia tipo Menu para poder regresar al Menu
    Menu menu= new Menu ();
  
     
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.ButtonGroup buttonGroupRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioButtonAdministrador;
    private javax.swing.JRadioButton radioButtonOperador;
    private javax.swing.JSpinner spinnerID;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField textFieldCorreo;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldPassword;
    // End of variables declaration//GEN-END:variables
}
