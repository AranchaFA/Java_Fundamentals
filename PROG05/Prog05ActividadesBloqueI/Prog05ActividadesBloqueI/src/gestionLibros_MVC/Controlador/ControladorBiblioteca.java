package gestionLibros_MVC.Controlador;

import gestionLibros_MVC.Modelo.Leer;
import gestionLibros_MVC.Vista.Vista;
import gestionLibros_MVC.Modelo.LibroBiblioteca;

public class ControladorBiblioteca {

    private LibroBiblioteca libroBiblioteca;
    
    public ControladorBiblioteca(){
        crearLibro();
    }

    public void crearLibro() {       
        libroBiblioteca = Vista.generarLibro();   
    }

    public void menu() {
        Vista.verMensaje("\n MENU GESTION"
                + "\n\t 1. crear libro"
                + "\n\t 2. prestar libro"
                + "\n\t 3. devolver libro"
                + "\n\t 4. mostrar libro"
                + "\n\t 5. salir"
                + "\n"
                + "\n\t Introducir Opcion:");
    }

    public void gestionMenu() {
        int opcion;

        do {
            menu();
            opcion = Leer.datoInt();

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    if (libroBiblioteca.prestamo()){
                        Vista.verMensaje("Prestado un ejemplar del libro "+ libroBiblioteca.toString());
                    }else{
                        Vista.verMensaje("NO HAY EJEMPLARES PARA PRESTAR "+  libroBiblioteca.toString());
                    };
                    break;
                case 3: if (libroBiblioteca.devolucion()){
                       Vista.verMensaje("LIBRO DEVUELTO "+ libroBiblioteca.toString());
                    }else{
                        Vista.verMensaje("NO hay ejemplares de este libro prestados "+ libroBiblioteca.toString());
                    };
                    break;
                case 4:
                    Vista.verMensaje(libroBiblioteca.toString());
                    break;
                case 5: System.out.println("Adios");
                    break;

            }
        } while (opcion != 5);

    }

}
