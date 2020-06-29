
package Controlador;

import Modelo.DAO_CSVs;
import Modelo.DAO_DatosPrimitivos;
import Modelo.DAO_Objetos;

public class Controlador {
    
    
    // ATRIBUTOS
    private DAO_CSVs daoCSV;
    private DAO_Objetos daoObjetos;
    private DAO_DatosPrimitivos daoDatosPrimitivos;
    // private List<Clase> atributoColeccion;
    
    // MÉTODOS
    
    // Getters + Setters
    
    // Constructor
    public Controlador() {
        daoCSV=new DAO_CSVs(nombreFichero);
        daoObjetos=new DAO_Objetos(nombreFichero);
        daoDatosPrimitivos=new DAO_DatosPrimitivos(nombreFichero);
        // CREAR Y CARGAR (habremos diseñado el método en este contolador) COLECCIONES
        // atributoColeccion=new List<Clase>();
        // cargarAtributoColeccion();
    }
    
    
}
