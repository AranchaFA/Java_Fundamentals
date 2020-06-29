package Modelo;

public class Dado {

    // ATRIBUTOS
    private int valor;

    // MÉTODOS
    // Getters
    public int getValor() {
        return valor;
    }

    // Constructor
    public Dado() {
    }

    // toString
    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + '}';
    }

    // Método para tirar el dado
    public int tirarDado() {
        this.valor = (int) (Math.random() * 6 + 1);
        return this.valor;
    }

    // Método para comparar el resultado del dado (puede haber empate)
    // Devolverá 1 si es mayor 
    //          -1 si es menor
    //           0 si es igual
    public int compararDados(Dado dado) {
        int n = 0;
        if (this.valor > dado.getValor()) {
            n = 1;
        }
        if (this.valor == dado.getValor()) {
            n = 0;
        }
        if (this.valor < dado.getValor()) {
            n = -1;
        }
        return n;
    }

}
