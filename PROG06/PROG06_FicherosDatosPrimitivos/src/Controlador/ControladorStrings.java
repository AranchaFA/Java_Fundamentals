/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.GrabarString;
import Modelo.LeerStrings;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class ControladorStrings {
    
    // ATRIBUTOS
    LeerStrings lector;
    GrabarString grabadora;
    int opcionSeleccionada;
    
    // MÉTODOS

    // Getters + Setters
    public LeerStrings getLector() {
        return lector;
    }

    public void setLector(LeerStrings lector) {
        this.lector = lector;
    }

    public GrabarString getGrabadora() {
        return grabadora;
    }

    public void setGrabadora(GrabarString grabadora) {
        this.grabadora = grabadora;
    }

    public int getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccionada(int opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }
    
    // toString
    @Override
    public String toString() {
        return "Controlador{" + "lector=" + lector + ", grabadora=" + grabadora + ", opcionSeleccionada=" + opcionSeleccionada + '}';
    }
    
    // Constructor (creará los objetos de los atributos)
    public ControladorStrings() {
        lector=new LeerStrings();
        grabadora=new GrabarString();
    }
    
    // Método para grabar un String
    public boolean grabarString(String nombreFichero,String string){
        boolean auxReturn;
        if (grabadora.grabarEnFichero(nombreFichero, string)) {
            auxReturn= true;
        } else {
             auxReturn= false;
        }
        return auxReturn;
    }
    
    // Método para leer el fichero y mostrarlo por pantalla
    public void leerFicheroPorPantalla(String nombreFichero){
        lector.leerFicheroPorPantalla(nombreFichero);
    }
    
    // Método para interactuar con el usuario
    public void ejecutarControlador(String nombreFichero){
        Scanner teclado=new Scanner(System.in);
        do {
            System.out.println("- OPCIONES -");
            System.out.println("1. Introducir String");
            System.out.println("2. Mostrar todos los Strings");
            System.out.println("3. Finalizar");
            System.out.println("¿Qué opción quieres?: ");
            // Podemos controlar que esté en el rango válido de valores
            // creando un objeto excepción nosotros, pero es largo.....y
            // no sé hacerlo ahora mismo o.O
            opcionSeleccionada=teclado.nextInt();
            // Según la opción, ejecutamos un método u otro
            switch (opcionSeleccionada) {
                case 1:
                    teclado.nextLine();  // Por si da problemas con el buffer
                    System.out.println("Introduce un String: ");
                    grabadora.grabarEnFichero(nombreFichero,teclado.nextLine());
                    break;
                case 2:
                    System.out.println("** Strings grabados hasta el momento: ");
                    lector.leerFicheroPorPantalla(nombreFichero);
                    break;
                case 3:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            
        } while (opcionSeleccionada!=3);
    }
}
