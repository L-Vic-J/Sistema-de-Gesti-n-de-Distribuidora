package InterfacesAdministradoresOperadores;

import javax.swing.table.DefaultTableModel;
import Clases.Conexion;
import Clases.Pedido;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SimulacionEntrega extends javax.swing.JFrame {

    private ventanaCrudPedidos menu;

    public SimulacionEntrega(ventanaCrudPedidos menu) {
        initComponents();
        this.menu = menu;
        setLocationRelativeTo(null);

        tbPedidosPendientes.setModel(modeloDisponibles);
        tbPedidosSimular.setModel(modeloSimulacion);

        try {
            cargarPedidos();
        } catch (Exception ex) {
            System.out.println("No se pudieron cargar los pedidos");
        }
    }

    private void cargarPedidos() throws Exception {
        modeloDisponibles.setRowCount(0); // Limpiar la tabla
        pedidosPendientes.clear();        // Limpiar lista

        Conexion conexion = new Conexion();

        try {
            Connection conn = conexion.crearConexion();
            String sql = "SELECT * FROM Pedido WHERE estado = 'Pendiente' AND id_Camion IS NOT NULL";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id_Pedido"),
                        rs.getInt("id_Cliente"),
                        rs.getString("direccionEntrega"),
                        rs.getDouble("pesoTotal"),
                        rs.getString("estado"),
                        rs.getInt("id_Camion")
                );
                pedidosPendientes.add(pedido);

                modeloDisponibles.addRow(new Object[]{
                    pedido.getId(),
                    pedido.getIdCliente(),
                    pedido.getDireccionEntrega(),
                    pedido.getPesoTotal(),
                    pedido.getEstado(),
                    pedido.getIdCamion()
                });
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error cargando pedidos: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
   
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPedidosPendientes = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnAgregarSimulacion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPedidosSimular = new javax.swing.JTable();
        btnSimular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos Pendientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        jScrollPane1.setBorder(null);
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        tbPedidosPendientes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbPedidosPendientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPedidosPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbPedidosPendientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbPedidosPendientes);

        btnVolver.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnAgregarSimulacion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAgregarSimulacion.setText("Agregar a Simulación");
        btnAgregarSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSimulacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnAgregarSimulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos Simulacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        tbPedidosSimular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbPedidosSimular.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbPedidosSimular);

        btnSimular.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        btnSimular.setText("Simular");
        btnSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 296, Short.MAX_VALUE)
                .addComponent(btnSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MousePressed

    private void tbPedidosPendientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidosPendientesMousePressed
        int fila = tbPedidosPendientes.getSelectedRow();
        int idPedido = (int) tbPedidosPendientes.getValueAt(fila, 0);

        for (Pedido p : pedidosPendientes) {
            if (p.getId() == idPedido) {
                pedidoSeleccionado = p;
            }
        }
    }//GEN-LAST:event_tbPedidosPendientesMousePressed

    private void btnAgregarSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSimulacionActionPerformed
        if (pedidoSeleccionado != null && !pedidosSeleccionados.contains(pedidoSeleccionado)) {
            pedidosSeleccionados.add(pedidoSeleccionado);

            modeloSimulacion.addRow(new Object[]{
                pedidoSeleccionado.getId(),
                pedidoSeleccionado.getIdCliente(),
                pedidoSeleccionado.getDireccionEntrega(),
                pedidoSeleccionado.getPesoTotal(),
                pedidoSeleccionado.getEstado(),
                pedidoSeleccionado.getIdCamion()
            });
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un pedido pendiente.");
        }

    }//GEN-LAST:event_btnAgregarSimulacionActionPerformed

    private void btnSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularActionPerformed
        if (pedidosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe agregar al menos un pedido para simular.");
            return;
        }
        // Lanza la simulacion de los hilos
        SimuladorEntrega simulador = new SimuladorEntrega(pedidosSeleccionados);
        simulador.setVisible(true);
        actualizarTablas();
    }//GEN-LAST:event_btnSimularActionPerformed
    
    //Actualiza las tablas
    public void actualizarTablas() {
    modeloDisponibles.setRowCount(0);
    modeloSimulacion.setRowCount(0);
    pedidosSeleccionados.clear();
    pedidoSeleccionado = null;

    try {
        cargarPedidos();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al cargar pedidos: " + ex.getMessage());
    }
}
    /**
     * @param args the command line arguments
     */

    private Pedido pedidoSeleccionado = null;
    private DefaultTableModel modeloDisponibles = new DefaultTableModel(new String[]{"ID", "Cliente", "Direccion", "Peso", "Estado", "Camion"}, 0) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false; // Todas las celdas son no editables
        }
    };
    private DefaultTableModel modeloSimulacion = new DefaultTableModel(new String[]{"ID", "Cliente", "Direccion", "Peso", "Estado", "Camion"}, 0) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false; // Todas las celdas son no editables
        }
    };
    private ArrayList<Pedido> pedidosPendientes = new ArrayList<>();
    private ArrayList<Pedido> pedidosSeleccionados = new ArrayList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarSimulacion;
    private javax.swing.JButton btnSimular;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPedidosPendientes;
    private javax.swing.JTable tbPedidosSimular;
    // End of variables declaration//GEN-END:variables
}
