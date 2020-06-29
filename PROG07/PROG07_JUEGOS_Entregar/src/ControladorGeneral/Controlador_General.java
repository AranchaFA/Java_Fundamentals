package ControladorGeneral;

import Ahorcado.Controlador.Controlador_Ahorcado;
import CestaConPalillos.Controlador.Controlador_CestaConPalillos;
import HundirElBarco.Controlador.Controlador_HundirElBarco;
import MoscaEscurridiza.Controlador.Controlador_MoscaEscurridiza;
import java.util.Scanner;

public class Controlador_General {

    // ATRIBUTOS
    // Constructor
    public Controlador_General() {
    }

    // MENÚ GENERAL
    public void ejecutarMenuGeneral() {
        Scanner teclado = new Scanner(System.in);
        int opcionElegida;
        do {
            System.out.println("\n\n");
            System.out.println("* * M E N Ú * *");
            System.out.println("1. JUGAR");
            System.out.println("2. VISUALIZAR FICHEROS");
            System.out.println("3. SALIR");
            System.out.println("¿Qué quieres hacer?");
            opcionElegida = teclado.nextInt();
            teclado.nextLine(); // Vaciamos buffer
            System.out.println("\n\n");

            switch (opcionElegida) {
                case 1:
                    ejecutarMenuJuegos();
                    break;
                case 2:
                    ejecutarMenuFicheros();
                    break;
                case 3:
                    System.out.println("¡ADIÓS!");
                    break;
                default:
                    System.out.println("La opción elegida no es válida, por favor introduce un valor entre 1 y 3.");
            }
        } while (opcionElegida != 3);
    }

    // MENÚ PARA JUGAR
    public void ejecutarMenuJuegos() {
        Scanner teclado = new Scanner(System.in);
        int opcionElegida;
        do {
            System.out.println("\n\n");
            System.out.println("* * M E N Ú * *");
            System.out.println("1. Hundir el barco");
            System.out.println("2. La mosca cojonera");
            System.out.println("3. Cesta con palillos");
            System.out.println("4. Ahorcado");
            System.out.println("5. Volver a menú principal");
            System.out.println("¿Qué quieres hacer?");
            opcionElegida = teclado.nextInt();
            System.out.println("\n\n");

            switch (opcionElegida) {

                case 1:
                    int numFilas;
                    // Pedimos el número de filas que tendrá el tablero
                    do {
                        System.out.println("¿De cuántas filas quieres que sea el tablero?");
                        numFilas = teclado.nextInt();
                        if (numFilas < 2) {
                            System.out.println("Por favor, introduce un mínimo de 2 filas.");
                        }
                    } while (numFilas < 2);
                    // Creamos un controlador con el número de filas de tablero deseadas
                    Controlador_HundirElBarco hundirElBarco = new Controlador_HundirElBarco(numFilas);
                    // Ejecutamos una partida con grabado final de rsultados
                    hundirElBarco.jugarYGrabarResultado();
                    break;

                case 2:
                    int largo;
                    int ancho;
                    // Pedimos el ancho y largo que tendrá la habitación
                    do {
                        System.out.println("¿Qué largo quieres que tenga la habitación?");
                        largo = teclado.nextInt();
                        if (largo < 2) {
                            System.out.println("Por favor, introduce un largo mínimo de 2.");
                        }
                    } while (largo < 2);
                    do {
                        System.out.println("¿Qué ancho quieres que tenga la habitación?");
                        ancho = teclado.nextInt();
                        if (ancho < 2) {
                            System.out.println("Por favor, introduce un ancho mínimo de 2.");
                        }
                    } while (largo < 2);
                    // Creamos un contolador con las dimensiones deseadas de la habitación
                    Controlador_MoscaEscurridiza moscaEscurridiza = new Controlador_MoscaEscurridiza(largo, ancho);
                    // Preguntamos el número de intntos para la partida
                    int maxIntentos;
                    do {
                        System.out.println("¿Cuántos intentos máximos quieres?\n(Introduce 0 para tener intentos ilimitados)");
                        maxIntentos = teclado.nextInt();
                        if (maxIntentos < 0) {
                            System.out.println("Por favor, introduce un valor mayor o igual a 0.");
                        }
                    } while (maxIntentos < 0);
                    // Ejecutamos el tipo de partida escogido con grabación final de los datos
                    if (maxIntentos == 0) {
                        moscaEscurridiza.jugarYGrabarSinLimiteIntentos();
                    } else {
                        moscaEscurridiza.jugarYGrabarConLimiteIntentos(maxIntentos);
                    }
                    break;

                case 3:
                    // Pedimos nombres y dimensiones de la cesta
                    teclado.nextLine(); // Vaciamos buffer
                    System.out.println("Nombre del jugador Nº1: ");
                    String nombreJugador1 = teclado.nextLine();
                    System.out.println("Nombre del jugador Nº2: ");
                    String nombreJugador2 = teclado.nextLine();
                    int numNiveles;
                    do {
                        System.out.println("Número de niveles de la cesta (mínimo 3) : ");
                        numNiveles = teclado.nextInt();
                        if (numNiveles < 3) {
                            System.out.println("Debes introducir un valor mayor o igual a 3.");
                        }
                    } while (numNiveles < 3);

                    // Creamos un controlador con los datos dados
                    Controlador_CestaConPalillos cestaConPalillos = new Controlador_CestaConPalillos(nombreJugador1, nombreJugador2, numNiveles);
                    // Realizamos una partida grabando los resultados
                    cestaConPalillos.echarUnaPartidaYGrabarResultado();
                    break;

                case 4:
                    teclado.nextLine(); // Vaciamos buffer
                    System.out.println("Nombre de jugador: ");
                    String nombreJugador = teclado.nextLine();
                    System.out.println("Palabra a acertar: ");
                    String palabraAAcertar = teclado.nextLine();
                    int maxFallos;
                    do {
                        System.out.println("Número de intentos: ");
                        maxFallos = teclado.nextInt();
                        if (maxFallos < 1) {
                            System.out.println("Debes introducir un mínimo de intentos de 1.");
                        }
                    } while (maxFallos < 1);

                    Controlador_Ahorcado ahorcado = new Controlador_Ahorcado(palabraAAcertar, nombreJugador, maxFallos);
                    ahorcado.echarUnaPartidaYGrabarResultado();
                    break;

                case 5:
                    // No se ejecuta el menú general, ni aquí ni fuera de este while, porque al salir de este bucle
                    // ya "volvemos" al del menú general (en ralidad aún estamos dentro). Si ejecutamos el método
                    // del menú general estaremos llamándolo dos veces, y al salir de este segundo bucle de menú
                    // general volverá a mostrar el menú general del primer bucle
                    break;

                default:
                    System.out.println("La opción elegida no es válida, por favor introduce un valor entre 1 y 5:");
                    opcionElegida = teclado.nextInt();
                    teclado.nextLine(); // Vaciamos buffer
            }
        } while (opcionElegida != 5);
    }

