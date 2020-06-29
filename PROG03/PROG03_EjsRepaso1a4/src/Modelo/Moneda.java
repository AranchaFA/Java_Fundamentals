package Modelo;

public class Moneda {

    // ATRIBUTOS
    private int valor;
    private String dibujo;
    
    // MÉTODOS
    // Getters
    public int getValor() {
        return valor;
    }

    public String getDibujo() {
        return dibujo;
    }
    // Constructor
    public Moneda(int valor) {
        this.valor = valor;
        if (valor==1) dibujo="CARA";
        else dibujo="CRUZ";
    }
    // toString
    @Override
    public String toString() {
        return "Moneda{" + "valor=" + valor + ", dibujo=" + dibujo + '}';
    }
    // Método para lanzar una moneda
    public Moneda lanzarMoneda(){
        this.valor=(int) (Math.random()*2+1);
        if (valor==1) dibujo="CARA";
        else dibujo="CRUZ";
        return this;
    }   
    // Método para comparar dos monedas
    public boolean compararMonedas(Moneda moneda) {
        if (this.valor==moneda.getValor()) return true;
        else return false;
    }
}
