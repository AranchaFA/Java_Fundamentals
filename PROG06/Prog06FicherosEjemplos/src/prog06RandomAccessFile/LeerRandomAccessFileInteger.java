package prog06RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerRandomAccessFileInteger {

    public static void main(String[] args) {

        RandomAccessFile fichero = null;
        int pos = 0;
        long size;
        try {
            fichero = new RandomAccessFile("randomAccessFile.txt", "r");
            //calcular cuántos enteros tiene el fichero
            size = fichero.length();
            size = size / 4; //cada entero ocupa 4 bytes
            System.out.println("El fichero tiene " + size + " enteros");
            //leemos desde el principio
            do {
                //nos situamos en la posición (byte de inicio) y 
                //vamos leyendo hasta el final
                System.out.print(" " + fichero.readInt());
                System.out.flush();
                pos++;

            } while (pos < size);
        } catch (FileNotFoundException ex) {
            System.out.println("el fichero no existe");
        } catch (IOException ex) {
            System.out.println("Error en acceso a fichero"); 
        } finally
        {
            try {
                fichero.close();
            } catch (IOException ex) {
                System.out.println("error en el cierre del fichero");
            }
            catch(NullPointerException ex){
                //si el fichero no existe no se puede crear el objeto y da este error
            }
        }

    }
}
