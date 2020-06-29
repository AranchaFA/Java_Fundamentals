package prog06RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class grabarRandomAccessFileInteger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        int pos, numero;
        long size;
        char continuar;
        
        try {
            fichero = new RandomAccessFile("randomAccessFile.txt", "rw");
            //calcular cuántos enteros tiene el fichero
            do {
            size = fichero.length();
            size = size / 4;
            System.out.println("El fichero tiene " + size + " enteros");
                       
            //pedimos que se introduzca el nuevo valor
            System.out.println("Introduce nuevo valor: ");
            numero = sc.nextInt();
         
            //escribimos el entero
            fichero.writeInt(numero);
                System.out.println("grabado");
                System.out.println("Continuar (s/n): ");
              }while (((continuar=(char)System.in.read())!='n') && ((continuar=(char)System.in.read())!='N'));
            
        } catch (FileNotFoundException ex) {
             System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            System.out.println("Error en la escritura del fichero");
        }
        finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                System.out.println("error al cerrar el  fichero");
            }
        }
    }
}
