
package ejer2.Controlador;

import ejer2.Modelo.Camello;

public class MainEjer2 {

    public static void main(String[] args) {
        
        // Creamos dos camellos
        Camello c1=new Camello("c1");
        Camello c2=new Camello("c2");
        
        do {
            c1.tirarDado();
            c1.pintarPosicion();
            c2.tirarDado();
            c2.pintarPosicion();
        } while (c1.getPosicionActual()<30 && c2.getPosicionActual()<30);
        
    }
    
}
