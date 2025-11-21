package ejercicios;

import java.sql.*;

public class Ejercicio6 {
    private static final String URL = "jdbc:mysql://localhost:3306/escuela";
    private static final String USER = "root";
    private static final String PASS = "";

    public void mostrarJSON() throws SQLException {
        String sql = """
                SELECT 
                    nombre,
                    JSON_UNQUOTE(JSON_EXTRACT(datos, '$.curso')) AS curso
                FROM alumno
                """;

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String curso = rs.getString("curso"); // alias del SELECT

                System.out.println("Alumno: " + nombre + " | Curso: " + curso);
            }
        }
    }
    public static void main(String[] args) {
        Ejercicio6 repo = new Ejercicio6();

        try {
            repo.mostrarJSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
