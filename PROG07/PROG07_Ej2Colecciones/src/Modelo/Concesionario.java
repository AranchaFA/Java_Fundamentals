
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    
    // ATRIBUTOS
    private List<Coche> coleccionCoches;

    // MÉTODOS
    // Getters + Setters
    public List<Coche> getColeccionCoches() {
        return coleccionCoches;
    }

    public void setColeccionCoches(List<Coche> coleccionCoches) {
        this.coleccionCoches = coleccionCoches;
    }

    // Constructores
    public Concesionario() {
        this.coleccionCoches = new ArrayList<>();
    }

    public Concesionario(List<Coche> coleccionCoches) {
        this.coleccionCoches = coleccionCoches;
    }

    // CARGAR COLECCIÓN DESDE CSV (en Controlador)
    
    // MOSTRAR COLECCIÓN de coches por pantalla (en Controlador, conjunto con la Vista)
    
    
}
