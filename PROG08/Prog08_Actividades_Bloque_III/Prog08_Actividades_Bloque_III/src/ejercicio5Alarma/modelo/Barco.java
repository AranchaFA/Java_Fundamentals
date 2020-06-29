
package ejercicio5Alarma.modelo;

public abstract class Barco implements ElementoConAlarma  {
    
    // ATRIBUTOS
    protected int tripulacion;
    protected int eslora;
    protected String nombre;
    protected Alarma alarma;

    // MÉTODOS
    // Constructor
    public Barco(int tripulacion, int eslora, String nombre) {
        this.tripulacion = tripulacion;
        this.eslora = eslora;
        this.nombre = nombre;
        alarma = new Alarma();
    }

    // Getters + Setters
    public int getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(int tripulacion) {
        this.tripulacion = tripulacion;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    // toString
    @Override
    public String toString() {
        return "Barco{" + "tripulacion=" + tripulacion + ", eslora=" + eslora + ", nombre=" + nombre + ", alarma=" + alarma + '}';
    }
           
}
