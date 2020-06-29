
package ejer2.Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MethodWithMyException {

    // MÉTODOS 
    // Método que lanza la exception
    public void exceptionMethod() throws MyException {
        // Bloque de instrucciones
        boolean condition = false;
        // Cuando se cumpla la condición que genera la exception la lanzamos
        if (condition) {
            // Acciones a hacer si salta la exception (ajustar un valor de variable,...)
            throw new MyException("ERROR, NO EXISTE ESE NOMBRE DE PROGRAMA");
        }
    }

    // Método que invoca al anterior y hace el tratamiento de la exception
    public void callExceptionMethod() {
        // Bloque de instrucciones
        // Llamada al método que puede generar la exception
        try {
            exceptionMethod();
        } catch (MyException ex) {
            System.out.println("Lanzando la exception... "+ex.getMessage());
            Logger.getLogger(MethodWithMyException.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
