package Controlador;

import Modelo.Menu;

public class GestorPrestarCosas {

    // ATRIBUTOS
    private Menu menu;

    // MÉTODOS
    // Getters + Setters
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    // toString
    @Override
    public String toString() {
        return "GestorPrestarCosas{" + "menu=" + menu + '}';
    }

    // Constructor
    public GestorPrestarCosas() {
        this.menu = new Menu();
    }

    // Métodos para operar con el menú y las opciones elegidas
    public void funcionar() {

        do {
            this.menu.ejecutarMenu();
            switch (this.getMenu().getSeleccion()) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    Vista.VistaPrestarCosas.seleccionNoValida();

            }
        } while (this.menu.getSeleccion() != 4);
    }
}
