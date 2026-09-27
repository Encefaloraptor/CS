package com.mycompany.myapp;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        final String URL = "jdbc:sqlite:archivos/empleados.db";
        final String QUERY = "SELECT * FROM empleados WHERE salario >= ? and salario <= ?";
        ArrayList<Empleado> resultado = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement ps = connection.prepareStatement(QUERY);
            ps.setDouble(1, 30000);
            ps.setDouble(2, 60000);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                resultado.add(new Empleado(rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getDouble("salario")));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        System.out.println(resultado);
    }
}
