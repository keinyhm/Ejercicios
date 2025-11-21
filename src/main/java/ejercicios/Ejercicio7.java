package ejercicios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CLASE ALUMNO DOCUMENTAL!!!
public class Ejercicio7 {
    private static final String FICHERO = "alumnos.json";
    private static final String CAMPO_NOMBRE = "nombre";
    private static final String CAMPO_EDAD   = "edad";
    private static final String CAMPO_CURSO  = "curso";

    private final ObjectMapper mapper;

    public Ejercicio7() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // JSON bonito
    }

    public void guardar(List<Map<String, Object>> alumnos) throws IOException {
        File file = new File(FICHERO);
        mapper.writeValue(file, alumnos);
    }

    public List<Map<String, Object>> leer() throws IOException {
        File file = new File(FICHERO);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        return mapper.readValue(
                file,
                new TypeReference<List<Map<String, Object>>>() {}
        );
    }

    private static Map<String, Object> crearAlumno(String nombre, int edad, String curso) {
        Map<String, Object> alumno = new HashMap<>();
        alumno.put(CAMPO_NOMBRE, nombre);
        alumno.put(CAMPO_EDAD, edad);
        alumno.put(CAMPO_CURSO, curso);
        return alumno;
    }

    public static void main(String[] args) throws IOException {
        Ejercicio7 doc = new Ejercicio7();

        List<Map<String, Object>> alumnos = new ArrayList<>();
        alumnos.add(crearAlumno("Martina", 20, "1º DAM"));
        alumnos.add(crearAlumno("Luis", 21, "2º DAM"));
        alumnos.add(crearAlumno("Julia", 19, "1º ASIR"));

        doc.guardar(alumnos);
        System.out.println("Alumnos guardados en " + FICHERO);

        List<Map<String, Object>> leidos = doc.leer();
        System.out.println("Contenido leído de " + FICHERO + ":");

        for (Map<String, Object> a : leidos) {
            System.out.println("Nombre: " + a.get(CAMPO_NOMBRE)
                    + ", Edad: " + a.get(CAMPO_EDAD)
                    + ", Curso: " + a.get(CAMPO_CURSO));
        }
    }
}
