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
public class Palanca {

    // ATRIBUTOS
    private boolean activada;
    private boolean desbloqueada;

    // MÉTODOS
    // Getters + Setters
    public boolean isActivada() {
        return activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public boolean isDesbloqueada() {
        return desbloqueada;
    }

    public void setDesbloqueada(boolean desbloqueada) {
        this.desbloqueada = desbloqueada;
    }

    // toString
    @Override
    public String toString() {
        return "Palanca{" + "activada=" + activada + ", desbloqueada=" + desbloqueada + '}';
    }

    // Constructor (por defecto bloqueada y desactivada)
    public Palanca() {
    }

    /**
     * Método para activar la palanca true = se ha activado (estaba desactivada)
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
     * Método para desactivar la alarma true = se ha desactivado (estaba
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

    /**
     * Método para bloquear la palanca true = se ha activado (estaba
     * desactivada) false = ya estaba activada
     */
    public boolean bloquear() {
        if (desbloqueada == true) {
            desbloqueada = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para desbloquear la palanca true = se ha desactivado (estaba
     * activada) false = ya estaba desactivada
     */
    public boolean desbloquear() {
        if (desbloqueada == false) {
            desbloqueada = true;
            return true;
        } else {
            return false;
        }
    }
}
