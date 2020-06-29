package Modelo;

public abstract class Ropa implements Producto{

    // ATRIBUTOS
    protected String descripcion;
    protected double precio;

    // MÉTODOS
    // Getters + Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // toString
    @Override
    public String toString() {
        return "Ropa{" + "descripcion=" + descripcion + ", precio=" + precio + '}';
    }

    // Constructor
    public Ropa(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public abstract double calcularImporte(int numUnidades);

}
