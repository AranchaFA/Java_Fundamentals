/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.logging.Level;
import java.util.logging.Logger;
import gestionLibros_MVC.Modelo.Leer;

/**
 *
 * @author J
 */
public class MainCalculadora {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        float x, y;
        int opcion;
        char operacion;
        Calculadora calc = new Calculadora();
        do {
            calc.mostrarMenu();
            opcion = Leer.datoInt();
            switch (opcion) {
                case 1:
                    System.out.print("Introduce x:");
                    x = Leer.datoFloat();
                    System.out.print("Introduce y:");
                    y = Leer.datoFloat();
                    calc.setX(x);
                    calc.setY(y);
                    System.out.println(calc.toString());
                    break;
                case 2:
                    operacion = '+';
                    calc.verResultado(operacion, calc.suma());
                    break;
                case 3:
                    operacion = '-';
                    calc.verResultado( operacion, calc.resta());
                    break;
                case 4:
                    operacion = '*';
                    calc.verResultado( operacion, calc.multiplicacion());
                    break;
                case 5:
                    operacion = '/';
                    calc.verResultado(operacion, calc.division());
                case 6:
                    System.out.println("gracias por utilizarme");
                    break;
                default:
                    System.out.println("Error el valor tiene que estar entre 1 y 6\n ");
            }
        } while (opcion != 6);

    }

}
