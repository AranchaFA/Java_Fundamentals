package prog06ficherosCaracteres;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscrituraPrintWriterConFileWriter {

    public static void main(String[] args) {
        
        FileWriter fw = null;
        try {
            PrintWriter file = null;
            fw = new FileWriter("FicheroPrintWriterConFileWriter.txt");
            file = new PrintWriter(fw);
            file.println("Juan");
            file.println("Jesús");
            file.println("Miguel");
            file.close();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(EscrituraPrintWriterConFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(EscrituraPrintWriterConFileWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
