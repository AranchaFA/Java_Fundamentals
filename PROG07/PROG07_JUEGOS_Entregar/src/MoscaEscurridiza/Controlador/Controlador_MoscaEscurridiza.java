package MoscaEscurridiza.Controlador;

import ModeloGeneral.DAO_CSVs;
import MoscaEscurridiza.Modelo.*;
import java.util.Scanner;

public class Controlador_MoscaEscurridiza {

    // ATRIBUTOS
    private  DAO_CSVs daoResultados;
    private Mosca mosca;
    private Habitacion habitacion;
    private int numIntentos;
    private String nombreJugador;
    private boolean cazada; // Nos indicará si al terminar la partida el jugador cazó o no la mosca

    // MÉTODOS

    // Construtor 
    // Deberá crear la mosca y la habitación (sin calcular posición inicial para la mosca)
    // para ello necesita pasar los parámetros largo/ancho de la habitación
    // Crearemos también el DAO_CSVs con su fichero de resultdos asociado (este lo definimos directamente sin pasar parámetro)
    public Controlador_MoscaEscurridiza(int largo, int ancho) {
        daoResultados=new DAO_CSVs("ResultadosMosca.csv");
        habitacion = new Habitacion(largo, ancho);
        mosca = new Mosca();
    }

    // Método para realizar UNA jugada: situar la mosca y tratar de cazarla
    // Los parámetros a pasar serán las posiciones en el ARRAY, que serán las dadas por el jugador restando 1
    public boolean realizarUnaJugada(int filaElegida, int columnaElegida) {
        boolean acierto = false;
        // Reinicializamos el array con todas sus posiciones a null para eliminar la mosca que queda si ha habido una jugada anterior
        // No la podemos eliminar al finalizar la jugada porque necesitamos que perdure el objeto Mosca en el array de la Habitación
        // para poder mostrar por pantalla la Habitación con las posiciones null y la posición de la mosca.
        // También podríamos crear el objeto habitación en este punto en vez de en el constructor.
        habitacion.setArrayHabitacion(new Mosca[habitacion.getLargo()][habitacion.getAncho()]);
        // Ubicamos la mosca en una posición
        mosca.calcularPosicion(habitacion);
        // Comprobamos si la posición elegida por el jugador es donde está la mosca
        if (habitacion.getArrayHabitacion()[filaElegida][columnaElegida] != null) {
            acierto = true;
        }
        return acierto;
    }

