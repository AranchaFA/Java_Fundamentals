package Controlador;

import Modelo.Instrumento;

public class Musico {

    // ATRIBUTOS
    private String nombre;

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "Musico{" + "nombre=" + nombre + '}';
    }

    // Constructor
    public Musico() {
    }

    public Musico(String nombre) {
        this.nombre = nombre;
    }

    // Método para tocar un instrumento
    public void tocar(Instrumento instrumento){
        instrumento.tocar();
    }
}
