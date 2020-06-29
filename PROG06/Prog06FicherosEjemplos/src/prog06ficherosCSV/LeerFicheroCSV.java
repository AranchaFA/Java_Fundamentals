
package prog06ficherosCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerFicheroCSV {
       
    public static void tokenizar(String linea){
        StringTokenizer tokens = new StringTokenizer(linea, ",");

        while(tokens.hasMoreTokens()){
            String nom = tokens.nextToken() ;
            String apel = tokens.nextToken();
            int   edad = Integer.parseInt(tokens.nextToken());
            Persona persona = new Persona (nom, apel, edad);
            System.out.println(persona.toString());
        }   
    }
        
    public static void main(String[] args) {

      
            try {
                FileReader fr = null;
                
                fr = new FileReader("nombres.csv");
                BufferedReader registro = new BufferedReader(fr);
                //BufferedReader registro = new BufferedReader(new FileReader("c:/ficheros/libros.csv"));
                //leemos el primer registro
                String cadena = registro.readLine();
                while (cadena != null) {
                    tokenizar(cadena);
                    //leemos el siguiente registro
                    cadena = registro.readLine();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LeerFicheroCSV.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LeerFicheroCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
}
