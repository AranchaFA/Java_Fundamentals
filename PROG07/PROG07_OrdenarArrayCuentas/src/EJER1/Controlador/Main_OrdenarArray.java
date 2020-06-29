package EJER1.Controlador;

import EJER1.Modelo.Cuenta;
import EJER1.Modelo.DAO_Objetos;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_OrdenarArray {

    public static void main(String[] args) {

        Controlador_ObjetosCSV c = new Controlador_ObjetosCSV("fileCuentas.csv", "ficheroObjetos.dat");

        // Crearemos un array con los OBJETOS que obtenemos del CSV para luego ordenarlo
        // El tamaño del array será igual al número de registros que tiene el CSV
        Cuenta[] arrayCuentas = new Cuenta[c.getDaoCSV().contarRegistros()];
        // Creamos el fichero de objetos del que volcaremos la información al array
        c.generarFicheroObjetos();
        // Guardamos los objetos del fichero en el array
        try {
            // Abrir fichero para leer
            c.getDaoObjetos().abrirLeer();

            // Leer y guardar el array en bucle
            try {
                for (int i = 0; i < arrayCuentas.length; i++) {
                    arrayCuentas[i] = c.getDaoObjetos().leerUnObjeto();
                }
            } catch (EOFException ex) {
                System.out.println("Fichero de objetos terminado de mostrar. " + ex.getMessage());
                // Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase no encontada. " + ex.getMessage());
                Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar fichero
            c.getDaoObjetos().cerrarLeer();

        } catch (IOException ex) {
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Mostramos el array antes de ordenar
        for (int i = 0; i < arrayCuentas.length; i++) {
            System.out.println(arrayCuentas[i].toString());
        }
        // Ordenamos el fichero (la clase Cuenta debe tener equals y compareTo
        Arrays.sort(arrayCuentas);

        // Mostramos el array para comprobar
        for (int i = 0; i < arrayCuentas.length; i++) {
            System.out.println(arrayCuentas[i].toString());
        }
    }

}
