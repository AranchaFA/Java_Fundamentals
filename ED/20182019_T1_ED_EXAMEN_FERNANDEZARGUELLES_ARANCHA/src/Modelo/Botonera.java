/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Botonera para una cafetera
 *
 * @author Arancha
 */
public class Botonera {

    private boolean botonEspresso;
    private boolean botonLungo;

    /**
     * Constructor por defecto, no hace falta pasar nada por parámetro ni
     * inicializar ningún atributo: ambos botones estarán por defecto
     * desactivados al crear la botonera.
     */
    public Botonera() {
    }

    /**
     * Nos devuelve el número del botón que se encontraba activado: 1 = Espresso
     * 2 = Lungo 0 = Ninguno
     *
     * Sólo puede haber un botón activado al mismo tiempo, luego no hay que
     * especificarle cuál por parámetro.
     *
     * @return
     */
    public int desactivarBoton() {

    }

    /**
     * Nos devuelve si ha sido capaz de activar el botón o no. Si ya estaba en
     * funcionamiento no será capaz de activarlo. Tampoco si la cafetera no está
     * encendida.
     *
     * Se pasará por parámetro el botón que se quiere activar: 1 = Espresso 2 =
     * Lungo
     *
     * @return
     */
    public int activarBoton() {

    }

}
