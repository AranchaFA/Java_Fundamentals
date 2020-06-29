/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Arancha
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leer {

    /* DEPURARLO!!!
    // Método para leer un carácter
    public static char datoCaracter() {
        char c = '\0';

        try {
            c = (char) System.in.read();
            System.in.skip(System.in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }
     */
    // Método para leer un dato (en bytes) por teclado y devolverlo convertido en String
    public static String leerDato() {
        String v_dato = "";
        try {
            // Definimos un objeto de Stream de caracteres de entrada
            // Lee bytes y los convierte en un String:
            InputStreamReader v_str = new InputStreamReader(System.in);
            // Definimos el buffer con el que leeremos las entradas por teclado
            BufferedReader teclado = new BufferedReader(v_str);
            // Aplicamos el método de LEER una cadena hasta que se introduce un intro
            v_dato = teclado.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return v_dato;
    }

    // Método para convertir un dato de tipo String en uno de tipo short
    public static short datoShort() {
        try {
            return Short.parseShort(leerDato());
        } catch (NumberFormatException ex) {
            return Short.MIN_VALUE;
        }
    }

    // Método para convertir un dato de tipo String en uno de tipo int
    public static int datoInt() {
        try {
            return Integer.parseInt(leerDato());
        } catch (NumberFormatException ex) {
            return Integer.MIN_VALUE;
        }
    }
    
     // Método para convertir un dato de tipo String en uno de tipo long
    public static long datoLong(){
        try {
        return Long.parseLong(leerDato());
        } catch (NumberFormatException ex) {
            return Long.MIN_VALUE;
        }
    }
    
     // Método para convertir un dato de tipo String en uno de tipo float
    public static float datoFloat(){
        try {
        return Float.parseFloat(leerDato());
        } catch (NumberFormatException ex) {
            return Float.MIN_VALUE;
        }
    }
    
     // Método para convertir un dato de tipo String en uno de tipo double
    public static double datoDouble(){
        try {
        return Double.parseDouble(leerDato());
        } catch (NumberFormatException ex) {
            return Double.MIN_VALUE;
        }
    }
}
