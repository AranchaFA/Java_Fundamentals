package Modelo;

import java.util.Scanner;

public class Menu {

    // ATRIBUTOS
    private int seleccion;

    // MÉTODOS  
    
    // Método para mostrar el menú por pantalla
    public void mostrarMenu() {
        // Objeto teclado para introducir datos:
        // Leer teclado = new Leer();
        Scanner teclado=new Scanner(System.in);

        System.out.println("MENU: ");
        System.out.println("1. Opción 1");
        System.out.println("2. Opción 2");
        System.out.println("3. Opción 3");
        System.out.println("4. Opción 4");
        System.out.println("0. Abandonar MENÚ");
        System.out.println("Introduce opción: ");
        this.seleccion = teclado.nextInt();
    }
    // Métodos para mostrar la opción elegida:
    public String opcion1() {
        return "Has seleccionado la opción 1";
    }

    public String opcion2() {
        return "Has seleccionado la opción 2";
    }

    public String opcion3() {
        return "Has seleccionado la opción 3";
    }

    public String opcion4() {
        return "Has seleccionado la opción 4";
    }
    
    // Método para pintar asteriscos en función de la opción elegida:
    public void pintarAsteriscos(){
        for (int i=0;i<10*this.seleccion;i++) {
            System.out.print("*");
        }
    }

    // Getter, setter y toString
    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    @Override
    public String toString() {
        return "Menu{" + "seleccion=" + seleccion + '}';
    }

}
