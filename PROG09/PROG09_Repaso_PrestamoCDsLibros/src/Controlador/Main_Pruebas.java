
package Controlador;

public class Main_Pruebas {

    public static void main(String[] args) {

        Controlador_BBDD c=new Controlador_BBDD();
        
        Vista.Vista.mostrarColeccionMap(c.getColeccion().get("PRESTAMOS"));
        
        c.hacerPrestamo();
    }
    
}
