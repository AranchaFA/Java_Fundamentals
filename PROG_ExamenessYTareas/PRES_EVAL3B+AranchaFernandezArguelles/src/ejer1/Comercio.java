package ejer1;

import java.util.Objects;

public class Comercio {

    // ATRIBUTOS
    private String cif;
    private String nombre;
    private String ciudad;

    // MÉTODOS
    // Getters + Setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // toString
    @Override
    public String toString() {
        return "Comercio{" + "cif=" + cif + ", nombre=" + nombre + ", ciudad=" + ciudad + '}';
    }

    // Constructor
    public Comercio(String cif, String nombre, String ciudad) {
        this.cif = cif;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    // equals + hashCode (comparando por cif)
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.cif);
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
        final Comercio other = (Comercio) obj;
        if (!Objects.equals(this.cif, other.cif)) {
            return false;
        }
        return true;
    }

}
