package Modelo;

public class Menu {

    // ATRIBUTOS
    private int seleccion;

    // MÉTODOS
    // Getters + Setters
    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }
    // toStriing
    @Override
    public String toString() {
        return "Men\u00fa{" + "seleccion=" + seleccion + '}';
    }
    // Constructor
    public Menu() {
    }

    // Método para mostrar opciones y seleccionar una
    public boolean ejecutarMenu() {
        Leer teclado = new Leer();
        int auxSeleccion;
        boolean auxReturn;

        System.out.println("** M E N Ú **");
        System.out.println("1. Registrar una cosa.");
        System.out.println("2. Tomar prestada una cosa.");
        System.out.println("3. Devolver una cosa.");
        System.out.println("4. Abandonar menú.");
        System.out.println("");
        System.out.println("¿Qué quiere hacer? ");

        auxSeleccion = teclado.datoInt();

        if (auxSeleccion < 1 && auxSeleccion > 4) {
            auxReturn = false;
        } else {
            this.seleccion = auxSeleccion;
            auxReturn = true;
        }
        return auxReturn;
    }
}
