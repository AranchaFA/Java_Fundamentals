/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arancha
 */
public class Cuadrado extends Figura {

    // ATRIBUTOS
    private float lado;

    // MÉTODOS
    // Getters + Setters
    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }

    // toString
    @Override
    public String toString() {
        return "Cuadrado{" + "lado=" + lado + '}';
    }

    // Constructor
    public Cuadrado(float lado) {
        this.lado = lado;
    }

    // Métodos del interface
    @Override
    public float calcularArea() {
        return lado*lado;
    }


}