    // Método para mostrar las posiciones de la habitación por pantalla
    public void mostrarHabitacion() {
        if (numIntentos==0) {
            System.out.println("Habitación creada: ");
        } else {
            System.out.println("Posición de la mosca en el intento número "+numIntentos);
        }
        for (int i = 0; i < habitacion.getLargo(); i++) {
            for (int j = 0; j < habitacion.getAncho(); j++) {
                if (habitacion.getArrayHabitacion()[i][j] == null) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + mosca.getNombre() + " ");
                }
            }
            System.out.println("");
        }
    }

    // Método para echar una partida de N intentos que pediremos por teclado
    public void echarPartidaConLimiteIntentos(int maxIntentos) {
        Scanner teclado = new Scanner(System.in);
        
        int filaArray = 0;
        int columnaArray = 0;
        int filaJugador = 0;
        int columnaJugador = 0;
        
        // Pedimos el nombre del jugador porque necesitaremos grabarlo
        System.out.println("Nombre de jugador:");
        nombreJugador=teclado.nextLine();
        // Mostramos habitación recién creada:
        mostrarHabitacion();
        // REalizamos intentos en bucle hasta encontrar la mosca o hasta agotar los intentos
        while (numIntentos < maxIntentos && cazada==false) {
            // Pedimos una posición donde buscar al jugador
            do {
                System.out.println("Elige fila: ");
                filaJugador = teclado.nextInt();
                filaArray = filaJugador - 1; // La fila del array será 1 posición menor a la intruducida por el jugdor
                if (filaJugador < 1 || filaJugador > habitacion.getLargo()) {
                    System.out.println("El valor introducido está fuera de rango, por favor elige una fila entre 1 y " + habitacion.getLargo());
                }
            } while (filaJugador < 1 || filaJugador > habitacion.getLargo());

            do {
                System.out.println("Elige columna: ");
                columnaJugador = teclado.nextInt();
                columnaArray = columnaJugador - 1; // La fila del array será 1 posición menor a la intruducida por el jugdor
                if (columnaJugador < 1 || columnaJugador > habitacion.getAncho()) {
                    System.out.println("El valor introducido está fuera de rango, por favor elige una columna entre 1 y " + habitacion.getAncho());
                }
            } while (columnaJugador < 1 || columnaJugador > habitacion.getAncho());
            // Realizamos la jugada con la posición introducida y guardamos el resultado (true/false) en el atributo cazada
            cazada=realizarUnaJugada(filaArray, columnaArray);
            // Sumamos un intento al número de intentos realizados
            numIntentos++;
            // Mostramos la habitación para comprobar la posición de la mosca
            if (cazada) {
                System.out.println("\n¡ HAS CAZADO A LA MOSCA !");
            } else {
                System.out.println("\nInténtalo de nuevo...");
            }
            mostrarHabitacion();
            if (numIntentos==maxIntentos) {
                System.out.println("\nFIN DE PARTIDA\nNo has tenido suerte...");
            }
            
        }
    }
    
    // Método para echar una partida sin límite de intentos (hasta encontrar la mosca)
    public void echarPartidaSinLimiteIntentos() {
        Scanner teclado = new Scanner(System.in);
        
        int filaArray = 0;
        int columnaArray = 0;
        int filaJugador = 0;
        int columnaJugador = 0;
        
        // Pedimos el nombre del jugador porque necesitaremos grabarlo
        System.out.println("Nombre de jugador:");
        nombreJugador=teclado.nextLine();
        // Mostramos habitación recién creada:
        mostrarHabitacion();
        // REalizamos intentos en bucle hasta encontrar la mosca o hasta agotar los intentos
        while (cazada==false) {
            // Pedimos una posición donde buscar al jugador
            do {
                System.out.println("Elige fila: ");
                filaJugador = teclado.nextInt();
                filaArray = filaJugador - 1; // La fila del array será 1 posición menor a la intruducida por el jugdor
                if (filaJugador < 1 || filaJugador > habitacion.getLargo()) {
                    System.out.println("El valor introducido está fuera de rango, por favor elige una fila entre 1 y " + habitacion.getLargo());
                }
            } while (filaJugador < 1 || filaJugador > habitacion.getLargo());

            do {
                System.out.println("Elige columna: ");
                columnaJugador = teclado.nextInt();
                columnaArray = columnaJugador - 1; // La fila del array será 1 posición menor a la intruducida por el jugdor
                if (columnaJugador < 1 || columnaJugador > habitacion.getAncho()) {
                    System.out.println("El valor introducido está fuera de rango, por favor elige una columna entre 1 y " + habitacion.getAncho());
                }
            } while (columnaJugador < 1 || columnaJugador > habitacion.getAncho());
            // Realizamos la jugada con la posición introducida y guardamos el resultado (true/false) en el atributo cazada
            cazada=realizarUnaJugada(filaArray, columnaArray);
            // Sumamos un intento al número de intentos realizados
            numIntentos++;
            // Mostramos la habitación para comprobar la posición de la mosca
            if (cazada) {
                System.out.println("\n¡ HAS CAZADO A LA MOSCA !");
            } else {
                System.out.println("\nInténtalo de nuevo...");
            }
            mostrarHabitacion();
        }
    }
    
    // Métodos para echar una partida (con o sin límite de intentos) y guardr el resultado final
    public void jugarYGrabarConLimiteIntentos(int maxIntentos){
        echarPartidaConLimiteIntentos(maxIntentos);
        grabarResultado();
    }
    public void jugarYGrabarSinLimiteIntentos(){
        echarPartidaSinLimiteIntentos();
        grabarResultado();
    }
    
    // Método para grabar lor resultados en un fihero CSV
    public void grabarResultado(){
        String moscaCazada;
        if (cazada==true) {
            moscaCazada="cazada";
        } else {
            moscaCazada="no cazada";
        }
        String stringAGrabar=nombreJugador+","+moscaCazada+","+numIntentos;
        daoResultados.anhadirUnResultado(stringAGrabar);
    }
    
    public void mostrarReaultados(){
        daoResultados.mostrarFicheroPorPantalla();
    }
}
