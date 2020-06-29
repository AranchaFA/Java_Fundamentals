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
public abstract class Vehiculo {

    // ATRIBUTOS
    protected String matricula;
    protected int velocidad;

    // MÉTODOS
    // Getters + Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    // toString
    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", velocidad=" + velocidad + '}';
    }

    // Constructor
    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.velocidad = 0;
    }

    // Acelerar, retorna la velocidad final
    public int acelerar(int incremento) throws DemasiadoRapidoException{
        return this.velocidad+=incremento;
    }
}
