
package Controlador;

import Modelo.Carta;
import Modelo.Jugador;
import java.util.Scanner;

public class Main_JuegoCartas {

    public static void main(String[] args) {
        // Creamos objeto Scanner para meter datos por teclado
        Scanner teclado=new Scanner(System.in);
        
        // Creamos los dos jugadores
        Jugador jugador1, jugador2;
        
        // Pedimos el nombre a los jugadores
        System.out.println("Nombre jugador 1: ");
        jugador1=new Jugador(teclado.nextLine());
        System.out.println("Nombre jugador 2: ");
        jugador2=new Jugador(teclado.nextLine());
        
        // Visualizamos los datos iniciales de los jugadores
        System.out.println("Datos iniciales de ambos jugadores: ");
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());
        
        // Los ds jugadores cogerán carta
        jugador1.cogerCarta();
        jugador2.cogerCarta();
        
        // Visualizamos los datos de los jugadores tras coger carta
        System.out.println("Datos tras coger carta de ambos jugadores: ");
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());
        
        // Comparamos las cartas de los jugadores (usando variables auxiliares)
        Carta auxCartaMayor=jugador1.getCarta().cartaMayor(jugador2.getCarta());
        Jugador ganador;
        if (jugador1.getCarta().cartaMayor(jugador2.getCarta())==jugador1.getCarta()) ganador=jugador1;
        else ganador=jugador2;
        System.out.println("Ha ganado "+ganador.getNombre()+" con "+ganador.getCarta().getDibujo()+" frente a "+jugador2.getCarta().getDibujo());
        
    }
    
}
