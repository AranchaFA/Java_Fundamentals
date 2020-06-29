package Controlador;

import Modelo.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_Concesionario {

    // ATRIBUTOS
    private Concesionario concesionario;
    private DAO_CSVs daoCSV;

    // MÉTODOS
    // Getters + Setters
    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    // Constructores
    public Controlador_Concesionario() {
        this.concesionario = new Concesionario();
        this.daoCSV=new DAO_CSVs("coches.csv");
    }

    public Controlador_Concesionario(List<Coche> coleccionCoches) {
        this.concesionario = new Concesionario(coleccionCoches);
        this.daoCSV=new DAO_CSVs("coches.csv");
    }

    // Cargar fichero CSV en la colección
    public void cargarColeccionDesdeCSV() {
        try {
            daoCSV.abrirLeer();
            
            String stringLeido=daoCSV.leerUnString();
            while (stringLeido!=null) {
                StringTokenizer stk=new StringTokenizer(stringLeido);
                String matricula=stk.nextToken();
                String marca=stk.nextToken();
                String modelo=stk.nextToken();
                Coche coche=new Coche(matricula, marca, modelo);
                this.concesionario.getColeccionCoches().add(coche);
                stringLeido=daoCSV.leerUnString();
            } 
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador_Concesionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador_Concesionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // MOSTRAR COLECCIÓN de coches por pantalla (conjunto con la Vista)
    public void mostrarColeccionCompleta(){
        Vista.Vista.mostrarColeccionCompleta(concesionario.getColeccionCoches());
    }
}
