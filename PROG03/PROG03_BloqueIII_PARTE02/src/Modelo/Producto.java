
package Modelo;

public class Producto {
    
    // ATRIBUTOS
    private String descripcion;
    private String marca;
    private float peso;
    private float precio;
    
    // MÉTODOS

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "descripcion=" + descripcion + ", marca=" + marca + ", peso=" + peso + ", precio=" + precio + '}';
    }

    public Producto(String descripcion, float precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
}
