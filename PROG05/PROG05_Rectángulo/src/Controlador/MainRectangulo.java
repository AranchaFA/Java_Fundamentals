
package Controlador;

import Modelo.Rectangulo;
import Modelo.Triangulo;

public class MainRectangulo {

    public static void main(String[] args) {
        
        Rectangulo rectangulo=new Rectangulo(10, 6);
        rectangulo.relleno();
        System.out.println("");
        rectangulo.hueco();
        System.out.println("");
        
        Triangulo triangulo=new Triangulo(11, 6);
        triangulo.relleno();
        System.out.println("");
        triangulo.hueco();
        System.out.println("");
    }
    
}
