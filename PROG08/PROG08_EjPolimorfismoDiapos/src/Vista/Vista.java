
package Vista;

import Modelo.Figura;
import com.sun.xml.internal.fastinfoset.tools.StAX2SAXReader;

public class Vista {
    
    // MÉTODOS
    public static void verMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static void verFigura(Figura figura){
        System.out.println(figura.toString());
    }
}
