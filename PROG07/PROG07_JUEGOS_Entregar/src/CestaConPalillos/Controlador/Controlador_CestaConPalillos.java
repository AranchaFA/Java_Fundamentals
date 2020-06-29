package CestaConPalillos.Controlador;

import CestaConPalillos.Modelo.*;
import ModeloGeneral.DAO_CSVs;
import java.util.Scanner;

public class Controlador_CestaConPalillos {

    // ATRIBUTOS
    private DAO_CSVs daoResultados;
    private Cesta cesta;
    private Jugador jugador1, jugador2;
    private Jugador ganador;

    // MÉTODOS

    // Constructor
    public Controlador_CestaConPalillos(String nombreJugador1, String nombreJugador2, int numNivelesCesta) {
        daoResultados = new DAO_CSVs("ResultadosPalillos.csv");
        jugador1 = new Jugador(nombreJugador1);
        jugador2 = new Jugador(nombreJugador2);
        cesta = new Cesta(numNivelesCesta);
    }

    // Método para realizar una jugada, en él controlaremos que queden suficientes palillos
    // y que se retiren como máximo 3
    public void realizarUnaJugada() {
        Scanner teclado = new Scanner(System.in);
        int nivelArray;
        int nivelJugador;
        int numPalillosARetirar;
        int numPalillosDisponibles;
        boolean posible;

        // Mostramos el estado de la cesta para que el jugador pueda escoger
        cesta.mostrarCesta();
        do {
            // Pedimos el nivel del que se quieren retirar palillos
            do {
                System.out.println("¿De qué nivel deseas retirar palillos?");
                nivelJugador = teclado.nextInt();
                if (nivelJugador < 1 || nivelJugador > cesta.getNumNiveles()) {
                    System.out.println("Nivel no válido, introduce un número entre 1 y " + cesta.getNumNiveles());
                }
            } while (nivelJugador < 1 || nivelJugador > cesta.getNumNiveles());
            // El nivel (fila) en el array será una posición menor al dado por el jugador por empezar desde 0
            nivelArray = nivelJugador - 1;

            // Pedimos el número de palillos a retirar
            do {
                System.out.println("¿Cuántos palillos deseas retirar? (Máximo 3)");
                numPalillosARetirar = teclado.nextInt();
                if (numPalillosARetirar > 3 || numPalillosARetirar < 1) {
                    System.out.println("Cantidad no válida, debes retirar entre 1 y 3.");
                }
            } while (numPalillosARetirar > 3 || numPalillosARetirar < 1);

            // Comprobamos si quedan suficientes palillos
            numPalillosDisponibles = cesta.contarPalillosDeUnNivel(nivelArray);
            if (numPalillosARetirar > numPalillosDisponibles) {
                posible = false;
                System.out.println("No es posible la jugada (quedan " + numPalillosDisponibles + " en ese nivel).");
            } else {
                posible = true;
            }
        } while (!posible);

        // Una vez que la jugada es posible, retiramos los palillos de la cesta
        cesta.retirarPalillos(nivelArray, numPalillosARetirar);
    }

    // Método para echar una partida entre 2 jugdores
    public void echarUnaPartida() {
        // Asignamos turno al primer jugador
        jugador1.setTurno(true);
        // Realizamos jugadas individuales, alternando el turno de los jugadores, hasta
        // que el número de palillos que quede en la cesta sea 1, entonces habrá ganado
        // el último jugador en tener el turno
        do {
            if (jugador1.isTurno()) {
                System.out.println(jugador1.getNombre() + " te toca jugar:");
                realizarUnaJugada();
                // Tras realizar la jugada invertimos el estado de los turnos
                jugador1.setTurno(false);
                jugador2.setTurno(true);
            } else {
                System.out.println(jugador2.getNombre() + " te toca jugar:");
                realizarUnaJugada();
                // Tras realizar la jugada invertimos el estado de los turnos
                jugador1.setTurno(true);
                jugador2.setTurno(false);
            }
        } while (cesta.contarPalillosDeLaCesta()>1);
        // Al llegar al último palillo, el jugdor al que le toque el turno es el perdedor
        if (jugador1.isTurno()) {
            ganador=jugador2;
        } else {
            ganador=jugador1;
        }
        // Mostramos el nombre del ganador y la cesta para que se vea el resultado
        cesta.mostrarCesta();
        System.out.println("\nFIN DE PARTIDA\n¡ FELICIDADES "+ganador.getNombre()+", HAS GANADO!");
    }

    // Método par grabar el rsultado de una partida
    public void grabarResultado() {
        String stringAGrabar = jugador1.getNombre() + "," + jugador2.getNombre() + "," + ganador.getNombre();
        daoResultados.anhadirUnResultado(stringAGrabar);
    }

    // Método para echar una partida y grabar los resultados finales
    public void echarUnaPartidaYGrabarResultado() {
        echarUnaPartida();
        grabarResultado();
    }
    
    // Método para mostrar los resultados del CSV por pantalla
    public void mostrarResultados(){
        daoResultados.mostrarFicheroPorPantalla();
    }
}
