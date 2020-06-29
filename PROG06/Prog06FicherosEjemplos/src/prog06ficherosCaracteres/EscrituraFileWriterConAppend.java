
package prog06ficherosCaracteres;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscrituraFileWriterConAppend {

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            File file = new File("lecturaFileWriter.txt"); // Solo es un objeto
            fw = new FileWriter(file, true); // abrimos el fichero para añadir TRUE
            fw.write("Esta es una nueva linea de append");             // Escribimos caracteres en el fichero
            fw.flush();                             // Limpiamos
            fw.close();                             // Cerramos el archivo cuando todo ha terminado
            System.out.println("El fichero se ha añadido una nueva linea al fichero existente");
        } catch (IOException ex) {
            Logger.getLogger(EscrituraFileWriterConAppend.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(EscrituraFileWriterConAppend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             
            
    }
    
}
