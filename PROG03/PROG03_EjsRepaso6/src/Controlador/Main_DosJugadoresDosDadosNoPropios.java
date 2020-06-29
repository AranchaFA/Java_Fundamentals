/*
JUEGO:  2 jugadores (con nombre)
        2 dados por jugador (NO propios)
        Ganan dobles
        Si empate a dobles, gana el mayor
        Si empate a número, tablas
 */
package Controlador;

import Modelo.Dado;
import Modelo.Jugador;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class Main_DosJugadoresDosDadosNoPropios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creamos objeto Scanner para introducir datos por teclado
        Scanner teclado = new Scanner(System.in);

        // Creamos dos jugadores
        Jugador jugador1 = new Jugador("Calimera");
        Jugador jugador2 = new Jugador("Priscilo");

        // Preguntamos el tipo de dado a utilizar
        System.out.println("¿De cuántos lados son los dados?: ");
        int auxNumCaras = teclado.nextInt();

        // Creamos 2 dados
        Dado dado1 = new Dado(auxNumCaras);
        Dado dado2 = new Dado(auxNumCaras);

        // Mostramos los atributos iniciales de ambos jugadores
        System.out.println("Los datos iniciales de los jugadores son: ");
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());

        // Realizamos la tirada de ambos jugadores
        jugador1.tirarDosDados(dado1,dado2);
        jugador2.tirarDosDados(dado1,dado2);
        System.out.println("Los dos jugadores han tirado los dados");

        // Comprobamos si alguno tiene dobles
        if (!jugador1.dobles() && !jugador2.dobles()) {
            System.out.println("Ninguno ha sacado dobles");
        }
        if (jugador1.dobles() && !jugador2.dobles()) {
            System.out.println("Ha ganado " + jugador1.getNombre());
        }
        if (!jugador1.dobles() && jugador2.dobles()) {
            System.out.println("Ha ganado " + jugador2.getNombre());
        }
        if (jugador1.dobles() && jugador2.dobles()) {
            if (jugador1.tiradaMayor(jugador2)) {
                System.out.println("Ha ganado " + jugador1.getNombre());
            } else {
                if (jugador1.empate(jugador2)) {
                    System.out.println("TABLAS");
                } else {
                    System.out.println("Ha ganado " + jugador2.getNombre());
                }
            }
        }
        
        // Mostramos los atributos de ambos jugadores para comprobar
        System.out.println("Los datos finales de ambos jugadores son: ");
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());
    }
}


