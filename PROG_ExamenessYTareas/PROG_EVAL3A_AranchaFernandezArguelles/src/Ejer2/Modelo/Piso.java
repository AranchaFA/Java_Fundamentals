/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejer2.Modelo;

import Modelo.*;

/**
 *
 * @author Arancha
 */
public class Piso extends Inmueble{

    // Constructor
    public Piso(String id) {
        super(id);
    }

    // toString
    @Override    
    public String toString() {
        return super.toString()+"InstanceOf: "+this.getClass().getSimpleName();
    }
    
    @Override
    public double calcularComisionAlquiler(double precio) {
        return precio*0.05;
    }

    @Override
    public double calcularComisionVenta(double precio) {
        return precio*0.1;
    }
    
}
