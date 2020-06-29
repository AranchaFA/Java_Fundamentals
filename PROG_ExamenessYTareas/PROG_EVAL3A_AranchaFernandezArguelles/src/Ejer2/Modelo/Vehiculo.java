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
public abstract class Vehiculo implements AlquilableVendible {

    // ATRIBUTOS
    protected String matricula;

    // MÉTODOS
    // Getters + Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // toString
    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + '}';
    }

    // Constructor
    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    // Los vehiculos no están disponibles para la venta
    @Override
    public double calcularComisionVenta(double precio) {
        System.out.println("¡¡ Los vehículos no están disponible para vender !!");
        return 0;
    }
}
