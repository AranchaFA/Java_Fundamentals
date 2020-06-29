/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Botonera interior de un ascensor
 *
 * @author Arancha
 */
public class BotoneraInt {

    private boolean activado;
    private int numPlantaActivado;
    private int numBotones;

    /**
     * Indica si la botonera se encuentra en funcionamiento
     * @return activado=true
     */
    public boolean isActivado() {
        return activado;
    }

    /**
     * 
     * @param activado
     */
    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    /**
     * Número de la planta seleccionada en caso de estar activada la botonera
     * @return Número de planta seleccionada
     */
    public int getNumPlantaActivado() {
        return numPlantaActivado;
    }

    /**
     *
     * @param numPlantaActivado
     */
    public void setNumPlantaActivado(int numPlantaActivado) {
        this.numPlantaActivado = numPlantaActivado;
    }

    /**
     * Indica el número de botones de la botonera
     * @return número de botones de la botonera
     */
    public int getNumBotones() {
        return numBotones;
    }

    /**
     *
     * @param numBotones
     */
    public void setNumBotones(int numBotones) {
        this.numBotones = numBotones;
    }

    @Override
    public String toString() {
        return "BotoneraInt{" + "activado=" + activado + ", numPlantaActivado=" + numPlantaActivado + ", numBotones=" + numBotones + '}';
    }

    /**
     * Constructor especificando el número total de botones de la botonera
     * @param numBotones
     */
    public BotoneraInt(int numBotones) {
        this.numBotones = numBotones;
    }

    /**
     * Método para activar un botón de la botonera, para ello debe estar inactiva
     * @param numPlantaActivado
     * @return número de planta seleccionada, 
     * o número de la planta que se encontraba seleccionada si la botonera se encontraba activa
     */
    public int activarBoton(int numPlantaActivado) {
        if (!this.activado) {
            this.activado=true;
            this.numPlantaActivado = numPlantaActivado;
        }
        return this.numPlantaActivado;
    }
}
