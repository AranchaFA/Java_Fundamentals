package Modelo;

import java.util.Objects;

public class VOCD implements Prestable{

    // ATRIBUTOS
    private String cod_cd;
    private String titulo;
    private String artista;
    private int anio;

    // MÉTODOS
    // Getters + Setters
    public String getCod_cd() {
        return cod_cd;
    }

    public void setCod_cd(String cod_cd) {
        this.cod_cd = cod_cd;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    // toString
    @Override
    public String toString() {
        return "VOCD{" + "cod_cd=" + cod_cd + ", titulo=" + titulo + ", artista=" + artista + ", anio=" + anio + '}';
    }

    // Constructor
    public VOCD(String cod_cd, String titulo, String artista, int anio) {
        this.cod_cd = cod_cd;
        this.titulo = titulo;
        this.artista = artista;
        this.anio = anio;
    }

    // equals + hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cod_cd);
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
        final VOCD other = (VOCD) obj;
        if (!Objects.equals(this.cod_cd, other.cod_cd)) {
            return false;
        }
        return true;
    }

    @Override
    public String obtenerCodigo() {
        return this.cod_cd;
    }
    

}
