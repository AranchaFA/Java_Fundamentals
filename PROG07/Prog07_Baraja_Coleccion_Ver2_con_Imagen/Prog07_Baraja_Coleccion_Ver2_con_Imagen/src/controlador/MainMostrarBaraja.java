
package controlador;

import modelo.*;
import vista.*;

public class MainMostrarBaraja {
    
     public static void main(String[] args) {
    
    Baraja baraja;   //objeto con un arrayList de objetos carta
    
    //generamos la baraja
    baraja = new Baraja();
    
    //mostrar baraja
    Vista.verBaraja(baraja);

     }
    
    
}
