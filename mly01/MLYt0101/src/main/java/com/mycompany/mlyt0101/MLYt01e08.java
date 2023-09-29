/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mlyt0101;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author OWNER
 */
public class MLYt01e08 {

    public static void main(String[] args) {
        insertar(104,"Eva",40000);
        consultar();
    }

    public static void consultar() {
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

    public static void insertar(int id, String nombre, float salario) {
         String sql = "INSERT INTO empleados (id, nombre, salario) VALUES (?,?,?)";
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:empleados.db");
                PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setInt(1,id);
                ps.setString(2,nombre);
                ps.setFloat(3,salario);
            int cantFilasAfectadas = ps.executeUpdate();
           
                System.out.println("\t Hemos insertado: " + cantFilasAfectadas);
             
        } catch (SQLException e) {
            System.out.println("Código de Error: " + e.getErrorCode() + "%n" +
                    "SLQState: " + e.getSQLState() + "%n" +
                    "Mensaje: " + e.getMessage() + "%n");
        }

    }
}
