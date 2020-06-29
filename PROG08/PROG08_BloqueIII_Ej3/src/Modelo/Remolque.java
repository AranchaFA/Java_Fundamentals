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
public class Remolque {

    // ATRIBUTOS
    private int peso;

    // MÉTODOS
    // Getters + Setters
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    // toString
    @Override
    public String toString() {
        return "Remolque{" + "peso=" + peso + '}';
    }

    // Constructor
    public Remolque(int peso) {
        this.peso = peso;
    }

}
