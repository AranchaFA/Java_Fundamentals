package prog06ficherosCaracteres;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EScrituraPrintWriterConBufferedWriter {

    public static void main(String[] args) {
        try {
            File f;
            f = new File("FicheroPrintWriterConBufferedWriter.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter wr = new PrintWriter(bw);
            wr.println("Juan");//escribimos en el archivo
            wr.println("Jesus"); //concatenamos en el archivo sin borrar lo existente
            wr.close();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(EScrituraPrintWriterConBufferedWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
