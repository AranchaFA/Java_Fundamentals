/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejer2.Modelo;

/**
 *
 * @author Arancha
 */
public class Moto extends Vehiculo {

    // toString
    @Override
    public String toString() {
        return super.toString() + "InstanceOf: " + this.getClass().getSimpleName();
    }

    // Constructor
    public Moto(String matricula) {
        super(matricula);
    }

    // Yo no utilizaba los días así que diferencio el cálculo pasando un precio
    @Override
    public double calcularComisionAlquiler(double precio) {
        double coste = precio*5;
        return coste;
    }

}
