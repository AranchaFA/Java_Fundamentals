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
public class Bicicleta extends Vehiculo{
    
    // MÉTODOS
    // toString
    @Override
    public String toString() {
        return super.toString() + "InstanceOf: " + this.getClass().getSimpleName();
    }

    // Constructor
    public Bicicleta(String id, ArrayList<Persona> personas) {
        super(id, personas);
        this.tarifa = 1;
    }

    @Override
    public double calcularPrecioPasaje() {
        return this.tarifa * 1 + personas.size() * personas.get(0).getTarifa();
    }
}
