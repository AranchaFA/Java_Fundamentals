
package HundirElBarco.Modelo;

import java.io.Serializable;

public class Barco implements Serializable{
    
    // ATRIBUTOS
    String nombre;
    
    // MÉTODOS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Premio{" + "nombre=" + nombre + '}';
    }

    public Barco() {
        nombre="♪♫♪ Un barquito chiquitito ♪♫♪";
    }
    
}
