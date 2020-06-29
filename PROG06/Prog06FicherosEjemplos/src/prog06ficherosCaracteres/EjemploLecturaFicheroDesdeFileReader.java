/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06ficherosCaracteres;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author rpe
 */
public class EjemploLecturaFicheroDesdeFileReader {
    public static void main(String[] args)   {
      File fichero;
      BufferedReader br = null;
      String cadena;
      
      fichero = new File("FicheroCaracteres.txt");
      
           if (fichero.exists())
        {
          int k = 0;
          try {        
            br = new BufferedReader(new FileReader(fichero));
            while ((cadena = br.readLine()) != null)
            {
              System.out.println(cadena);
              if ((++k)%21 == 0)
              {
                System.out.print("Pulse una tecla ...");
                System.in.read();
              }
            }
            br.close();
          }
          catch (IOException e)
          {
            System.out.println(e.getMessage());
          }
        }
        else    
          System.out.println("Directorio vacío, no exite el fichero");
      }

}
