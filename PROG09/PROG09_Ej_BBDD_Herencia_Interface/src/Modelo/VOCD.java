package Modelo;

import java.util.Date;

public class VOCD implements Producto{

    // ATRIBUTOS
    private String id_cd;
    private String nom_album;
    private String artista;
    private Date anio;
    private float precio;

    // MÉTODOS
    // Getters + Setters
    public String getId_cd() {
        return id_cd;
    }

    public void setId_cd(String id_cd) {
        this.id_cd = id_cd;
    }

    public String getNom_album() {
        return nom_album;
    }

    public void setNom_album(String nom_album) {
        this.nom_album = nom_album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
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
        return "CD{" + "id_cd=" + id_cd + ", nom_album=" + nom_album + ", autor=" + artista + ", año=" + (anio.getYear()+1900) + ", precio=" + precio + '}';
    }

    // Constructor
    public VOCD(String id_cd, String nom_album, String artista, Date anio, float precio) {
        this.id_cd = id_cd;
        this.nom_album = nom_album;
        this.artista = artista;
        this.anio = anio;
        this.precio = precio;
    }

    @Override
    public float calcularCoste() {
        return this.precio;
    }

}
