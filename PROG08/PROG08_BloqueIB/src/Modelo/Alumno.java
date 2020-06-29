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
public class Alumno extends Persona {

    // ATRIBUTOS
    private int calificacion;

    // MÉTODOS
    // Getters + Setters
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + " Alumno{" + "calificacion=" + calificacion + '}';
    }

    // Constructores
    
    public Alumno(String nombre, int edad, String sexo) {
        super(nombre, edad, sexo);
        ausentarse();
        this.calificacion=calificacionAleatoria();
    }

    // Método para calcular aleatoriamente si está ausente sobreescrito
    @Override
    public void ausentarse() {
        if ((int) (Math.random() * 10)<5) {
            this.ausente=false;
        } else {
            this.ausente=true;
        }
    }

    // Método para calcular una calificación aleatoria entre 0 y 10
    public int calificacionAleatoria(){
        return (int)(Math.random()*11);
    }
}
