package ejercicios;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//EL EJERCICIO 4 CORRESPONDE A ALUMNODAO

    public class Ejercicio4Test {

        @Test
        void testInsertarAlumno() {
            Ejercicio4 dao = new Ejercicio4();

            // El test pasa si no se lanza ninguna excepción al insertar
            assertDoesNotThrow(() -> dao.insertar("Keiny", 18));
        }
    }







