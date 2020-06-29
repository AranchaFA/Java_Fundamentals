
package Controlador;

import Modelo.ControladoraCalculadora;

public class MainCalculadora {

    public static void main(String[] args) {
        
        // Creamos un controlador (se crea con su calculadora)
        ControladoraCalculadora calculadora=new ControladoraCalculadora();
        // Mostramos menú, va incluido en el método realizarOperacion
        calculadora.realizarOperacion();
    }
    
}
