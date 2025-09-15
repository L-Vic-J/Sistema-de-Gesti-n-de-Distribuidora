
package InterfacesAdministradoresOperadores;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        //Se centra el menu
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonClientes = new javax.swing.JButton();
        botonUsuarios = new javax.swing.JButton();
        botonCamiones = new javax.swing.JButton();
        botonPedidos = new javax.swing.JButton();
        botonProductos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonClientes.setBackground(new java.awt.Color(255, 255, 255));
        botonClientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonClientes.setForeground(new java.awt.Color(0, 0, 0));
        botonClientes.setText("Clientes");
        botonClientes.setBorder(null);
        botonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClientesActionPerformed(evt);
            }
        });
        jPanel1.add(botonClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 163, 30));

        botonUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        botonUsuarios.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        botonUsuarios.setText("Usuarios");
        botonUsuarios.setBorder(null);
        botonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(botonUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 163, 30));

        botonCamiones.setBackground(new java.awt.Color(255, 255, 255));
        botonCamiones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonCamiones.setForeground(new java.awt.Color(0, 0, 0));
        botonCamiones.setText("Camiones");
        botonCamiones.setBorder(null);
        botonCamiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCamionesActionPerformed(evt);
            }
        });
        jPanel1.add(botonCamiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 163, 30));

        botonPedidos.setBackground(new java.awt.Color(255, 255, 255));
        botonPedidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonPedidos.setForeground(new java.awt.Color(0, 0, 0));
        botonPedidos.setText("Pedidos ");
        botonPedidos.setBorder(null);
        botonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidosActionPerformed(evt);
            }
        });
        jPanel1.add(botonPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 163, 30));

        botonProductos.setBackground(new java.awt.Color(255, 255, 255));
        botonProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonProductos.setForeground(new java.awt.Color(0, 0, 0));
        botonProductos.setText("Productos");
        botonProductos.setBorder(null);
        botonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProductosActionPerformed(evt);
            }
        });
        jPanel1.add(botonProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 160, 30));

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("GESTIONES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ciudad.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 270, 310));

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

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

    private void botonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClientesActionPerformed
            // Se crea instancia de tipo Venta Crud Clientes y se pasa como parametro la instancia actual
            VentanaCrudClientes ventanaCrudClientes= new VentanaCrudClientes (this);
            // Hacemos visible la venta
            ventanaCrudClientes.setVisible(true);
            // Se cierra la ventana menu
            this.dispose();
    }//GEN-LAST:event_botonClientesActionPerformed

    private void botonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUsuariosActionPerformed
        VentanaCrudUsuarios ventanaCrudUsuarios= new VentanaCrudUsuarios (this);
        ventanaCrudUsuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botonUsuariosActionPerformed

    private void botonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProductosActionPerformed
       ventanaCrudProductos ventaCrudProductos= new ventanaCrudProductos (this);
        ventaCrudProductos.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_botonProductosActionPerformed

    private void botonCamionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCamionesActionPerformed
        try {
            ventanaCrudCamiones ventanaCamiones = new ventanaCrudCamiones(this);
            ventanaCamiones.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir ventana de camiones: " + ex.getMessage());
        }  
    }//GEN-LAST:event_botonCamionesActionPerformed

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
      ventanaCrudPedidos ventanaPedidos = new ventanaCrudPedidos(this); 
        ventanaPedidos.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_botonPedidosActionPerformed


    public JButton getBotonCamiones() {
        return botonCamiones;
    }

    public JButton getBotonClientes() {
        return botonClientes;
    }

    public JButton getBotonPedidos() {
        return botonPedidos;
    }

    public JButton getBotonProductos() {
        return botonProductos;
    }

    public JButton getBotonUsuarios() {
        return botonUsuarios;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCamiones;
    private javax.swing.JButton botonClientes;
    private javax.swing.JButton botonPedidos;
    private javax.swing.JButton botonProductos;
    private javax.swing.JButton botonUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
