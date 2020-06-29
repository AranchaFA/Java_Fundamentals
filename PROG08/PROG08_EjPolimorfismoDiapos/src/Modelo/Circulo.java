package Modelo;

public class Circulo extends Figura {

    // ATRIBUTOS
    private double radio;

    // MÉTODOS
    // Getters + Setters
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
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
        return super.toString() + "\nCirculo{" + "radio=" + radio + '}';
    }

    // Constructores
    public Circulo(double radio) {
        this.radio = radio;
    }

    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    // Métodos para cálculos sobreescritos
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * this.radio;
    }

}
