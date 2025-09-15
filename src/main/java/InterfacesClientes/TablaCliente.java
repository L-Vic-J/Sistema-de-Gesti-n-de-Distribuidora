
package InterfacesClientes;

import Clases.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TablaCliente {


     
     public static DefaultTableModel cargarTabla(int id) throws Exception {
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
            String consulta="SELECT * FROM Pedido WHERE id_Cliente=?";
            CallableStatement st = conn.prepareCall(consulta);
            int idCliente= id;
            String idClienteStr=String.valueOf(idCliente);
            st.setString(1,idClienteStr);
            
            ResultSet rs = st.executeQuery();

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

    

}
