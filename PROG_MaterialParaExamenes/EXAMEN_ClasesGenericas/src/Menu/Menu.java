package Menu;

import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
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
    
    public void ejecutarMenuSecundario() {
        Scanner teclado = new Scanner(System.in);
        int opcionElegida;
        
        do {
            System.out.println("*** M E N Ú ***");
            System.out.println("1. Sub-Opción 1");
            System.out.println("2. Sub-Opción 2");
            System.out.println("0. Volver a menú principal");
            System.out.println("\n¿Qué quieres hacer?");
            opcionElegida = teclado.nextInt();
            teclado.nextLine(); // Vaciamos buffer
            System.out.println("\n\n");

            switch (opcionElegida) {
                // Creamos un controlador con valores cualesquiera para los parámetros, porque sólo utilizarmos el DAO
                case 1:
                    // Método de la opción 1
                    break;
                case 2:
                    // Método de la opción 2
                    break;
                case 0:
                    // No se ejecuta el menú general, ni aquí ni fuera de este while, porque al salir de este bucle
                    // ya "volvemos" al del menú general (en ralidad aún estamos dentro). Si ejecutamos el método
                    // del menú general estaremos llamándolo dos veces, y al salir de este segundo bucle de menú
                    // general volverá a mostrar el menú general del primer bucle
                    break;
                default:
                    System.out.println("La opción elegida no es válida, por favor introduce un valor entre 0 y 2:");
                    opcionElegida = teclado.nextInt();
                    teclado.nextLine(); // Vaciamos buffer
            }
        } while (opcionElegida != 0);
    }
}
