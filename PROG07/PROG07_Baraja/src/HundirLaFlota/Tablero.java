package HundirLaFlota;

import java.io.Serializable;

public class Tablero implements Serializable{

    // ATRIBUTOS
    private int numFilas; // Habrá igua número de filas que de columnas
    private Casilla[][] arrayCasillas;

    // MÉTODOS
    // Getters + Setters
    public int getNumFilas() {
        return numFilas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    public Casilla[][] getArrayCasillas() {
        return arrayCasillas;
    }

    public void setArrayCasillas(Casilla[][] arrayCasillas) {
        this.arrayCasillas = arrayCasillas;
    }

    // Constructor
    public Tablero(int numFilas) {
        this.numFilas = numFilas;
        // Inicializamos el array de NxN casillas
        arrayCasillas = new Casilla[numFilas][numFilas];
        // Creamos los objetos casilla que ocuparán todas las posiciones
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numFilas; j++) {
                arrayCasillas[i][j] = new Casilla();
            }
        }
        // A una posición al azar le asignamos un premio
        arrayCasillas[(int) (Math.random() * numFilas)][(int) (Math.random() * numFilas)].setBarco(new Barco());
    }

    // toString
    @Override
    public String toString() {
        return "Tablero{" + "numCasillasLado=" + numFilas + ", arrayCasillas=" + arrayCasillas + '}';
    }

    // Mostrar tablero marcando las casillas ya elegidas
    public void mostrarTablero() {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numFilas; j++) {
                if (arrayCasillas[i][j].isElegida() && arrayCasillas[i][j].getBarco()!=null) {
                    System.out.print(" X ");
                } else if (arrayCasillas[i][j].isElegida() && arrayCasillas[i][j].getBarco()==null) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println("");
        }
    }

}
