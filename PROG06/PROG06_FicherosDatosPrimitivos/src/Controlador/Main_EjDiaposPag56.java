package Controlador;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_EjDiaposPag56 {

    public static void main(String[] args) {

        // Queremos GRABAR un fichero con 1 String y 10 tandas de 1 int (0-6) 
        // y 1 float (o-1)
        // GRABAR EL FICHERO
        // Creamos un File con el fichero a grabar
        File fileSalida = new File("string_int_float.dat");
        // Creamos flujo de salida de datos (bytes)
        // Se puede inicializar aquí porque copiaremos todo en UNA SOLA SESIÓN
        FileOutputStream fos = null;
        // Datos primitivos+String --> DataOS
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream(fileSalida, true);
            dos = new DataOutputStream(fos);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero de salida no encontrado. " + ex.getMessage());
            Logger.getLogger(Main_EjDiaposPag56.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //Grabamos un String inicialmente
            dos.writeUTF("Un string :)");
            // Grabamos 10 bloques con un entero y un real
            for (int i = 0; i < 10; i++) {
                dos.writeInt((int) (Math.random() * 7));
                dos.writeFloat((float) Math.random());
            }
        } catch (IOException ex) {
            System.out.println("Problemas al grabar en fichero de salida. " + ex.getMessage());
            Logger.getLogger(Main_EjDiaposPag56.class.getName()).log(Level.SEVERE, null, ex);
        }

        // LEER EL FICHERO
        // Creamos un File con el fichero creado para leerlo
        File fileEntrada = new File("string_int_float.dat");
        // Creamos flujo de entrada de datos FileIS (bytes)
        FileInputStream fis = null;
        // Datos primitivos+String --> DataIS
        DataInputStream dis = null;
        try {
            fis = new FileInputStream(fileSalida);
            dis = new DataInputStream(fis);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero de entrada no encontrado. " + ex.getMessage());
            Logger.getLogger(Main_EjDiaposPag56.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Mostramos por pantalla el String
            System.out.println(dis.readUTF());
            // Leemos los 10 bloques de int-float
            for (int i = 0; i < 10; i++) {
                System.out.print(dis.readInt() + "    ");
                System.out.println(dis.readFloat());
            }
        } catch (IOException ex) {
            System.out.println("Problemas al leer el fichero de entrada. "+ex.getMessage());
            Logger.getLogger(Main_EjDiaposPag56.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
