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
public class Medicion {

    // ATRIBUTOS
    Sensor sensor;
    double valorMedicion;

    // MÉTODOS
    // Getters + Setters
    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public double getValorMedicion() {
        return valorMedicion;
    }

    public void setValorMedicion(double valorMedicion) {
        this.valorMedicion = valorMedicion;
    }

    // toString
    @Override
    public String toString() {
        return "Medicion{" + "sensor=" + sensor + ", valorMedicion=" + valorMedicion + '}';
    }

    // Constructor
    public Medicion(Sensor sensor, double valorMedicion) {
        this.sensor = sensor;
        this.valorMedicion = valorMedicion;
    }

}
