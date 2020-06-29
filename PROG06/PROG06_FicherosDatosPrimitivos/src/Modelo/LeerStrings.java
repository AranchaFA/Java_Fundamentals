/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arancha
 */
public class LeerStrings {

    // ATRIBUTOS
    // Objeto File desde el que leeremos
    private File fileStrings;
    // Metemos el File en un flujo de lectura de datos FileIS
    private FileInputStream fis;
    // Metemos el FileIS en un DataIS (por trabajar con Strings)
    private DataInputStream dis;

    // MÉTODOS
    // Getter del file por si fuera necesario
    public File getFileStrings() {
        return fileStrings;
    }

    // Constructor (no se crearán los atributos objetos)
    public LeerStrings() {

    }

    // Método para leer fichero de Strings y mostrarlo por pantalla
    public void leerFicheroPorPantalla(String nombreFichero) {

        try {
            // ABRIMOS FICHERO
            fileStrings = new File(nombreFichero);
            fis = new FileInputStream(fileStrings);
            dis = new DataInputStream(fis);
            // LEEMOS FICHERO
            while (true) {
                System.out.println(dis.readUTF());
            }
        } catch (EOFException ex) {
            System.out.println("Fin de fichero. " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(LeerStrings.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                // CERRAMOS FICHERO
                dis.close();
                fis.close();
            } catch (IOException ex) {
                System.out.println("Problemas al cerrar el fichero. "+ex.getMessage());
                Logger.getLogger(LeerStrings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
