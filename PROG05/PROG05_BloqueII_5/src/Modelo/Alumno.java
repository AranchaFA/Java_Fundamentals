package Modelo;

public class Alumno {

    // ATRIBUTOS
    private String nombre;
    private Asignatura asig1, asig2;

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura getAsig1() {
        return asig1;
    }

    public void setAsig1(Asignatura asig1) {
        this.asig1 = asig1;
    }

    public Asignatura getAsig2() {
        return asig2;
    }

    public void setAsig2(Asignatura asig2) {
        this.asig2 = asig2;
    }

    // toString
    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", asig1=" + asig1 + ", asig2=" + asig2 + '}';
    }

    // Constructor pasando el nombre
    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    // Método para calcular la nota final, media de ambas asignaturas
    public float notaFinal() {
        float notaFinal = (asig1.notaMedia() + asig2.notaMedia()) / 2;
        return notaFinal;
    }

}
