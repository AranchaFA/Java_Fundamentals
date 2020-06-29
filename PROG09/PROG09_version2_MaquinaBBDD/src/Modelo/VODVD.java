package Modelo;

import java.util.Date;

public class VODVD implements Producto {

    // ATRIBUTOS
    private String id_dvd;
    private String nom_dvd;
    private String director;
    private String genero;
    private Date anio;
    private float precio;

    // MÉTODOS
    // Getters + Setters
    public String getId_dvd() {
        return id_dvd;
    }

    public void setId_dvd(String id_dvd) {
        this.id_dvd = id_dvd;
    }

    public String getNom_dvd() {
        return nom_dvd;
    }

    public void setNom_dvd(String nom_dvd) {
        this.nom_dvd = nom_dvd;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // toString
    @Override
    public String toString() {
        return "DVD{" + "id_dvd=" + id_dvd + ", nom_dvd=" + nom_dvd + ", director=" + director + ", genero=" + genero + ", año=" + (anio.getYear()+1900)+ ", precio=" + precio + '}';
    }

    // Constructores
    public VODVD(String id_dvd, float precio) {
        this.id_dvd = id_dvd;
        this.precio = precio;
    }

    public VODVD(String id_dvd, String nom_dvd, String director, String genero, Date anio, float precio) {
        this.id_dvd = id_dvd;
        this.nom_dvd = nom_dvd;
        this.director = director;
        this.genero = genero;
        this.anio = anio;
        this.precio = precio;
    }

    @Override
    public float calcularCoste() {
        return this.precio;
    }

}
