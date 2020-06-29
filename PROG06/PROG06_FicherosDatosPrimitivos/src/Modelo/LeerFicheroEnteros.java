package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerFicheroEnteros {

    // ATRIBUTOS
    
    // Objeto File con el archivo.
    // Se inicializa en el momento de leer (método leer), al especificar por
    // parámetro el fichero en concreto con el que queremos trabajar.
    private File fileEntrada;
    // Objeto FileIS para el flujo de datos de entrada.
    // Se inicializa en el método leer que será cuando tengamos el File para
    // pasarle por parámetro
    private FileInputStream fis;
    // Como trabajamos con enteros: objeto DataIS para tratar datos primitivos.
    // Se inicializa en el método leer que será cuando tengamos el FIS para
    // pasarle por parámetro
    private DataInputStream dis;

    
    // MÉTODOS
    
    // Constructor: Los atributos se inicializarán al ejecutar el método leer,
    // si inicializamos el File sólo servirá para leer el fichero con el que
    // lo creamos y será menos genérico
    public LeerFicheroEnteros() {

    }

    // Método para leer un entero de un fichero de enteros (pasando el nombre)
    public int leerUnEntero(String nombreFichero) {
        int auxReturn = 0;
        try {
            // Creamos los objetos
            fileEntrada = new File(nombreFichero);
            fis = new FileInputStream(fileEntrada);
            dis = new DataInputStream(fis);

            // Leemos el entero y lo guardamos en la variable a retornar
            auxReturn = dis.readInt();
            
            // Cerramos el fichero
            dis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado. " + ex.getMessage());
            Logger.getLogger(LeerFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Problema al leer el fichero. " + ex.getMessage());
            Logger.getLogger(LeerFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return auxReturn;
    }

    // Método para leer un entero de un fichero de enteros (pasando el File)
    public int leerUnEntero(File nombreFile) {
        int auxReturn = 0;
        try {
            // Creamos los objetos
            fileEntrada = nombreFile;
            fis = new FileInputStream(fileEntrada);
            dis = new DataInputStream(fis);

            // Leemos el entero y lo guardamos en la variable a retornar
            auxReturn = dis.readInt();
            
            // Cerramos el fichero
            dis.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado. " + ex.getMessage());
            Logger.getLogger(LeerFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Problema al leer el fichero. " + ex.getMessage());
            Logger.getLogger(LeerFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return auxReturn;
    }
}
