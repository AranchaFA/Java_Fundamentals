
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GeneradorFicheroEnteros {

    public static void main(String[] args) {
        
        FileOutputStream fos=null;
        try {
            // Creamos el fichero para grabar en él los enteros
            // Nos lo creará automáticamente
            File enteros=new File("enteros.dat");
            // Metemos el fichero en un flujo de salida
            fos = new FileOutputStream(enteros);
            // TRabajamos con int: metemos el flujo en un objeto tipo DataOS
            DataOutputStream dos=new DataOutputStream(fos);
            // Creamos un bucle para grabar 20 números aleatorios entre 1-100
            for (int i = 0; i < 20; i++) {
                try {
                    // Grabamos un entero en el fichero
                    int num=(int) (Math.random()*100+1);
                    dos.writeInt(num);
                    System.out.println("Grabado el número "+num+" en la posición "+i);
                } catch (IOException ex) {
                    System.out.println("Problema al grabar el entero generado aleatoriamente.");
                    Logger.getLogger(GeneradorFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo. "+ex.getMessage());
            Logger.getLogger(GeneradorFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(GeneradorFicheroEnteros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
