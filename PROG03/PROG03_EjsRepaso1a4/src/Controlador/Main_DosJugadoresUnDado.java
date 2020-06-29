package Controlador;

import Modelo.Dado;
import Modelo.Jugador;

public class Main_DosJugadoresUnDado {

    public static void main(String[] args) {
        // Creamos los dos jugadores y el dado
        Jugador jugador1 = new Jugador("Calimera");
        Jugador jugador2 = new Jugador("Priscilo");
        Dado dado = new Dado();

        // Visualizamos los atributos iniciales de los 3 objetos
        System.out.println("Los datos iniciales del jugador 1 son: " + '\n' + jugador1.toString());
        System.out.println("Los datos iniciales del jugador 2 son: " + '\n' + jugador2.toString());
        System.out.println("Los datos iniciales del dado son: " + '\n' + dado.toString());

        // Tiramos dado para ambos jugadores
        jugador1.setResultado(dado.tirarDado());
        jugador2.setResultado(dado.tirarDado());

        // Comparamos el resultado de la tirada
        int auxResultado;
        auxResultado = jugador1.comprobarTiradaDados(jugador2);
        if (auxResultado == 1) {
            System.out.println("¡FELICIDADES JUGADOR 1!");
        }
        if(auxResultado==-1) System.out.println("FELICIDADES JUGADOR 2");
        if(auxResultado==0) System.out.println("EMPATE");
        // Visualizamos los atributos de los dos jugadores para comprobar
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());
    }

}
