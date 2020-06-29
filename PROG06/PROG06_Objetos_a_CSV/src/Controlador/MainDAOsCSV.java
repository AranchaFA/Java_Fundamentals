package Controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainDAOsCSV {

    public static void main(String[] args) {

        Controlador c = new Controlador("entradaPersonas.dat", "salidaPersonas.csv");
        
        // ME ESCRIBE
        c.grabarAtributosEnCSV();

        c.mostrarFicheroCSV();

    }

}
