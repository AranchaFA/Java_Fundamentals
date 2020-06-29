package Modelo;

public class Jugador {

    // ATRIBUTOS
    private String nombre;
    private Dado dado;
    private int numTiradas;

    // MÉTODOS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public int getNumTiradas() {
        return numTiradas;
    }

    public void setNumTiradas(int numTiradas) {
        this.numTiradas = numTiradas;
    }

    // Constructor que cree el jugador con un dado genérico de 6 caras
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dado = new Dado();
    }

    // Constructor que cree el jugador con un dado con las caras deseadas
    public Jugador(String nombre, int numCaras) {
        this.nombre = nombre;
        this.dado = new Dado(numCaras);
    }

    // toString
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", dado=" + dado + ", numTiradas=" + numTiradas + '}';
    }

    // Método para tirar el dado
    public int tirarDado() {
        this.dado.tirarDado();
        return this.dado.getValor();
    }

    // Método para contar las tiradas hasta sacar 6
    public int tirarHastaSacar6() {
        do {
            this.tirarDado();
            this.numTiradas++;
        } while (this.dado.getValor()!=6);
        return this.numTiradas;
    }
}
