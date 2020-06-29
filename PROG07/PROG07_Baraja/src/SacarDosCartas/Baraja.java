package SacarDosCartas;

public class Baraja {

    // ATRIBUTOS
    private Carta[] baraja;

    // MÉTODOS
    // Getters + Setters
    public Carta[] getBaraja() {
        return baraja;
    }

    public void setBaraja(Carta[] baraja) {
        this.baraja = baraja;
    }

    // Constructor 
    public Baraja() {
        baraja = new Carta[52];
        generarBaraja();
    }

    // Generamos las 52 cartas de la baraja
    public void generarBaraja() {
        char[] palo = {'♦', '♠', '♥', '♣'};
        String[] dibujo = {"AS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int contador = 0; // También valdría (10*i+j)
        for (int i = 0; i < palo.length; i++) {
            System.out.println("Creando las cartas del palo " + palo[i]);
            for (int j = 0; j < dibujo.length; j++) {
                baraja[contador] = new Carta(palo[i], dibujo[j]);
                contador++;
            }
        }
    }

    public Carta sacarUnaCarta() {
        int posicionCarta = (int) (Math.random() * 52);
        Carta carta = baraja[posicionCarta];
        baraja[posicionCarta] = null;
        return carta;
    }

    public void mostrarBaraja() {
        for (int i = 0; i < baraja.length; i++) {
            if (baraja[i]!=null) {
                System.out.println(baraja[i].toString());
            } else {
                System.out.println("¡ La carta no está !");
            }
            
        }
    }

}
