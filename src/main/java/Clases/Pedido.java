package Clases;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
// Se importa el paquete types para setear nulls
import java.sql.Types;

public class Pedido {

    // Atributos
    private int id;
    private int idCliente;
    private String direccionEntrega;
    private double pesoTotal;
    private String estado;  
    private Integer idCamion;

    // Constructores
    public Pedido(int idCliente, String direccionEntrega, double pesoTotal) {
        this.idCliente = idCliente;
        this.direccionEntrega = direccionEntrega;
        this.pesoTotal = pesoTotal;
        this.estado = "Pendiente";
        this.idCamion = null;
    }

    public Pedido(int id, int idCliente, String direccionEntrega, double pesoTotal, String estado, Integer idCamion) {
        this.id = id;
        this.idCliente = idCliente;
        this.direccionEntrega = direccionEntrega;
        this.pesoTotal = pesoTotal;
        this.estado = estado;
        this.idCamion = idCamion;
    }
    
    // Para CRUD de pedidos

    public Pedido(int id) {
        this.id = id;
    }
    
    // Para pedidos de Clientes
   public Pedido(Integer idCliente) {
        this.idCliente=idCliente;
    }

    

    // Cargar todos los pedidos
    public static DefaultTableModel cargarTabla() throws Exception {
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("Peso Total");
        modelo.addColumn("Estado");
        modelo.addColumn("Camión");

        String[] datos = new String[6];

        try {
            Connection conn = conexion.crearConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Pedido");

            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt("id_Pedido"));
                datos[1] = String.valueOf(rs.getInt("id_Cliente"));
                datos[2] = rs.getString("direccionEntrega");
                datos[3] = String.valueOf(rs.getDouble("pesoTotal"));
                datos[4] = rs.getString("estado");
                datos[5] = String.valueOf(rs.getInt("id_Camion"));
                modelo.addRow(datos);
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar pedidos: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        return modelo;
    }

    // Agregar pedido
    public void agregarPedido() throws Exception {

        Conexion conexion = new Conexion();
        try {
            String agregar = "INSERT INTO Pedido (id_Cliente, direccionEntrega, pesoTotal, estado, id_Camion) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(agregar, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, this.idCliente);
            ps.setString(2, this.direccionEntrega);
            ps.setDouble(3, this.pesoTotal);
            ps.setString(4, this.estado);
            ps.setInt(5, this.idCamion);
            
       
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);  // Guarda el ID generado
            }

            JOptionPane.showMessageDialog(null, "Pedido agregado con éxito.");

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error al agregar pedido: " + exception.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }
    
    
    
    public void agregarPedidoCliente() throws Exception {

        Conexion conexion = new Conexion();
        try {
            String agregar = "INSERT INTO Pedido (id_Cliente, direccionEntrega, pesoTotal, estado) VALUES (?,?,?,?)";
            PreparedStatement ps = conexion.crearConexion().prepareStatement(agregar, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, this.idCliente);
            ps.setString(2, this.direccionEntrega);
            ps.setDouble(3, this.pesoTotal);
            ps.setString(4, this.estado);
    
       
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);  // Guarda el ID generado
            }

            JOptionPane.showMessageDialog(null, "Pedido agregado con éxito.");

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error al agregar pedido: " + exception.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    
   

