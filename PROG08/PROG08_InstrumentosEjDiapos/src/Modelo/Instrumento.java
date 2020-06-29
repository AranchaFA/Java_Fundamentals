package Modelo;

public abstract class Instrumento {

    // ATRIBUTOS
    protected String nombre;

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
        return "Instrumento{" + "nombre=" + nombre + '}';
    }

    // Constructores
    public Instrumento(String nombre) {
        this.nombre = nombre;
    }

    // Método sonar
    public abstract void tocar();
    
}
