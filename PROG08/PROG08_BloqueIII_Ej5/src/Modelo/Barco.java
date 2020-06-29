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
public abstract class Barco {

    // ATRIBUTOS
    protected int tripulacion;
    protected float eslora;
    protected String nombreBarco;

    // MÉTODOS
    // Getters + Setters
    public int getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(int tripulacion) {
        this.tripulacion = tripulacion;
    }

    public float getEslora() {
        return eslora;
    }

    public void setEslora(float eslora) {
        this.eslora = eslora;
    }

    public String getNombreBarco() {
        return nombreBarco;
    }

    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }

    // toString
    @Override
    public String toString() {
        return "Barco{" + "tripulacion=" + tripulacion + ", eslora=" + eslora + ", nombreBarco=" + nombreBarco + '}';
    }

    // Constructores
    public Barco() {
    }

    public Barco(int tripulacion, float eslora, String nombreBarco) {
        this.tripulacion = tripulacion;
        this.eslora = eslora;
        this.nombreBarco = nombreBarco;
    }

}