    // Modificar pedido
    public void modificarPedido() throws Exception {
        Conexion conexion = new Conexion();

        try {
            Connection conn = conexion.crearConexion();
            String sql = "UPDATE Pedido SET id_Cliente=?, direccionEntrega=?, pesoTotal=?, estado=?, id_Camion=? WHERE id_Pedido=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, this.idCliente);
            ps.setString(2, this.direccionEntrega);
            ps.setDouble(3, this.pesoTotal);
            ps.setString(4, this.estado);

            if (this.idCamion != null) {
                ps.setInt(5, this.idCamion);
            } else {
                ps.setString(5, null);
            }

            ps.setInt(6, this.id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Pedido modificado con éxito.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar pedido: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    
        // Modificar pedido
    public void modificarPedidoCliente() throws Exception {
        Conexion conexion = new Conexion();

        try {
            Connection conn = conexion.crearConexion();
            String sql = "UPDATE Pedido SET direccionEntrega=?, pesoTotal=? WHERE id_Pedido=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, this.direccionEntrega);
            ps.setDouble(2, this.pesoTotal);
            ps.setInt(3, this.id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Pedido modificado con éxito.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar pedido: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        
    }
            
            
            
    // Eliminar pedido
    public void eliminarPedido() throws Exception {
        Conexion conexion = new Conexion();

        try {
            Connection conn = conexion.crearConexion();

            // 1. Eliminar productos asociados en Pedido_Producto
            String deleteProductos = "DELETE FROM Pedido_Producto WHERE id_Pedido=?";
            PreparedStatement psProductos = conn.prepareStatement(deleteProductos);
            psProductos.setInt(1, this.id);
            psProductos.executeUpdate();
            psProductos.close();

            // 2. Eliminar el pedido
            String deletePedido = "DELETE FROM Pedido WHERE id_Pedido=?";
            PreparedStatement psPedido = conn.prepareStatement(deletePedido);
            psPedido.setInt(1, this.id);
            psPedido.executeUpdate();
            psPedido.close();

            JOptionPane.showMessageDialog(null, "Pedido eliminado con éxito.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar pedido: " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    
    // Metodo para ver el historial de cliente
     public static void Historial(int id) {    
     Conexion conexion = new Conexion ();
     
     // Realiza consulta a tabla usando el ID del cliente logeado
     
     String sql= "SELECT * FROM Pedido WHERE id_Cliente= ?";
     
     try{
         
         // Abre conexion
         PreparedStatement ps = conexion.crearConexion().prepareStatement(sql);
         ps.setInt(1, id);
         ResultSet rs= ps.executeQuery();
         String contenido="Historial de pedidos\n";
         while (rs.next()){
             
           // Almacena en una instancia de pedido cada campo del registro pedido
           Pedido pedido = new Pedido(rs.getInt("id_Pedido"),rs.getInt("id_Cliente"),rs.getString("direccionEntrega"),rs.getDouble("pesoTotal"),rs.getString("estado"),rs.getInt("id_Camion"));
          
          // Lo almacena en una varibale String, cada registro se almacena debajo del anterior
          contenido+= pedido.toString()+"\n";    
         }
         
         // Muestra en pantalla el historial
         JOptionPane.showMessageDialog(null, contenido);
         
         
     } catch (Exception exception){
         JOptionPane.showConfirmDialog(null, "Error al generar el historial", "Generación de historial",JOptionPane.ERROR_MESSAGE);
         
     }   
 }
   
     
     
     
     // Metodo para consultar pedido
     
public void ConsultarPedido() {    
     Conexion conexion = new Conexion ();
     
     // Realiza consulta a tabla usando el ID del cliente logeado
     
     String sql= "SELECT * FROM Pedido WHERE id_Pedido= ?";
     
     try{
         
         // Abre conexion
         PreparedStatement ps = conexion.crearConexion().prepareStatement(sql);
         ps.setInt(1, this.id);
         ResultSet rs= ps.executeQuery();
         String contenido="Información del pedido\n";
         while (rs.next()){
             
           // Almacena en una instancia de pedido cada campo del registro pedido
           Pedido pedido = new Pedido(rs.getInt("id_Pedido"),rs.getInt("id_Cliente"),rs.getString("direccionEntrega"),rs.getDouble("pesoTotal"),rs.getString("estado"),rs.getInt("id_Camion"));
          
          // Lo almacena en una varibale String, cada registro se almacena debajo del anterior
          contenido+= pedido.toString()+"\n";    
         }
         
         // Muestra en pantalla el historial
         JOptionPane.showMessageDialog(null, contenido);
         
         
     } catch (Exception exception){
         JOptionPane.showConfirmDialog(null, "Error al consultar el pedido", "Consulta de pedido",JOptionPane.ERROR_MESSAGE);
         
     }   
 }
       
     
 // Metodo para generar reporte
 public void GenerarReporte(int id) {
         try {
        
      

        // Abre conexion con la BD
        Conexion conexion = new Conexion();
        Connection conexionDB = conexion.crearConexion();

        // Hace el query
        String sql = "SELECT * FROM Pedido WHERE id_Pedido = ?";
        PreparedStatement ps = conexionDB.prepareStatement(sql);
        ps.setInt(1, this.id);
        ResultSet rs = ps.executeQuery();

        // Crea carpeta
        File carpeta = new File("ProyectoSegundoAvance/Reportes");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        // Crea archivo txt para el reporte

        String nombreArchivo = "pedido_" + id + ".txt";
        File archivo = new File(carpeta, nombreArchivo);
        FileWriter fw = new FileWriter(archivo);

        
       // Lee cada registro y lo escribe en codificación UTF
        if (rs.next()) {
            
            // El output lo hace solo con getPath para sobreescribir el archivo en caso de actualizacion de pedido
            try (DataOutputStream outPut= new DataOutputStream (new FileOutputStream(archivo.getPath()))){
                
                outPut.writeUTF("Reporte del pedido:"+rs.getInt("id_Pedido")+"\n");
                outPut.writeUTF("Direccion de entrega:"+rs.getString("direccionEntrega")+"\n");
                outPut.writeUTF("Peso total:"+rs.getDouble("pesoTotal")+"\n");
                outPut.writeUTF("Estado:"+rs.getString("estado")+"\n");
                outPut.writeUTF("ID camion:"+rs.getInt("id_Camion")+"\n");   
                
                JOptionPane.showMessageDialog(null, "Reporte de pedido generado con éxito", "Generación de pedido", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException exception){
                JOptionPane.showMessageDialog(null, "Error al generar reporte", "Generación de pedido", JOptionPane.INFORMATION_MESSAGE);
                
            }
           
            JOptionPane.showMessageDialog(null, "Reporte guardado en: " + archivo.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un pedido con ese ID.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
        

}
    
    
   
    // Getters y Setters
    public int getId() { 
        return id; 
    }
    
    public int getIdCliente() { 
        return idCliente; 
    }
    
    public String getDireccionEntrega() { 
        return direccionEntrega; 
    }
    
    public double getPesoTotal() { 
        return pesoTotal; 
    }
    
    public String getEstado() { 
        return estado; 
    }
    
    public Integer getIdCamion() { 
        return idCamion; 
    }

    public void setId(int id) { 
        this.id = id; 
    }
    
    public void setIdCliente(int idCliente) { 
        this.idCliente = idCliente; 
    }
    
    public void setDireccionEntrega(String direccionEntrega) { 
        this.direccionEntrega = direccionEntrega; 
    }
    
    public void setPesoTotal(double pesoTotal) { 
        this.pesoTotal = pesoTotal; 
    }
    
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
    
    public void setIdCamion(Integer idCamion) { 
        this.idCamion = idCamion; 
    }

    @Override
    public String toString() {
        return  
                
        "\nID=" + id +"ID Cliente=" + idCliente +"Direccion de entrega='" + direccionEntrega+"Peso total=" + pesoTotal +"Estado" + estado + "ID Camion=" + idCamion;
               
    }
}