/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06ficherosBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author rpe
 */
public class FicheroBytes02 {

    /**
     * grabar y leer un fichero binario usando FileInputStream (String fichero)
     * FileOutputStream (String fichero)
     */
    public static void escribirFicheroBinario() {
        try (FileOutputStream fos = new FileOutputStream("fichero_bin.ext")) {

            String texto = "Esto es una prueba para ficheros binariosssss";

            //Copiamos el texto en un array de bytes
            byte codigos[] = texto.getBytes();

            fos.write(codigos);
            System.out.println("String grabado en Fichero");

        } catch (IOException e) {

        }
    }

    public  static void leerFicheroBinario() {
        try(FileInputStream fis=new FileInputStream("fichero_bin.ddr")){

        int valor = fis.read();
        while (valor != -1) {
            System.out.print((char) valor);
            valor = fis.read();
        }
            System.out.println("\n Finalizada la lectura del fichero binario");
    }
    catch(IOException e){}
    }

  
    public static void main(String[] args) {
        escribirFicheroBinario();
        leerFicheroBinario();
        
    }
}
