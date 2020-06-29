package Controlador;

import Modelo.Persona;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDAOs {

    public static void main(String[] args) {

        // Creo un controlador
        Controlador c = new Controlador("mayores.dat", "menores.dat", "todos.dat");
        // Creo 3 personas para grabar en un archivo
        Persona p1 = new Persona("Aran", "Fer Ar", 31);
        Persona p2 = new Persona("Firu", "Tález Tález", 14);
        Persona p3 = new Persona("Cali", "Cuález Cuález", 76);

        // Los voy metiendo por teclado con los métodos del DAO
        // No tengo que abrir ni cerrar ficheros porque lo hace el método grabarUnobjeto
        try {
            System.out.println("Grabando " + p1.toString());
            c.getDaoSalidaTodos().grabarUnObjeto(p1);
            System.out.println("Grabando " + p2.toString());
            c.getDaoSalidaTodos().grabarUnObjeto(p2);
            System.out.println("Grabando " + p3.toString());
            c.getDaoSalidaTodos().grabarUnObjeto(p3);
        } catch (IOException ex) {
            System.out.println("Problema al crear el fichero TODOS. " + ex.getMessage());
         //   Logger.getLogger(MainDAOs.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("Se ha terminado de grabar el fichero todos.dat");
        }

        // Copiamos los datos del fichero de entrada en los dos diferentes de salida
        try {
            System.out.println("Copiamos de manera selectiva");
            c.copiarFicheroSelectivamente();
        } catch (IOException ex) {
            System.out.println("Error al copiar de manera selectiva. "+ex.getMessage());
         //   Logger.getLogger(MainDAOs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada al copiar de manera selectiva");
          //  Logger.getLogger(MainDAOs.class.getName()).log(Level.SEVERE, null, ex);
        }

         // Comprobamos los resultados
 
            c.mostrarFicherosPorPantalla();

    }

}
