package Controlador;

import Modelo.*;
import Vista.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_PilotosF1 {

    // ATRIBUTOS
    private DAO_CSV daoCSV;
    private Circuito circuito;

    // MÉTODOS
    // Constructor
    public Controlador_PilotosF1() {
        daoCSV = new DAO_CSV("tiempos.csv");
        circuito = new Circuito("CarbonRing", "Sotrondio", new ArrayList<>());
    }

    // Generar la colección de pilotos del circuito
    public void generarListPilotos() {
        try {
            // Abrimos fichero CSV para leer
            daoCSV.abrirLeer();
            // Leemos en bucle generando objetos Piloto hasta fin de fichero
            // Aproechamos el método para contar el nº de registos del CSV y no tner que contolar
            // si el siguiente String es null para que no de una excepcion
            String stringLeido = null;
            while ((stringLeido = daoCSV.leerUnString()) != null) {
                circuito.getListPilotos().add(daoCSV.generarUnObjeto(stringLeido));
            }
            // Cerramos el fichero
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador_PilotosF1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador_PilotosF1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Mostrar por pantalla la lista de pilotos
    public void mostrarListPilotos() {
        Iterator it = circuito.getListPilotos().iterator();
        while (it.hasNext()) {
            Vista.verPiloto((Piloto) it.next());
        }
    }

    // Método para buscar un objeto en una colección tipo LIST
    public Piloto buscarUnObjeto(Piloto objetoABuscar) {
        Piloto objetoEncontrado = null;
        List<Piloto> coleccionObjetos = circuito.getListPilotos();
        if (coleccionObjetos.contains(objetoABuscar)) {
            int posicionObjeto = coleccionObjetos.indexOf(objetoABuscar);
            objetoEncontrado = coleccionObjetos.get(posicionObjeto);
        } else {
            
        }
        return objetoEncontrado;
    }
    
    // Mostrar las medias de todos los pilotos
    public void mostrarTiemposMediosPilotos(){
        
    }
    
 /*   
    // Método para buscar un objeto desde el fichero CSV
    public Piloto buscarUnObjetoDesdeCSV(Piloto objetoABuscar) {
        Piloto objetoEncontrado = null;
        Piloto objetoAEncontrar=Vista.datosParaBucarPiloto();
        objetoEncontrado=daoCSV.
        if (coleccionObjetos.contains(objetoABuscar)) {
            int posicionObjeto = coleccionObjetos.indexOf(objetoABuscar);
            objetoEncontrado = coleccionObjetos.get(posicionObjeto);
        }
        return objetoEncontrado;
    }
*/
    // Mostrar (sólo mostrar) el menú
    public void mostrarMenu() {
        System.out.println("* MENÚ +"
             + "\n 1. Cargar colección de pilotos a memoria"
             + "\n 2. Mostrar colección de pilotos"
             + "\n 3. Buscar y mostrar un piloto"
             + "\n 0. Salir");
    }

    // Gestionar la elección del menú
    public void gestionMenu(int opcion) {
        switch (opcion) {
            case 0:
                Vista.verMensaje("ADIÓS");
                break;
            case 1:
                generarListPilotos();
                break;
            case 2:
                mostrarListPilotos();
                break;
            case 3:
                Piloto objetoABuscar=Vista.datosParaBucarPiloto();
                Piloto objetoEncontrado=buscarUnObjeto(objetoABuscar);
                if (objetoEncontrado!=null) {
                    System.out.println("Piloto encontrado, sus datos son:"
                         + "\n"+objetoEncontrado);
                } else {
                    System.out.println("El piloto no se ha encontrado.");
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    /*
    // Generar un objeto Piloto a partir de un String del CSV
    public Piloto generarUnObjeto(String stringAtributos) {
        Piloto objetoGenerado = null;
        List<Double> tiempos = null;
        // Creamos un StringTokenizer para tokenizar el String introducido desde el CSV
        StringTokenizer stk = new StringTokenizer(stringAtributos, ",");
        // Sacamos los 3 primeros atributos que siempre son "fijos"
        String nombre = stk.nextToken();
        String pais = stk.nextToken();
        String escuderia = stk.nextToken();
        // La cantidad de tiempos no es constante, así que leemos tokens en bucle
        while (stk.hasMoreTokens()) {
            tiempos.add(Double.parseDouble(stk.nextToken().trim()));
        }
        // Ya tenemos los 4 atibutos para crear el objeto Piloto
        objetoGenerado = new Piloto(nombre, pais, escuderia, tiempos);
        return objetoGenerado;
    }
     */
}
