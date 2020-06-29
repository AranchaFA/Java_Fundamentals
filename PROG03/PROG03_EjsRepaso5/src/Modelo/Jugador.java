package Modelo;

/**
 * JUGADOR para jugar con dos dados propios
 *
 * @author Arancha
 */
public class Jugador {

    // ATRIBUTOS
    private String nombre;
    private Dado dado1;
    private Dado dado2;

    // MÉTODOS
    /**
     * Devuelve el nombre del jugador
     *
     * @return nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el dado número 1 del jugador
     *
     * @return dado 1
     */
    public Dado getDado1() {
        return dado1;
    }

    /**
     * Devuelve el dado número 2 del jugador
     *
     * @return dado 2
     */
    public Dado getDado2() {
        return dado2;
    }

    // Setters para los dados
    /**
     * Asigna el dado número 1 al jugador
     *
     * @param dado1
     */
    public void setDado1(Dado dado1) {
        this.dado1 = dado1;
    }

    /**
     * Asigna el dado número 2 al jugador
     *
     * @param dado2
     */
    public void setDado2(Dado dado2) {
        this.dado2 = dado2;
    }

    /**
     * Constructor, sólo con nombre, así vale para otros juegos que no requieran
     * 2 dados
     *
     * @param nombre
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", dado1=" + dado1 + ", dado2=" + dado2 + '}';
    }

    /**
     * Genera un valor aleatorio para cada dado del jugador
     */
    public void tirarDosDados() {
        this.dado1.tirarDado();
        this.dado2.tirarDado();
    }

    /**
     * Compreba si los valores de los dos dados del jugador son iguales
     *
     * @return true si iguales / false si diferentes
     */
    public boolean dobles() {
        if (this.dado1.valorIgual(this.dado2)) {
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
        if (this.dado1.valorMayor(jugador.getDado1())) {
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
        if (this.dado1.valorIgual(jugador.getDado1())) {
            return true;
        } else {
            return false;
        }
    }
}
