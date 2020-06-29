/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Cafetera de cápsulas
 *
 * @author Arancha
 */
public class Cafetera {

    private boolean encendida;
    private PortaCapsulas portaCapsulas;
    private Botonera botonera;
    private DepositoAgua depositoAgua;
    private DepositoCapsulasUsadas depositoCapsulasUsadas;

    /**
     * Constructor por defecto que creará todos los atributos de tipo objeto. No
     * se pasará nada por parámetro pues los objetos se inicializarán con sus
     * constructores por defecto que tampoco requieren parámetros.
     */
    public Cafetera() {
        this.botonera = new Botonera();
        this.depositoAgua = new DepositoAgua();
        this.depositoCapsulasUsadas = new DepositoCapsulasUsadas();
        this.portaCapsulas = new PortaCapsulas();

    }

    /**
     * Nos devuelve si la cafetera se encuentra encendida o no tras ejecutar el
     * método.
     *
     * @return
     */
    public boolean encendeerCafetera() {

    }

    /**
     * Devuelve si ha podido hacer el café o no.
     *
     * 1) Encendida = true (COMPROBAR 1) 
     * 2) portaCapsulas.cargarCapsula 
     * 3) botonera.activarBoton ; en función del botón que activamos: 
     * 4) depositoAgua.numCafes >= [1 si espresso] [2 si lungo] (COMPROBAR 2) 
     * 5) depositoCapsulasUsadas.numCapsulas <10 (COMPROBAR 2)
     *
     * Recibe como parámetro una cápsula y el tipo de café (espresso o lungo)
     * que queremos.
     *
     * Si no hay agua suficiente o no hay espacio para la cápcula usada en el
     * depósito de cápsulas usadas NO DEJA HACER EL CAFÉ (aunque sí podemos
     * haber cargado la cápcula, y quedaría cargada). @param capsula @param
     * numBoton @return
     */
    public boolean hacerCafe(Capsula capsula, int numBoton) {
        
    }

}
