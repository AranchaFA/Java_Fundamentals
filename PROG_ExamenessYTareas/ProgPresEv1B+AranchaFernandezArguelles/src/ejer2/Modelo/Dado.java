
package ejer2.Modelo;

public class Dado {
    
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + '}';
    }

    public Dado() {
    }
    
    public int tirarDado(){
        this.valor=(int) (Math.random()*6+1);
        return this.valor;
    }
}
