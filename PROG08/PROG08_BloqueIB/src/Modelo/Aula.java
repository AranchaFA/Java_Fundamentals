/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Arancha
 */
public class Aula {

    // ATRIBUTOS
    private int id;
    private int maxAlumnos;
    private String materia;
    Profesor profesor;
    ArrayList<Alumno> alumnos;

    // MÉTODOS
    // Getters + Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    // toString
    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", maxAlumnos=" + maxAlumnos + ", materia=" + materia + ", profesor=" + profesor + ", alumnos=" + alumnos + '}';
    }

    // Constructor
    public Aula(int id, int maxAlumnos) {
        this.id = id;
        this.maxAlumnos = maxAlumnos;
        this.profesor=new Profesor("Calimera", 45, "M");
        this.alumnos=new ArrayList<>();
        int numAlumnos=(int) (Math.random()*this.maxAlumnos+1);
        for (int i = 0; i < numAlumnos; i++) {
            Alumno alumno=new Alumno(materia, id, materia)
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
}
