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
public class Persona implements Pasajero{

    // ATRIBUTOS
    private String id;
    private double tarifa;
    
    // MÉTODOS
    // Getters + Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    // toString
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", tarifa=" + tarifa + '}';
    }
    
    // Constructor

    public Persona(String id) {
        this.id = id;
        this.tarifa=1;
    }
    
    
    @Override
    public double calcularPrecioPasaje() {
        return this.tarifa*1;
    }
    
}
