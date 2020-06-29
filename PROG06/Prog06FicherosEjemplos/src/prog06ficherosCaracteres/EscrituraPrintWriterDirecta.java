package prog06ficherosCaracteres;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscrituraPrintWriterDirecta {

    public static void main(String[] args) {
        
        PrintWriter file = null;
        try {
            file = new PrintWriter("FicheroPrintWriterDirecto.txt");
            file.println("Juan");
            file.println("Jesús");
            file.println("Miguel");
            file.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrituraPrintWriterDirecta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            file.close();
        }

    }

}
