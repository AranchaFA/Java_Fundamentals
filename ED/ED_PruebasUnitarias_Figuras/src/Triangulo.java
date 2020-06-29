/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arancha
 */
public class Triangulo extends Figura{

    // ATRIBUTOS
    private float base;
    private float altura;

    // MÉTODOS
    // Getters + Setters
    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    // toString
    @Override
    public String toString() {
        return "Triangulo{" + "base=" + base + ", altura=" + altura + '}';
    }

    // Constructor
    public Triangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    // Métodos del interface
    @Override
    public float calcularArea() {
        return base * altura / 2;
    }
}
