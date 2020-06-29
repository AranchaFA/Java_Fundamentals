package Modelo;

public class Persona {

    // ATRIBUTOS
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String DNI;
    private String sexo;

    // MÉTODOS
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDNI() {
        return DNI;
    }

    public String getSexo() {
        return sexo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // toString
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", DNI=" + DNI + ", sexo=" + sexo + '}';
    }

    // Constructor, exigimos sexo para este ejercicio
    public Persona(String sexo, String nombre) {
        this.sexo = sexo;
        this.nombre = nombre;
    }

}
