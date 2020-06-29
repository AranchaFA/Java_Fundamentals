package HundirLaFlota;

import java.util.Scanner;

public class Controlador {

    // ATRIBUTOS
    private Tablero tablero;

    // MÉTODOS
    // Constructor
    public Controlador(int numFilasTablero) {
        tablero = new Tablero(numFilasTablero);
    }

    // Echar una partida
    public void echarUnaPartida() {
        Scanner teclado = new Scanner(System.in);
        boolean acierto = false;
        do {
            int fila,columna;
            // Comprobamos que la posición no haya sido elegida ya
            do {
                System.out.println("Elige fila... ");
                fila = teclado.nextInt()-1;
                while (fila > tablero.getNumFilas() || fila < 1) {
                    System.out.println("Valor fuera de rango [1-" + tablero.getNumFilas() + "]. Elige fila...");
                    fila = teclado.nextInt()-1;
                }
                System.out.println("...y columna: ");
                columna = teclado.nextInt()-1;
                while (columna > tablero.getNumFilas() || columna < 1) {
                    System.out.println("Valor fuera de rango [1-" + tablero.getNumFilas() + "]. Elige columna...");
                    columna = teclado.nextInt()-1;
                }
                if (tablero.getArrayCasillas()[fila][columna].isElegida()) {
                    System.out.println("La posición ya había sido elegida, inténtalo en otra.");
                }
            } while (tablero.getArrayCasillas()[fila][columna].isElegida());

            // Posiciones en el array (fila/columna-1) pq pediremos fila/columna contando desde 1 y no desde 0
            // Marcamos como elegida esa posición
            tablero.getArrayCasillas()[fila][columna].setElegida(true);

            if (tablero.getArrayCasillas()[fila][columna].getBarco() != null) {
                acierto = true;
                System.out.println("\n¡ HUNDIDO !");
                System.out.println(tablero.getArrayCasillas()[fila][columna].getBarco().getNombre() + "\n");
                tablero.mostrarTablero();
                System.out.println("");

            } else {
                System.out.println("\nAgua...\n");
                tablero.mostrarTablero();
                System.out.println("");
            }
        } while (acierto != true);
    }

}
