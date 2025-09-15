
package Clases;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Producto {
        // Atributos propios
   
    private int id;
    private String nombre;
    private String descripcion; 
    private int cantidad;
    private double peso; 
    private String unidad;
    private double precio;
    private boolean disponible;
  
    
  
    
    // Constructor agregar

    public Producto(String nombre, String descripcion, int cantidad, double peso,String unidad,double precio,boolean disponible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.peso = peso;
        this.unidad=unidad;
        this.precio = precio;
        this.disponible=disponible;
    }
    
 
   
    // Constructor modificar 

    public Producto(int id, String nombre, String descripcion, int cantidad, double peso,String unidad ,double precio, boolean disponible) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
        this.cantidad = cantidad;
        this.peso = peso;
         this.unidad=unidad;
        this.precio = precio;
        this.disponible = disponible;
    }
    
    
    // Constructor eliminar

    public Producto(int id) {
        this.id = id;
    }
    
    
    // CRUD
    
    
      // Consultar productos
      
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
           modelo.addColumn("Descripción");
           modelo.addColumn("Cantidad");
           modelo.addColumn("Peso");
           modelo.addColumn("Unidad");
           modelo.addColumn("Precio");
           modelo.addColumn("Esta disponible");
                   
           String datos[] = new String[8];
           
           try {
               // Se hace query a la bd
               Statement statement = conexion.crearConexion().createStatement();
               ResultSet result= statement.executeQuery("SELECT * FROM Producto");
               
               // Se guarda los campos en la lista
               while (result.next()){
                   datos [0]= result.getString(1);
                   datos [1]= result.getString(2);     
                   String descripcion= result.getString(3);
                   if (descripcion.equals(null)){
                       descripcion="N/A";
                   }
                   datos [2]= descripcion;
                   
                   datos [3]= result.getString(4);
                   datos [4]= result.getString(5);
                   datos [5]= result.getString(6);
                   datos [6]= result.getString(7);
                   datos[7] = result.getInt(8) == 1 ? "Sí" : "No";
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
      
      public void agregarProducto (){
          Conexion conexion= new Conexion ();
          
          
          try {
              String agregar= "INSERT INTO Producto (nombre,descripcion,cantidad,peso,unidad,precio,disponible) VALUES (?,?,?,?,?,?,?)";
              CallableStatement callableStatement = conexion.crearConexion().prepareCall(agregar);
              
              callableStatement .setString(1,this.nombre);
              callableStatement .setString(2,this.descripcion);
              callableStatement .setInt(3,this.cantidad);
              callableStatement .setDouble(4,this.peso);
              callableStatement .setString(5,this.unidad);
              callableStatement .setDouble(6,this.precio);

              int disponibilidad = this.disponible ? 1 : 0;
              callableStatement.setInt(7, disponibilidad);
             
              callableStatement.execute();
              
               JOptionPane.showMessageDialog(null, "Nuevo producto agregado");
              
          } catch (SQLException exception){
                   JOptionPane.showMessageDialog(null, "Error al agregar el producto a la base de datos, error:"+exception.getMessage());  
                } catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Error al agregar el producto a la base de datos, error:"+exception.getMessage());  
                } finally {
                    conexion.cerrarConexion();
          }
           }
      

      
      
         public void ModificarProducto (){
          Conexion conexion= new Conexion ();
          //String nombre, String descripcion, int cantidad, double peso, double precio,boolean disponible
          
            String modificar ="""
                                UPDATE Producto SET
                                nombre = ?,
                                descripcion = ?,
                                cantidad = ?,
                                peso = ?,
                                precio = ?,
                                disponible= ?
                                WHERE id_producto = ?
                                """;
          
          try {
              CallableStatement callableStatement =conexion.crearConexion().prepareCall(modificar);
              callableStatement.setString(1, this.nombre);
              callableStatement.setString(2, this.descripcion);
              callableStatement.setInt(3, this.cantidad);
              callableStatement.setDouble(4, this.peso);
              callableStatement.setDouble(5, this.precio);
              
              int disponibilidad = this.disponible ? 1 : 0;
              callableStatement.setInt(6, disponibilidad);
              callableStatement.setInt(7, this.id);
              
              callableStatement.executeUpdate();
              
              JOptionPane.showMessageDialog(null, "Producto modificado con exito");
                } catch (SQLException exception){
                   JOptionPane.showMessageDialog(null, "Error al modificar el producto en la base de datos, error:"+exception.getMessage());  
                } catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Error al modificar el producto en la base de datos, error:"+exception.getMessage());  
                } finally {
                    conexion.cerrarConexion();
          }
              
          }
          
         
         
         
    // Getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }
    
    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
    
    
    
    
}
