
package Controlador;

import Modelo.Coche;
import Modelo.Moto;

public class Main_PruebaVehiculo {

    public static void main(String[] args) {
        
        Coche cochePepe;
        Coche cocheMaria;
        
        System.out.println("Creamos los coches de Pepe y María.");
        cochePepe=new Coche(3, "0000BBB", "gris plata", 0, 0);
        cocheMaria=new Coche(5, "1111CCC", "rojo", 0, 0);
        
        System.out.println("Información de los coches: ");
        System.out.println(cochePepe.toString());
        System.out.println(cocheMaria.toString());
        
        System.out.println("Creamos la moto de Pepe: ");
        Moto motoPepe=new Moto(2, "2222BBB", "negro", 0, 0);
        
        System.out.println("Información de la moto: ");
        System.out.println(motoPepe.toString());
    }
    
}
