package InterfacesAdministradoresOperadores;

import Clases.Pedido;  
import Clases.SimulacionEntregaPedidos;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class SimuladorEntrega extends javax.swing.JFrame {

    private ArrayList<Pedido> pedidos;
    

    public SimuladorEntrega(ArrayList<Pedido> pedidosSeleccionados) {
        initComponents();
        setLocationRelativeTo(null);
        this.pedidos = pedidosSeleccionados;

        // Nombres en los labels
        if (pedidos.size() > 0) {
            labPedido1.setText("Pedido " + pedidos.get(0).getId());
        }
        if (pedidos.size() > 1) {
            labPedido2.setText("Pedido " + pedidos.get(1).getId());
        }
        if (pedidos.size() > 2) {
            labPedido3.setText("Pedido " + pedidos.get(2).getId());
        }
        if (pedidos.size() > 3) {
            labPedido4.setText("Pedido " + pedidos.get(3).getId());
        }
        if (pedidos.size() > 4) {
            labPedido5.setText("Pedido #" + pedidos.get(4).getId());
        }
        if (pedidos.size() > 5) {
            labPedido6.setText("Pedido " + pedidos.get(5).getId());
        }

        // Iniciar simulacion en un hilo independiente
      
        new Thread(() -> simular()).start();
    }

    private void simular() {
        try {
            
            // Se crea lista de hilos para almacenarlos y hacerles Join
            ArrayList<Thread> hilosTerminados= new ArrayList<>();
            JProgressBar[] progresos = {barPedido1, barPedido2, barPedido3, barPedido4, barPedido5, barPedido6};
            JLabel [] labels= {labPedido1, labPedido2, labPedido3, labPedido4, labPedido5, labPedido6};
   
            
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                JProgressBar carga = progresos[i];
                JLabel label= labels[i];
                // Se hace instancia de simulacionEntregaPedidos con sus atributos
                SimulacionEntregaPedidos simulador = new SimulacionEntregaPedidos (pedido,carga,label);
                simulador.start();
                hilosTerminados.add(simulador);
                       
                }
                // Al finalizar, cada hilo se le aplica el Join 
                for (Thread hilo : hilosTerminados) {
                    hilo.join();    
                
            }

            JOptionPane.showMessageDialog(this, "Simulación completada,todos los pedidos fueron entregados");
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la simulación: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        labPedido1 = new javax.swing.JLabel();
        barPedido1 = new javax.swing.JProgressBar();
        labPedido2 = new javax.swing.JLabel();
        labPedido3 = new javax.swing.JLabel();
        labPedido4 = new javax.swing.JLabel();
        labPedido5 = new javax.swing.JLabel();
        labPedido6 = new javax.swing.JLabel();
        barPedido4 = new javax.swing.JProgressBar();
        barPedido5 = new javax.swing.JProgressBar();
        barPedido6 = new javax.swing.JProgressBar();
        barPedido2 = new javax.swing.JProgressBar();
        barPedido3 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        labPedido1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labPedido1.setText("Sin Pedido Seleccionado");

        barPedido1.setBackground(new java.awt.Color(204, 204, 204));

        labPedido2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labPedido2.setText("Sin Pedido Seleccionado");

        labPedido3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labPedido3.setText("Sin Pedido Seleccionado");

        labPedido4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labPedido4.setText("Sin Pedido Seleccionado");

        labPedido5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labPedido5.setText("Sin Pedido Seleccionado");

        labPedido6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labPedido6.setText("Sin Pedido Seleccionado");

        barPedido4.setBackground(new java.awt.Color(204, 204, 204));

        barPedido5.setBackground(new java.awt.Color(204, 204, 204));

        barPedido6.setBackground(new java.awt.Color(204, 204, 204));

        barPedido2.setBackground(new java.awt.Color(204, 204, 204));

        barPedido3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barPedido1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labPedido2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barPedido2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labPedido3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barPedido3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labPedido4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barPedido4, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labPedido5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barPedido5, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(labPedido6, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barPedido6, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPedido1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labPedido2)
                    .addComponent(barPedido2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labPedido3)
                    .addComponent(barPedido3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labPedido4)
                    .addComponent(barPedido4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labPedido5)
                    .addComponent(barPedido5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labPedido6)
                    .addComponent(barPedido6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barPedido1;
    private javax.swing.JProgressBar barPedido2;
    private javax.swing.JProgressBar barPedido3;
    private javax.swing.JProgressBar barPedido4;
    private javax.swing.JProgressBar barPedido5;
    private javax.swing.JProgressBar barPedido6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labPedido1;
    private javax.swing.JLabel labPedido2;
    private javax.swing.JLabel labPedido3;
    private javax.swing.JLabel labPedido4;
    private javax.swing.JLabel labPedido5;
    private javax.swing.JLabel labPedido6;
    // End of variables declaration//GEN-END:variables
}
