
package Clases;

import InterfacesClientes.Loginclientes;
import InterfacesClientes.MenuClientes;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class GestionClientes extends Thread{
    
    Socket socket;
    int id;
    Loginclientes login= new Loginclientes ();

    public GestionClientes(Loginclientes login, int id) {
        this.id=id;
        this.login=login;
    }
 
    @Override
    public void run() {
        
        try {
             this.socket = new Socket("127.0.0.1", 9200);
             
             DataInputStream input= new DataInputStream (socket.getInputStream());
             DataOutputStream output= new DataOutputStream (socket.getOutputStream());
             
             String mensaje= "CLIENTE CONECTADO";
             // Se envia al cliente
             output.writeUTF(mensaje);
             // Se recibe mensaje del servidor
             String respuesta= input.readUTF();
             if (respuesta.equals("OK")){
                 MenuClientes menuClientes= new MenuClientes (this.id);
                 menuClientes.setVisible(true);
                 login.dispose();
                   
             }
                   
            
        } catch (IOException ex){
            
            
        }
        
        
        
       
    }
    
    
    

    
}
