
package Controlador;

import Modelo.Leer;
import Modelo.Libro;

public class MainLibro {

    public static void main(String[] args) {
        
        // Creamos dos libros
        Libro libro1=new Libro("El Quijote", "Cervantes", 1);
        Libro libro2=new Libro();
        // Pedimos por teclado los datos del libro 2
        // Creamos objeto clase teclado para introducir los datos
        Leer teclado=new Leer();
        
        System.out.println("Título del libro Nº2: ");
        libro2.setTitulo(teclado.leerDato());
        System.out.println("Autor del libro Nº2: ");
        libro2.setAutor(teclado.leerDato());
        System.out.println("Nº ejemplares del libro Nº2: ");
        libro2.setNumEjemplares(teclado.datoInt());
        
        // Visualizamos los datos iniciales de ambos libros
        System.out.println("Datos iniciales del libro Nº1: "+'\n'+libro1.toString());
        System.out.println("Datos iniciales del libro Nº2: "+'\n'+libro2.toString());
        
        // Realizamos préstamos / devoluciones con el libro 1
        System.out.println("Realizamos un préstamos del libro Nº1 y sus datos finales son:");
        libro1.prestamo();
        System.out.println(libro1.toString());
        
        System.out.println("Intentamos un segundo préstamo del libro Nº1: ");
        if (libro1.prestamo()) {
            System.out.println("Se ha podido prestar");
        }
        else {
            System.out.println("No se ha podido prestar");
        }
        
        System.out.println("Los datos actuales del libro Nº1 son:");
        System.out.println(libro1.toString());
        
        System.out.println("Devolvemos el libro Nº1 y sus datos son: ");
        libro1.devolucion();
        System.out.println(libro1.toString());
        
        System.out.println("Intentamos devolver por segunda vez el libro Nº1: ");
         if (libro1.devolucion()) {
            System.out.println("Se ha podido devolver");
        }
        else {
            System.out.println("No se ha podido devolver");
        }
         
        System.out.println("Los datos actuales del libro Nº1 son:");
        System.out.println(libro1.toString());
    }
    
}
