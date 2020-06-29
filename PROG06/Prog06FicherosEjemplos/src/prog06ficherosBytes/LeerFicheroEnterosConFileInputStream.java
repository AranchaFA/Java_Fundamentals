package prog06ficherosBytes;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerFicheroEnterosConFileInputStream {

    /**
     *Generar núm aleatorios entre 0 y 100 y almacenarlos en un fichero
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        FileInputStream fis = null;
        int num;
        try {
            fis = new FileInputStream("FicheroEnterosEnBytes.dat");
            
            while ((num = fis.read())!=-1){
                System.out.print(num+" ");
                System.out.flush();
            }
            System.out.println("\nFin de fichero");
       
        } catch (FileNotFoundException ex) {
            System.out.println("Error fichero no encontrado");  
        } catch (IOException ex) {
            System.out.println("Error en la escritura en el fichero"); 
        }

    }

}
