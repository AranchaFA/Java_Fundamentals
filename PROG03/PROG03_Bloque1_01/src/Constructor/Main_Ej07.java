/*

 */
package Constructor;

import Modelo.Coche;
import Modelo.Garaje;
import java.util.Scanner;

public class Main_Ej07 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Creamos un garaje
        Garaje garaje = new Garaje();

        // Creamos dos coches
        System.out.println("Introduzca marca del coche1: ");
        String marca1 = teclado.nextLine();
        System.out.println("Introduzca modelo del coche1: ");
        String modelo1 = teclado.nextLine();

        System.out.println("Introduzca marca del coche2: ");
        String marca2 = teclado.nextLine();
        System.out.println("Introduzca modelo del coche2: ");
        String modelo2 = teclado.nextLine();

        Coche coche1 = new Coche(marca1, modelo1);
        Coche coche2 = new Coche(marca2, modelo2);
        
        // Vamos cogiendo los coches      
        garaje.aceptarCoche(coche2, "cambiar aceite");
        System.out.println(garaje.toString());
        
        garaje.aceptarCoche(coche1, "pastillas frenos");
        System.out.println(garaje.toString());
        
        garaje.devolverCoche();
        System.out.println(garaje.toString());
        
        garaje.aceptarCoche(coche1, "pastillas frenos");
        System.out.println(garaje.toString());
        
        garaje.devolverCoche();
        System.out.println(garaje.toString());
        
        garaje.aceptarCoche(coche2, "cambiar aceite");
        System.out.println(garaje.toString());
        
        garaje.devolverCoche();
        System.out.println(garaje.toString());
        
        garaje.aceptarCoche(coche1, "pastillas frenos");
        System.out.println(garaje.toString());
        
        garaje.devolverCoche();
        System.out.println(garaje.toString());
    }

}
