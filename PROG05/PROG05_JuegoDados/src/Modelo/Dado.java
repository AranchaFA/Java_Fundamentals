
package Modelo;

public class Dado {

    // ATRIBUTOS
    private int valor;
    private int numCaras;

    // MÉTODOS
    public int getValor() {
        return valor;
    }

    public int getNumCaras() {
        return numCaras;
    }
    
    // Constructor por defecto que nos haga un dado genérico de 6 caras
    public Dado() {    
        this.numCaras=6;
    }

    // Constructor para crear un dado con el número de caras que se desée
    public Dado(int numCaras) {
        this.numCaras = numCaras;
    }

    // toString
    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + ", numCaras=" + numCaras + '}';
    }

    // Método para tirar el dado
    public int tirarDado() {
        this.valor = (int) (Math.random() * this.numCaras + 1);
        return this.valor;
    }
}
