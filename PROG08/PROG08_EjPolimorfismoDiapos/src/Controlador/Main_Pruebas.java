
package Controlador;

import Modelo.*;
import Controlador.*;

public class Main_Pruebas {

    public static void main(String[] args) {
        
        Cuadrado cuadrado=new Cuadrado("Cuadrado1", 2.5);
        Triangulo triangulo=new Triangulo("Triangulo1", 2, 4);
        Circulo circulo=new Circulo("Circulo1", 4.2);
        
        CalculadorMatematico cm=new CalculadorMatematico();
    }
    
}
