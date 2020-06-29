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
public class Venta {

    // ATRIBUTOS
    private Producto producto;
    private int numUnidades;
    private double importe;

    // MÉTODOS
    // Getters + Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    // toString
    @Override
    public String toString() {
        return "Venta{" + "producto=" + producto + ", numUnidades=" + numUnidades + ", importe=" + importe + '}';
    }

    // Constructor
    public Venta(Producto producto, int numUnidades, double importe) {
        this.producto = producto;
        this.numUnidades = numUnidades;
        this.importe = importe;
    }

}
