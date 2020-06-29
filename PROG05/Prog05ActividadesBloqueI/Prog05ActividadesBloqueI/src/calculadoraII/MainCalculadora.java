/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraII;

import calculadora.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import gestionLibros_MVC.Modelo.Leer;

/**
 *
 * @author J
 */
public class MainCalculadora {

    public void mostrarMenu() {
        System.out.println("Mi Calculadora");
        System.out.println("1 - Introducir valores a la calculadora x,y");
        System.out.println("2 - Suma");
        System.out.println("3 - Resta");
        System.out.println("4 - Multiplicación");
        System.out.println("5 - División");
        System.out.println("6 - Salir");
        System.out.print("Selecciona opción:");
    }

    public void verResultado(Calculadora c, char operacion, float rtdo) {
        System.out.println(c.getX() + " " + operacion + " " + c.getY() + "=" + rtdo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        float x, y;
        int opcion;
        char operacion;
        Calculadora calc;
        calc = new Calculadora();
        MainCalculadora progPpal = new MainCalculadora();
        do {
            progPpal.mostrarMenu();
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
                    progPpal.verResultado(calc, operacion, calc.suma());
                    break;
                case 3:
                    operacion = '-';
                    progPpal.verResultado(calc, operacion, calc.resta());
                    break;
                case 4:
                    operacion = '*';
                    progPpal.verResultado(calc, operacion, calc.multiplicacion());
                    break;
                case 5:
                    operacion = '/';
                    progPpal.verResultado(calc, operacion, calc.division());

                    break;
                case 6:
                    System.out.println("gracias por utilizarme");
                    break;
                default:
                    System.out.println("Error el valor tiene que estar entre 1 y 6\n ");
            }
        } while (opcion != 6);

    }

}
