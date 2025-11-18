package ejercicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Ejercicio4 {
    //declaramos en variables finales y privadas la conexión a la base de datos
    private final String url = "jdbc:mysql://localhost:3306/escuela";
    private final String user = "root";
    private final String pw = "";

    public void insertar(String nombre, int edad) throws SQLException {
        String sql = "INSERT INTO  alumno(nombre, edad) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(url, user, pw);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: El alumno que se ha intentado insertar ya existe en la base de datos. " + e.getMessage());
        }
    }

    public List<String> listar() throws IOException, SQLException {
        List<String> alumnos = new ArrayList();
        try (Connection con = DriverManager.getConnection(url, user, pw);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM alumno")) {
            while (rs.next()) {
                alumnos.add(rs.getString("nombre"));
                alumnos.add(rs.getString("edad"));
            }
        }
        return alumnos;
    }

    public static void main(String[] args) throws IOException, SQLException {
        Ejercicio4 alumnoDAO = new Ejercicio4();

        System.out.println("Guardando datos...");
        alumnoDAO.insertar("Sofía", 17);
        alumnoDAO.insertar("María", 19);
        alumnoDAO.insertar("Ana", 18);
        System.out.println("Listado de alumnos..." +  alumnoDAO.listar());
    }
}

