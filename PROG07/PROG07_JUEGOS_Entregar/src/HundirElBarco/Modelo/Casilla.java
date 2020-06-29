package HundirElBarco.Modelo;

import java.io.Serializable;

public class Casilla implements Serializable{

    // ATIBUTOS
    private Barco barco;
    private boolean elegida;

    // MÉTODOS
    // Getters + Setters
    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public boolean isElegida() {
        return elegida;
    }

    public void setElegida(boolean elegida) {
        this.elegida = elegida;
    }
    
    // Constructor (sin elegir y sin barco por defecto, el barco se asignará en el tablero)
    public Casilla() {
    }
    // toString
    @Override
    public String toString() {
        return "Casilla{" + "barco=" + barco + ", elegida=" + elegida + '}';
    }
}
