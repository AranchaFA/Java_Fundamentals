package ejer1.controlador;

import ejer1.modelo.Persona;
import ejer1.modelo.Sillon;

public class MainGestionSillon1 {

    public static void main(String[] args) {

        // Creamos un sillón y dos personas metiendo los datos directamente
        Sillon sillon = new Sillon("MiSillon");
        Persona usuario1 = new Persona("Calimera", 20);
        Persona usuario2 = new Persona("Priscilo", 40);

        // Se sienta usuario1 y mostramos la información de los 3 objetos
        System.out.println("Sentamos a " + usuario1.getNombre());
        sillon.ocuparSillon(usuario1);
        System.out.println("Información del usuario 1: " + '\n' + usuario1.toString());
        System.out.println("Información del usuario 2: " + '\n' + usuario2.toString());
        System.out.println("Información del sillón: " + '\n' + sillon.toString());
        
        // Comprobamos si el sillón está ocupado o libre
        System.out.println("El sillón está......:");
        if (sillon.getUsuario() == null) {
            System.out.println("LIBRE");
        } else {
            System.out.println("OCUPADO");
        }

    }

}
