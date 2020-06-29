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
public abstract class Pieza {

    // ATRIBUTOS
    protected String nombre;
    protected String movimiento;

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    // toString
    @Override
    public String toString() {
        return "Pieza{" + "nombre=" + nombre + ", movimiento=" + movimiento + '}';
    }

    // Constructor
    public Pieza(String nombre) {
        this.nombre = nombre;
    }

    // Generar cadena de información
    public String stringInformacion(){
        return "Soy un "+this.getClass().getSimpleName()+": "+this.nombre+"\n"+this.movimiento;
    }
}
