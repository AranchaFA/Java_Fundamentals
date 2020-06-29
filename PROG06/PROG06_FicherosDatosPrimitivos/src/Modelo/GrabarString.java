package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarString {

    // ATRIBUTOS
    // Objeto File donde guardaremos los Strings
    private File fileStrings;
    // Metemos el File en un flujo de salida FileOS
    private FileOutputStream fos;
    // Metemos el FileOS en un DataOS (por trabajar con Strings)
    private DataOutputStream dos;

    // MÉTODOS
    // Getter del File por si fuera necesario
    public File getFileStrings() {
        return fileStrings;
    }

    // Constructor (NO creará los objetos, porque FOS debe crearse en el
    // método grabar para inicializar el 'new FOS(file,TRUE)' y que cada vez que
    // vayamos a grabar nos sitúe al final del fichero para introducir el nuevo
    // String, si no graba al inicio y nos pisa el fichero entero.
    public GrabarString() {
        
    }

    // Método para grabar un String al fichero de salida
    public boolean grabarEnFichero(String nombreFichero,String string) {
        boolean auxReturn = false;
        fileStrings = new File(nombreFichero);
        // ABRIMOS EL ARCHIVO
        try {
            // Necesitamos inicializar el 'new FOS(file,TRUE)' para que cada vez que
            // vayamos a grabar nos sitúe al final del fichero para introducir el nuevo
            // String, si no graba al inicio y nos pisa el fichero entero.
            fos = new FileOutputStream(fileStrings, true);
            dos = new DataOutputStream(fos);
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el fichero. " + ex.getMessage());
            Logger.getLogger(GrabarString.class.getName()).log(Level.SEVERE, null, ex);
        }
        // GRABAMOS EL STRING
        try {
            dos.writeUTF(string);
            // Si no graba porque hay una excepción rompe, y no cambia a auxReturn=true
            auxReturn = true;
        } catch (IOException ex) {
            System.out.println("Problema al grabar la información. " + ex.getMessage());
            Logger.getLogger(GrabarString.class.getName()).log(Level.SEVERE, null, ex);
        }
        // CERRAMOS EL FICHERO
        try {
            dos.close();
            fos.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero. "+ex.getMessage());
            Logger.getLogger(GrabarString.class.getName()).log(Level.SEVERE, null, ex);
        }

        return auxReturn;
    }
}
