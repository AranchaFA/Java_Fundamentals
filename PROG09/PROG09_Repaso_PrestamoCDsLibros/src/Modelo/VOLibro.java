package Modelo;

import java.util.Objects;

public class VOLibro implements Prestable {

    // ATRIBUTOS
    private String cod_libro;
    private String titulo;
    private String autor;
    private String tema;
    private double unidades;

    // MÉTODOS
    // Getters + Setters
    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public double getUnidades() {
        return unidades;
    }

    public void setUnidades(double unidades) {
        this.unidades = unidades;
    }

    // toString
    @Override
    public String toString() {
        return "VOLibro{" + "cod_libro=" + cod_libro + ", titulo=" + titulo + ", autor=" + autor + ", tema=" + tema + ", unidades=" + unidades + '}';
    }

    // Constructor
    public VOLibro(String cod_libro, String titulo, String autor, String tema, double unidades) {
        this.cod_libro = cod_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.tema = tema;
        this.unidades = unidades;
    }

    // equals + hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.cod_libro);
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
        final VOLibro other = (VOLibro) obj;
        if (!Objects.equals(this.cod_libro, other.cod_libro)) {
            return false;
        }
        return true;
    }

    @Override
    public String obtenerCodigo() {
        return this.cod_libro;
    }

}
