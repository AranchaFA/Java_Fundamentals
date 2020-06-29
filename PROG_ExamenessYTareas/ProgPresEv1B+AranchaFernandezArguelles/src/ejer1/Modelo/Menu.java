package ejer1.Modelo;

import Modelo.Leer;

public class Menu {

    private int opcionSeleccionada;

    public int getOpcionSeleccion() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccion(int opcionSeleccion) {
        this.opcionSeleccionada = opcionSeleccion;
    }

    @Override
    public String toString() {
        return "Menu{" + "opcionSeleccion=" + opcionSeleccionada + '}';
    }

    public Menu() {
    }

    // Nos devuelve la opción seleccionada
    public int mostrarMenu() {
        
        //Teclado
        Leer teclado=new Leer();

        System.out.println("MENU DEL ASCENSOR");
        System.out.println("1- Subir Personas al ascensor");
        System.out.println("2- Bajar Personas del ascensor");
        System.out.println("3- Mostrar información del ascensor");
        System.out.println("0- Salir");
        System.out.println("¿Qué opción quieres?");
        
        this.opcionSeleccionada=teclado.datoInt();
        
        return this.opcionSeleccionada;
    }
}
