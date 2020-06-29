package MoscaEscurridiza.Modelo;

public class Mosca {

    // ATRIBUTOS
    private String nombre;
    // Posición en el ARRAY, para el jugador será [fila+1][columna+1] porque empezamos a contar desde 1 y no desde 0
    private int fila, columna; 

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    // Constructor
    public Mosca() {
        this.nombre = "M";
    }

    // toString
    @Override
    public String toString() {
        return "Mosca{" + "nombre=" + nombre + ", fila=" + fila + ", columna=" + columna + '}';
    }

    // Método para calcular una posición aleatoria en una habitación
    public void calcularPosicion(Habitacion habitacion){
        //Como trunca el último valor ya nos ajusta a los valores de las posiciones del array [0-(largo-1)]
        fila=(int) (Math.random()*habitacion.getLargo()); 
        columna=(int) (Math.random()*habitacion.getAncho());
        habitacion.getArrayHabitacion()[fila][columna]=this;
    }
}
