
package paqueteLeerDatos;

public class NewMain {

    public static void main(String[] args) {
        System.out.println("Introduce cadena: ");
        String cadena = Leer.leerDato();
        System.out.println("Has metido "+cadena);
        
        System.out.println("Introduce caracter:");
        char c = Leer.datoCaracter();
        System.out.println("has metido una "+c);
        
         System.out.println("Introduce cadena: ");
         cadena = Leer.leerDato();
        System.out.println("has metido "+cadena);
    }
    
}
