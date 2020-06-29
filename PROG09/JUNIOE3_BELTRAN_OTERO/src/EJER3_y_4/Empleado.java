
package EJER3_y_4;


public class Empleado {
    private String dni;
    private String nombre;
    private String apellido;
    private String apellido2;
    private String direccion;
    private String telf;
    private int edad;

    public Empleado(String dni, String nombre, String apellido, String apellido2, String direccion, String telf, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telf = telf;
        this.edad = edad;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", apellido2=" + apellido2 + ", direccion=" + direccion + ", telf=" + telf + ", edad=" + edad + '}';
    }
    
    
    
    
    
}
