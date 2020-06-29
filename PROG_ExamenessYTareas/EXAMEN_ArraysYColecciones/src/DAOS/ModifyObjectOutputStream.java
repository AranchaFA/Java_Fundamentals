
package DAOS;

import java.io.*;

public class ModifyObjectOutputStream extends ObjectOutputStream{
    
    // Constructor: nos crerá un objeto idéntico al OOS, ya que sólo queremos
    // modificar el método para escribir la cabecera, todo lo demás será idéntico
    public ModifyObjectOutputStream(OutputStream os) throws IOException {
        super(os);
    }

    // Sobreescribimos el método encargado de grabar la cabecera cada vez que
    // vamos a grabar objetos para que no nos la escriba. Si no, la inserta en
    // el fichero al inicio de cada nueva sesión de grabación de datos, y al
    // leer el fichero intentará leerla como un objeto y como no lo es, da error.
    @Override
    protected void writeStreamHeader() throws IOException {
        reset(); 
    }
    
    
}
