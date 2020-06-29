package Controlador;

import Modelo.DAO_CSV;
import Modelo.DAO_ObjetosPersona;
import Modelo.Persona;
import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    private DAO_CSV daoCSV;
    private DAO_ObjetosPersona daoObjetos;

    public Controlador(String nombreFicheroCSV, String nombreFicheroObjetos) {
        daoCSV = new DAO_CSV(nombreFicheroCSV);
        daoObjetos = new DAO_ObjetosPersona(nombreFicheroObjetos);
    }

    // Método para leer un String del fichero CSV y con su información generar un
    // objeto de la clase Persona, NO SE ABRIRÁN LOS FLUJOS DE ENTRADA/SALIDA,
    // ESO SE HARÁ EN EL MÉTODO PARA COPIAR EL FICHERO COMPLETO PARA NO ABRIRLOS Y
    // CERRARLOS CADA VEZ QUE LEEMOS UNA LÍNEA DEL CSV Y GENERAMOS UN OBJETO
    public Object generarUnObjetoPersona() throws IOException {
        // HAY QUE CONTROLAR EN ESTE MÉTODO LA EOF, PORQUE SI PONEMOS THROWS IOException
        // CUANDO SE EJECUTA EN EL MÉTODO PARA GRABAR TODO EL FICHERO SALTA LA IOEx Y
        // SE "SALTA" LA EOFEx QUE INCLUIMOS EN ESE MÉTODO 
        String auxString;
        Persona auxPersona = null;
        // Leemos un String del CSV
        auxString = daoCSV.leerUnString();
        if (auxString != null) {
            // Sabemos que tiene 3 tokens, así que tokenizamos ordenadamente guardando
            // en los atributos de la persona a generar
            // Creamos un StringTokenizer para el String leido
            StringTokenizer stk = new StringTokenizer(auxString, ",");
            // Vamos tokenizando cada "valor" leido a su atributo correspniente
            String auxNombre = stk.nextToken();
            String auxApellidos = stk.nextToken();
            String auxEdad = stk.nextToken();
            // Pasamos la edad a un int PRIMERO ELIMINAMOS POSIBLES ESPACIOS EN BLANCO
            // ANTES O DESPUÉS DE LA CIFRA PORQUE SI NO DARÁ ERROR
            auxEdad = auxEdad.trim();
            int edad = Integer.parseInt(auxEdad);
            // Creamos la persona con los atributos obtenidos
            auxPersona = new Persona(auxNombre, auxApellidos, edad);
            // Casteamos a Object que es como la devolverá el método
        }
        return (Object) auxPersona;
    }

    // Método para generar un fichero completo de personas a partir de los datos
    // de un CSV
    public void generarFicheroPersonasDesdeCSV() {

        // Abrimos los flujos de entrada (CSV) y salida (Objects) de datos
        // Para la salida de objetos abriremos para grabar SIN CABECERA
        try {
            daoCSV.abrirLeer();
            // daoObjetos.abrirGrabarSinCabecera(); AL FINAL NO VALE ASÍ
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir los ficheros. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } 

        // Generamos un objeto persona por cada línea del CSV hasta EOF y lo grabamos 
        // en el fichero de salida, lo mostramos por pantalla para comprobar
        try {
            Object auxObject;
            while ((auxObject = generarUnObjetoPersona()) != null) {
                System.out.println("Leído el objeto: " + auxObject.toString());
                System.out.println("Grabando el objeto.....");
                daoObjetos.grabarUnObjetoPersona(auxObject);
                System.out.println("Grabado!");
            }
        } catch (IOException ex) {
            System.out.println("Error al generar el fichero de personas. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cerramos los archivos de entrada (CSV) y salida (Objects SIN CABECERA)
        try {
            daoCSV.cerrarLeer();
            // daoObjetos.cerrarGrabarSinCabecera(); AL FINAL NO VALE ASÍ
        } catch (IOException ex) {
            System.out.println("Error al cerrar los ficheros. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Método para mostrar el fichero creado por pantalla para comprobar
    public void mostrarFicheroObjetos() {
        daoObjetos.mostrarFicheroPorPantalla();
    }

    public void mostrarFicheroCSV(){
        daoCSV.mostrarFicheroPorPantalla();
    }
}
