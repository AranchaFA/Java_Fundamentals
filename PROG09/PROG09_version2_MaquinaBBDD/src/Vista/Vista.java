
package Vista;

import Modelo.*;
import java.util.Map;

public class Vista {
    
    public static void mostrarColeccion(Map<String,Producto> coleccionMap){
        for (String keyMap : coleccionMap.keySet()) {
            System.out.println(coleccionMap.get(keyMap).toString());
        }
    }
}
