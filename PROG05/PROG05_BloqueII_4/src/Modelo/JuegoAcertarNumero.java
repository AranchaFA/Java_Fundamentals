package Modelo;

public class JuegoAcertarNumero {

    private int numero;
    private int minimo;
    private int maximo;

    // Getters+Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    // toString
    @Override
    public String toString() {
        return "JuegoAcertarNumero{" + "numero=" + numero + ", minimo=" + minimo + ", maximo=" + maximo + '}';
    }

    // Constructor 
    public JuegoAcertarNumero() {
        this.minimo = 1;
        this.maximo = 100;
    }

    // Método para generar un número aleatorio a adivinar
    public void generarNumero() {
        this.numero = (int) (Math.random() * 100 + 1);
    }

    // Método para comprobar el número introducido por el jugador
    public boolean comprobarNumero(int numero) {
        boolean auxReturn;
        if (numero == this.numero) {
            auxReturn = true;
        } else {
            if (numero < this.numero) {
                this.minimo = numero + 1;
            } else {
                this.maximo = numero - 1;
            }
            auxReturn = false;
        }
        return auxReturn;
    }
}
