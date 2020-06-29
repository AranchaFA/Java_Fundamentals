package Controlador;

import Modelo.Baraja;
import Modelo.Carta;
import Modelo.JugadorCartas;
import Vista.Vista;
import java.util.Iterator;

public class Main_MostrarCartaDesdeFichero {

    public static void main(String[] args) {

        // Creamos la baraja
        Baraja baraja = new Baraja();

        // Creamos un jugador
        JugadorCartas jugador = new JugadorCartas("MalVitiMal");

        // Le repartimos una carta al jugador
        for (int i = 0; i < 52; i++) {
            jugador.anhadirCartaAlMazo(baraja.repartirUnaCarta());
        }

        //Vista.muestraCarta(jugador.quitarUnaCartaDelMazo());

        // Recorremos la colección de cartas del jugador mostrando la imagen
        Iterator it = jugador.getMazo().iterator(); // No lo uso para nada
        for (Carta carta1 : jugador.getMazo()) {
            Vista.muestraCarta(carta1);
        }
    }
}
