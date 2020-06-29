package Controlador;

import Modelo.GrabarObjetos;
import Modelo.LeerObjetos;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorObjetos {

    // ATRIBUTOS
    // Lector y grabadora de objetos
    LeerObjetos lector;
    GrabarObjetos grabadora;

    // MÉTODOS
    // Constructor (inicializa el lector y la grabadora)
    public ControladorObjetos() {
        lector = new LeerObjetos();
        grabadora = new GrabarObjetos();
    }

    // Métodos para abrir un fichero para leer o grabar (abrirán distintos flujos!)
    public void abrirFicheroParaLeer(String nombreFichero) throws IOException {
        lector.abrirFichero(nombreFichero);
    }

    public void abrirFicheroParaGrabar(String nombreFichero) throws IOException {
        grabadora.abrirFichero(nombreFichero);
    }

    // Método para leer un objeto de un fichero
    public Object leerUnObjeto() throws IOException, ClassNotFoundException {
        return lector.leerObjeto();
    }

    // Método para grabar un objeto pasado por parámetro CON CABECERA
    public void grabarUnObjetoConCabecera(Object objeto) {
        abrirFicheroParaGrabar();
        grabadora.grabarObjetoConCabecera(objeto);
    }

    // Método para grabar un objeto pasado por parámetro SIN CABECERA
    public void grabarUnObjetoSinCabecera(Object objeto) {
        grabadora.grabarObjetoSinCabecera(objeto);
    }

    // Método para crear un nuevo fichero de objetos
    /*public File crearFicheroObjetos(String nombreFichero){
        Scanner teclado=new Scanner(System.in);
        String auxNombre,auxApellidos,opcion;
        int auxEdad;
        do {            
            System.out.println("Introduzca nombre de la persona: ");
            auxNombre=teclado.nextLine();
            System.out.println("Apellidos: ");
            auxApellidos=teclado.nextLine();
            System.out.println("Edad: ");
            auxEdad=teclado.nextInt();
            System.out.println("¿Meter otra persona? S/N");
            opcion=teclado.nextLine();
        } while (opcion.equalsIgnoreCase("s"));
        return ....... ;    
        } */

    // Método para leer un fichero de entrada completo y grabarlo en uno de salida
    public void copiarFichero(String nombreFicheroEntrada, String nombreFicheroSalida) {
        // Abrimos ambos archivos
        try {
            abrirFicheroParaLeer(nombreFicheroEntrada);
            abrirFicheroParaGrabar(nombreFicheroSalida);
        } catch (IOException ex) {
            System.out.println("Error al abrir fichero. " + ex.getMessage());
            Logger.getLogger(ControladorObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Grabamos los objetos de uno en uno hasta fin de fichero
        // Habrá que diferenciar si el archivo existe o no para grabar con o sin cabecera
        try {
            if (grabadora.getFicheroSalida().exists()) {
                // Suponemos que si existe no estará vacío
                grabarUnObjetoSinCabecera(lector.leerObjeto());

            } else {
                grabarUnObjetoConCabecera(lector.leerObjeto());
            }
        } catch (IOException ex) {
            System.out.println("Problemas al grabar. "+ex.getMessage());
            Logger.getLogger(ControladorObjetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada. "+ex.getMessage());
            Logger.getLogger(ControladorObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Repetimos en bucle hasta EOF, ahora el fichero ya estará creado y con cabecera
        Object auxBucle;
        try {
            while ((auxBucle=leerUnObjeto())!=null) {
                grabarUnObjetoSinCabecera(auxBucle);
            }
        } catch (IOException ex) {
            System.out.println("Problemas al grabar. "+ex.getMessage());
            Logger.getLogger(ControladorObjetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada. "+ex.getMessage());
            Logger.getLogger(ControladorObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
