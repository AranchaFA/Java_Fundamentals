package Controlador;

import Modelo.Libro;

public class MainLibroMenu {

    public static void main(String[] args) {

        // Creamos un libro (se crea con su menú)
        Libro libro = new Libro("Momo", "Michael Ende", 2);

        // Ejecutamos el bucle con el menú y la ejecución de selecciones
        libro.getMenu().ejecutarSeleccion(libro);
        }
    }
