package paqueteLeerDatos;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leer {

    public static char datoCaracter(){

        char c = '\0';

        try {
            //evitando el problema que el INTRO quede en el buffer
            //opcion 1
           
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            c = (char) br.read();

            //opcion 2
 /*           
             c= (char) is.read(); //pero queda el "\n" o INTRO
            // limpiar el INTRO del buffer del flujo de entrada  
            
            int n= System.in.available(); //num bytes que quedan en el buffer
            is.skip(n);   //skip(n) hace que se salten los n bytes del buffer limpiandolo
 */      
            } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
	  }

    public static String leerDato() {

        String v_dato = "";
        try {
//defino el objeto de stream de caracteres de entrada
            InputStreamReader v_str = new InputStreamReader(System.in);
            //defino el buffer por donde se va a leer, el teclado (estandar)
            BufferedReader teclado = new BufferedReader(v_str);
            //aplico el metodo de leer una linea hasta que pulso el intro
            v_dato = teclado.readLine();

        } catch (IOException ex) {
            Logger.getLogger(Leer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_dato;
    }

    public static short datoShort() {
        try {
            return Short.parseShort(leerDato());
        } catch (NumberFormatException e) {
            return Short.MIN_VALUE; // valor más pequeño
        }
    }

    public static int datoInt() {
        try {
            return Integer.parseInt(leerDato());
        } catch (NumberFormatException e) {
            return Short.MIN_VALUE; // valor más pequeño
        }
    }

    public static long datoLong() {
        try {
            return Long.parseLong(leerDato());
        } catch (NumberFormatException e) {
            return Long.MIN_VALUE; // valor más pequeño
        }
    }

    public static float datoFloat() {
        try {
            return Float.parseFloat(leerDato());
        } catch (NumberFormatException e) {
            return Float.NaN; // no es un valor numerico
        }
    }

    public static double datoDouble() {
        try {
            return Double.parseDouble(leerDato());
        } catch (NumberFormatException e) {
            return Double.NaN; // no es un valor numerico
        }
    }

}


