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
public class Coche extends Vehiculo {

    // ATRIBUTOS
    private String categoria;

    // MÉTODOS
    // Getters + Setters
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // toString
    @Override
    public String toString() {
        return "Coche{" + "categoria=" + categoria + '}';
    }

    // Constructor
    public Coche(String matricula, String categoria) {
        super(matricula);
        this.categoria = categoria;
    }

    // Yo no utilizaba los días así que diferencio el cálculo pasando un precio
    // Calculo el beneficio sacado del alquiler de vehículos como el de cualquier
    // transacción inmobiliaria, pero en este caso la comisión es del 100% para la empresa
    @Override
    public double calcularComisionAlquiler(double precio) {
        double coste = 0;
        if (this.categoria.equalsIgnoreCase("E")) {
            coste = precio * 10;
        } else {
            coste = precio * 20;
        }
        return coste;
    }

}
