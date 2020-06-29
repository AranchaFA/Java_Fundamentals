
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContarParesEImpares {

    public static void main(String[] args) {

        // Contadores para pares e impares
        int contPares = 0;
        int contImpares = 0;
        // Esto nos lo crea automáticamente al poner el try-catch
        FileInputStream fis = null;
        try {
            // Creamos el objeto File con el archivo de enteros
            File file = new File("enteros.dat");
            try {
                // Metemos en archivo en un flujo de lectura
                fis = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                System.out.println("Fichero no encontrado. " + ex.getMessage());
            }
            // Trabajamos con ints: lo metemos en un objeto tipo DataInputStream
            DataInputStream dis = new DataInputStream(fis);
            // Contamos las veces que aparecen pares e impares
            try {
                while (true) {
                    // El 0 se contabilizaría como par
                    if (dis.readInt() % 2 == 0) {
                        contPares++;
                    } else {
                        contImpares++;
                    }
                }
            } catch (EOFException ex) {
                System.out.println("Se ha terminado de leer el archivo. " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Problema al leer el fichero para contabilizar los pares e impares. ");
                System.out.println(ex.getMessage());
                Logger.getLogger(ContarParesEImpares.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            // Comparamos qué contador es mayor
            if (contImpares > contPares) {
            System.out.println("Hay más impares (" + contImpares + ") que pares (" + contPares + ").");
        } else if (contImpares < contPares) {
            System.out.println("Hay más pares (" + contPares + ") que impares (" + contImpares + ").");
        } else {
            System.out.println("Hay tantos pares (" + contPares + ") como impares (" + contImpares + ").");
        }
        try {
            fis.close();
        } catch (IOException ex) {
            System.out.println("Problemas al leer el fichero para cerrarlo.");
            Logger.getLogger(ContarParesEImpares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}
