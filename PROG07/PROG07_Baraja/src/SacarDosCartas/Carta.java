package SacarDosCartas;

public class Carta {

    // ATIBUTOS
    private String dibujo;
    private char palo;
    private int valor;

    // MÉTODOS
    // Getters + Setters
    public String getDibujo() {
        return dibujo;
    }

    public void setDibujo(String dibujo) {
        this.dibujo = dibujo;
    }

    public char getPalo() {
        return palo;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    // Constructos
    public Carta(char palo,String dibujo) {
        this.dibujo = dibujo;
        this.palo = palo;
        asignarValor();
    }

    public void asignarValor() {
        if (dibujo.equals("AS")) {
            valor = 1;
        } else if (dibujo.equals("J")) {
            valor = 11;
        } else if (dibujo.equals("Q")) {
            valor = 12;
        } else if (dibujo.equals("K")) {
            valor = 13;
        } else {
            valor = Integer.parseInt(dibujo);
        }
    }

    // toString
    @Override
    public String toString() {
        return "Carta{" + "dibujo=" + dibujo + ", palo=" + palo + ", valor=" + valor + '}';
    }
    
    
}
