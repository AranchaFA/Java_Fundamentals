package CestaConPalillos.Modelo;

public class Jugador {

    // ATRIBUTOS
    private String nombre;
    private boolean turno;

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    // toString
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + '}';
    }

    // Constructor

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
}
