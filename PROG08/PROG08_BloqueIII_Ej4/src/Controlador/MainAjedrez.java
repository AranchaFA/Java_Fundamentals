/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author Arancha
 */
public class MainAjedrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos una colección de piezas de ajedrez
        ArrayList<Pieza> piezas=new ArrayList<>();
        // Lo cargamos con dos torres y dos alfiles
        piezas.add(new Torre("Torre 1"));
        piezas.add(new Torre("Torre 2"));
        piezas.add(new Alfil("Alfil 1"));
        piezas.add(new Alfil("Alfil 2"));
        // Mostramos la información de todas las piezas
        for (Pieza pieza : piezas) {
            System.out.println(pieza.stringInformacion());
        }
    }
    
}
