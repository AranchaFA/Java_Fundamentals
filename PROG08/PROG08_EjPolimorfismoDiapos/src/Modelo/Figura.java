package Modelo;

public abstract class Figura {

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
        return "Figura{" + "nombre=" + nombre + '}';
    }

    // Constructores
    public Figura() {
    }

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();
}
