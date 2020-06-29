package Ahorcado.Controlador;

import Ahorcado.Modelo.*;
// import ModeloGeneral.DAO_CSVs;
import java.util.Scanner;

public class Controlador_Ahorcado {

    // ATRIBUTOS
    // private DAO_CSVs daoResultados;
    private Recuento recuento;
    private Acierto aciertos;
    private char[] arrayPalabraAAcertar;
    private String stringPalabraAAcertar;
    private String nombreJugador;

    // MÉTODOS
    // Constructor
    public Controlador_Ahorcado(String palabraAAcertar, String nombreJugador, int maxFallos) {
        // daoResultados = new DAO_CSVs("ResultadosAhorcado.csv");
        this.nombreJugador = nombreJugador;
        stringPalabraAAcertar = palabraAAcertar.toUpperCase();// Trabajamos con MAYÚSCULAS
        recuento = new Recuento(maxFallos);
        // Creamos el array con la palabra a acertar a partir del String
        arrayPalabraAAcertar = stringPalabraAAcertar.toCharArray();
        // Creamos el objeto aciertos pasando la longitud de la palabra
        aciertos = new Acierto(stringPalabraAAcertar.length());
    }

    // Método para realizar UN intento 
    // Comprobar una letra EN MAYÚSCULAS
    // Añadirla a elegidas descontando intentos si procede
    // Comprobar si se ha acertado finalmente la palabra
    public void realizarUnaJugada(char letra) {
        letra = Character.toUpperCase(letra);
        boolean existe = false;
        // Comprobamos si la letra está en la palabra a acertar, y si lo está la
        // grabamos en la misa posición en que se encuentra en el array de aciertos
        for (int i = 0; i < arrayPalabraAAcertar.length; i++) {
            if (arrayPalabraAAcertar[i] == letra) {
                aciertos.grabarLetra(i, letra);
                existe = true;
            }
        }
        // Grabamos la letra como elegida en función de si existía o no
        if (existe) {
            recuento.grabarLetraAcertada(letra);
        } else {
            recuento.grabarLetraFallada(letra);
        }
        // Comprobamos si se ha acertdo la palabra
        aciertos.comprobarPalabraAcertada();
    }

    // Método para echar una partida completa
    public void echarUnaPartida() {
        Scanner teclado = new Scanner(System.in);
        char letraElegida;

        do {
            // Mostramos el estado del array de aciertos
            System.out.print("\nPalabra a acertar:  ");
            aciertos.mostrarArray();
            // Mostramos las letras elegidas
            System.out.print("\nLetras ya elegidas:  ");
            recuento.mostrarArray();
            // Mostramos el número de fallos restantes:
            System.out.print("\nNúmero de intentos restantes:  ");
            System.out.println(recuento.getFallosRestantes());
            System.out.println("");

            // Pedimos una letra y comprobamos que es válida
            int posicion;
            boolean elegida;
            do {
                // Comprobamos que es una letra de la A a la Z
                do {
                    System.out.println("Elige una letra: ");
                    letraElegida = teclado.nextLine().charAt(0);
                    letraElegida = Character.toUpperCase(letraElegida);

                    // Calculo las posiciones que tendría en el vector para que me sirvan
                    // para controlar si el valor introducido es válido
                    posicion = (int) letraElegida - 65; // A=65 -> posicion=0
                    if (posicion == 165 - 65) { // Ñ=165 (ya le hemos restado 65) a la última posición
                        posicion = recuento.getArrayElegidas().length - 1;
                    }

                    if (posicion < 0 || posicion > recuento.getArrayElegidas().length - 1) {
                        System.out.println("Has introducido un caracter no válido, por favor introduce una letra de la A a la Z.");
                    }
                } while (posicion < 0 || posicion > recuento.getArrayElegidas().length - 1);

                // Una vez que sabemos que es una letra válida comprobamos si la letra ya está elegida
                // (si lo comprobamos en el mismo bucle, como busca por la posición ASCII se los sale
                // del array cuando el caracter no corresponde a una letra porque esa posición no existirá 
                // en el array, hay que controlar antes que sea un caracter válido)
                elegida = recuento.comprobarSiLetraElegida(letraElegida);
                if (elegida) {
                    System.out.println("Has introducido una letra ya elegida, por favor introduce otra.");
                }
            } while (elegida);

            // Una vez que tenemos una letra válida realizamos una jugada con ella
            realizarUnaJugada(letraElegida);
        } while (recuento.getFallosRestantes() > 0 && !aciertos.isPalabraAcertada());

        // Al acabar la partida mostramos los resultados en función del resultado
        if (aciertos.isPalabraAcertada()) {
            System.out.println("¡ HAS ACERTADO !");
            System.out.print("La palabra era:  ");
            System.out.println(stringPalabraAAcertar);
            System.out.print("Te han quedado " + recuento.getFallosRestantes() + " intentos.");
        } else {
            System.out.println("¡ LO SIENTO !\nHas agotado tus intentos.");
            System.out.print("La palabra era:  ");
            System.out.println(stringPalabraAAcertar);
        }
    }

    // Método para grabar los resultados en CSV
    public void grabarResultados() {
        String acertada;
        if (aciertos.isPalabraAcertada()) {
            acertada = "palabra acertada";
        } else {
            acertada = "palabra no acertada";
        }
        String stringAGrabar = nombreJugador + "," + stringPalabraAAcertar + "," + acertada + "," + recuento.getMaxFallos() + "," + recuento.getFallosRestantes();

      //  daoResultados.anhadirUnResultado(stringAGrabar);
    }

    // Mostrar los rsultados del CSV
    public void mostrarResultados() {
     //   daoResultados.mostrarFicheroPorPantalla();
    }

    // Método para echar una partida grabando los resultados finales
    public void echarUnaPartidaYGrabarResultado() {
        echarUnaPartida();
        grabarResultados();
    }
}
