package Controlador;

import Modelo.Jugador;

public class MainDadosHastaSacar6 {

    public static void main(String[] args) {
        // Creamos dos juadores
        Jugador jugador1 = new Jugador("Firulais");
        Jugador jugador2 = new Jugador("Calimera");
        // Mostramos sus atributos iniciales
        System.out.println("Atributos iniciales del jugador 1: " + '\n' + jugador1.toString());
        System.out.println("Atributos iniciales del jugador 2: " + '\n' + jugador2.toString());
        // Tiran los jugadores hasta sacar un 6 y mostramos sus atributos finales
        jugador1.tirarHastaSacar6();
        System.out.println("Atributos finales tras tirar hasta sacar 6 jugador 1: " + '\n' + jugador1.toString());
        jugador2.tirarHastaSacar6();
        System.out.println("Atributos finales tras tirar hasta sacar 6 jugador 2: " + '\n' + jugador2.toString());
        // Comparamos quién ha sacado un 6 en menos tiradas
        if (jugador1.getNumTiradas() < jugador2.getNumTiradas()) {
            System.out.println("Ha ganado " + jugador1.getNombre());
        } else {
            System.out.println("Ha ganado " + jugador2.getNombre());
        }
    }

}
