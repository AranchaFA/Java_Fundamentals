/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.GrabarFichero;
import Modelo.LeerFichero;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class Controlador {
    
    private GrabarFichero grabarFichero;
    private LeerFichero leerFichero;
    private File file;

    public Controlador() {
        file=new File("cadenas.das");
    }
    
    
    
    public void menu () {
        System.out.println("\t\t MENU"
             +"\n1. Grabar"
             +"\n2. Leer"
             +"\n0. Salir"
             +"\nIntroduce opción: ");
    }
    
    public void lanzarMenu(){
        int opcion;
        Scanner teclado=new Scanner(System.in);
        
        do {   
            menu();
            opcion=teclado.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Finalizando programa.");
                    // Método grabar
                    break;
                case 1:
                    teclado.nextInt();
                    grabarFichero=new GrabarFichero(file);
                    grabarFichero.grabar();
                    // Método grabar
                    break;
                case 2:
                    leerFichero=new LeerFichero(file);
                    leerFichero.leer();
                    // Método leer
                    break;
                default:
                    System.out.println("Opción errónea.");
            }
        } while (true);
    }
}
