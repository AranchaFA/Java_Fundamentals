
package Modelo;

public class Jugador {
    
    // ATRIBUTOS
    private String nombre;
    private Carta carta;
    
    // MÉTODOS
    public String getNombre() {
        return nombre;
    }

    public Carta getCarta() {
        return carta;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", carta=" + carta + '}';
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public void cogerCarta() {
        this.carta=new Carta((int)(Math.random()*13+2)); // Valores entre 2 y 14.999...
    }
}
