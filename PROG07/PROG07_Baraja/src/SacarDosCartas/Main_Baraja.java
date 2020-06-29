package SacarDosCartas;

import SacarDosCartas.Baraja;
import SacarDosCartas.Carta;

public class Main_Baraja {

    public static void main(String[] args) {

        // Creamos una baraja
        Baraja baraja = new Baraja();

        System.out.println("Sacamos dos cartas: ");
        System.out.println(baraja.sacarUnaCarta().toString());
        System.out.println(baraja.sacarUnaCarta().toString());
        System.out.println("");
        System.out.println("Mostramos todas las cartas de la baraja, para comprobar que faltan dos: ");
        baraja.mostrarBaraja();

    }

}
