package ejer1.controlador;

import ejer1.modelo.Persona;
import ejer1.modelo.Sillon;

public class MainGestionSillon2 {

    public static void main(String[] args) {

        // Creamos un sillón y dos personas metiendo los datos directamente
        Sillon sillon = new Sillon("MiSillon");
        Persona usuario1 = new Persona("Calimera", 20);
        Persona usuario2 = new Persona("Priscilo", 40);
        
        // Apartado A
        System.out.println("Estado inicial del sillón: " + '\n' + sillon.toString());
        
        // Apartado B
        System.out.println("Un usuario va a usar el sillón, ¿cómo está?");
        if (sillon.ocuparSillon(usuario1) == true) {
            sillon.ocuparSillon(usuario1);
            System.out.println("LIBRE");
        } else {
            System.out.println("OCUPADO");
        }
        System.out.println("Estado actual del sillón: " + '\n' + sillon.toString());
        
        // Apartado C
        System.out.println("Otro usuario va a usar el sillón, ¿cómo está?");
        if (sillon.ocuparSillon(usuario2) == true) {
            sillon.ocuparSillon(usuario2);
            System.out.println("LIBRE");
        } else {
            System.out.println("OCUPADO");
        }
        System.out.println("Estado actual del sillón: " + '\n' + sillon.toString());
        
        // Apartado D
        System.out.println("El usuario "+sillon.getUsuario().getNombre()+" se levanta del sillón.");
        sillon.desocuparSillon();
        
        if (sillon.getUsuario() == null) {
            System.out.println("LIBRE");
        } else {
            System.out.println("OCUPADO");
        }
        System.out.println("Estado actual del sillón: " + '\n' + sillon.toString());
        
        // Apartado E
        System.out.println("Otro usuario va a usar el sillón, ¿cómo está?");
        if (sillon.ocuparSillon(usuario2) == true) {
            sillon.ocuparSillon(usuario2);
            System.out.println("LIBRE");
        } else {
            System.out.println("OCUPADO");
        }
        System.out.println("Estado actual del sillón: " + '\n' + sillon.toString());
        
        // Apartado F
        System.out.println("Atributos del sillón (sin usar toString): ");
        System.out.println("Id: "+sillon.getId());
        System.out.println("Precio: "+sillon.getPrecio());
        System.out.println("Recaudación: "+sillon.getRecaudacion());
        System.out.println("Total usuarios: "+sillon.getTotalUsuarios());
        System.out.println("Usuario actual: "+sillon.getUsuario());
        
        System.out.println("El sillón se ha usado "+sillon.getTotalUsuarios()+" veces en total.");
        
        System.out.println("El sillón ha recaudado "+sillon.getRecaudacion()+"€ en total.");
    }

}
