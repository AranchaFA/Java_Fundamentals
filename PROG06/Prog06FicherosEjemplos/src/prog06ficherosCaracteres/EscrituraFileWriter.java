/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06ficherosCaracteres;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscrituraFileWriter {

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            File file = new File("lecturaFileWriter.txt"); // Solo es un objeto
            fw = new FileWriter(file); // Creamos un fichero actual y un
            // objeto FileWriter
            fw.write("Hola como estas\n yo me llamo Roberto\n");             // Escribimos caracteres en el fichero
            fw.flush();                             // Limpiamos
            fw.close();                             // Cerramos el archivo cuando todo ha terminado
            System.out.println("El fichero se ha grabado con un mensaje");
        } catch (IOException ex) {
            Logger.getLogger(EscrituraFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(EscrituraFileWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             
            
    }
    
}
