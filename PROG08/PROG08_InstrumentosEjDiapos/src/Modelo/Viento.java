
package Modelo;

public class Viento extends Instrumento{
    
    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Constructores
    public Viento(String nombre) {
        super(nombre);
    }

    // Método sonar
    @Override
    public void tocar() {
        System.out.println("¡ SOPLANDO !");
    }
}
