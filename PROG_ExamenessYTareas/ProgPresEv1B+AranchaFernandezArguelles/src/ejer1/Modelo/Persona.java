package ejer1.Modelo;

public class Persona {

    private String nombre;
    private float peso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", peso=" + peso + '}';
    }

    public Persona(String nombre) {
        this.nombre = nombre;
        this.peso = (float) (50 + (Math.random() * 50 + 1));
    }

    

}
