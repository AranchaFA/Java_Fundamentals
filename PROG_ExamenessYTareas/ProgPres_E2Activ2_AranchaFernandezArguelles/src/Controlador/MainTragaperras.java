
package Controlador;

import Modelo.Tragaperras;

public class MainTragaperras {

    public static void main(String[] args) {
        
        // Creamos una tragaperras y un controlador
        Tragaperras tragaperras=new Tragaperras();
        ControladorTragaperras controlador=new ControladorTragaperras();
        
        // Ejecutamos la tragaperras en el controlador
        controlador.ejecutarTragaperras(tragaperras);
        
    }
    
}
