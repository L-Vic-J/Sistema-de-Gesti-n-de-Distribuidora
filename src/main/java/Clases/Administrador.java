
package Clases;

import Enum.Rol;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Administrador extends Usuario{
    
    

      // Constructor agregar 
    
    public Administrador(String nombre, String correo, String password, Rol rol) {
        this.nombre=nombre;
        this.correo= correo;
        this.password= password;
        this.rol=rol;
    }
       
    
        // Constructor actualizar
    
    public Administrador(int id,String nombre, String correo, String password, Rol rol) {
       this.id=id;
       this.nombre=nombre;
       this.correo=correo;
       this.password=password;
       this.rol=rol;
    }
    
    // Constructor eliminar
      public Administrador(int id) {
       this.id=id;
    }
   
 
      // CRUD
      
      // Consultar usuarios
      
      public static DefaultTableModel cargarTabla (){
                 
          
          // Instancia de conexion
          Conexion conexion= new Conexion ();
          
          // Instancia DefaultTableModel, se inmoviliza columnas 
           DefaultTableModel modelo = new DefaultTableModel(){
              @Override
              public boolean isCellEditable(int row, int column) {
                  return false;
              }
              
           };
           
           // Se agrega columnas
           
           modelo.addColumn("ID");
           modelo.addColumn("Nombre");
           modelo.addColumn("Correo");
           modelo.addColumn("Contraseña");
           modelo.addColumn("Rol");
                   
           String datos[] = new String[5];
           
           try {
               // Se hace query a la bd
               Statement statement = conexion.crearConexion().createStatement();
               ResultSet result= statement.executeQuery("SELECT * FROM Usuario");
               
               // Se guarda los campos en la lista
               while (result.next()){
                   datos [0]= result.getString(1);
                   datos [1]= result.getString(2);
                   datos [2]= result.getString(3);
                   datos [3]= result.getString(4);
                   datos [4]= result.getString(5);
                   modelo.addRow(datos);      
                   }
          
               // Se capturan excepciones
           }  catch (SQLException exception){
                   JOptionPane.showMessageDialog(null, "Error al cargar la base de datos, error:"+exception.getMessage());  
          } catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Error al cargar la base de datos, error:"+exception.getMessage());  
          } finally {
               conexion.cerrarConexion();
           }
           return modelo;
          
           }
      
      
      
      // Agregar usuarios
      
      public void agregarUsuario (){
          Conexion conexion= new Conexion ();
          
          try {
              String agregar= "INSERT INTO Usuario (nombre,correo,contraseña,rol) VALUES (?,?,?,?)";
              CallableStatement callableStatement = conexion.crearConexion().prepareCall(agregar);
              
              callableStatement .setString(1,this.nombre);
              callableStatement .setString(2,this.correo);
              callableStatement .setString(3,this.password);
              if (this.rol.equals(Rol.Administrador)){
                  callableStatement .setString(4,"Administrador");
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
      
      
         public void ModificarUsuario (){
          Conexion conexion= new Conexion ();
          
            String modificar ="""
                                UPDATE Usuario SET
                                nombre = ?,
                                correo = ?,
                                contraseña = ?,
                                rol = ?
                                WHERE id_Usuario = ?
                                """;
          
          try {
              CallableStatement callableStatement =conexion.crearConexion().prepareCall(modificar);
              callableStatement.setString(1, this.nombre);
              callableStatement.setString(2, this.correo);
              callableStatement.setString(3, this.password);
              
                if (this.rol.equals("Administrador")){
                  callableStatement .setString(4,"Administrador");
              } else {
                 callableStatement .setString(4,"Operador");
                  }      
              
              callableStatement.setInt(5, this.id);
          
              
              callableStatement.executeQuery();
              
              JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
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
       
       
    

