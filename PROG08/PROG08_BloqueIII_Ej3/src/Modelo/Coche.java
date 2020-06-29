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
public class Coche extends Vehiculo{

    // ATRIBUTOS
    private int numPuertas;


    // MÉTODOS
    // Getters + Setters
    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + " Coche{" + "numPuertas=" + numPuertas + '}';
    }

    // Constructor
    public Coche(String matricula,int numPuertas) {
        super(matricula);
        this.numPuertas=numPuertas;
    }
    
    
}
