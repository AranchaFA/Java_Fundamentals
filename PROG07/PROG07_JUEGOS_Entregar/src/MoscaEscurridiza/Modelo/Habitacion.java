package MoscaEscurridiza.Modelo;

public class Habitacion {

    // ATRIBUTOS
    private int largo, ancho; // Número de posiciones que tendrá de alto/ancho
    private Mosca[][] arrayHabitacion;

    // MÉTODOS
    // Getters + Setter
    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public Mosca[][] getArrayHabitacion() {
        return arrayHabitacion;
    }

    public void setArrayHabitacion(Mosca[][] arrayHabitacion) {
        this.arrayHabitacion = arrayHabitacion;
    }

    // toString
    @Override
    public String toString() {
        return "Habitacion{" + "largo=" + largo + ", ancho=" + ancho + ", arrayHabitacion=" + arrayHabitacion + '}';
    }

    // Constructor
    public Habitacion(int largo, int ancho) {
        this.largo = largo;
        this.ancho = ancho;
        arrayHabitacion = new Mosca[largo][ancho];
    }

}
