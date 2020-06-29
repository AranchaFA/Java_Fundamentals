
package Controlador;

import Modelo.Menu;

public class Main_Menu {

    public static void main(String[] args) {
        
        // Creamos un objeto de la clase Menu:
        Menu menu=new Menu();
        
        do {
            menu.mostrarMenu();
            switch (menu.getSeleccion()){
                case 1: System.out.println(menu.opcion1());
                break;
                case 2: System.out.println(menu.opcion2());
                break;
                case 3: System.out.println(menu.opcion3());
                break;
                case 4: System.out.println(menu.opcion4());
                break;
                case 0: System.out.println("¡ADIÓS!");
                break;
                default: System.out.println("¡Opción no válida!");
            }
            menu.pintarAsteriscos();
            System.out.println("");
        }
       while (menu.getSeleccion()!=0); 
    }    
}
