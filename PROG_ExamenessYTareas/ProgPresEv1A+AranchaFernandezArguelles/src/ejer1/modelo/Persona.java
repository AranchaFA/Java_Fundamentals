package ejer1.modelo;

public class Persona {

    // ATRIBUTOS
    private String nombre;
    private int edad;

    // MÉTODOS
    // Getters para todo
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Sin setters para la edad porque se asigna en constructor y no es modificable
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
