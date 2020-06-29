package prog06RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModificarUnaPosicionDeUnRandomAccessFileDeEnteros {

    public static void leerRandomAccess(RandomAccessFile raf) {
        int totalEnteros;

        try {
            //calculamos cuantos enteros hay en el fichero, sabiendo 1 int = 4 bytes
            // y que length nos muestra el total de bytes del fichero
            totalEnteros = (int) (raf.length() / 4);
            System.out.println("\nEl fichero tiene " + totalEnteros + " enteros");
            raf.seek(0); //me situo al principio del fichero
            for (int pos = 0; pos < totalEnteros; pos++) {
                System.out.print(" " + raf.readInt());
                System.out.flush();
            }

        } catch (IOException ex) {
            System.out.println("Error en la lectura del fichero");
        }
    }

    public static void modificarPosicRandomAccessFile(RandomAccessFile raf) {

        long size;
        int pos, numero;
        Scanner sc = new Scanner(System.in);
        try {
            //calcular cuántos enteros tiene el fichero
            size = raf.length();  //total de bytes del fichero
            size = size / 4;  //cada entero ocupa 4 bytes
            System.out.println("\nEl fichero tiene " + size + " enteros");
            //Modificar el entero que se encuentra en una posición determinada
            do {
                System.out.println("Introduce una posición entre 1 y  " + size + " donde quieras modificar: ");
                pos = sc.nextInt();
            } while (pos < 1 || pos > size + 1);
            pos--;  //la posición 1 realmente es la 0
            //nos situamos en la posición (byte de inicio) del entero a modificar
            //en Java un entero ocupa 4 bytes
            raf.seek(pos * 4);
            if (size != 0) {  //el fichero no esta vacio
                //leemos y mostramos el valor actual
                System.out.println("Valor actual: " + raf.readInt());
            }
            //pedimos que se introduzca el nuevo valor
            System.out.println("Introduce nuevo valor: ");
            numero = sc.nextInt();
            //nos situamos de nuevo en la posición del entero a modificar
            //esto es necesario porque después de la lectura que hemos realizado para mostrar
            //el valor el puntero de lectura/escritura ha avanzado al siguiente entero del fichero.
            //si no hacemos esto escribiremos sobre el siguiente entero
            raf.seek(pos * 4);
            //escribimos el entero
            raf.writeInt(numero);
        } catch (IOException ex) {
            System.out.println("Error en la escritura del fichero");
        }
    }

    public static void main(String[] args) {

        RandomAccessFile fichero = null;
        int pos, numero;
        long size;
        try {
            fichero = new RandomAccessFile("randomAccessFile.txt", "rw");

            //leemos el fichero
            leerRandomAccess(fichero);

            //procedemos a modificar un valor concreto del fichero
            modificarPosicRandomAccessFile(fichero);

            //volvemos a leer el fichero para que nos muestre si se ha modificado el valor
            leerRandomAccess(fichero);
            try {
                fichero.close();
            } catch (IOException ex) {
                System.out.println("error en fichero");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no se encuentra");
        } catch (IOException ex) {
            System.out.println("Error en la E/S del fichero");
        }
    }
}
