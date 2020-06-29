package Modelo;

/**
 * DADO para juegos, como atributos un número de caras y un valor para los
 * resultados
 *
 * @author Arancha
 */
public class Dado {

    // ATRIBUTOS
    private int valor;
    private int numCaras;

    // MÉTODOS
    /**
     * No habrá setters: para valor se asignará con el método tirarDado numCaras
     * se asigna al crear el dado y no puede variar
     *
     */
    /**
     * Devuelve el valor de la última tirada
     *
     * @return valor de la última tirada
     */
    public int getValor() {
        return valor;
    }

    /**
     * Devuelve el número de caras del dado
     *
     * @return número de caras del dado
     */
    public int getNumCaras() {
        return numCaras;
    }

    /**
     * Constructor, obligado el número de caras
     * @param numCaras
     */
    public Dado(int numCaras) {
        this.numCaras = numCaras;
    }

    // toString
    @Override
    public String toString() {
        return "Dado{" + "valor=" + valor + ", numCaras=" + numCaras + '}';
    }

    /**
     * Calcula un número del 1 al numCaras al azar, devuelve el valor obtenido y
     * se lo asigna al atributo valor
     *
     * @return valor obtenido en la tirada
     */
    public int tirarDado() {
        this.valor = (int) (Math.random() * this.numCaras + 1);
        return this.valor;
    }

    /**
     * Comprueba si el dado tiene el mismo resultado que otro dado
     *
     * @param dado
     * @return true si iguales / false si distintos
     */
    public boolean valorIgual(Dado dado) {
        if (this.valor == dado.valor) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprueba si el valor del dado es mayor que el de otro dado
     *
     * @param dado
     * @return true si mayor / false si igual o menor
     */
    public boolean valorMayor(Dado dado) {
        if (this.valor > dado.valor) {
            return true;
        } else {
            return false;
        }
    }
}
