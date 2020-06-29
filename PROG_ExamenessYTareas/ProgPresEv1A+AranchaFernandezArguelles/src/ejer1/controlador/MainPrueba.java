
package ejer1.controlador;

import ejer1.modelo.Persona;
import ejer1.modelo.Sillon;
import java.util.Scanner;

public class MainPrueba {

    public static void main(String[] args) {
        
        // Creamos objeto de la clase Scanner para introducir datos por teclado
        Scanner teclado=new Scanner(System.in);
        
        // Creamos un sillon
        System.out.println("¿Cómo se identificará el sillón?: ");
        Sillon sillon=new Sillon(teclado.nextLine());
        
        // Creamos una persona usando variables auxiliares para ambos parámetros
        System.out.println("¿Cómo se llama el usuario?");
        String auxNombre=teclado.nextLine();
        System.out.println("¿Cuántos años tiene?");
        int auxEdad=teclado.nextInt();
        Persona usuario=new Persona(auxNombre, auxEdad);
        
        // Mostramos la información de ambos objetos
        System.out.println("La información inicial del sillón es:"+'\n'+sillon.toString());
        System.out.println("La información inicial del usuario es:"+'\n'+usuario.toString());
        
        // Sentamos a la persona y mostramos la información
        System.out.println("Sentamos a "+usuario.getNombre());
        sillon.ocuparSillon(usuario);
        System.out.println("Tras sentarse, la información del sillón es: "+'\n'+sillon.toString());   
    }
    
}
