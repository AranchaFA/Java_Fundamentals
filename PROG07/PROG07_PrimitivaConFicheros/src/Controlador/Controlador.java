package Controlador;

import Modelo.*;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    // ATRIBUTOS
    private DAO_CSVs daoCSV;
    private DAO_Objetos daoObjetos;
    private DAO_DatosPrimitivos daoInts;
    private List<Integer> combinacionPremiada;
    private List<Jugador> jugadores;

    // MÉTODOS
    // Getters + Setters
    public DAO_CSVs getDaoCSV() {
        return daoCSV;
    }

    public void setDaoCSV(DAO_CSVs daoCSV) {
        this.daoCSV = daoCSV;
    }

    public DAO_Objetos getDaoObjetos() {
        return daoObjetos;
    }

    public void setDaoObjetos(DAO_Objetos daoObjetos) {
        this.daoObjetos = daoObjetos;
    }

    public DAO_DatosPrimitivos getDaoInts() {
        return daoInts;
    }

    public void setDaoInts(DAO_DatosPrimitivos daoInts) {
        this.daoInts = daoInts;
    }

    public List<Integer> getCombinacionPremiada() {
        return combinacionPremiada;
    }

    public void setCombinacionPremiada(List<Integer> combinacionPremiada) {
        this.combinacionPremiada = combinacionPremiada;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    // Constructor
    public Controlador() {
        // Creamos los DAOs
        daoCSV = new DAO_CSVs("ApostantesPrimitiva.csv");
        daoInts = new DAO_DatosPrimitivos("combinacionGanadora.dat");
        daoObjetos = new DAO_Objetos("ganadores.dat");
        // Creamos y cargadmos la lista de números ganadores
        combinacionPremiada = new ArrayList<>();
        generarCombinacionPremiada();
        // Creamos y cargamos la colección de jugadores
        jugadores = new ArrayList<>();
        generarColeccionJugadores();
    }

    // Generar las dos colecciones desde CSV y fichero de bytes
    public void generarCombinacionPremiada() {
        try {
            // Abrimos para leer fichero de ints
            daoInts.abrirLeer();
            // Leemos en bucle cargando los números en la lista
            try {
                while (true) {
                    int enteroLeido = daoInts.leerUnRegistro();
                    combinacionPremiada.add(Integer.valueOf(enteroLeido));
                }
            } catch (EOFException ex) {
                // System.out.println("Fin de fichero al cargar combinación ganadora. " + ex.getMessage());
                //   Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Cerrar fichero
            daoInts.cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al cargar combinación ganadora. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarColeccionJugadores() {
        try {
            daoCSV.abrirLeer();
            // Tokenizamos en bucle
            String stringLeido = daoCSV.leerUnString();
            while (stringLeido != null) {
                Jugador objetoGenerado = daoCSV.generarUnObjeto(stringLeido);
                jugadores.add(objetoGenerado);
                stringLeido = daoCSV.leerUnString();
            }
            // Cerramos CSV
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int numeroAciertosJugador(Jugador jugador) {
        int aciertos = 0;
        Iterator it = jugador.getCombinacionApostada().iterator();
        while (it.hasNext()) {
            Integer numeroLeido= (Integer) it.next();
            if (combinacionPremiada.contains(numeroLeido)) {
                aciertos++;
            }
        }
        return aciertos;
    }

    public void asignarAciertosDeTodosLosJugadores(){
        for (Jugador jugador : jugadores) {
            jugador.setNumeroAciertos(numeroAciertosJugador(jugador));
        }
    }
    
    public void grabarFicheroObjetosJugadoresPremiados(List<Jugador> coleccion){
        try {
            // Abrimos para grabar fichero de objetos
            daoObjetos.abrirGrabarSobreescribir();
            for (Jugador jugador : coleccion) {
                if (jugador.getNumeroAciertos()>=3) {
                    daoObjetos.grabarUnObjeto(jugador);
                }
            }
            // Ceramos fichero de objetos
            daoObjetos.cerrarGrabar();
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
