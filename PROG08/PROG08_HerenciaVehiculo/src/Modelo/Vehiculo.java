package Modelo;

public class Vehiculo {

    // ATRIBUTOS
    private String matricula;
    private String color;
    private int numeroRuedas;
    private int cilindrada;
    private int potencia;

    // MÉTODOS
    // Getters + Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    // toString
    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", color=" + color + ", numeroRuedas=" + numeroRuedas + ", cilindrada=" + cilindrada + ", potencia=" + potencia + '}';
    }

    // Constructores
    public Vehiculo(String matricula, String color, int numeroRuedas) {
        this.matricula = matricula;
        this.color = color;
        this.numeroRuedas = numeroRuedas;
    }

    public Vehiculo(String matricula, String color, int numeroRuedas, int cilindrada) {
        this.matricula = matricula;
        this.color = color;
        this.numeroRuedas = numeroRuedas;
        this.cilindrada = cilindrada;
    }

    public Vehiculo(String matricula, String color, int numeroRuedas, int cilindrada, int potencia) {
        this.matricula = matricula;
        this.color = color;
        this.numeroRuedas = numeroRuedas;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
    }

    
}
