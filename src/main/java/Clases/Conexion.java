
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    // Atributos propios de la clase
    
    private String url;
    private String db;
    private String usuario;
    private String password;
    private String driver;
    Connection conexion;
    
    // Constructor

    public Conexion() {
        this.url = "jdbc:mysql://localhost:3306/";
        this.db = "Distribuidora";
        this.usuario = "root";
        this.password = "root";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }
    
    
    // Metodo para conectar a la db
    
    public Connection crearConexion () throws Exception {
        
        try {
            Class.forName(driver);
            conexion= DriverManager.getConnection(url+db,usuario,password);
            return conexion;
  
        } catch (SQLException exception){
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, error:"+exception.getMessage());  
        } catch (ClassNotFoundException exception){
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, error:"+exception.getMessage());      
        }
       
        throw new Exception ();
    }
    
    
    
    
    // Metodo para cerrar conexion
    
    
    public void cerrarConexion (){
        
        if (conexion!=null){
            try {
                conexion.close();
            } catch (SQLException exception){
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion,error"+exception.getMessage());   
            }
                
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
}
