/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arancha
 */
public class LeerFichero {

    private String cadena;
    private File file;
    private FileInputStream fis;
    private DataInputStream dis;

    public LeerFichero(File file) {
        this.file = file;
    }

    public void abrirFichero() {
        try {
            fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        }
    }

    public void cerrarFichero() {
        try {
            dis.close();
            fis.close();
        } catch (IOException ex) {
            System.out.println("Problemas al cerrar el fichero. " + ex.getMessage());
        }
    }

    public void leer() {
        String regCadena;
        // Abrimos el fichero
        abrirFichero();
        // Grabamos el String

        try {
            while (true) {
                regCadena = dis.readUTF();
                System.out.println(regCadena);
            }
        } catch (IOException ex) {
            System.out.println("Problemas al leer al fichero. " + ex.getMessage());
            // Cerramos el fichero DENTRO DEL CATCH porque fuera no 
            // llegaría a ejecutarlo al romper en la excepción
            cerrarFichero();
        }

    }

    public String leerCadenaAGrabar() {
        Scanner teclado = new Scanner(System.in);
        String cadena = teclado.nextLine();
        return cadena;
    }
}
