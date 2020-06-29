/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06ficherosCaracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rpe
 */
public class LecturaFileWriter {

    public static void main(String[] args) {

        FileReader fw = null;
        boolean eof = false;
        int c = 0;

        File file = new File("lecturaFileWriter.txt"); // Solo es un objeto
        if (file.exists()) {
            try {
                fw = new FileReader(file); // Creamos un fichero actual y un
                // objeto FileReader
                c = fw.read(); //leo el primer caracter de fichero 
                while (c != -1) { //si no es eof leo el resto
                    System.out.print((char) c); //lo convierto en caracter  
                    c = fw.read();             //read lee int del fichero 
                }
                fw.close();               // Cerramos el archivo cuando todo ha terminado               
                System.out.println("\nEl fichero se ha leido con un mensaje");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LecturaFileWriter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("error en lectura");
            }

        } else {
            System.out.println("El fichero no existe");
        }

    }

}
