/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06ficherosBytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author rpe
 */
public class FicheroBytes01 {

    public static void main(String[] args) throws IOException {
        //Instancia un objeto File de entrada y otro de salida, el fichero origen esta en la raiz
        //si no decimos nada la ruta está en el propio proyecto de netbeans
        //si la ruta del fichero esta en otro sitio
        //File ruta = new File("c:/ficheros");
        //File f = new File(ruta, "logo.gif");
                
        File archivoEntrada = new File("logo.gif");
        File archivoSalida = new File("destino.gif");
        // si no se indica nada graba en el proyecto

        //Instancia un   FileInputStream  y un  FileOutputStream  que se encargaran de leer y escribir archivos respectivamente
        FileInputStream lector = new FileInputStream(archivoEntrada);
        FileOutputStream escritor = new FileOutputStream(archivoSalida);
        System.out.println("ruta absoluta: "+archivoSalida.getAbsolutePath()); 
        System.out.println("ruta relativa: "+archivoSalida.getPath()); 

// Instancia una variable que contendrá el byte a leer
        int unByte;

// Informa que se está copiando el archivo
        System.out.println("\n\tEl archivo está siendo copiado....");
//Lee el archivoEntrada y guarda la informacion en el archivoSalida
        while ((unByte = lector.read()) != -1) {
            escritor.write(unByte);
        }
        //Cierra los archivos
        lector.close();
        escritor.close();

        //Informa que se ha copiado el archivo
        System.out.println("\tEl archivo ha sido copiado con éxito....\n");

    }

}
