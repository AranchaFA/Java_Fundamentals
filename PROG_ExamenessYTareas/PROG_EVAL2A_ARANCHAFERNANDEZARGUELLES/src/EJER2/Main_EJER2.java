package EJER2;

import java.util.Scanner;

public class Main_EJER2 {

    public static void main(String[] args) {

        DAO_DatosPrimitivos daoEnteros = new DAO_DatosPrimitivos("fileEnteros.dat");

        Scanner teclado = new Scanner(System.in);
        String seguir;

        do {
            boolean numValido = false;
            int numABuscar;

            do {
                System.out.println("¿Qué número quieres buscar? [1-100] :");
                numABuscar = teclado.nextInt();
                teclado.nextLine(); // Vaciamos buffer
                if (numABuscar > 0 && numABuscar < 101) {
                    numValido = true;
                }
            } while (numValido != true);

            System.out.print("El número " + numABuscar + " aparece " + daoEnteros.buscarUnRegistroYContabilizar(numABuscar) + " veces en el fichero.");
            System.out.println("Mostramos el fichero completo para comprobar: ");
            daoEnteros.mostrarFichero();

            System.out.println("¿Quieres buscar otro número? (S/N)");
            seguir = teclado.nextLine();
            while (!seguir.equalsIgnoreCase("s") && !seguir.equalsIgnoreCase("n")) {
                System.out.println("Opción no válida, introduce S o N :");
                seguir = teclado.nextLine();
            }

        } while (seguir.equalsIgnoreCase("s"));

    }

}
