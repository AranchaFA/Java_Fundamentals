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
public class Contrato {

    // ATRIBUTOS
    private AlquilableVendible av; // En vez usar inmueble usamos un AlquilableVendible
    private String tipo;
    double precio;
    double comision;

    // MÉTODOS
    // Getters + Setters
    public Ejer2.Modelo.AlquilableVendible getAv() {
        return av;
    }

    public void setAv(Ejer2.Modelo.AlquilableVendible av) {
        this.av = av;
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
        return "Contrato{" + "av=" + av + ", tipo=" + tipo + ", precio=" + precio + ", comision=" + comision + '}';
    }

    // Constructor
    // En vez de pasar un inmueble como parámetro pasamos un AlquilableVendible
    public Contrato(AlquilableVendible av, String tipo, double precio) {
        this.av = av;
        this.tipo = tipo;
        this.precio = precio;
        // Calculamos la comisión en funciónde si es alquiler ("A") o venta ("V")
        if (tipo.equalsIgnoreCase("A")) {
            this.comision = av.calcularComisionAlquiler(precio);
        } else {
            this.comision = av.calcularComisionVenta(precio);
        }
    }

    

}
