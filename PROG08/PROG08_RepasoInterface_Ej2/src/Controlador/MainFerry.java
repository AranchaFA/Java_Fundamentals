/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author Arancha
 */
public class MainFerry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos un controlador 
        Controlador c=new Controlador();
        // Creamos 3 Pasajeros diferentes
        Moto moto=new Moto("moto", new ArrayList<>());
        moto.getPersonas().add(new Persona("PAquita"));
        Autobus bus=new Autobus("bus", new ArrayList<>());
        bus.getPersonas().add(new Persona("Ataúlfo"));
        bus.getPersonas().add(new Persona("Mariadelao"));
        Persona calimero=new Persona("Calimero");
        
        // Creamos un viaje en el controlador para vender pasajes
        c.nuevoViaje();
        // Les vamos sacando pasajes
        System.out.println("Va a comprar un pasaje: "+moto.toString());
        System.out.println(c.registrarUnPasaje(moto)+"€");
        System.out.println("Va a comprar un pasaje: "+bus.toString());
        System.out.println(c.registrarUnPasaje(bus)+"€");
        System.out.println("Va a comprar un pasaje: "+calimero.toString());
        System.out.println(c.registrarUnPasaje(calimero)+"€");
        // Vemos el total recaudado
        System.out.println("TOTAL RECAUDADO: "+c.recaudacionViaje());
        // Mostramos todos los pasajes del viaje
        System.out.println("TODOS LOS PASAJES DEL VIAJE:");
        c.mostrarTodosLosViajes();
    }
    
}
