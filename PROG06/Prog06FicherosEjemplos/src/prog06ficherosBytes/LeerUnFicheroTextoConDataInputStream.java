package prog06ficherosBytes;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerUnFicheroTextoConDataInputStream {
    //leer un fichero llamado ficheroTextoDataOutputStream.txt  
    //creado con un DataOutputStream introduciendo caracteres por teclado

    public static void main(String[] args) {

        DataInputStream dis = null;
        FileInputStream fis = null;
        String cadena ="";
        int c;

        
        try {
            fis = new FileInputStream("ficheroTextoDataOutputStream.dat");

            dis = new DataInputStream(fis);

            //si la grabacion se hizo caracter a caracter
            while ((c=fis.read())!=-1){
                cadena +=(char)c; //como leemos int lo transformamos en char y añadimos a la cadena
            }

            //si los datos introducidos por teclado se grabaron como UTF entonces
            //  cadena = dis.readUTF();

            System.out.println("Finalizada lectura de fichero");
            System.out.println("El texto del fichero es: " + cadena);

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado"); 
        } catch (IOException ex) {
            System.out.println("Error en la escritura en el fichero"); 
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero");
            }
        }
    }

}
