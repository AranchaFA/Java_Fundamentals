
package ejer2;

import java.io.*;
import java.util.Scanner;

public class Main_ejer2 {

    public static void main(String[] args) throws IOException {
        
        File ficheroVocales=new File("vocales.txt");
        File ficheroStrings=new File("strings.txt");
        
        
        
        Scanner teclado=new Scanner(System.in);
        
        // Pedimos una cadena hasta pulsar intro y la grabamos en el fichero de Strings
        FileWriter fwStrings=new FileWriter(ficheroStrings);
        System.out.println("Introduce un String: ");
        fwStrings.write(teclado.nextLine());
        fwStrings.close();
        
        // Leemos esa cadena caracter a caracter y grabamos si es vocal en el fichero de vocales
        FileWriter fwVocales=new FileWriter(ficheroVocales);
        FileReader frStrings=new FileReader(ficheroStrings);
        
        int caracterLeidoInt=frStrings.read();
        while (caracterLeidoInt!=-1) {
        Character caracterLeidoChar=(char)caracterLeidoInt;
        // No sé cómo hacer ignoreCase ni encuentro un método que compruebe si es vocal, así que queda largo y feo
            if (caracterLeidoChar.equals('a')||caracterLeidoChar.equals('A')||caracterLeidoChar.equals('e')||caracterLeidoChar.equals('E')||caracterLeidoChar.equals('i')||caracterLeidoChar.equals('I')||caracterLeidoChar.equals('o')||caracterLeidoChar.equals('O')||caracterLeidoChar.equals('u')||caracterLeidoChar.equals('U')) {
                String vocal=String.valueOf(caracterLeidoChar);
                fwVocales.write(vocal);
                System.out.println("Grabada la vocal "+vocal);
            }
            caracterLeidoInt=frStrings.read();
        }
        frStrings.close();
        fwVocales.close();
        
        
    }
    
}
