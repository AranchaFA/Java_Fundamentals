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
public abstract class Calzado implements Producto{

    // ATRIBUTOS
    protected String descripcion;
    protected double precio;

    // MÉTODOS
    // Getters + Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // toString
    @Override
    public String toString() {
        return "Calzado{" + "descripcion=" + descripcion + ", precio=" + precio + '}';
    }

    // Constructor
    public Calzado(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public abstract double calcularImporte(int numUnidades);

}
