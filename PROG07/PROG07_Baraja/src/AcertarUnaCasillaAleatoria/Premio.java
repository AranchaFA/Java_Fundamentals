
package AcertarUnaCasillaAleatoria;

import java.io.Serializable;

public class Premio implements Serializable{
    
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

    public Premio() {
        nombre="¡ P R € M I O !";
    }
    
}
