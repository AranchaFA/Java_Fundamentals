package Modelo;

/**
 * JUGADOR para jugar a acercarse al valor de un resultado numérico
 *
 * @author Arancha
 */
public class Jugador {

    // ATRIBUTOS
    private String nombre;
    private int apuesta;

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
     * Devuelve el valor al que apuesta el jugador
     *
     * @return apuesta
     */
    public int getApuesta() {
        return apuesta;
    }

    /**
     * Asigna el valor al que apuesta el jugador
     *
     * @param apuesta
     */
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
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
        return "Jugador{" + "nombre=" + nombre + ", apuesta=" + apuesta + '}';
    }

    /**
     * Calcula la diferencia en valor absoluto entre apuesta y resultado
     * @param resultado
     * @return diferencia
     */
    public int diferencia(int resultado) {
        int diferencia = this.apuesta - resultado;
        if (diferencia < 0) {
            return (-diferencia);
        } else {
            return diferencia;
        }
    }
    

}
