
package Controlador;

import java.io.*;

public class Main_Enteros {

    public static void main(String[] args) {
        
        // Creamos un controlador
        ControladorEnteros controlador=new ControladorEnteros();
        
        // Pedimos el fichero origen y el número a comparar por teclado
        // Meteremos "enteros.dat" como fichero origen para probar
        
        controlador.pedirInformacion();
        
        // Leemos y grabamos selectivamente uno a uno los enteros del fichero
        
        /*
        // hasta llegar al final del fichero (EOFException).
        // No lanza la EOFException, supongo que porque se lanzará dentro del
        // while pero no "sale" al catch de fuera del bucle.
        // Romperá dentro del while y se seguirá ejecutando el bucle inficnito
        // porque recomprobará la condición del while y volverá a ejecutar el
        // controlador
        try {
            while (true) {
                controlador.leerYGrabarUnEntero();
            }
        } catch (Exception ex) {
            System.out.println("Ya hemos llegado al final del fichero. "+ex.getMessage());
        }
        */
        
        // Necesitamos haber definido el método leer DEL CONTROLADOR  como BOOLEAN
        // para controlar el while

            while (controlador.leerYGrabarUnEntero()==true) {
                System.out.println("Está grabando.");
                // No necesitamos meter nada porque ya lo ejecuta en la sentencia
                // de comprobación
            }
            
        // Mostramos todos los fcheros para verificar que está bien
        System.out.println("Números del fichero ORIGINAL: ");
        boolean auxCondicion;
        do {
           auxCondicion=false;
            System.out.print(controlador.getLector().leerUnEntero(controlador.getNombreArchivoOrigen())+", ");
           // Si rompe al leer por EOFEx no cambia a true
           auxCondicion=true;
        } while (auxCondicion==true);
        System.out.println("");
        
        System.out.println("Números del fichero de PARES: ");
        do {
           auxCondicion=false;
           System.out.print(controlador.getLector().leerUnEntero("ficheroPares.dat")+", ");
           // Si rompe al leer por EOFEx no cambia a true
           auxCondicion=true;
        } while (auxCondicion==true);
        System.out.println("");
        
        System.out.println("Números del fichero de IMPARES: ");
        do {
           auxCondicion=false;
           System.out.print(controlador.getLector().leerUnEntero("ficheroImpares.dat")+", ");
           // Si rompe al leer por EOFEx no cambia a true
           auxCondicion=true;
        } while (auxCondicion==true);
        System.out.println("");
        
        System.out.println("Números del fichero de MAYORES: ");
        do {
           auxCondicion=false;
           System.out.print(controlador.getLector().leerUnEntero("ficheroMayoresQue"+controlador.getNum()+".dat"+", "));
           // Si rompe al leer por EOFEx no cambia a true
           auxCondicion=true;
        } while (auxCondicion==true);
        
    }
    
}
