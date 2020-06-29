package ejer1.Controlador;

import ejer1.Modelo.Ascensor;
import ejer1.Modelo.Menu;

public class MainEj1 {

    public static void main(String[] args) {
        // Creamos un ascensor y un menú
        Ascensor ascensor = new Ascensor("SubeBaja", 250);
        Menu menu = new Menu();

        // Mostramos menú
        do {
            System.out.println("");
            menu.mostrarMenu();
            switch (menu.getOpcionSeleccion()) {
                case 1:
                    // Lleva los mensajes en la clase porque no devuelve tru o false
                    ascensor.subirPersonas();
                    break;
                case 2:
                    if (ascensor.bajarPersonas()) {
                        System.out.println("Se han bajado");
                    } else {
                        System.out.println("No había nadie!");
                    }
                    break;
                case 3:
                    System.out.println("Datos actuales del ascensor");
                    System.out.println(ascensor.toString());
                    break;
                case 0:
                    System.out.println("ADIÓS");
                    break;
                default:
                    System.out.println("Elige una opción entre 0 y 3");
            }

        } while (menu.getOpcionSeleccion() != 0);
    }

}
