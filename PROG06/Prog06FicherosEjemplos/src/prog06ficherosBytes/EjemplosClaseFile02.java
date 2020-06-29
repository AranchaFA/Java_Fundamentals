
package prog06ficherosBytes;

import java.io.File;

public class EjemplosClaseFile02 {
    //comprobar si existe un fichero
    public static void main(String[] args) {
        File path,fichero;
        String mensaje;
        
        path = new File("c:/prueba");
        fichero = new File(path,"fichero.txt");
        
        //tambien podríamos  fichero = new File("c:/prueba/fichero.txt");
        
        if (fichero.exists())
            mensaje ="SI existe";
        else
        mensaje ="NO existe";
        System.out.println("El directorio "+fichero.getPath()+" "+mensaje);
    }
    
}
