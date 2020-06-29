package Controlador;

import Modelo.Jugador;
import Modelo.Moneda;
import java.util.Scanner;

public class Main_JugadorAdivinaMoneda {

    public static void main(String[] args) {
        // Creamos teclado para introducir la apuesta
        Scanner teclado = new Scanner(System.in);

        // Creamos una moneda y un jugador
        Moneda moneda = new Moneda(0);
        Jugador jugador = new Jugador("Calimera");

        // Mostramos sus características al inicio
        System.out.println("Hemos creado una moneda con las siguientes características: ");
        System.out.println(moneda.toString());
        System.out.println("Hemos creado un jugador con las siguentes características: ");
        System.out.println(jugador.toString());

        // Pedimos al jugador que apueste
        System.out.println("¿Cuál es tu apuesta?  CARA=1 o CRUZ=2");
        jugador.setApuesta(teclado.nextInt());

        // Tiramos la moneda
        moneda.lanzarMoneda();
        System.out.println("Lanzamos la moneda, y el resultado es: ");
        System.out.println(moneda.toString());

        // Comprobamos con el método de la moneda
        Moneda auxMoneda; // Variable local, si llamo "moneda" a la del parámetro me cambia el objeto original
        if (moneda.compararMonedas(auxMoneda = new Moneda(jugador.getApuesta()))) {
            System.out.println("¡ACERTASTE!");
        } else {
            System.out.println("Prueba otra vez :(");
        }

        // Comprobamos con el método del jugador
        if (jugador.apostar(moneda)) {
            System.out.println("¡ACERTASTE!");
        } else {
            System.out.println("Prueba otra vez :(");
        }

    }

}
