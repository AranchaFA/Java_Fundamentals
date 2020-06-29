package Controlador;

import Modelo.Dado;
import Modelo.Jugador;

public class Main_DosJugadoresDosDados {

    public static void main(String[] args) {
        // Creamos los dos jugadores y los dos dados
        Jugador jugador1 = new Jugador("Calimera");
        Jugador jugador2 = new Jugador("Chindasbinto");
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        // Asignamos cada dado a su jugador
        jugador1.setDado(dado1);
        jugador2.setDado(dado2);
        // Mostramos los atributos iniciales de cada jugador
        System.out.println("Atributos iniciales del jugador 1: ");
        System.out.println(jugador1.toString());
        System.out.println("Atributos iniciales del jugador 2: ");
        System.out.println(jugador2.toString());
        // Realizamos las tiradas
        jugador1.getDado().tirarDado();
        jugador2.getDado().tirarDado();
        // Comparamos el resultado de las tiradas con el método del jugador
        // Para ello debemos guardar el valor de los dados en el atributo RESULTADO 
        // de los jugadores, porque es lo que comprará el método!!! 
        // (Si no, ambos resultados valdrán 0 por defecto, y siempre saldrá empate)
        int auxResultado;
        jugador1.setResultado(jugador1.getDado().getValor());
        jugador2.setResultado(jugador2.getDado().getValor());
        auxResultado = jugador1.comprobarTiradaDados(jugador2);
        if (auxResultado == 1) {
            System.out.println("¡FELICIDADES JUGADOR 1!");
        }
        if (auxResultado == -1) {
            System.out.println("¡FELICIDADES JUGADOR 2!");
        }
        if (auxResultado == 0) {
            System.out.println("¡EMPATE!");
        }
        // Comparamos el resultado de las tiradas con el método del dado
        auxResultado = dado1.compararDados(dado2);
        if (auxResultado == 1) {
            System.out.println("¡FELICIDADES JUGADOR 1!");
        }
        if (auxResultado == -1) {
            System.out.println("¡FELICIDADES JUGADOR 2!");
        }
        if (auxResultado == 0) {
            System.out.println("¡EMPATE!");
        }
        // Comparamos el resultado comparando los atributos de los dados directamente
        if (jugador1.getDado().getValor() > jugador2.getDado().getValor()) {
            System.out.println("¡FELICIDADES JUGADOR 1!");
        }
        if (jugador1.getDado().getValor() < jugador2.getDado().getValor()) {
            System.out.println("¡FELICIDADES JUGADOR 2!");
        }
        if (jugador1.getDado().getValor() == jugador2.getDado().getValor()) {
            System.out.println("¡EMPATE!");
        }
        // Mostramos el estado final de ambos jugadores para comprobar
        System.out.println("El estado final del jugador 1 es: ");
        System.out.println(jugador1.toString());
        System.out.println("El estado final del jugador 2 es: ");
        System.out.println(jugador2.toString());
    }

}
