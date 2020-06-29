package Modelo;

public abstract class Llamada {

    // ATRIBUTOS
    protected String numeroOrigen;
    protected String numeroDestino;
    protected int duracion; // En segundos

    // MÉTODOS
    // Getters + Setters
    public String getNumeroOrigen() {
        return numeroOrigen;
    }

    public void setNumeroOrigen(String numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    // toString
    @Override
    public String toString() {
        return "Llamada{" + "numeroOrigen=" + numeroOrigen + ", numeroDestino=" + numeroDestino + ", duracion=" + duracion + '}';
    }

    // Constructores
    public Llamada(String numeroOrigen, String numeroDestino, int duracion) {
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.duracion = duracion;
    }

    // Calcular precio
    public abstract int calcularCoste();
}
