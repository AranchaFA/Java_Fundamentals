/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tragaperras;

/**
 *
 * @author Arancha
 */
public class MainTragaperras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos una tragaperras y un controlador
        Tragaperras tragaperras=new Tragaperras();
        ControladorTragaperras controlador=new ControladorTragaperras();
        
        // Ejecutamos la tragaperras en el controlador
        controlador.ejecutarTragaperras(tragaperras);
    }
    
}
