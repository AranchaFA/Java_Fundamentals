/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Porta cápsulas para cafetera
 * @author Arancha
 */
public class PortaCapsulas {
    
    private boolean abierto;
    private Capsula capsula;

    /**
     * Constructor por defecto, no necesita pasar información por parámetros ni 
     * inicializar ningún atributo: por defecto se crearán siempre vacíos y 
     * cerrados.
     */
    public PortaCapsulas() {
    }
    
    /**
     * Nos devuelve si el porta cáptulas se encuentra abierto tras ejecutar 
     * el método.
     * @return
     */
    public boolean abrirPortaCapsulas () {
    }
    
    /**
     * Nos devuelve la capsula que se ha introducido (o que se encontraba ya 
     * cargada, en caso de no haber podido introducirla).
     * @param capsula
     * @return
     */
    public Capsula cargarCapsula (Capsula capsula) {
        this.capsula=capsula;
        return this.capsula;
    }
    
    /**
     * Nos devuelve la cápsula que se encontraba introducida en la cafetera 
     * y que se ha expulsado.
     * @return
     */
    public Capsula descargarCapsula(){
        Capsula auxCapsula=this.capsula;
        this.capsula=null;
        return auxCapsula;
    }
}
