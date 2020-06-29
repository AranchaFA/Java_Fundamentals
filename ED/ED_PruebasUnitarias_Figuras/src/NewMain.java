/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arancha
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Cuadrado c=new Cuadrado(3);
        Triangulo t=new Triangulo(2, 2);
        
        System.out.println(c.calcularArea());
        System.out.println(t.calcularArea());
    }
    
}
