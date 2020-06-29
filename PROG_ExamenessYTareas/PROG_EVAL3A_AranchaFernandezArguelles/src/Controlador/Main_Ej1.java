/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;

/**
 *
 * @author Arancha
 */
public class Main_Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos una inmobiliaria y un par de inmuebles
        Inmobiliaria i=new Inmobiliaria();
        Casa casa=new Casa("casa");
        Local local=new Local("local");
        
        // Firmamos contratos para probar
        // A: alquiler V: venta
        i.generarYRegistrarContrato(casa, "A", 1000);
        i.generarYRegistrarContrato(casa, "V", 1000);
        i.generarYRegistrarContrato(local, "A", 1000);
        i.generarYRegistrarContrato(local, "V", 1000);
        
        // mostramos todo el registro de contratos
        i.recaudacionFinalMostrandoContratos();
    }
    
}
