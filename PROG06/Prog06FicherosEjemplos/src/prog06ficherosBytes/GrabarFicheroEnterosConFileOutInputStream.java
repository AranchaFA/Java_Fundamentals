package prog06ficherosBytes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarFicheroEnterosConFileOutInputStream {

    /**
     *Generar núm aleatorios entre 0 y 100 y almacenarlos en un fichero
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        FileOutputStream fos = null;
        int num;
        try {
            fos = new FileOutputStream("FicheroEnterosEnBytes.dat");
            for (int i = 0; i < 10; i++) {
                num = (int) (Math.random()*100+1);
                fos.write(num);
                System.out.println("SE ha grabado un "+num);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error fichero no encontrado");  
        } catch (IOException ex) {
            System.out.println("Error en la escritura en el fichero"); 
        }

    }

}
