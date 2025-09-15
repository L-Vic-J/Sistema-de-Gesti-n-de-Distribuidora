package Clases;

import Clases.Conexion;
import Enum.Rol;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Cliente{
    
  // Atributos de la clase
    
    private int id;
    private String nombre;
    private String correo;
    private String password;
    private Rol rol;
    
   
// Constructor agregar

    public Cliente(String nombre, String correo, String password, Rol rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }
    
    
// Constructor modificar

    public Cliente( int id,String nombre, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }
    
    
    // Constructor eliminar

    public Cliente(int id) {
        this.id = id;
    }
    
  
    
    
// CRUD
    
    // Metodo para agregar cliente
    public void agregarCliente() {
         Conexion conexion= new Conexion ();
          
          try {
              String agregar= "INSERT INTO Clientes (nombre,correo,contraseña,rol) VALUES (?,?,?,?)";
              CallableStatement callableStatement = conexion.crearConexion().prepareCall(agregar);
              
              callableStatement .setString(1,this.nombre);
              callableStatement .setString(2,this.correo);
              callableStatement .setString(3,this.password);
              callableStatement .setString(4,this.rol.toString());
              
              callableStatement.execute();
              
               JOptionPane.showMessageDialog(null, "Nuevo cliente agregado");
              
          } catch (SQLException exception){
                   JOptionPane.showMessageDialog(null, "Error al agregar el cliente a la base de datos, error:"+exception.getMessage());  
                } catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Error al agregar el cliente a la base de datos, error:"+exception.getMessage());  
                } finally {
                    conexion.cerrarConexion();
          }
           }

    
    // Metodo consultar
    public static DefaultTableModel cargarTabla () {
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
               ResultSet result= statement.executeQuery("SELECT * FROM Clientes");
               
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

        
      
   
     // Metodo para eliminar clientes
    public void eliminarCliente() {
         Conexion conexion= new Conexion ();
          
          try {
              
              String eliminar ="DELETE FROM Clientes WHERE id_Cliente=?";
              CallableStatement callAbleStatement =conexion.crearConexion().prepareCall(eliminar);
              callAbleStatement.setInt(1, this.id);
              callAbleStatement.executeUpdate();
              JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
                } catch (SQLException exception){
                   JOptionPane.showMessageDialog(null, "Error al eliminar el cliente de la base de datos, error:"+exception.getMessage());  
                } catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Error al eliminar el cliente de la base de datos, error:"+exception.getMessage());  
                } finally {
                    conexion.cerrarConexion();
          }
              
          }


    

    // Metodo para editar clientes
    public void editarCliente() {
         Conexion conexion= new Conexion ();
          
            String modificar ="""
                                UPDATE Clientes SET
                                nombre = ?,
                                correo = ?,
                                contraseña = ?
                                WHERE id_Cliente = ?
                                """;
          
          try {
              CallableStatement callableStatement =conexion.crearConexion().prepareCall(modificar);
              callableStatement.setString(1, this.nombre);
              callableStatement.setString(2, this.correo);
              callableStatement.setString(3, this.password);
              callableStatement.setInt(4, this.id);
          
              
              callableStatement.executeUpdate();
              
              JOptionPane.showMessageDialog(null, "Cliente modificado con exito");
                } catch (SQLException exception){
                   JOptionPane.showMessageDialog(null, "Error al editar el cliente de la base de datos, error:"+exception.getMessage());  
                } catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Error al editar el cliente de la base de datos, error:"+exception.getMessage());  
                } finally {
                    conexion.cerrarConexion();
          }
        
    }

    
    // To String cliente

    @Override
    public String toString() {
        return "\n=== Información del Cliente === "+
                   "\nID=" + id +
                   "\nNombre=" + nombre + 
                   "\nCorreo=" + correo+    
                   "\nContraseña=" + password;  
    }
    //getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }
    
    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        clientes = clientes;
    }
}
