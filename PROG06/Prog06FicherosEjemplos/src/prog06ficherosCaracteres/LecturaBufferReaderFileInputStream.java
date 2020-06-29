package prog06ficherosCaracteres;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LecturaBufferReaderFileInputStream {

    public static void main(String[] args) {
        try {
            FileInputStream fstream = null;
            
            File file = new File("lecturaFileWriter.txt"); // Solo es un objeto
            // Abrimos el archivo
            fstream = new FileInputStream(file);
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                // Imprimimos la línea por pantalla
                System.out.println (strLinea);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaBufferReaderFileInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("error en lectura");
        } 
    }
}
