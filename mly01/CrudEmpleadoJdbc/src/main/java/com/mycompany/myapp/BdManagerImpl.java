package com.mycompany.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BdManagerImpl implements BdManager {

    private final String URL = "jdbc:sqlite:archivos/empleados.db";

    public int vaciarTabla() throws SQLException {
        int cantFilas = 0;
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM empleados");
            cantFilas = ps.executeUpdate();
            ps.close();
        }
        return cantFilas;
    }

    public int cargaInicial(ArrayList<Empleado> empleados) throws SQLException {

    }

    public ArrayList<Empleado> consultar() throws SQLException {
    String sql = "SELECT id, nombre, salario FROM empleados";
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:empleados.db");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("\t id: " + rs.getInt(1));
                System.out.println("\t nombre: " + rs.getString(2));
                System.out.println("\t salario: " + rs.getFloat(3));
            }
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "%n" +
                    "SLQState: " + e.getSQLState() + "%n" +
                    "Mensaje: " + e.getMessage() + "%n");
        }
    }

    public ArrayList<Empleado> consultar(double minSalar, double maxSalar) throws SQLException {

    }

    public int insertar(Empleado empleado) throws SQLException {
     int cantFilas=0;
       
        try (Connection conexion = DriverManager.getConnection(URL)){
                PreparedStatement ps = conexion.prepareStatement("SELECT count(*) FROM empleados WHERE id=?") {
                ps.setLong(1,empleado.id);
            ResultSet rs = ps.executeQuery();
            rs.next();
                if (rs.getInt(1)==0){
                    ps=connection.prepareStatement("INSERT INTO empleados (id,nombre,salario) VALUES(?,?,?)");
                    ps.setLong(1,empleado.id);
                    ps.setString(2,empleado.nombre);
                    ps.setDouble(3,empleado.salario);
                    cantFilas=ps.executeUpdate();
                }
                ps.close();
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "%n" +
                    "SLQState: " + e.getSQLState() + "%n" +
                    "Mensaje: " + e.getMessage() + "%n");
        }

    
    }

    public int borrar(Long id) throws SQLException {

    }

    public int actualizar(Empleado empleado) throws SQLException {

    }
}
