
package ejer3;

import java.io.*;

public class Main_ejer3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File ficheroVocales=new File("vocales.txt");
        FileReader frVocales=new FileReader(ficheroVocales);
        
        // Leemos en bucle y mostramos hasta fin de fichero (-1)
        int caracterLeidoInt=frVocales.read();
        while (caracterLeidoInt!=-1) {
            char caracterLeidoChar=(char)caracterLeidoInt;
            System.out.print(caracterLeidoChar+"  ");
            caracterLeidoInt=frVocales.read();
        }
    }
    
}
