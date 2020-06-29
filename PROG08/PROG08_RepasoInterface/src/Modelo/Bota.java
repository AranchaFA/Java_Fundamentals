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
public class Bota extends Calzado {

    // ATRIBUTOS
    // MÉTODOS
    // toString 
    @Override
    public String toString() {
        return super.toString() + this.getClass().getSimpleName();
    }

    // Constructor
    public Bota(String descripcion, double precio) {
        super(descripcion);
        this.precio = precio;
    }

    @Override
    public double calcularImporte(int numUnidades) {
        return this.precio * numUnidades;
    }
}
