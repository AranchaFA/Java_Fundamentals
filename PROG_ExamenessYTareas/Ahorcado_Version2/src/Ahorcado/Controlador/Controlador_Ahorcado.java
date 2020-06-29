package Ahorcado.Controlador;

import Ahorcado.Modelo.*;
import java.util.Scanner;

public class Controlador_Ahorcado {

    // ATRIBUTOS
    private Recuento recuento;
    private Acierto aciertos;
    private String palabraAAcertar;
    private String nombreJugador;

    // MÉTODOS
    // Constructor
    public Controlador_Ahorcado(String palabraAAcertar, String nombreJugador, int maxFallos) {
        this.nombreJugador = nombreJugador;
        this.palabraAAcertar = palabraAAcertar.toUpperCase();// Trabajamos con MAYÚSCULA
        // Creamos el objeto Recuento con el máximo de fallos y la palabra a acertar
        recuento = new Recuento(maxFallos,this.palabraAAcertar);
        // Creamos el objeto aciertos pasando la longitud de la palabra
        aciertos = new Acierto(this.palabraAAcertar.length());
    }

    // Método para realizar UN intento, nos devuelve si se ha acertado la palabra o no
    // Comprobar una letra EN MAYÚSCULAS
    // Añadirla a elegidas descontando intentos si procede
    // Comprobar si se ha acertado finalmente la palabra
    public boolean realizarUnaJugada(char letra) {
        letra = Character.toUpperCase(letra);
        boolean existe = false;
        boolean palabraAcertada;
        // Comprobamos si la letra está en la palabra a acertar, y si lo está la
        // grabamos en la misma posición en que se encuentra en el array de aciertos
        for (int i = 0; i < palabraAAcertar.length(); i++) {
            if (palabraAAcertar.charAt(i) == letra) {
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
        palabraAcertada=aciertos.comprobarPalabraAcertada();
        
        return palabraAcertada;
    }

    // Método para echar una partida completa
    public void echarUnaPartida() {
        Scanner teclado = new Scanner(System.in);
        char letraElegida;
        boolean palabraAcertada;

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
            String cadenaIntroducida;
            do {
                // Comprobamos que es una letra de la A a la Z
                do {
                    System.out.println("Elige una letra: ");
                    // Controlaremos que no se intoduzca más de un caracter
                    cadenaIntroducida=teclado.nextLine();
                    letraElegida = cadenaIntroducida.charAt(0);
                    letraElegida = Character.toUpperCase(letraElegida);

                    // Usamos las equivalencias ASCII para controlar si el caracter introducido es válido
                    posicion = (int) letraElegida; // A=65, Z=90, Ñ=165
                    if (posicion == 165) { //  Le damos un valor cualquiera dentro del rango válido
                        posicion = 65;
                    }

                    if (posicion < 65 || posicion > 90 || cadenaIntroducida.length()>1) {
                        System.out.println("Has introducido un caracter no válido, por favor introduce una letra de la A a la Z.");
                    }
                } while (posicion < 65 || posicion > 90 || cadenaIntroducida.length()>1);

                // Una vez que sabemos que es una letra válida comprobamos si la letra ya está elegida
                elegida = recuento.comprobarSiLetraElegida(letraElegida);
                if (elegida) {
                    System.out.println("Has introducido una letra ya elegida, por favor introduce otra.");
                }
            } while (elegida);

            // Una vez que tenemos una letra válida realizamos una jugada con ella
            palabraAcertada=realizarUnaJugada(letraElegida);
        } while (recuento.getFallosRestantes() > 0 && !palabraAcertada);

        // Al acabar la partida mostramos los resultados en función del resultado
        if (palabraAcertada) {
            System.out.println("¡ HAS ACERTADO !");
            System.out.print("La palabra era:  ");
            System.out.println(palabraAAcertar);
            System.out.print("Te han quedado " + recuento.getFallosRestantes() + " intentos.");
        } else {
            System.out.println("¡ LO SIENTO !\nHas agotado tus intentos.");
            System.out.print("La palabra era:  ");
            System.out.println(palabraAAcertar);
        }
    }

    /*
    // Método para grabar los resultados en CSV
    public void grabarResultados() {
        String acertada;
        if (aciertos.comprobarPalabraAcertada()) {
            acertada = "palabra acertada";
        } else {
            acertada = "palabra no acertada";
        }
        String stringAGrabar = nombreJugador + "," + palabraAAcertar + "," + acertada + "," + recuento.getMaxFallos() + "," + recuento.getFallosRestantes();

        daoResultados.anhadirUnResultado(stringAGrabar);
    }

    // Mostrar los rsultados del CSV
    public void mostrarResultados() {
        daoResultados.mostrarFicheroPorPantalla();
    }

    // Método para echar una partida grabando los resultados finales
    public void echarUnaPartidaYGrabarResultado() {
        echarUnaPartida();
        grabarResultados();
    }
*/
}
