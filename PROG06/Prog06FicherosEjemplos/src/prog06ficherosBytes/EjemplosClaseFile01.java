
package prog06ficherosBytes;

import java.io.File;

public class EjemplosClaseFile01 {
    //comprobar si existe un directorio
    public static void main(String[] args) {
        File dir;
        String mensaje;
        
        dir = new File("c:/prueba");
        
        if (dir.exists())
            mensaje ="SI existe";
        else
        mensaje ="NO existe";
        System.out.println("El directorio "+dir.getPath()+" "+mensaje);
    }    
}
