
package Modelo;

public class Temporizador {
    
    // MÉTODOS
    // Constructores
    public Temporizador() {
    }
    
    // Monitorizar una puerta
    public void monitorizarPuerta(Automatizable automatizable){
        automatizable.timeOut();
    }
}
