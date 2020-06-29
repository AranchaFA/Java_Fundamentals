package prog06ficherosCaracteres;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscrituraFileWrtierConBufferedWriter {

    public static void main(String[] args) {

        try {
            FileWriter fw = null;

            String sFichero = "filewriterConBufferedWriter.txt";

            //creamos el objeto FileWriter
            File file = new File(sFichero);
            fw = new FileWriter(file);

            BufferedWriter fbw = new BufferedWriter(fw);
            for (int i = 0; i < 5; i++) {
                String cadena ="cadena " + i+"\n";
                fbw.write(cadena );
            }
            fbw.close();
        } catch (IOException ex) {
            Logger.getLogger(EscrituraFileWrtierConBufferedWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
