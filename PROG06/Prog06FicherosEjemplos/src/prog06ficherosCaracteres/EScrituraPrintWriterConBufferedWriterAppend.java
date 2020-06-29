package prog06ficherosCaracteres;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EScrituraPrintWriterConBufferedWriterAppend {

    public static void main(String[] args) {
        try {
            File f;
            f = new File("FicheroPrintWriterConBufferedWriter.txt");
            FileWriter fw = new FileWriter(f,true); //preparamos para añadir
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter wr = new PrintWriter(bw);
            wr.println("Maria");//escribimos en el archivo
            wr.write("Ana"); //concatenamos en el archivo sin borrar lo existente
            wr.close();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(EScrituraPrintWriterConBufferedWriterAppend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
