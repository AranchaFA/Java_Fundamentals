/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 *
 * @author Arancha
 */
public class Controlador {

    // ATRIBUTOS
    // Para empezar a vender pasajes de un viaje se inicializará un Viaje
    // en la PRIMERA posición de la LinkedList, para ir añadiendo los pasajes
    private LinkedList<Viaje> viajes;

    // MÉTODOS
    // Getters + Setters
    public LinkedList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(LinkedList<Viaje> viajes) {
        this.viajes = viajes;
    }

    // toString
    @Override
    public String toString() {
        return "Controlador{" + "viajes=" + viajes + '}';
    }

    // Constructor
    public Controlador() {
        this.viajes = new LinkedList<>();
    }

    // Abrir venta de pasajes de un viaje (con la fecha del sistema)
    public void nuevoViaje(){
        this.viajes.addFirst(new Viaje((GregorianCalendar) Calendar.getInstance()));
    }
    // Método para registrar un pasaje de un pasajero
    public double registrarUnPasaje(Pasajero pasajero){
        double precio=pasajero.calcularPrecioPasaje();
        Pasaje pasaje=new Pasaje(pasajero, precio);
        // Añadimos un objeto Pasaje con el Pasajero y el precio al PRIMER Viaje de la LinkedList
        this.viajes.getFirst().getPasajes().add(pasaje);
        return precio;
    }
    
    // Método para calcular la recaudación total de el último viaje realizado
    public double recaudacionViaje(){
        double recaudacion=0;
        // Sumamos el precio de todos los pasajes de la lista de pasajes del PRIMER Viaje de la LinkedList
        for (Pasaje pasaje : viajes.getFirst().getPasajes()) {
            recaudacion+=pasaje.getPrecioPasaje();
        }
        return recaudacion;
    }
    
    // Mostrar toda la información de todos los viajes realizados
    public void mostrarTodosLosViajes(){
        for (Viaje viaje : viajes) {
            System.out.println(viaje.toString());
        }
    }
}
