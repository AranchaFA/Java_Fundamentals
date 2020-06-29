
package ejer3.modelo;

public class JugadorJuegoMoneda {
    
    // ATRIBUTOS
    private String nombre;
    private Moneda moneda; 

    // MÉTODOS
    // Getters
    public String getNombre() {
        return nombre;
    }

    public Moneda getMoneda() {
        return moneda;
    }
    
    // Setter sólo para el nombre (la moneda se crea en constructor)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // toString
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", moneda=" + moneda + '}';
    }  

    // Constructor con el nombre por parámetro y creando su moneda
    public JugadorJuegoMoneda(String nombre) {
        this.nombre = nombre;
        this.moneda= new Moneda();
    }
   
}


