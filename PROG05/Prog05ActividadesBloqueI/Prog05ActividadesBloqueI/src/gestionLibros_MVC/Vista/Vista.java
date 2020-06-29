
package gestionLibros_MVC.Vista;

import gestionLibros_MVC.Modelo.Leer;
import gestionLibros_MVC.Modelo.LibroBiblioteca;

public class Vista {
    
    public static void verMensaje(String txt){
        System.out.println(txt);
    }
    
    public static LibroBiblioteca generarLibro(){
        LibroBiblioteca libro;
       String titulo, autor;
        int totalEjemplares;
       verMensaje("Introduce titulo: ");
        titulo = Leer.leerDato();
       verMensaje("Introduce autor: ");
        autor = Leer.leerDato();
        verMensaje("Numero total de ejemplares: ");
        totalEjemplares = Leer.datoInt();
        libro =   new LibroBiblioteca(titulo, autor, totalEjemplares);
        return libro;
    }
}
