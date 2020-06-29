package Modelo;

import java.util.Objects;

public class Coche implements Comparable<Coche> {

    // ATRIBUTOS
    private String matricula;
    private String marca;
    private String modelo;

    // MÉTODOS
    // Getters + Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // toString
    @Override
    public String toString() {
        return "Coche_Ej2Colecciones{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + '}';
    }

    // Constructores
    public Coche(String matricula) {
        this.matricula = matricula;
    }

    public Coche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    // compareTo
    @Override
    public int compareTo(Coche o) {
        return this.matricula.compareToIgnoreCase(o.matricula);
    }

    // hashCode + equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.matricula);
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
        final Coche other = (Coche) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

}
