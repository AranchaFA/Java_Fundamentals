package HundirElBarco.Controlador;

import ModeloGeneral.DAO_CSVs;
import HundirElBarco.Modelo.Tablero;
import java.util.Scanner;

// Vamos a grabar tras cada jugada el nombre del jugador, el número de intentos hasta acertar y la posición donde estaba el barco
public class Controlador_HundirElBarco {

    // ATRIBUTOS
    private DAO_CSVs daoResultados;
    private Tablero tablero;
    private int numIntentos; // Número de intentos hasta acertar
    private int filaBarco, columnaBarco; // Posición donde estará el barco
    private String nombreJugador; // No lo pongo como objeto porque del jugador sólo me interesa el nombre para el CSV

    // MÉTODOS
    // Constructor
    public Controlador_HundirElBarco(int numFilasTablero) {
        tablero = new Tablero(numFilasTablero);
        daoResultados=new DAO_CSVs("ResultadosBarco.csv");
    }

    // Echar una partida, devuelve el número de intentos hasta acertar
    public int echarUnaPartida() {        
        Scanner teclado = new Scanner(System.in);
        System.out.println("Nombre de jugador: ");
        nombreJugador=teclado.nextLine();
        numIntentos=0;
        boolean acierto = false;
        do {
            // Posiciones en el array (fila/columna-1) pq pediremos fila/columna contando desde 1 y no desde 0
            int filaArray, columnaArray, filaJugador, columnaJugador;
            // Comprobamos que la posición no haya sido elegida ya
            do {
                System.out.println("Elige fila... ");
                filaJugador = teclado.nextInt();
                while (filaJugador > tablero.getNumFilas() || filaJugador < 1) {
                    System.out.println("Valor fuera de rango [1-" + tablero.getNumFilas() + "]. Elige fila...");
                    filaJugador = teclado.nextInt();
                }
                filaArray = filaJugador - 1;
                System.out.println("...y columna: ");
                columnaJugador = teclado.nextInt();
                while (columnaJugador > tablero.getNumFilas() || columnaJugador < 1) {
                    System.out.println("Valor fuera de rango [1-" + tablero.getNumFilas() + "]. Elige columna...");
                    columnaJugador = teclado.nextInt();
                }
                columnaArray=columnaJugador-1;
                if (tablero.getArrayCasillas()[filaArray][columnaArray].isElegida()) {
                    System.out.println("La posición ya había sido elegida, inténtalo en otra.");
                }
            } while (tablero.getArrayCasillas()[filaArray][columnaArray].isElegida());

            // Marcamos como elegida esa posición
            tablero.getArrayCasillas()[filaArray][columnaArray].setElegida(true);

            if (tablero.getArrayCasillas()[filaArray][columnaArray].getBarco() != null) {
                acierto = true;
                filaBarco=filaJugador;
                columnaBarco=columnaJugador;
                System.out.println("\n¡ HUNDIDO !");
                System.out.println(tablero.getArrayCasillas()[filaArray][columnaArray].getBarco().getNombre() + "\n");
                tablero.mostrarTablero();
                System.out.println("");

            } else {
                System.out.println("\nAgua...\n");
                tablero.mostrarTablero();
                System.out.println("");
            }
            numIntentos++;
        } while (acierto != true);
        return numIntentos;
    }

    public void mostrarResultados(){
        daoResultados.mostrarFicheroPorPantalla();
    }
    
    public void grabarResultado(){
        daoResultados.anhadirUnResultado(nombreJugador+","+numIntentos+","+filaBarco+","+columnaBarco);
    }

    public void jugarYGrabarResultado(){
        echarUnaPartida();
        grabarResultado();
    }
}
