/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import static java.lang.Float.NaN;

/**
 *
 * @author J
 */
public class Calculadora {

    private float x;
    private float y;

    public Calculadora() {
        x = 0;
        y = 0;
    }

    public Calculadora(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float suma() {
        return x + y;
    }

    public float resta() {
        return x - y;
    }

    public float multiplicacion() {
        return x - y;
    }

    public float division() {
        return x / y;
    }

    @Override
    public String toString() {
        return "Calculadora{" + "x=" + x + ", y=" + y + '}';
    }
    
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
     
    public void verResultado( char operacion, float rtdo) {
        System.out.println(x + " " + operacion + " " + y + "=" + rtdo);
    }
}
