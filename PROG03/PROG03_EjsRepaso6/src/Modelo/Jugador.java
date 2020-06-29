package Modelo;

/**
 * JUGADOR para jugar a los dados sin dados propios
 *
 * @author Arancha
 */
public class Jugador {

    // ATRIBUTOS
    private String nombre;
    private int valorDado1;
    private int valorDado2;

    // MÉTODOS
    /**
     * Devuelve el nombre del jugador
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el valor del dado número 1 en una tirada
     *
     * @return valorDado1
     */
    public int getValorDado1() {
        return valorDado1;
    }

    /**
     * Devuelve el valor del dado número 2 en una tirada
     *
     * @return valorDado2
     */
    public int getValorDado2() {
        return valorDado2;
    }

    // Setters para los resultados de los dados en una tirada
    /**
     * Asigna el valor del dado número 1 en una tirada
     *
     * @param valorDado1
     */
    public void setValorDado1(int valorDado1) {
        this.valorDado1 = valorDado1;
    }

    /**
     * Asigna el valor del dado número 2 en una tirada
     *
     * @param valorDado2
     */
    public void setValorDado2(int valorDado2) {
        this.valorDado2 = valorDado2;
    }

    /**
     * Constructor, sólo con nombre
     *
     * @param nombre
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", valorDado1=" + valorDado1 + ", valorDado2=" + valorDado2 + '}';
    }

    /**
     * Asigna valores aleatorios a una tirada de dos dados
     *
     * @param dado1
     * @param dado2
     */
    public void tirarDosDados(Dado dado1, Dado dado2) {
        this.valorDado1 = dado1.tirarDado();
        this.valorDado2 = dado2.tirarDado();
    }

    /**
     * Comprueba si los valores de los dos dados tirados por el jugador son
     * iguales
     *
     * @return true si iguales / false si diferentes
     */
    public boolean dobles() {
        if (this.valorDado1 == this.valorDado2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprueba si el valor del dado 1 del jugador es mayor que el valor del
     * dado 1 de otro jugador
     *
     * @param jugador
     * @return true si mayor / false si menor o igual
     */
    public boolean tiradaMayor(Jugador jugador) {
        if (this.valorDado1 > jugador.getValorDado1()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprueba si el valor del dado 1 del jugador es igual al valor del dado 1
     * de otro jugador
     *
     * @param jugador
     * @return true si iguales / false si diferentes
     */
    public boolean empate(Jugador jugador) {
        if (this.valorDado1 == jugador.getValorDado1()) {
            return true;
        } else {
            return false;
        }
    }
}
