package Modelo;

public class Triangulo extends Figura {

    // ATRIBUTOS
    private double altura;
    private double base;
    // Tratamos todos los triángulos como equiláteros

    // MÉTODOS
    // Getters + Setters
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
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
        return super.toString() + "\nTriangulo{" + "altura=" + altura + ", base=" + base + '}';
    }

    // Constructor
    public Triangulo(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }

    public Triangulo(String nombre, double altura, double base) {
        super(nombre);
        this.altura = altura;
        this.base = base;
    }

    // Métodos para cálculos sobreescritos
    @Override
    public double calcularPerimetro() {
        return 3 * this.base;
    }

    @Override
    public double calcularArea() {
        return this.base * this.altura / 2;
    }

}
