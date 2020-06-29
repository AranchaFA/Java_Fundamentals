/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Arancha
 */
public class Pasaje {

    // ATRIBUTOS
    private Pasajero pasajero;
    private double precioPasaje;

    // MÉTODOS
    // Getters + Setters
    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public double getPrecioPasaje() {
        return precioPasaje;
    }

    public void setPrecioPasaje(double precioPasaje) {
        this.precioPasaje = precioPasaje;
    }

    // toString
    @Override
    public String toString() {
        return "Pasaje{" + "pasajero=" + pasajero + ", precioPasaje=" + precioPasaje + '}';
    }

    // Constructor
    public Pasaje(Pasajero pasajero, double precioPasaje) {
        this.pasajero = pasajero;
        this.precioPasaje = precioPasaje;
    }

}
