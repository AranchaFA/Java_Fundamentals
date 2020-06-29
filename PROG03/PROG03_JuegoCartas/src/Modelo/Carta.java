
package Modelo;

public class Carta {
    
    // ATRIBUTOS
    private int valor; // de 2 a 14 (valor del AS)
    private String dibujo;

    // MÉTODOS
    public int getValor() {    
        return valor;
    }
    public String getDibujo() {    
        return dibujo;
    }

    @Override
    public String toString() {
        return "Carta{" + "valor=" + valor + ", dibujo=" + dibujo + '}';
    }
    
    // Constructor con el valor como parámetro, asignará el dibujo en función de éste
    public Carta(int valor) {
        this.valor = valor;
        if (valor<11) this.dibujo=Integer.toString(valor); // Para asignar los dibujos numéricos
        if (valor==11) this.dibujo="J";
        if (valor==12) this.dibujo="Q";
        if (valor==13) this.dibujo="K";
        if (valor==14) this.dibujo="AS";
    }
    
    // Método para comparar el valor de la carta con otro
    public Carta cartaMayor(Carta carta) {
        if (this.valor>carta.getValor()) return this;
        else return carta;
    } 
}
