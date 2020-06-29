package ejer2.Contolador;

import ejer2.Modelo.DAO_DatosPrimitivos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_ejer2 {

    public static void main(String[] args) {

        DAO_DatosPrimitivos daoEnteros;
        Set<Integer> coleccionEnteros;

        // Inicializamos el DAO
        daoEnteros = new DAO_DatosPrimitivos("enteros1a9.dat");

        // Nos serviría un set cualquiera, necesitamos que no se repitan valores
        // en la colección pero no que sigan un orden especial
        coleccionEnteros = new HashSet<>();

        // Añadimos números aleatorios hasta completar la colección de 0 a 9:
        // tendrá un size=10
        // Contabilizamos el total de intentos
        int intentos = 0;
        while (coleccionEnteros.size() < 10) {
            intentos++;
            int numeroGenerado = (int) (Math.random() * 10);
            Integer numeroAGrabar = Integer.valueOf(numeroGenerado);
            boolean anhadido = coleccionEnteros.add(numeroAGrabar);
            if (anhadido) {
                System.out.print("Generado : " + numeroGenerado + "  Estado de la colección:  \nNúmero de intentos="+intentos);
                // Mostramos estado actual de la colección
                for (Integer integer : coleccionEnteros) {
                    System.out.print(integer.toString());
                }
                System.out.println("");
            }
            intentos++;
        }

        // Volcamos los enteros de la colección a un fichero (sobreescribiendo si existe)
        try {
            daoEnteros.abrirGrabarSobreescribir();
            for (Integer integer : coleccionEnteros) {
                daoEnteros.grabarUnRegistro(integer.intValue());
            }
            daoEnteros.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main_ejer2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main_ejer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Mostramos el fichero para comprobar
        System.out.println("Fichero de bytes: ");
        daoEnteros.mostrarFichero();

    }

}