    // MENÚ PARA VER LOS FICHEROS DE RESULTADOS
    public void ejecutarMenuFicheros() {
        Scanner teclado = new Scanner(System.in);
        int opcionElegida;
        do {
            System.out.println("\n\n");
            System.out.println("* * M E N Ú * *");
            System.out.println("1. Visualizar resultados de hundir el barco");
            System.out.println("2. Visualizar resultados de la mosca cojonera");
            System.out.println("3. Visualizar resultados de cesta con palillos");
            System.out.println("4. Visualizar resultados de ahorcado");
            System.out.println("5. Volver a menú principal");
            System.out.println("¿Qué quieres hacer?");
            opcionElegida = teclado.nextInt();
            teclado.nextLine(); // Vaciamos buffer
            System.out.println("\n\n");

            switch (opcionElegida) {
                // Creamos un controlador con valores cualesquiera para los parámetros, porque sólo utilizarmos el DAO
                case 1:
                    Controlador_HundirElBarco hundirElBarco = new Controlador_HundirElBarco(2);
                    hundirElBarco.mostrarResultados();
                    break;
                case 2:
                    Controlador_MoscaEscurridiza moscaEscurridiza = new Controlador_MoscaEscurridiza(2, 2);
                    moscaEscurridiza.mostrarReaultados();
                    break;
                case 3:
                    Controlador_CestaConPalillos cestaConPalillos = new Controlador_CestaConPalillos("Calimera", "Edemiro", 3);
                    cestaConPalillos.mostrarResultados();
                    break;
                case 4:
                    Controlador_Ahorcado ahorcado = new Controlador_Ahorcado("periquito", "Calimera", 4);
                    ahorcado.mostrarResultados();
                    break;
                case 5:
                    // No se ejecuta el menú general, ni aquí ni fuera de este while, porque al salir de este bucle
                    // ya "volvemos" al del menú general (en ralidad aún estamos dentro). Si ejecutamos el método
                    // del menú general estaremos llamándolo dos veces, y al salir de este segundo bucle de menú
                    // general volverá a mostrar el menú general del primer bucle
                    break;
                default:
                    System.out.println("La opción elegida no es válida, por favor introduce un valor entre 1 y 5:");
                    opcionElegida = teclado.nextInt();
                    teclado.nextLine(); // Vaciamos buffer
            }
        } while (opcionElegida != 5);
    }
}
