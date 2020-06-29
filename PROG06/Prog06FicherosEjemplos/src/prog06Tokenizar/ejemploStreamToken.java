
package prog06Tokenizar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ejemploStreamToken {

    public static void main(String[] args) {
       
          String text = "Hola. Esto es un fichero de texto\n que será dividido "
              + "en tokens. 1+1=2";
      try {
         // create a new file with an ObjectOutputStream
         FileOutputStream out = new FileOutputStream("ficheroToken1.txt");
         ObjectOutputStream oout = new ObjectOutputStream(out);

         // write something in the file
         oout.writeUTF(text);
         oout.flush();
    
            // create an ObjectInputStream for the file we created before
           ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ficheroToken1.txt"));
            // create a new tokenizer
            Reader file = new BufferedReader(new InputStreamReader(ois));
            StreamTokenizer st = new StreamTokenizer(file);
            
            // print the stream tokens
         boolean eof = false;
         do {
            int token = st.nextToken();
            switch (token) {
               case StreamTokenizer.TT_EOF:
                  System.out.println("EOF encontrado");
                  eof = true;
                  break;
               case StreamTokenizer.TT_EOL:
                  System.out.println("Fin de linea");
                  break;
               case StreamTokenizer.TT_WORD:
                  System.out.println("Palabra: " + st.sval);
                  break;
               case StreamTokenizer.TT_NUMBER:
                  System.out.println("Number: " + st.nval);
                  break;
               default:
                  System.out.println((char) token + " encontrado.");
            }
         } while (!eof);
            
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(ejemploStreamToken.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
