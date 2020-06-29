/*
Clase Triángulo usando la clase Punto como atributo.
 */
package Triangulo;

import PaquetePunto.Punto;

/**
 *
 * @author Arancha
 */
public class Triangulo {
    
    // ATRIBUTOS:
    
    private Punto punto1=new Punto();
    private Punto punto2=new Punto();
    private Punto punto3=new Punto();
    
    // MÉTODOS:
    
    public void setPunto1(Punto p) {
        punto1=p;
    }
    public Punto getPunto1() {
        return punto1;
    }
    
    public void setPunto2(Punto p) {
        punto2=p;
    }
    public Punto getPunto2(Punto p) {
        return punto2;
    }
    
    public void setPunto3(Punto p) {
        punto3=p;
    }
    public Punto getPunto3(Punto p) {
        return punto3;
    }
    
    
}
