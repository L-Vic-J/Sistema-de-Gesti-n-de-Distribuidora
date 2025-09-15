package Clases;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class SimulacionEntregaPedidos extends Thread {

    private Pedido pedido;
    private JProgressBar progreso;
    private JLabel numeroPedido;

    public SimulacionEntregaPedidos(Pedido pedido, JProgressBar progreso, JLabel numeroPedido) {
        this.pedido = pedido;
        this.progreso = progreso;
        this.numeroPedido = numeroPedido;
    }

    @Override
    public void run() {
        numeroPedido.setText("Pedido " + pedido.getId());
        for (int i = 0; i <= 100; i++) {
            progreso.setValue(i);
            try {
                Thread.sleep((int) (Math.random() * 50 + 30));
            } catch (InterruptedException ex) {
                System.out.println("Error en simulación del pedido: " + ex.getMessage());
            }
           
            // Actualizar estado a Entregado
               
        }
        
             try {
             pedido.setEstado("Entregado");
             pedido.modificarPedido();
                
            }catch (Exception exception){
                
            }
    }
}