package Modelo;

public class Coche extends Vehiculo {

    // ATRIBUTOS
    private int numeroPuertas;

    // MÉTODOS
    // Getters + Setters
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    // toString
    @Override
    public String toString() {
        return super.toString()+"\nCoche{" + "numeroPuertas=" + numeroPuertas + '}';
    }

    // Constructores
    public Coche(String matricula, String color) {
        super(matricula, color, 4);
    }

    public Coche(String matricula, String color, int cilindrada) {
        super(matricula, color, 4, cilindrada);
    }

    public Coche(String matricula, String color, int cilindrada, int potencia) {
        super(matricula, color, 4, cilindrada, potencia);
    }

    public Coche(int numeroPuertas, String matricula, String color, int cilindrada, int potencia) {
        super(matricula, color, 4, cilindrada, potencia);
        this.numeroPuertas = numeroPuertas;
    }

    
}
