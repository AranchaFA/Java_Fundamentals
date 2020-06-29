package AcertarUnaCasillaAleatoria;

import java.io.Serializable;

public class Casilla implements Serializable{

    // ATIBUTOS
    private Premio premio;
    private boolean elegida;

    // MÉTODOS
    // Getters + Setters
    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public boolean isElegida() {
        return elegida;
    }

    public void setElegida(boolean elegida) {
        this.elegida = elegida;
    }
    
    // Constructor (sin elegir y sin premio por defecto, el premio se asignará en el tablero)
    public Casilla() {
    }
    // toString
    @Override
    public String toString() {
        return "Casilla{" + "premio=" + premio + ", elegida=" + elegida + '}';
    }

    

}
