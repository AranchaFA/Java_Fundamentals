
package Vista;

import Modelo.*;
import java.util.Iterator;
import java.util.List;

public class Vista {
    
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static void mostrarObjeto(Object objeto){
        System.out.println(objeto.toString());
    }
    
    public static void mostrarColeccionJugadores(List<Jugador> coleccion){
        Iterator it=coleccion.iterator();
        while (it.hasNext()) {
            System.out.println((it.next()).toString());
        }
    }
    
    public static void mostrarCombinacionGanadora(List<Integer> coleccion){
        Iterator it=coleccion.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public static void mostrarColeccionJugadoresPremioSiONo(List<Jugador> coleccion){
        Iterator it=coleccion.iterator();
        while (it.hasNext()) {
            Jugador jugadorLeido=(Jugador) it.next();
            System.out.println(jugadorLeido.toString());
            if (jugadorLeido.getNumeroAciertos()>=3) {
                System.out.println("¡Combinación premiada! (Tienes "+jugadorLeido.getNumeroAciertos()+" aciertos)\n");
            } else {
                System.out.println("Combinación sin premio... (Tienes "+jugadorLeido.getNumeroAciertos()+" aciertos)\n");
            }
        }
    }
    
}
