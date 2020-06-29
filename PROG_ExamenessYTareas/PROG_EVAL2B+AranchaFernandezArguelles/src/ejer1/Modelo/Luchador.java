package ejer1.Modelo;

import java.util.LinkedList;
import java.util.Objects;

public class Luchador implements Comparable<Luchador> {

    // ATRIBUTOS
    private String nombre;
    private String apellido;
    private String edad;
    private LinkedList<String> cinturones;
    private int numeroCinturones;

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public LinkedList<String> getCinturones() {
        return cinturones;
    }

    public void setCinturones(LinkedList<String> cinturones) {
        this.cinturones = cinturones;
    }

    public int getNumeroCinturones() {
        return numeroCinturones;
    }

    public void setNumeroCinturones(int numeroCinturones) {
        this.numeroCinturones = numeroCinturones;
    }
    
    // toString
    @Override
    public String toString() {
        return "Luchador{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cinturones=" + cinturones + ", numeroCinturones=" + numeroCinturones + '}';
    }
    

    // Constructores
    public Luchador(String nombre, String apellido, String edad, LinkedList<String> cinturones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cinturones = cinturones;
        this.numeroCinturones=cinturones.size();
    }

    public Luchador(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    // equals + hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Luchador other = (Luchador) obj;
        if (!this.nombre.equalsIgnoreCase(other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    // compareTo (por si queremos ordenarlos)
    @Override
    public int compareTo(Luchador o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }
}
