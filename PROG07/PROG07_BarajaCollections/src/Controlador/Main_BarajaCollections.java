
package Controlador;

import Modelo.*;
import java.util.LinkedList;

public class Main_BarajaCollections {

    public static void main(String[] args) {
        
        // Creamos la baraja
        Baraja baraja=new Baraja();
        Carta carta=null;
        
        // Creamos un jugador
        JugadorCartas jugador=new JugadorCartas("MalVitiMal");
        
        // Le repartimos al jugador 10 cartas de la baraja
        System.out.println("Coge las cartas:");
        LinkedList mazoJugador=new LinkedList();
        for (int i = 0; i < 10; i++) {
            Carta cartaCogida=baraja.repartirUnaCarta();
            System.out.print(cartaCogida.toString());
            mazoJugador.addFirst(cartaCogida);
        }
        // Pasamos al jugador la colección de cartas
        jugador.setMazo(mazoJugador);
        
        System.out.println("\n\nMazo del jugador: ");
        jugador.mostrarMazo();
        
        System.out.println("\n\nCartas restantes de la baraja: ");
         baraja.mostrarBaraja();
        
        
        
    }
    
}
