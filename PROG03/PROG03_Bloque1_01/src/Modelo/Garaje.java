/*

 */
package Modelo;

public class Garaje {

    // ATRIBUTOS
    /*
    Al tener un único atributo Coche sólo podrá guardar una variable coche en cada momento:
    atender un sólo coche a la vez.
     */
    private Coche coche;
    private String averiaAsociada;
    private long numeroCochesAtendidos;

    // MÉTODOS
    // Getters+Setters
    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public String getAveriaAsociada() {
        return averiaAsociada;
    }

    public void setAveriaAsociada(String averiaAsociada) {
        this.averiaAsociada = averiaAsociada;
    }

    public long getNumeroCochesAtendidos() {
        return numeroCochesAtendidos;
    }

    public void setNumeroCochesAtendidos(long numeroCochesAtendidos) {
        this.numeroCochesAtendidos = numeroCochesAtendidos;
    }

    // Aceptar coche (box vacío)
    public Boolean aceptarCoche(Coche coche, String averiaAsociada) {
        if (this.coche == null) {
            this.coche = coche;
            this.averiaAsociada = averiaAsociada;

            numeroCochesAtendidos++;

            float importeAveria = (float) (Math.random() * 100 + 100);
            this.coche.acumularAveria(importeAveria);

            return true;

        } else {
            return false;
        }
    }

    // Devolver coche (vaciar el box ocupado)
    public void devolverCoche() {
        if (coche != null) {
            this.coche = null;
            this.averiaAsociada=null;
        }
    }

    // toString()
    @Override
    public String toString() {
        return "Garaje{" + "coche=" + coche + ", averiaAsociada=" + averiaAsociada + ", numeroCochesAtendidos=" + numeroCochesAtendidos + '}';
    }

    // Constructor (por defecto)
}
