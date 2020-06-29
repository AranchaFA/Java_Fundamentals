
package vista;

import modelo.Baraja;
import modelo.Carta;

public class Vista {
    public static void verMensaje(String txt){
        System.out.println(txt);
    }
    
    public static void verCarta(Carta c){
        System.out.print(c.toString());
    }
    
    public static void verBaraja(Baraja b){
        System.out.println(b.toString());
    }
}
