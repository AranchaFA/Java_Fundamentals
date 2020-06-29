package Menu;

import java.util.Scanner;

public class Menu {

    public void ejecutarMenu() {
        int opcion;
        do {
            Scanner teclado = new Scanner(System.in);

            System.out.println("*** M E N Ú ***");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("0. Salir");
            System.out.println("\n¿Qué quieres hacer?");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    // Método de la opción 1
                    break;
                case 2:
                    // Método de la opción 2
                    break;
                case 0:
                    System.out.println("¡ Adiós !");
                    break;
                default:
                    System.out.println("Opción no válida, por favor introduce un número entre 0 y 2:");
                    opcion=teclado.nextInt();
            }

        } while (opcion!=0);

    }
}
