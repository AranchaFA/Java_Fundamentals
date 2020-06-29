package CestaConPalillos.Modelo;

public class Cesta {

    // ATRIBUTOS
    private int numNiveles;
    private Palillo[][] arrayCesta;

    // MÉTODOS
    // Getters + Setters
    public int getNumNiveles() {
        return numNiveles;
    }

    public void setNumNiveles(int numNiveles) {
        this.numNiveles = numNiveles;
    }

    public Palillo[][] getArrayCesta() {
        return arrayCesta;
    }

    public void setArrayCesta(Palillo[][] arrayCesta) {
        this.arrayCesta = arrayCesta;
    }

    // toString
    @Override
    public String toString() {
        return "Cesta{" + "numNiveles=" + numNiveles + ", arrayCesta=" + arrayCesta + '}';
    }

    // Constructor
    public Cesta(int numNiveles) {
        this.numNiveles = numNiveles;
        // Creamos el array, será cuadrado con tantas fils/columnas como niveles
        arrayCesta = new Palillo[numNiveles][numNiveles];
        // Inicializamos objetos de tipo Palillo en las posiciones que corresponda
        for (int i = 0; i < numNiveles; i++) {
            for (int j = 0; j < numNiveles; j++) {
                if (j <= i) {
                    arrayCesta[i][j] = new Palillo();
                }
            }
        }
    }

    // Método para contar los palillos disponibles en un nivel
    public int contarPalillosDeUnNivel(int nivel) {
        // Recorremos las columnas de la fila (nivel) elegido para contar cuántos palillos quedan
        // hasta que se acaben los palillos
        int numPalillosNivel = 0;
        boolean quedanPalillos = true;
        do {
            // Usamos el contador de palillos del nivel como contador también para las columnas del array porque coinciden
            // Como máximo habrá palillos hasta la columna que coincida con el valor del nivel

            // Hay que poner como condición que el máximo de palillos contados sea igual al nivel, porque
            // si no en el último nivel, al estar completo, nunca encuentra una posición null y trata de seguir leyendo fuera
            // del array. 
            // Si incluimos la condición numPalillosNivel<=nivel en el if se nos sigue saliendo porque trata de
            // comprobar la primera cláusula en la que leemos el array y la posición ya está fuera de su dimensión.
            // Si ponemos numPalillosNivel<nivel, no se sale pero entonces estaríamos contabilizando un Palillo de menos 
            // en la última fila
            // Hay que controlarlo antes de leer la posición del array, sacando la cláusula al while
            // Esto queda mucho más sencillo con un for pero estariamos leyendo muchos nulls sin necesidad,
            // y a la hora de hacer recuento de la cesta entera se multiplica el desperdicio de trabajo
            if (arrayCesta[nivel][numPalillosNivel] != null) {
                numPalillosNivel++;
            } else {
                quedanPalillos = false;
            }

        } while (quedanPalillos && numPalillosNivel <= nivel);
        return numPalillosNivel;
    }

    // Método para contar los palillos totales en la cesta, cuando sólo quede 1 habrá terminado
    // la partida y ganará el jugador que acaba de tner el turno
    public int contarPalillosDeLaCesta() {
        int numPalillosCesta = 0;
        boolean quedanPalillos = true;
        // Recorremos todos los niveles contando los palillos que quedan y sumándolos al total
        for (int i = 0; i < numNiveles; i++) {
            numPalillosCesta +=contarPalillosDeUnNivel(i);
        }
        return numPalillosCesta;
    }

    // Método para retirar palillos, numNivel será la fila del array (será la fila elegida
    // por el jugador -1 por empezar a contar en 0 en vez de en 1)
    public void retirarPalillos(int numNivel, int numPalillosARetirar) {
        int numPalillosRetirados = 0;
        // Recorremos la fila elegida DE ATRÁS A DELANTE poniendo a null el número de palillos elegido
        // Empezamos a buscar palillos desde la posición con valor igual a la del nivel, pues es la máxima
        // posición en que podemos encontrarlos (se inicializa la cesta con palillos en las columnas <= fila correspondiente).
        for (int j = numNivel; j >= 0; j--) {
            if (arrayCesta[numNivel][j] != null && numPalillosRetirados < numPalillosARetirar) {
                arrayCesta[numNivel][j] = null;
                numPalillosRetirados++;
            }
        }
    }

    // Método para mostrar la cesta con los palillos que le quedan
    public void mostrarCesta() {
        for (int i = 0; i < numNiveles; i++) {
            for (int j = 0; j < numNiveles; j++) {
                if (arrayCesta[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(" I ");
                }
            }
            System.out.println("");
        }
    }
}
