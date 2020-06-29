package ejer1;

import java.util.Objects;

public class Programa {

    // ATRIBUTOS
    private String cod;
    private String nombre;
    private String version;

    // MÉTODOS
    // Getters + Setters
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    // toString
    @Override
    public String toString() {
        return "Programa{" + "cod=" + cod + ", nombre=" + nombre + ", version=" + version + '}';
    }

    // Constructor
    public Programa(String cod, String nombre, String version) {
        this.cod = cod;
        this.nombre = nombre;
        this.version = version;
    }

    // equals + hashCode (comparando por cod)
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cod);
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
        final Programa other = (Programa) obj;
        if (!Objects.equals(this.cod, other.cod)) {
            return false;
        }
        return true;
    }

}
