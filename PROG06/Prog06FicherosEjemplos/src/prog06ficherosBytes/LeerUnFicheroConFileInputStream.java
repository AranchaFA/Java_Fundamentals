package prog06ficherosBytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerUnFicheroConFileInputStream{
    //leer un fichero llamado ficheroParaLeer.txt  usando un FileInputSream
    //y creado anteriormente con el bloc de notas

    public static void main(String[] args) {

        FileInputStream fis = null;
        String cadena="";
        int c;

        try {
            fis = new FileInputStream("ficheroPrintStreamParaLeer.txt");
            
            while ((c=fis.read())!=-1){
                cadena +=(char)c; //como leemos int lo transformamos en char y añadimos a la cadena
            }
            System.out.println("Finalizada lectura de fichero");
            System.out.println("El texto del fichero es: "+cadena);            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error en el fichero"); 
        } catch (IOException ex) {
            System.out.println("Error en la lectura del fichero");} finally {
            try {
                fis.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero");}
        }
    }

}
