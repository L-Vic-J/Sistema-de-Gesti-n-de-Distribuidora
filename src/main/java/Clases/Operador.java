
package Clases;

import Enum.Rol;
import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Operador extends Usuario {
    
   
    
    // Constructor agregar
    public Operador(String nombre, String correo, String password, Rol rol) {
        this.nombre=nombre;
        this.correo= correo;
        this.password= password;
        this.rol=rol;
    }
     
       // Constructor modificar
    public Operador(int id,String nombre, String correo, String password, Rol rol) {
        this.id=id;
        this.nombre=nombre;
        this.correo= correo;
        this.password= password;
        this.rol=rol;
    }
    
    
    // Constructor eliminar
    
        public Operador(int id) {
        this.id=id;
    }
        
        
         public void agregarUsuario (){
          Conexion conexion= new Conexion ();
          
          try {
              String agregar= "INSERT INTO Usuario (nombre,correo,contraseña,rol) VALUES (?,?,?,?)";
              CallableStatement callableStatement = conexion.crearConexion().prepareCall(agregar);
              
              callableStatement .setString(1,this.nombre);
              callableStatement .setString(2,this.correo);
              callableStatement .setString(3,this.password);
              if (this.rol.equals(Rol.Operador)){
                  callableStatement .setString(4,"Operador");
              } 
              callableStatement.execute();
              
               JOptionPane.showMessageDialog(null, "Nuevo usuario agregado");
              
          } catch (SQLException exception){
                   JOptionPane.showMessageDialog(null, "Error al agregar el usuario a la base de datos, error:"+exception.getMessage());  
                } catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Error al agregar el usuario a la base de datos, error:"+exception.getMessage());  
                } finally {
                    conexion.cerrarConexion();
          }
           }
        
             public void eliminarUsuario (){
          Conexion conexion= new Conexion ();
          
          try {
              
              String eliminar ="DELETE FROM Usuario WHERE id_Usuario=?";
              CallableStatement callAbleStatement =conexion.crearConexion().prepareCall(eliminar);
              callAbleStatement.setInt(1, this.id);
              callAbleStatement.executeUpdate();
              JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
                } catch (SQLException exception){
                   JOptionPane.showMessageDialog(null, "Error al eliminar el usuario de la base de datos, error:"+exception.getMessage());  
                } catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Error al eliminar el usuario de la base de datos, error:"+exception.getMessage());  
                } finally {
                    conexion.cerrarConexion();
          }
              
          }
        
        
        
        
        
        
        
        
    
      @Override
    public String toString() {
        return "\n=== Información del Usuario === "+
                   "\nID=" + id +
                   "\nNombre=" + nombre + 
                   "\nCorreo=" + correo+    
                   "\nContraseña=" + password+
                   " \nRol=" + rol;
             
    }
    
    
}
