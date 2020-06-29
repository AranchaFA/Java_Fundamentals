
package Vista;

import Modelo.*;
import java.util.Map;

public class Vista {
    
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static void mostrarObjeto(Object objeto){
        System.out.println(objeto.toString());
    }
    
    public static void mostrarColeccionMap(Map<String,Prestable> coleccionMap){
        for (String keyMap : coleccionMap.keySet()) {
            System.out.println(coleccionMap.get(keyMap).toString());
        }
    }
}
