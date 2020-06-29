package Modelo;

public class Mascota {

    private String tipo;

    private String raza;

    private String nombre;
    
    private int añoNacimiento;

    public Mascota(String nombre, String tipo) {
        this.nombre=nombre;
        this.tipo=tipo;
    }
    
    // GETTERS
    public String getTipo() {
        return tipo;
    }

    public String getRaza() {
        return raza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }
    
    /* SETTERS (el tipo no va a cambiar, el nombre podría aunque no sea lógico,
     el año de nacimiento y la raza hay que meterlos fuera del constructor
     así que hacen falta */

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // toString

    @Override
    public String toString() {
        return "Mascota{" + "tipo=" + tipo + ", raza=" + raza + ", nombre=" + nombre + ", a\u00f1oNacimiento=" + añoNacimiento + '}';
    }
    
}
