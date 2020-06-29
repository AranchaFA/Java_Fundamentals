
package Modelo;

public class MenuCalculadora {
    
    // SIN ATRIBUTOS

    // MÉTODOS
    // Constructor por defecto
    public MenuCalculadora() {
    }
    /**
     * Método para mostrar el menú de la calculadora:
     * Devuelve el valor de la opción seleccionada
     */
    public int mostrarMenuCalculadora(){
        int opcionSeleccionada;
        // Objeto teclado para leer datos del usuario
        Leer teclado=new Leer();
        
        System.out.println("Mi calculadora: ");
        System.out.println("1. Introducir valores");
        System.out.println("2. Suma");
        System.out.println("3. Resta");
        System.out.println("4. Multiplicación");
        System.out.println("5. División");
        System.out.println("6. Salir");
        System.out.println("Introduce opción: ");
        
        opcionSeleccionada=teclado.datoInt();
        
        return opcionSeleccionada;
    }
}
