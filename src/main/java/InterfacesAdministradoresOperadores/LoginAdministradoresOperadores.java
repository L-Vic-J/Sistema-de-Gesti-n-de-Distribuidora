package InterfacesAdministradoresOperadores;

import Clases.Usuario;
import Enum.Rol;
import Clases.Conexion;
import Clases.Operador;
import Clases.Administrador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class LoginAdministradoresOperadores extends javax.swing.JFrame {

    
    // Desarrolladores: LEITON JIMENEZ VICTOR EDUARDO, GONZALEZ CASCANTE KENNETH FERNANDO, HERNANDEZ ARIAS JEAUSTHIN DANIEL,GOMEZ HERNANDEZ HENRY JAFET
   
    public LoginAdministradoresOperadores() {
        initComponents();
        // Se centra la pantalla
        setLocationRelativeTo(null);
        iniciarCuentas ();
                
    }
    
    

    
    // Metodo para almacenar cuentas en Array List para validar el login
    
    public void iniciarCuentas (){
        
        Conexion conexion= new Conexion ();
        String datos []= new String [4];
        
        try {
            Statement statement = conexion.crearConexion().createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM Usuario");
            
            while (resultSet.next()){
                int id=Integer.parseInt(resultSet.getString(1));
                String nombre=resultSet.getString(2);
                String correo=resultSet.getString(3);
                String password=resultSet.getString(4);
                String rol=resultSet.getString(5);
                
                if (rol.equals("Administrador")){
                    Usuario usuarioAdministador= new Administrador (id,nombre,correo,password,Rol.Administrador);
                    usuarios.add(usuarioAdministador);
                } else{
                    Usuario usuarioOperador= new Operador (id,nombre,correo,password,Rol.Operador);
                    usuarios.add(usuarioOperador);
                    
                }
                  
            }
                  
        } catch (SQLException exception){
            JOptionPane.showMessageDialog(null, "Error al intentar cargar las cuentas de la base de datos, error:"+exception.getMessage());
            
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error al intentar cargar las cuentas de la base de datos, error:"+exception.getMessage());
       
   }
        }
        
    
    // Metodo para buscar la cuenta en el Array List de usuarios
    public Usuario buscarCuenta (int id, String password){
        
        for (Usuario usuario : usuarios) {
            // Si la encuentra, la retorna
            if (id==usuario.getId() && password.equals(usuario.getPassword())){
                return usuario;
            } 
        }
         // Retorna null en caso de que no exista  y muestra mensaje
        JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
        return null;
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNombreEmpresa = new javax.swing.JLabel();
        jLabelBanner = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldID = new javax.swing.JTextField();
        botonIngresar = new javax.swing.JButton();
        passwordFieldPassword = new javax.swing.JPasswordField();
        jLabelLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNombreEmpresa.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabelNombreEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreEmpresa.setText("Distribuidora de Costa Rica S.A");
        jPanel1.add(jLabelNombreEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, -1, -1));

        jLabelBanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Diseño.png"))); // NOI18N
        jPanel1.add(jLabelBanner, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 260, 490));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Distribuidora de Costa Rica S.A");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("INICIAR SESIÓN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        textFieldID.setForeground(new java.awt.Color(0, 0, 0));
        textFieldID.setBorder(null);
        textFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldIDActionPerformed(evt);
            }
        });
        jPanel1.add(textFieldID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 158, -1));

        botonIngresar.setBackground(new java.awt.Color(0, 51, 102));
        botonIngresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonIngresar.setForeground(new java.awt.Color(255, 255, 255));
        botonIngresar.setText("Ingresar");
        botonIngresar.setBorder(null);
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(botonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 120, 40));

        passwordFieldPassword.setForeground(new java.awt.Color(0, 0, 0));
        passwordFieldPassword.setBorder(null);
        jPanel1.add(passwordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 158, -1));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Captura de pantalla 2025-07-19 151528.png"))); // NOI18N
        jLabelLogo.setText("jLabel4");
        jPanel1.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 100, 90));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 20, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("______________________________");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 220, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("______________________________");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        // Se almacenan los get de los TextField en variables
        // Se captura excepcion tipo NumberFormatException

        try {
            int id=  Integer.parseInt(textFieldID.getText());
            String password=passwordFieldPassword.getText();
            // Se usa metodo de buscar cuenta
            Usuario usuario=buscarCuenta (id,password);

             if (usuario instanceof Administrador){
                menu.setVisible(true);
                // Escondemos la venta para que siempre quede a la escucha
                this.hide();

                // Si es operador se desactivan los botones de gestion de usuarios y de productos
            } else if (usuario instanceof Operador) {
                menu.setVisible(true);
                menu.getBotonUsuarios().setEnabled(false);
                menu.getBotonProductos().setEnabled(false);
                this.dispose();
            }

        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Debe ingresar un valor numerico");
        }

    }//GEN-LAST:event_botonIngresarActionPerformed

    private void textFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldIDActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginAdministradoresOperadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdministradoresOperadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdministradoresOperadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdministradoresOperadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdministradoresOperadores().setVisible(true);
            }
        });
        
        // Servidor 
        
                ServerSocket servidor = null;
          
             try {
                 
            // Se indica que el servidor esta en escucha
            System.out.println("Servidor iniciado.");
            // Socket del servidor
            servidor = new ServerSocket(9200); 

            while (true) {
                // Se espera conexion del cliente
                Socket cliente = servidor.accept();

                // Hilo para atender al cliente, cada cliente tiene su hilo
                new Thread(() -> {
                    try {
                        DataInputStream inPut = new DataInputStream(cliente.getInputStream());
                        DataOutputStream outPut = new DataOutputStream(cliente.getOutputStream());

                        // Se lee mensaje del cliente
                        String mensaje = inPut.readUTF();

                        if (mensaje.equals("CLIENTE CONECTADO")) {
                            String respuesta = "OK";
                            outPut.writeUTF(respuesta); // Se envia conexion al cliente
                        }
                        
                    } catch (IOException exception) {
                        System.out.println("Excepción en hilo cliente: " + exception.getMessage());
                    }
                }).start(); // Se inicia el hilo
            }

        } catch (IOException exception) {
            System.out.println("Excepción en servidor: " + exception.getMessage());
        }
       
    }

    // Se instancia menu
    Menu menu= new Menu ();
   
// Se crea ArrayList que almacenara Administradores y operadores de la tabla
   private static ArrayList<Usuario> usuarios= new ArrayList ();

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelBanner;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombreEmpresa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordFieldPassword;
    private javax.swing.JTextField textFieldID;
    // End of variables declaration//GEN-END:variables
}
