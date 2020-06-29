/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmaTemperatura;

/**
 *
 * @author J
 */
public class Timbre {
    private boolean timbre;

    public boolean isTimbre() {
        return timbre;
    }

    public void setTimbre(boolean timbre) {
        this.timbre = timbre;
    }
    
    public void activar(){      
       timbre = true; 
       System.out.println("Activando timbre Riinnnnnnngggggg");
    }
    public void desactivar(){  
       timbre = false; 
       System.out.println("timbre silencio");
    }

    @Override
    public String toString() {
        return "Timbre{" + "timbre=" + timbre + '}';
    }
    
}
