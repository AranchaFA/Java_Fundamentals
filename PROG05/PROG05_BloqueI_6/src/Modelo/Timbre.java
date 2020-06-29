
package Modelo;

import Vista.VistaTimbre;

public class Timbre {
    
    // ATRIBUTOS
    private boolean timbre;
    
    // MÉTODOS

    public boolean isTimbre() {
        return timbre;
    }

    public void setTimbre(boolean timbre) {
        this.timbre = timbre;
    }

    @Override
    public String toString() {
        return "Timbre{" + "timbre=" + timbre + '}';
    }

    public Timbre() {
    }
    
    // Método para activar el timbre
    public void activar(){
        this.timbre=true;
        VistaTimbre.activado();
    }
    
    public void desactivar(){
        this.timbre=false;
        VistaTimbre.desactivado();
    }
}
