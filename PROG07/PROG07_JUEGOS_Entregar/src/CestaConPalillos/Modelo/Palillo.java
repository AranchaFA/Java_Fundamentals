package CestaConPalillos.Modelo;

public class Palillo {

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
        return "Palillo{" + "nombre=" + nombre + '}';
    }
    // Constructor
    public Palillo() {
        nombre="¡¿ Un palo !!";
    }
    
}
