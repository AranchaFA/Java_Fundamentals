package Modelo;

public class Moto extends Vehiculo {

    // ATRIBUTOS
    private int numeroPlazas;

    // MÉTODOS
    // Getters + Setters
    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\nMoto{" + "numeroPlazas=" + numeroPlazas + '}';
    }

    // Constructores
    public Moto(String matricula, String color) {
        super(matricula, color, 2);
    }

    public Moto(String matricula, String color, int cilindrada) {
        super(matricula, color, 2, cilindrada);
    }

    public Moto(String matricula, String color, int cilindrada, int potencia) {
        super(matricula, color, 2, cilindrada, potencia);
    }

    public Moto(int numeroPlazas, String matricula, String color, int cilindrada, int potencia) {
        super(matricula, color, 2, cilindrada, potencia);
        this.numeroPlazas = numeroPlazas;
    }

}
