package ejercicios;
//aqui centralizaremos la lógica de todo lo que hemos hecho anteriormente

import java.io.IOException;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException, IOException {
        //objeto de la clase Ejercicio10 (alumnoService en realidad)
        Ejercicio10 servicio = new Ejercicio10();

        // Probar métodos de AlumnoService
        servicio.insertarAlumno("Luis", 19);
        servicio.mostrarAlumnos();

    }
}
