package Modelo;

public class Percusion extends Instrumento {

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString   
    // Constructor
    public Percusion(String nombre) {
        super(nombre);
    }

    // Método sonar
    @Override
    public void tocar() {
        System.out.println("¡ GOLPEANDO !");
    }

}
