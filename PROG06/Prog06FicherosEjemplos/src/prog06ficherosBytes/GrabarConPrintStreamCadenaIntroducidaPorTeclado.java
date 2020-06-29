
package prog06ficherosBytes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarConPrintStreamCadenaIntroducidaPorTeclado {
/* introducir una cadena por teclado hasta pulsar un intro y almacenar dicha
    cadena en un archivo llamado ficheroCadenaTecladoPrintStream.txt
    */
    public static void main(String[] args) {
        char c;
        String cadena="";
        try {
            PrintStream  ps = new PrintStream("ficheroCadenaTecladoPrintStream.txt");
            System.out.println("Introduce una cadena para guardar en un fichero INTRO para finalizar");
            while ((c= (char) System.in.read())!='\n'){
                cadena = cadena + c;
        }
            System.out.println("se ha grabado en el fichero "+cadena);
            ps.println(cadena);
            
        } catch (FileNotFoundException ex) {
            System.out.println("error en el fichero"); } catch (IOException ex) {
            Logger.getLogger(GrabarConPrintStreamCadenaIntroducidaPorTeclado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
