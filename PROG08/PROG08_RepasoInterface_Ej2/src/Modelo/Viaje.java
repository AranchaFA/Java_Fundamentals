/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Arancha
 */
public class Viaje {

    // ATRIBUTOS
    private ArrayList<Pasaje> pasajes;
    private GregorianCalendar fecha;

    // MÉTODOS
    // Getters + Setters
    public ArrayList<Pasaje> getPasajes() {
        return pasajes;
    }

    public void setPasajes(ArrayList<Pasaje> pasajes) {
        this.pasajes = pasajes;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    // toString
    @Override
    public String toString() {
        return "Viaje{" + "pasajes=" + pasajes + ", fecha=" + fecha.getTime() + '}';
    }
    
    // Constructor
    public Viaje(GregorianCalendar fecha) {
        this.fecha = fecha;
        this.pasajes = new ArrayList<>();
    }

}
