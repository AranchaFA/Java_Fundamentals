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
public abstract class Sensor {

    // ATRIBUTOS
    protected int numID;
    protected boolean activo;
    protected String unidadesMedida;

    // MÉTODOS
    // Getters + Setters
    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) {
        this.numID = numID;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(String unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    // toString
    @Override
    public String toString() {
        return "Sensor{" + "numID=" + numID + ", activo=" + activo + ", unidadesMedida=" + unidadesMedida + '}';
    }

    // Constructor (por defecto desactivada y sin unidades, se especificarán para cada subtipo)
    public Sensor(int numID) {
        this.numID = numID;
    }

    // Métodos para activar / desactivar el sensor
    public void activar() {
        activo = true;
    }

    public void desactivar() {
        activo = false;
    }
    
    // Método para tomar una medición
    public abstract double tomarMedicion();
}
