package Modelo;

public class Cuadrado extends Figura {

    // ATRIBUTOS
    private double lado;

    // MÉTODOS
    // Getters + Setters
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\nCuadrado{" + "lado=" + lado + '}';
    }

    // Constructor
    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public Cuadrado(String nombre, double lado) {
        super(nombre);
        this.lado = lado;
    }

    // Métodos para cálculos sobreescritos
    @Override
    public double calcularPerimetro() {
        return 4 * this.lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(this.lado, 2);
    }

}
