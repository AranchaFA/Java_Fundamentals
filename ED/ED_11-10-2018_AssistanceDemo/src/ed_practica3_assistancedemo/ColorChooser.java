/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_practica3_assistancedemo;

import java.io.File;
import java.util.List;
import javafx.beans.binding.Binding;

/**
 *
 * @author Arancha
 */
public class ColorChooser {

    /**
     * Método de prueba
     *
     * @param binding
     */
    
    public void synoad(Binding binding) {

        int firstNumber = 1;
        int secondNumber = 1;
        int valorMaximoInteger = Integer.MAX_VALUE;
        int valorMinimoInteger = Integer.MIN_VALUE;

        Integer entero = new Integer("10");
        Integer entero2 = new Integer(10);

        File file = new File("c:\\config.cfg");

        String bindName = binding.toString();

        Integer integer = new Integer("22");
        
        System.out.println("El valor es: " + integer); // Hicimos el atajo en tools >> options >> code template soutint+Tab
        
        System.out.println("El valor es: " + integer);
        
        System.out.println("La cadena es: " + bindName);
        
        
          

    }
    
}
