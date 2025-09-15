
package InterfacesClientes;

import Clases.Pedido;
import InterfacesAdministradoresOperadores.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MenuClientes extends javax.swing.JFrame {

  // Se almacena el ID del cliente traido desde el Login
    public MenuClientes(int id) {
        this.id=id;
        initComponents();
        
      
        setLocationRelativeTo(null);
    }
    
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonCrearPedido = new javax.swing.JButton();
        botonVerMiPedido = new javax.swing.JButton();
        botonConsultarPedidos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonCrearPedido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonCrearPedido.setText("Crear pedido");
        botonCrearPedido.setBorder(null);
        botonCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(botonCrearPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 163, 30));

        botonVerMiPedido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonVerMiPedido.setText("Ver mi historial");
        botonVerMiPedido.setBorder(null);
        botonVerMiPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerMiPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(botonVerMiPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 163, 30));

        botonConsultarPedidos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonConsultarPedidos.setText("Consultar pedidos");
        botonConsultarPedidos.setBorder(null);
        botonConsultarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarPedidosActionPerformed(evt);
            }
        });
        jPanel1.add(botonConsultarPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 163, 30));

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

    private void botonCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearPedidoActionPerformed
       ventanaCrudPedidos ventanaCrudPedidos= new ventanaCrudPedidos (this,this.id);
       ventanaCrudPedidos.setVisible(true);
       this.dispose();
       
       
    }//GEN-LAST:event_botonCrearPedidoActionPerformed

    private void botonVerMiPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerMiPedidoActionPerformed
       Pedido.Historial(this.id);     
    }//GEN-LAST:event_botonVerMiPedidoActionPerformed

    private void botonConsultarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarPedidosActionPerformed
        VentanaConsultarPedido ventanaConsultarPedidos= new VentanaConsultarPedido (this);
        ventanaConsultarPedidos.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_botonConsultarPedidosActionPerformed


    

 
    int id;
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultarPedidos;
    private javax.swing.JButton botonCrearPedido;
    private javax.swing.JButton botonVerMiPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
