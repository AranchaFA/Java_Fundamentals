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
public class Alarma {

    // ATRIBUTOS
    private boolean activada;

    // MÉTODOS
    // Getters + Setters
    public boolean isActivada() {
        return activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    // toString
    @Override
    public String toString() {
        return "Alarma{" + "activada=" + activada + '}';
    }

    // Constructor (por defecto desactivada)
    public Alarma() {
    }

    /**
     * Método para activar la alarma 
     * true = se ha activado (estaba desactivada)
     * false = ya estaba activada
     */
    public boolean activar() {
        if (activada == false) {
            activada = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para desactivar la alarma 
     * true = se ha desactivado (estaba
     * activada) false = ya estaba desactivada
     */
    public boolean desactivar() {
        if (activada == true) {
            activada = false;
            return true;
        } else {
            return false;
        }
    }

}
