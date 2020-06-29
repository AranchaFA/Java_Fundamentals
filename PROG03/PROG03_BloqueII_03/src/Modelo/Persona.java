package Modelo;

public class Persona {

    private String nombre;

    private String apellidos;

    private final String nif;

    private short edad;

    public Persona(String nombre, String apellidos, String nif) {
        this.apellidos=apellidos;
        this.nombre=nombre;
        this.nif=nif; 
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", edad=" + edad + '}';
    }

    // No tiene sentido un set para los parámetros pasados en el constructor
    // Para edad sí, porque se puede introducir después de inicializar el objeto
    public String getNombre() {
        return nombre;
    }

    /* public void setNombre(String nombre) {
    this.nombre = nombre;
    }*/

    public String getApellidos() {
        return apellidos;
    }

    /*public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
    }*/

    public String getNif() {
        return nif;
    }

    /*public void setNif(String nif) {
    this.nif = nif;
    }*/

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    
}
