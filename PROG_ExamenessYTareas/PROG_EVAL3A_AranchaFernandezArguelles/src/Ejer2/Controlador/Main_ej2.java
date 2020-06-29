/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejer2.Controlador;

import Ejer2.Modelo.*;

/**
 *
 * @author Arancha
 */
public class Main_ej2 {

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
        
        // Creamos una moto y un coche de cada categoria
        Moto moto=new Moto("1111AAA");
        Coche cocheE=new Coche("2222BBB", "E");
        Coche cocheF=new Coche("3333FFF", "F");
        
        // Intentamos venderlos (no se puede)
        i.generarYRegistrarContrato(moto, "V", 1000);
        i.generarYRegistrarContrato(cocheE, "V", 1000);
        i.generarYRegistrarContrato(cocheF, "V", 1000);
        // Los alquilamos
        i.generarYRegistrarContrato(moto, "A", 1000);
        i.generarYRegistrarContrato(cocheE, "A", 1000);
        i.generarYRegistrarContrato(cocheF, "A", 1000);
        
        // mostramos de nuevo todo el registro de contratos
        i.recaudacionFinalMostrandoContratos();
    }
    
}
