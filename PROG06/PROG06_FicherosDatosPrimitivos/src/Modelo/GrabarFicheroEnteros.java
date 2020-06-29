package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarFicheroEnteros {

    // ATRIBUTOS
    
    // Objeto File con el fichero. 
    // Se inicializa en el momento de grabar (método grabar), al especificar por
    // parámetro el fichero en concreto con el que queremos trabajar.
    private File fileSalida;
    // Objeto FileOS para el flujo de salida de datos. 
    // Se inicializa en el método grabar que será cuando tengamos el File para
    // pasarle por parámetro
    private FileOutputStream fos;
    // Trabajamos con int: DataOS para trabajar con datos primitivos
    // Se inicializa en el método grabar que será cuando tengamos el FOS para
    // pasarle por parámetro
    private DataOutputStream dos;

    
    // MÉTODOS
    
    // Constructor: Los atributos se inicializarán al ejecutar el método leer,
    // si inicializamos el File sólo servirá para leer el fichero con el que
    // lo creamos y será menos genérico.
    // El FOS hay que inicializarlo OBLIGATORIAMENTE en el método grabar para
    // que nos sitúe al final del fichero cada vez que vayamos a grabar y no
    // nos pise toda la información guardada anteriormente
    public GrabarFicheroEnteros() {
    }

    // Método para grabar un entero.
    public void grabarUnEntero(int entero, String nombreFichero) {
        try {

            // Creamos los objetos
            fileSalida = new File(nombreFichero);
            fos = new FileOutputStream(fileSalida, true);
            dos = new DataOutputStream(fos);

            // Grabamos el entero
            dos.writeInt(entero);

            // Cerramos fichero
            dos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado. " + ex.getMessage());
            Logger.getLogger(GrabarFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Problema al grabar el dato. " + ex.getMessage());
            Logger.getLogger(GrabarFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
