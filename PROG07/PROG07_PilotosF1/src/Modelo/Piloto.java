 package Modelo;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class Piloto implements Serializable, Comparable<Piloto> {

    // ATRIBUTOS
    private String nombre;
    private String pais;
    private String escuderia;
    private List<Double> tiempos;

    public Piloto(String nombre) {
        this.nombre=nombre;
    }

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public List<Double> getTiempos() {
        return tiempos;
    }

    public void setTiempos(List<Double> tiempos) {
        this.tiempos = tiempos;
    }

    // Constructor
    public Piloto(String nombre, String pais, String escuderia, List<Double> tiempos) {
        this.nombre = nombre;
        this.pais = pais;
        this.escuderia = escuderia;
        this.tiempos = tiempos;
    }
    
    // toString
    @Override
    public String toString() {
        return "nombre=" + nombre + ", pais=" + pais + ", escuderia=" + escuderia +", tiempos="+ tiempos+'}';
    }
    
    // Método para obtener un String con los tiempos de la List, así podremos incorporarla al toString
    // (no haría falta, el toString ya muestra bien los elementos de la List)
    public String mostrarTiempos(){
        String stringTiempos="Tiempos: ";
        for (int i = 0; i <= tiempos.size(); i++) {
            stringTiempos+=tiempos.get(i)+"   ";
        }
        return stringTiempos;
    }
    
    // Contar cuántos registros tiene la colecciónd de tiempos
    public double calcularMediaTiempos(){
        double mediaTiempos= 0;
        for (int i = 0; i < tiempos.size(); i++) {
            mediaTiempos+=tiempos.get(i)/tiempos.size();
        }
        return mediaTiempos;
    }
    
    // Metodos para comparar y ordenar
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nombre);
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
        final Piloto other = (Piloto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    // compareTo
    @Override
    public int compareTo(Piloto piloto) {
        return this.nombre.compareToIgnoreCase(piloto.nombre);
    }
}
