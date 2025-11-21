package ejercicios;
//EL EJERCICIO 10 CORRESPONDE A LA CLASE ALUMNOSERVICE (se llama ejercicio10 por seguir un orden en los ejercicios)

import java.io.IOException;
import java.sql.SQLException;

public class Ejercicio10 {
    private Ejercicio4 alumnoDAO; //instancia de la clase AlumnosDAO (Ejercicio4 en este caso)

    //constructor
    public Ejercicio10(){
       alumnoDAO = new Ejercicio4();
    }

    //metodo de insertar alumno llamano al que maneja la inserción desde la bd(ejercicio 4)
    public void insertarAlumno(String nombre, int edad) throws IOException, SQLException {
       alumnoDAO.insertar(nombre, edad);
    }

    //al igual que el anterior se llama el metodo dem mostrar definido desde el ejercicio 4
    public void mostrarAlumnos() throws IOException, SQLException {
       alumnoDAO.listar();
   }
}






