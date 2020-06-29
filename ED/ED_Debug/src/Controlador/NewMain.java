/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import numeros.Entero;

/**
 *
 * @author Arancha
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hola holita");
        Entero a = new Entero(4);
        Entero b = new Entero(6);
        //      Entero suma = Entero.suma(a, b);
//        Entero resta = Entero.resta(a, b);

        Entero potencia = Entero.potencia(a, b);
        System.out.println("caquita");
    }

}
