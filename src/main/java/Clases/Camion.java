package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Camion {

    // Atributos propios
    private int id;
    private String placa;
    private String modelo;
    private double capacidadMaxima;

    // Constructor para agregar
    public Camion(String placa, String modelo, double capacidadMaxima) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Constructor para modificar
    public Camion(int id, String placa, String modelo, double capacidadMaxima) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Constructor para eliminar
    public Camion(int id) {
        this.id = id;
    }

    // Consultar camiones
    public static DefaultTableModel cargarTabla() throws Exception {
        Conexion conexion = new Conexion();

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Placa");
        modelo.addColumn("Modelo");
        modelo.addColumn("Capacidad Máxima");

        String datos[] = new String[4];

        try {
            Statement st = conexion.crearConexion().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Camion");

            while (rs.next()) {
                datos[0] = rs.getString("id_Camion");
                datos[1] = rs.getString("placa");
                datos[2] = rs.getString("modelo");
                datos[3] = rs.getString("capacidadMaxima");
                modelo.addRow(datos);
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar camiones: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        return modelo;
    }

    // Agregar camión
    public void agregarCamion() throws Exception {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Camion (placa, modelo, capacidadMaxima) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conexion.crearConexion().prepareStatement(sql);
            ps.setString(1, this.placa);
            ps.setString(2, this.modelo);
            ps.setDouble(3, this.capacidadMaxima);

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Camión agregado con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar camión: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    // Modificar camión
    public void modificarCamion() throws Exception {
        Conexion conexion = new Conexion();
        String sql = "UPDATE Camion SET placa = ?, modelo = ?, capacidadMaxima = ? WHERE id_Camion = ?";

        try {
            PreparedStatement ps = conexion.crearConexion().prepareStatement(sql);
            ps.setString(1, this.placa);
            ps.setString(2, this.modelo);
            ps.setDouble(3, this.capacidadMaxima);
            ps.setInt(4, this.id);

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Camión modificado con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar camión: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    // Eliminar camión
    public void eliminarCamion() throws Exception {
        Conexion conexion = new Conexion();
        String sql = "DELETE FROM Camion WHERE id_Camion = ?";

        try {
            PreparedStatement ps = conexion.crearConexion().prepareStatement(sql);
            ps.setInt(1, this.id);

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Camión eliminado con éxito.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar camión: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCapacidadMaxima(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}
