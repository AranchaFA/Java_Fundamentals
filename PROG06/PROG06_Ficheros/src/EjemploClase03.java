
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploClase03 {

    // Leer un fichero de enteros y contar cuántas veces se repite un número pedido por teclado 
    public static void main(String[] args) {

        /* Scanner fich=new Scanner("enteros.dat");
           fich.nextInt(); // Nos leería el siguiente entero del fichero directamente
         */
        Scanner teclado = new Scanner(System.in);
        FileInputStream fis = null;

        // Contador y número a buscar
        int contVecesApareceNum = 0;
        int numABuscar = -1; // Nos pide inicializarlo al devolverlo en el sout del finally
        int numLeidoDelFichero; // Lo necesitamos para el bucle, si no nos pitaba el EOFException
        int posicion = 0; // Para controlar las posiciones en que encontramos el número
        try {
            // Creamos el objeto tipo File con el archivo a leer
            File file = new File("enteros.dat");
            // Creamos el flujo de datos (bytes)
            fis = new FileInputStream(file);
            // "Englobamos" el fis en la clase para datos primitivos (porque son enteros)
            DataInputStream dis = new DataInputStream(fis);

            // Pedimos el número a buscar
            System.out.println("¿Qué número quieres buscar?: ");
            numABuscar = teclado.nextInt();

            // Recorremos el fichero entero a entero comparando con el numABuscar
            while (true) { // Bucle infinito, termina cuando rompe por la excepción de fin de fichero
                numLeidoDelFichero = dis.readInt();
                posicion++;
                if (numLeidoDelFichero == numABuscar) {
                    contVecesApareceNum++;
                    System.out.println("Se ha encontrado el " + numLeidoDelFichero + ", contador=" + contVecesApareceNum);
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No encuentra el fichero.");
            // Logger.getLogger(EjemploClase03.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
            System.out.println("Hemos llegado al final del fichero.");
        } catch (IOException ex) {
            System.out.println("Problema en la lectura del fichero. " + ex.getMessage());
        } finally { // El finally lo ejecuta tanto si rompe el programa (EOFException p.ej.) como si sale bien
            // en este caso, podríamos mostrar el resultado aquí o después del while
            System.out.println("El número " + numABuscar + " aparece " + contVecesApareceNum + " veces");
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(EjemploClase03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
