
package Modelo;

import java.io.Serializable;
import java.util.List;



public class Jugador implements Serializable{
    
    // ATIBUTOS
    private String nombre;
    private String apellidos;
    private List<Integer> combinacionApostada;
    private int numeroAciertos;
    
    // MÉTODOS
    // Getters + Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Integer> getCombinacionApostada() {
        return combinacionApostada;
    }

    public void setCombinacionApostada(List<Integer> combinacionApostada) {
        this.combinacionApostada = combinacionApostada;
    }

    public int getNumeroAciertos() {
        return numeroAciertos;
    }

    public void setNumeroAciertos(int numeroAciertos) {
        this.numeroAciertos = numeroAciertos;
    }
    
    
    
    // toString

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", combinacionApostada=" + combinacionApostada + ", numeroAciertos=" + numeroAciertos + '}';
    }

    // Constructor
    public Jugador(String nombre, String apellidos, List<Integer> combinacionApostada) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.combinacionApostada = combinacionApostada;
    }
    
}
