/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Arancha
 */
public abstract class Vehiculo implements Pasajero{
    
    // ATRIBUTOS
    protected String id;
    protected double tarifa;
    protected ArrayList<Persona> personas;
    
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

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
    
    // toString

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", tarifa=" + tarifa + ", personas=" + personas + '}';
    }
    
    // Constructor

    public Vehiculo(String id, ArrayList<Persona> personas) {
        this.id = id;
        this.personas = personas;
    }
    
    
}
