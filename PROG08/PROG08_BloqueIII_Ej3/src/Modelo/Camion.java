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
public class Camion extends Vehiculo {

    // ATRIBUTOS
    private Remolque remolque;

    // MÉTODOS
    // Getters + Setters
    public Remolque getRemolque() {
        return remolque;
    }

    public void setRemolque(Remolque remolque) {
        this.remolque = remolque;
    }

    // toString
    @Override
    public String toString() {
        String mostrar;
        if (this.remolque == null) {
            mostrar = super.toString() + " Camion{" + "Sin remolque" + '}';
        } else {
            mostrar = super.toString() + " Camion{" + "remolque=" + remolque + '}';
        }
        return mostrar;
    }

    // Constructor
    public Camion(String matricula) {
        super(matricula);
        this.remolque = null;
    }

    // Poner / Quitar remolque
    public void ponerRemolque(Remolque remolque) {
        this.remolque = remolque;
    }

    public void quitaRemolque() {
        this.remolque = null;
    }

    // Sobreescribir método acelerar para que no pase de 100km/h
    @Override
    public int acelerar(int incremento) throws DemasiadoRapidoException {
        int velocidadFinal = getVelocidad() + incremento;
        String mensaje = "";
        if (velocidadFinal > 100 && this.remolque != null) {
            this.velocidad=100;
            throw new DemasiadoRapidoException("¡ Demasiado rápido ! (" + velocidadFinal + "km/h)");           
        } else {
            super.acelerar(incremento);
        }
        return this.velocidad;
    }

}
