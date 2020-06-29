package Modelo;

import java.util.Scanner;

public class MenuLibro {

    // ATRIBUTOS
    private int seleccion;

    // MÉTODOS
    // Getter + Setter
    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

    // toString
    @Override
    public String toString() {
        return "MenuLibro{" + "seleccion=" + seleccion + '}';
    }

    // Constructor (por defecto)
    public MenuLibro() {
    }

    // Método para mostrar el menú por pantalla
    public void mostrarMenu() {
        // Objeto teclado para introducir datos:
        Leer teclado = new Leer();
        // Scanner teclado=new Scanner(System.in);

        System.out.println("MENU: ");
        System.out.println("1. Prestar Libro1");
        System.out.println("2. Devolver Libro1");
        System.out.println("3. Mostrar información Libro1");
        System.out.println("4. Abandonar MENÚ");
        System.out.println("Introduce opción: ");
        this.seleccion = teclado.datoInt();
    }

    // Método para realizar las operaciones elegidas
    public void ejecutarSeleccion(Libro libro) {
        int contadorIntentos=0;
        VistaLibro vista=new VistaLibro();
        boolean auxBoolean;
        do {
            this.mostrarMenu();
            switch (this.seleccion) {
                case 1:
                    auxBoolean = libro.prestamo();
                    if (auxBoolean) {
                        vista.accionPosible();
                        contadorIntentos=0;
                    } else {
                        vista.accionNoPosible();
                        contadorIntentos++;
                        if(contadorIntentos>3) System.out.println("Que no, pesao");
                    }
                    break;
                case 2:
                    auxBoolean = libro.devolucion();
                    if (auxBoolean) {
                        vista.accionPosible();
                        contadorIntentos=0;
                    } else {
                        vista.accionNoPosible();
                        contadorIntentos++;
                        if(contadorIntentos>3) System.out.println("Que no, pesao");
                    }
                    break;
                case 3:
                    System.out.println(libro.toString());
                    ;
                    break;
                case 4:
                    System.out.println("¡ADIÓS!");
                    break;
                default:
                    System.out.println("Introduzca un número entre 1 y 4");
            }

        } while (this.seleccion != 4);
    }
}
