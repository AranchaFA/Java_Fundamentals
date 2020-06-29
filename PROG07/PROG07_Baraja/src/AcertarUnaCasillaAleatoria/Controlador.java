package AcertarUnaCasillaAleatoria;

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
            System.out.println("Elige fila... ");
            int fila = teclado.nextInt();
            while (fila > tablero.getNumFilas() || fila < 1) {
                System.out.println("Valor fuera de rango [1-" + tablero.getNumFilas() + "]. Elige fila...");
                fila = teclado.nextInt();
            }
            System.out.println("...y columna: ");
            int columna = teclado.nextInt();
            while (columna > tablero.getNumFilas() || columna < 1) {
                System.out.println("Valor fuera de rango [1-" + tablero.getNumFilas() + "]. Elige columna...");
                columna = teclado.nextInt();
            }
            // Posiciones en el array (fila/columna-1) pq pediremos fila/columna contando desde 1 y no desde 0

            // Marcamos como elegida esa posición
            tablero.getArrayCasillas()[fila - 1][columna - 1].setElegida(true);

            if (tablero.getArrayCasillas()[fila - 1][columna - 1].getPremio()!=null) {
                System.out.println(tablero.getArrayCasillas()[fila - 1][columna - 1].getPremio().getNombre());
                acierto = true;
                tablero.mostrarTablero();
            } else {
                System.out.println("Inténtalo de nuevo...");
                tablero.mostrarTablero();
            }
        } while (acierto != true);

    }

}
