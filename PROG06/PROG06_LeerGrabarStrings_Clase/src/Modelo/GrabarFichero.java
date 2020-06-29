
package Modelo;

import java.io.*; // Para poner todas las clases del paquete java.io
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarFichero {
    
    private String cadena;
    private File file;
    private FileOutputStream fos;
    private DataOutputStream dos;

    public GrabarFichero(File file) {
        this.file = file;
    }

    public void abrirFichero(){
        try {
            fos=new FileOutputStream(file,true);
            dos=new DataOutputStream(fos);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        }
    }
    
    public void cerrarFichero(){
        try {
            dos.close();
            fos.close();
        } catch (IOException ex) {
            System.out.println("Problemas al cerrar el fichero. "+ex.getMessage());
        }
    }
    
    public void grabar(){
        String opcion;
        do {            
            // Abrimos el fichero
        abrirFichero();
        // Grabamos el String
        System.out.println("Introduce la cadena a grabar: ");
        try {
            dos.writeUTF(leerCadenaAGrabar());
        } catch (IOException ex) {
            System.out.println("Problema al grabar en fichero. "+ex.getMessage());
        }
        // Cerramos el fichero
        cerrarFichero();
        
            System.out.println("¿Quieres grabar más cadenas? S/N");
            opcion= leerCadenaAGrabar();
        } while (opcion.toUpperCase().equals("S"));
        
    }
    
    public String leerCadenaAGrabar(){
        Scanner teclado =new Scanner(System.in);
        String cadena=teclado.nextLine();
        return cadena;
    }
}
