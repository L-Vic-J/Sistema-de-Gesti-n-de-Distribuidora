
package InterfacesClientes;

import Clases.Conexion;
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


public class VentanaConsultarPedido extends javax.swing.JFrame {


    public VentanaConsultarPedido(MenuClientes menu) {
        this.menu= menu;
        initComponents();
        botonReporte.setEnabled(false);
        textFieldInvisible.setVisible(false);
        
        // Se centra la pantalla  
        setLocationRelativeTo(null);
        // Se inhabilita acomodar columnas
        tablaPedido.getTableHeader().setReorderingAllowed(false);
        tablaPedido.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tablaPedido.getTableHeader().setForeground(new Color(0, 51, 102));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tablaPedido.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        
        DefaultTableModel modelo= new DefaultTableModel ();
         modelo.addColumn("ID Pedido");
         modelo.addColumn("ID Cliente");
         modelo.addColumn("Dirección entrega");
         modelo.addColumn("Peso total");
         modelo.addColumn("Estado");
         modelo.addColumn("ID camión");
        
    }
    
    // Metodo para cargar pedidos en la tabla
    public DefaultTableModel cargarPedido (int id){
        
        DefaultTableModel modelo= new DefaultTableModel ();
           // Se centra la pantalla  
        setLocationRelativeTo(null);
        // Se inhabilita acomodar columnas
        tablaPedido.getTableHeader().setReorderingAllowed(false);
        tablaPedido.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        tablaPedido.getTableHeader().setForeground(new Color(0, 51, 102));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tablaPedido.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
         modelo.addColumn("ID Pedido");
         modelo.addColumn("ID Cliente");
         modelo.addColumn("Dirección entrega");
         modelo.addColumn("Peso total");
         modelo.addColumn("Estado");
         modelo.addColumn("ID camión");
        
    
        Conexion conexion = new Conexion ();
        String sql= "SELECT * FROM Pedido WHERE id_Pedido=? ";
        
        try {
             try {
                 String datos[]= new String [6];
                 PreparedStatement ps= conexion.crearConexion().prepareCall(sql);
                 ps.setInt(1,id);
                 ResultSet rs= ps.executeQuery();
                 
                 
                 while (rs.next()){
                     datos [0]= String.valueOf(rs.getInt("id_Pedido"));
                     datos [1]= String.valueOf(rs.getInt("id_Cliente"));
                     datos [2]= rs.getString("direccionEntrega");
                     datos [3]= String.valueOf(rs.getDouble("pesoTotal"));
                     datos [4]= rs.getString("estado");
                     datos [5]=String.valueOf(rs.getInt("id_Camion"));  
                     modelo.addRow(datos);
                 }
                            
                   
             } catch (SQLException exception){
                 JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos","Error conexion",JOptionPane.ERROR_MESSAGE);
             }catch (Exception exception){
                 JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos","Error conexion",JOptionPane.ERROR_MESSAGE);
             }finally {
               conexion.cerrarConexion();
           }
             
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null,"El ID del pedido debe ser numerico","Error al consultar pedido",JOptionPane.ERROR_MESSAGE);
        }
            
         return modelo;
            
    }
    

    public void limpiar (){
        textFieldID.setText("");
        botonReporte.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldID = new javax.swing.JTextField();
        textFieldInvisible = new javax.swing.JTextField();
        botonConsultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        botonReporte = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta de pedidos");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID del pedido:");

        botonConsultar.setText("Consultar");
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(115, 115, 115))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textFieldInvisible, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonConsultar)
                        .addGap(131, 131, 131))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldInvisible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setForeground(new java.awt.Color(0, 51, 102));

        botonReporte.setText("Generar reporte");
        botonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonReporte))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(botonReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonVolver)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPedidoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteActionPerformed
      int id= Integer.parseInt(textFieldInvisible.getText().toString());
      Pedido pedido = new Pedido (id);
      pedido.GenerarReporte(id);
      limpiar ();
      
      
    }//GEN-LAST:event_botonReporteActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
         menu.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void tablaPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidoMousePressed
        botonReporte.setEnabled(true);
        int fila= tablaPedido.getSelectedRow();
        String id= tablaPedido.getValueAt(fila,0).toString();
        textFieldInvisible.setText(id);


    }//GEN-LAST:event_tablaPedidoMousePressed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        int id= Integer.parseInt(textFieldID.getText());
        DefaultTableModel modelo= cargarPedido (id);
        tablaPedido.setModel(modelo);   
    }//GEN-LAST:event_botonConsultarActionPerformed

     MenuClientes menu;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonReporte;
    private javax.swing.JButton botonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPedido;
    private javax.swing.JTextField textFieldID;
    private javax.swing.JTextField textFieldInvisible;
    // End of variables declaration//GEN-END:variables
}
