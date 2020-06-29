/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class MainAplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Creamos un controlador con los ficheros a usar
        LogicaAplicacion controlador = new LogicaAplicacion("ResultadosTestOpositores.csv", "OpositoresAptos.dat");

        // Mostramos menú
        int opcion;
        do {
            Scanner teclado = new Scanner(System.in);

            System.out.println("*** M E N Ú ***");
            System.out.println("1. Mostrar los opositores a partir de objetos.");
            System.out.println("2. Mostrar cuántos opositores hay.");
            System.out.println("3. Grabar fichero de objetos de opositores con media superior a 70.");
            System.out.println("4. Salir");
            System.out.println("\n¿Qué quieres hacer?");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    controlador.leerCSVMostrarObjetos();
                    break;
                case 2:
                    System.out.print("El número total de opositores es ");
                    System.out.println(controlador.getDaoCSV().contarNumRegistros());
                    break;
                case 3:
                    controlador.grabarFicheroCSVAObjetos_MediaMayor70();
                    break;
                case 4:
                    System.out.println("¡ Adiós !");
                    break;
                default:
                    System.out.println("Opción no válida, por favor introduce un número entre 0 y 2:");
                    opcion = teclado.nextInt();
            }

        } while (opcion != 4);
    }

}
