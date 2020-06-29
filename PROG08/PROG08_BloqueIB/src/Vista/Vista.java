
package Vista;

import java.util.Iterator;
import java.util.List;

public class Vista {
    
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static void mostrarObjeto(Object objeto){
        System.out.println(objeto.toString());
    }
    
    public static void mostrarColeccionCompleta2(List<Clase> coleccion){
        for (Object object : coleccion) {
            System.out.println(object.toString());
        }
    }
}
