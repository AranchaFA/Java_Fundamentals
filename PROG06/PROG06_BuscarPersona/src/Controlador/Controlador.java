package Controlador;

import Modelo.DAO_BuscarPersona;
import Modelo.Persona;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    // ATRIBUTOS
    private DAO_BuscarPersona daoBuscarPersona;

    // MÉTODOS
    public DAO_BuscarPersona getDaoBuscarPersona() {
        return daoBuscarPersona;
    }

    public void setDaoBuscarPersona(DAO_BuscarPersona daoBuscarPersona) {
        this.daoBuscarPersona = daoBuscarPersona;
    }

    public Controlador(String nombreFichero) {
        daoBuscarPersona = new DAO_BuscarPersona(nombreFichero);
    }

    public Controlador(File ficheroPersonas) {
        this.daoBuscarPersona = new DAO_BuscarPersona(ficheroPersonas);
    }

    public Persona buscarPersonaEnTodoElFichero() {
        // Abrir flujos de lectura
        try {
            daoBuscarPersona.abrirParaLeer();
        } catch (IOException ex) {
            System.out.println("Eror al abrir para leer. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Buscamos en bucle
        System.out.println("Persona a buscar: " + daoBuscarPersona.getPersonaABuscar().toString());
        Persona personaEncontrada = null;
        Persona personaLeida = null;
        try {
            do {
                personaLeida = daoBuscarPersona.leerUnaPersona();
                System.out.println("Persona leída: " + personaLeida.toString());
                if (daoBuscarPersona.compararDosPersonas(personaLeida)) {
                    personaEncontrada = personaLeida;
                }
            } while (personaEncontrada == null);           
        } catch (EOFException ex) {
            System.out.println("Fin de fichero al comparar. " + ex.getMessage());
            // Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al leer persona para comparar. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("clase no encontrada. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cerrar flujos
        try {
            daoBuscarPersona.cerrarParaLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar fichero. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personaEncontrada;
    }
}
