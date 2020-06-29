package Modelo;

public class VOLibro implements Producto {

    // ATRIBUTOS
    private String cod_libro;
    private String titulo;
    private String autor;
    private String tema;
    private float precio;

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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // toString
    @Override
    public String toString() {
        return "Libro{" + "cod_libro=" + cod_libro + ", titulo=" + titulo + ", autor=" + autor + ", tema=" + tema + ", precio=" + precio + '}';
    }

    // Constructores
    public VOLibro(String cod_libro, float precio) {
        this.cod_libro = cod_libro;
        this.precio = precio;
    }

    public VOLibro(String cod_libro, String titulo, String autor, String tema, float precio) {
        this.cod_libro = cod_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.tema = tema;
        this.precio = precio;
    }

    @Override
    public float calcularCoste() {
        return this.precio;
    }

}
