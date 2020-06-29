
package Vista;

import Modelo.Contacto;
import java.util.Iterator;
import java.util.Map;

public class Vista {
    // verMensaje(String mensajeAMostrar)
    
    // verContacto(Contacto contactoAMostrar)
    
    // Mostrar toda la agenda
    
    public static void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static void mostrarObjeto(Object objeto){
        System.out.println(objeto.toString());
    }
    
    public static void mostrarColeccionCompleta(Map<String,Contacto> coleccion){
        Iterator it=coleccion.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(coleccion.get(it.next()).toString());
        }
    }
}
