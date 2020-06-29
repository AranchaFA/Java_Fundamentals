package prog06serializacion;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LecturaArchivoObjetos {

    // bloque para abrir el fichero y evitar que se escriba una nueva cabecera al añadir nuevos registros en una nueva sesión
   
     public static void main(String[] args) {
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Coche coche;
        Scanner teclado = new Scanner(System.in);
        char continuar = 's';
        try {
            //Se crea el fichero
          
            fis = new FileInputStream("coches.dat");
            ois = new ObjectInputStream(fis);

            while (( coche = (Coche) ois.readObject()) != null)  {
                //Se lee el  objeto Coche y se visualiza
                if (coche instanceof Coche)
                        System.out.println(coche.toString());
              
            }
            fis.close();
 
        } catch (FileNotFoundException ex) {
                       System.out.println("1"+ex.getMessage());
        } catch (IOException ex) {
                        System.out.println("Fin de fichero");
            try {
                fis.close();
            } catch (IOException ex1) {
                Logger.getLogger(LecturaArchivoObjetos.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(LecturaArchivoObjetos.class.getName()).log(Level.SEVERE, null, ex);
         }
        

    }

}
