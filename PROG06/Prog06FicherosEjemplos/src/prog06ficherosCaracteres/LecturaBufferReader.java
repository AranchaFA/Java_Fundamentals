/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06ficherosCaracteres;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LecturaBufferReader {

    public static void main(String[] args) {
        FileReader fr = null;
        String sCadena;
        try {
            fr = new FileReader("lecturaFileWriter.txt");
            BufferedReader bf = new BufferedReader(fr);
            //tambien podriamos poner
            //BufferedReader bf = new BufferedReader(new FileReader("datos.txt"));
            while ((sCadena = bf.readLine()) != null) {
                System.out.println(sCadena);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecturaBufferReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Excepcion en la lectura");
        } finally {
            try {
                fr.close();
                System.out.println("Fin de lectura del fichero");
            } catch (IOException ex) {
                Logger.getLogger(LecturaBufferReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
