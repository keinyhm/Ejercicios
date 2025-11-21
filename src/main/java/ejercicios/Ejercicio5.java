package ejercicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

//CLASE ALUMNOREPOSITORY PARA LA ENTIDAD ALUMNO
public class Ejercicio5 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");


    public void insertarAlumno(Alumno a) {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin(); //se inicia la transaccion
            em.persist(a);
            em.getTransaction().commit();//se confirma con un commit
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); //deshace si hay error
            }
            e.printStackTrace();
        } finally {
            em.close();  //cerramos el entity manager para evitar fuga de recursos
        }
    }

    public List<Alumno> listar(){
        EntityManager em = emf.createEntityManager();
        List<Alumno> lista = null;

        try{
            lista = em.createQuery("from Alumno").getResultList();
        } finally {
            em.close();
        }
        return lista;
    }

    //main para probar los métodos anteriores
    public static void main(String[] args) {
        Ejercicio5 repo = new Ejercicio5();

        Alumno a1 = new Alumno(18, "Keiny");
        repo.insertarAlumno(a1);

        List<Alumno> lista = repo.listar();
        for (Alumno a : lista) {
            System.out.println(a.getId() + " - " + a.getNombre() + " - " + a.getEdad());
        }
    }

}
