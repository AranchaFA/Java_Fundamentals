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
public class Profesor extends Persona {

    // ATRIBUTOS
    private String materia;

    // MÉTODOS
    // Getters + Setters
    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + " Profesor{" + "materia=" + materia + '}';
    }

    // Constructores (asignando la materia de manera aleatoria)
    public Profesor(String nombre, int edad, String sexo) {
        super(nombre, edad, sexo);
        ausentarse();
        this.materia=materiaAleatoria();
    }

    // Método para calcular aleatoriamente si está ausente sobreescrito
    @Override
    public void ausentarse() {
        if ((int) (Math.random() * 10)<8) {
            this.ausente=false;
        } else {
            this.ausente=true;
        }
    }

    // Método para elegir una materia aleatoriamente
    public String materiaAleatoria() {
        switch ((int) (Math.random() * 3)) {
            case 0:
                return "Matemáticas";
            case 1:
                return "Filosofía";
            default:
                return "Física";
        }
    }
    
    // Método para elegir sexo aleatoriamente
    public String sexoAleatorio() {
        switch ((int) (Math.random() * 2)) {
            case 0:
                return "H";
            default:
                return "M";
        }
    }
}
