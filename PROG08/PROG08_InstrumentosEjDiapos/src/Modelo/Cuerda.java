
package Modelo;

public class Cuerda extends Instrumento{

    
    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Constructores
    public Cuerda(String nombre) {
        super(nombre);
    }

    // Método sonar
    @Override
    public void tocar() {
        System.out.println("¡ RASGANDO !");
    }
    
}
