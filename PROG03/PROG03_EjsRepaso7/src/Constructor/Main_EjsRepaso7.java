
package Constructor;

import Modelo.Dado;
import Modelo.Jugador;
import java.util.Scanner;

/**
 *
 *
 * @author Arancha
 */
public class Main_EjsRepaso7 {

    /**
     * JUEGO: 2 jugadores, 1 dado de 101 caras (0-100), gana quien se acerque
     * más al resultado
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Creamos 2 jugadores
        Jugador jugador1 = new Jugador("Calimera");
        Jugador jugador2 = new Jugador("Priscilo");

        // Creamos un dado de 101 caras
        Dado dado = new Dado(101);

        // Presuntamos un número a cada jugador
        System.out.println(jugador1.getNombre() + ", di un número entre 0 y 100: ");
        jugador1.setApuesta(teclado.nextInt());
        System.out.println(jugador2.getNombre() + ", di un número entre 0 y 100: ");
        jugador2.setApuesta(teclado.nextInt());

        // Realizamos una tirada de dado y mostramos el resultado
        dado.tirarDado();
        System.out.println("Tiramos el dado......y ha salido: ");
        System.out.println(dado.toString());

        // Comprobamos quién se ha quedado más cerca del resultado
        if (jugador1.diferencia(dado.getValor()) < jugador2.diferencia(dado.getValor())) {
            System.out.println("FELICIDADES " + jugador1.getNombre());
        }
        if (jugador1.diferencia(dado.getValor()) > jugador2.diferencia(dado.getValor())) {
            System.out.println("FELICIDADES " + jugador2.getNombre());
        }
        if (jugador1.diferencia(dado.getValor()) == jugador2.diferencia(dado.getValor())) {
            System.out.println("TABLAS");
        }
    }

}
