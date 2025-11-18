package ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    //variable privada con el nombre del fichero
    private final String fileName = "alumnos.txt";

    //método de guardar usando el buffered writer para escribir en el fichero y guardarlo
    public void guardar(List<String> alumnos) throws IOException {
        try  (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            for (String a: alumnos) { //iteramos con un foreach
                bw.write(a);//escribimos
                bw.newLine();//añadimos la linea
            }
        }
    }

    //método de cargar usando buffered reader para leer linea por linea
    public List<String> cargar() throws IOException{
        List <String> lista = new ArrayList<>(); //creamos la lista
        //leemos con el buffered reader
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;//variable para almacenar cada linea
            while((linea = br.readLine()) != null){ //bucle para leer linea a linea
                lista.add(linea);
            }
        }
        return lista; //devuelve la lista
    }

    //método main para centralizar la lógica de la aplicación
    public static void main(String [] args)throws IOException {
        //creamos un objeto de la clase AlumnoRepositoryFile
        Ejercicio3 repo = new Ejercicio3();
        //guardamos datos con el método guardar y List.of para hacer que la lista  sea inmutable
        repo.guardar(List.of("Sofía, 17",  "María, 18", "Adela, 19" ));
        //para leer los datos llamamos al método cargar
        System.out.println("Datos leídos: " + repo.cargar());

    }
}
