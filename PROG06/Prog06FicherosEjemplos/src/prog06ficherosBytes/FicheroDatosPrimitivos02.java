package prog06ficherosBytes;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FicheroDatosPrimitivos02 {

    public static void main(String[] args) throws FileNotFoundException {
        //programa que graba un mensaje =" Ejemplo mensaje" en un fichero
        //y a continuación escribe 20 números: 1 numero real entre 0 y  
        // y otro  número entero entre  1 y 6 ,así alternativamente
        int numInt;
        float numFloat;
        String mensaje;
        boolean eof = false;

        File ficheroEntrada = new File("FicheroDatosPrimitivos.dat");
        DataInputStream fin = new DataInputStream(new FileInputStream(ficheroEntrada));

        try {
            mensaje = fin.readUTF(); //leemos el string
            System.out.println("mensaje: " + mensaje);

            //leemos  los 10 bloques de números real y entero
            while (!eof) {
                //leemos en el fichero numero entero y numero real en cada iteracion
                numInt = fin.readInt();
                numFloat = fin.readFloat();
                System.out.println("Número entero: " + numInt + " Numero real: " + numFloat);
            }
        } catch (EOFException ex) {
            System.out.println("Se ha llegado al final del fichero");
        } catch (IOException ex) {
            System.out.println("Error en la lectura del fichero");
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}
