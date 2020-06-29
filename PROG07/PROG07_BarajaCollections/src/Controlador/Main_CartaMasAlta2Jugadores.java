
package Controlador;

import Modelo.*;
import Vista.Vista;
import java.util.Iterator;

public class Main_CartaMasAlta2Jugadores {

    public static void main(String[] args) {
        
        // Repartimos n cartas a cada jugador (2 jugadores), sacarán la primera
        // carta de su mazo cada uno y gana el que tenga la carta más alta
        JugadorCartas jugador1=new JugadorCartas("Calimera");
        JugadorCartas jugador2=new JugadorCartas("Priscilo");
        Baraja baraja=new Baraja();
        // Repartimos 3 cartas a cada uno
        for (int i = 0; i < 3; i++) {
            jugador1.getMazo().addFirst(baraja.repartirUnaCarta());
            jugador2.getMazo().addFirst(baraja.repartirUnaCarta());
        }
        // Vamos sacando una carta de cada jugador hasta terminarlas
        // Lo hacemos como si no supiéramos cuántas cartas hemos repartido
        // Consideramos que el 1 es el menor (tienen el valor que marca el dibujo)
        Iterator it1=jugador1.getMazo().iterator();
        Iterator it2=jugador2.getMazo().iterator();
        while (it1.hasNext()&&it2.hasNext()) {
            Carta carta1=(Carta) it1.next();
            Carta carta2=(Carta) it2.next();
            Vista.muestraCarta(carta1);
            Vista.muestraCarta(carta2);
            if (carta1.getValor()<carta2.getValor()) {
                System.out.println("¡ "+jugador2.getNombre()+" HAS GANADO !"); 
            } else {
                System.out.println("¡ "+jugador1.getNombre()+" HAS GANADO !"); 
            }
        }
    }
    
}
