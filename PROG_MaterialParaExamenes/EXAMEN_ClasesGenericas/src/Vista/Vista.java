
package Vista;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Vista {
    
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static void mostrarObjeto(Object objeto){
        System.out.println(objeto.toString());
    }
    
    public static void mostrarColeccionList(List<Clase> coleccion){
        for (Object object : coleccion) {
            System.out.println(object.toString());
        }
    }
    
    public static void mostrarColeccionMap(Map<String,Clase> coleccionMap){
        for (String keyMap : coleccionMap.keySet()) {
            System.out.println(coleccionMap.get(keyMap).toString());
        }
    }
}
