
package prog06ficherosBytes;
 //volcar por pantalla un mensaje y un número usando el PrintStream
import java.io.PrintStream;


public class EjemploPrintStream01 {


    public static void main(String[] args) {
           int c = 15;

      // create printstream object
      PrintStream ps = new PrintStream(System.out);

      // print an object and change line
      ps.println(c);        
      ps.print("Nueva linea");

      // flush the stream
      ps.flush();
    }
    
}
