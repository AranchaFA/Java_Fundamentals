package HundirLaFlota;

import java.util.Scanner;

public class Main_HundirLaFlota {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String seguir;
        do {
            // Inicializamos un nuevo controlador cada vez que juguemos, para reiniciar el tablero
            System.out.println("¿Cuántas filas quieres que tenga el tablero?");
            Controlador controlador = new Controlador(teclado.nextInt());
            teclado.nextLine(); // Vaciamos buffer
            // Jugamos partida
            controlador.echarUnaPartida();

            System.out.println("¿Otra partida? (S/N)");
            seguir = teclado.nextLine();
            while (!seguir.equalsIgnoreCase("s") && !seguir.equalsIgnoreCase("n")) {
                System.out.println("Opción no válida, por favor introduce S o N)");
                seguir = teclado.nextLine();
            }
        } while (seguir.equalsIgnoreCase("s"));

    }

}
