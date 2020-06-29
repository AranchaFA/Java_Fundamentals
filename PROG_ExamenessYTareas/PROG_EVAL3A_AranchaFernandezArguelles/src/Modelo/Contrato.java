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
public class Contrato {

    // ATRIBUTOS
    private Inmueble inmueble;
    private String tipo;
    double precio;
    double comision;

    // MÉTODOS
    // Getters + Setters
    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    // toString
    @Override
    public String toString() {
        return "Contrato{" + "inmueble=" + inmueble + ", tipo=" + tipo + ", precio=" + precio + ", comision=" + comision + '}';
    }

    // Constructor
    public Contrato(Inmueble inmueble, String tipo, double precio) {
        this.inmueble = inmueble;
        this.tipo = tipo;
        this.precio = precio;
        // Calculamos la comisión en funciónde si es alquiler ("A") o venta ("V")
        if (tipo.equalsIgnoreCase("A")) {
            this.comision=inmueble.calcularComisionAlquiler(precio);
        } else {
            this.comision=inmueble.calcularComisionVenta(precio);
        }
    }

}
