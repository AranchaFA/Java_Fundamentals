
package Modelo;

public class Persona {
    
    // ATRIBUTOS
    String nombre;
    String apellido1;
    String apellido2;
    String DNI;
    
    // MÉTODOS

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

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", DNI=" + DNI + '}';
    }

    public Persona(String nombre, String apellido1, String apellido2, String DNI) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.DNI = DNI;
    }

}
