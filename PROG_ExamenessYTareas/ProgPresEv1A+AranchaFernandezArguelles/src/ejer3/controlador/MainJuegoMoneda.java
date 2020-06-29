package ejer3.controlador;

import ejer3.modelo.JugadorJuegoMoneda;
import ejer3.modelo.Moneda;

public class MainJuegoMoneda {

    public static void main(String[] args) {

        // Apartado A
        JugadorJuegoMoneda jugadora1 = new JugadorJuegoMoneda("Priscila");
        JugadorJuegoMoneda jugadora2 = new JugadorJuegoMoneda("Calimera");
        JugadorJuegoMoneda jugadora3 = new JugadorJuegoMoneda("Firulaisa");

        Moneda monedaJuego = new Moneda();

        // Apartado B
        System.out.println("Lanzamos la moneda del juego, y el resultado es: ");
        monedaJuego.lanzarMoneda();
        System.out.println(monedaJuego.toString());
        System.out.println("Las 3 jugadoras lanzan sus monedas, y sus resultados son: ");
        jugadora1.getMoneda().lanzarMoneda();
        jugadora2.getMoneda().lanzarMoneda();
        jugadora3.getMoneda().lanzarMoneda();

        System.out.println(jugadora1.toString());
        System.out.println(jugadora2.toString());
        System.out.println(jugadora3.toString());

        // Apartado C
        // Comprobamos resultado de la jugadora 1
        if (jugadora1.getMoneda().compararMonedas(monedaJuego) == true) {
            System.out.println("¡" + jugadora1.getNombre() + " HA GANADO!");
        } else {
            System.out.println(jugadora1.getNombre() + " prueba de nuevo :(");
        }
        // Comprobamos resultado de la jugadora 2
        if (jugadora2.getMoneda().compararMonedas(monedaJuego) == true) {
            System.out.println("¡" + jugadora2.getNombre() + " HA GANADO!");
        } else {
            System.out.println(jugadora2.getNombre() + " prueba de nuevo :(");
        }
        // Comprobamos resultado de la jugadora 3
        if (jugadora3.getMoneda().compararMonedas(monedaJuego) == true) {
            System.out.println("¡" + jugadora3.getNombre() + " HA GANADO!");
        } else {
            System.out.println(jugadora3.getNombre() + " prueba de nuevo :(");
        }

    }

}
