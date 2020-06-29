
package Controlador;

import Modelo.Moneda;

public class Main_LanzarMoneda {

    public static void main(String[] args) {
        // Creamos una moneda
        Moneda moneda=new Moneda(0);
        
        // Mostramos sus características al inicio
        System.out.println("Hemos creado una moneda con las siguientes características: ");
        System.out.println(moneda.toString());
        
        // Tiramos la moneda
        System.out.println("Lanzamos la moneda, y el resultado es: ");
        System.out.println(moneda.lanzarMoneda().toString());
    }
    
}
