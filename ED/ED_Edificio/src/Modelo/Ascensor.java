/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Ascensor de un edificio
 *
 * @author Arancha
 */
public class Ascensor {

    private int numAscensor;
    private int plantaActual;
    private boolean abierto;
    private Persona persona1;
    private Persona persona2;
    private BotoneraExt botoneraExt;
    private BotoneraInt botoneraInt;

    /**
     * Devuelve el número que identifica al ascensor
     * @return número identificativo del ascensor
     */
    public int getNumAscensor() {
        return numAscensor;
    }

    /**
     *
     * @param numAscensor
     */
    public void setNumAscensor(int numAscensor) {
        this.numAscensor = numAscensor;
    }

    /**
     * Devuelve la planta en que se encuentra el ascensor
     * @return planta en que se encuentra el ascensor
     */
    public int getPlantaActual() {
        return plantaActual;
    }

    /**
     *
     * @param plantaActual
     */
    public void setPlantaActual(int plantaActual) {
        this.plantaActual = plantaActual;
    }

    /**
     * Indica si está abierto el ascensor
     * @return abierto=true
     */
    public boolean isAbierto() {
        return abierto;
    }

    /**
     *
     * @param abierto
     */
    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    /**
     * Devuelve la persona nº1 que está empleando el ascensor
     * @return persona nº1 que está en el ascensor
     */
    public Persona getPersona1() {
        return persona1;
    }

    /**
     *
     * @param persona1
     */
    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    /**
     * Devuelve la persona nº2 que está empleando el ascensor
     * @return persona nº2 que está en el ascensor
     */
    public Persona getPersona2() {
        return persona2;
    }

    /**
     *
     * @param persona2
     */
    public void setPersona2(Persona persona2) {
        this.persona2 = persona2;
    }

    /**
     * Devuelve la botonera exterior del ascensor
     * @return botonera exterior del ascensor
     */
    public BotoneraExt getBotoneraExt() {
        return botoneraExt;
    }

    /**
     *
     * @param botoneraExt
     */
    public void setBotoneraExt(BotoneraExt botoneraExt) {
        this.botoneraExt = botoneraExt;
    }

    /**
     * Devuelve la botonera interior del ascensor
     * @return botonera interior del ascensor
     */
    public BotoneraInt getBotoneraInt() {
        return botoneraInt;
    }

    /**
     *
     * @param botoneraInt
     */
    public void setBotoneraInt(BotoneraInt botoneraInt) {
        this.botoneraInt = botoneraInt;
    }

    @Override
    public String toString() {
        return "Ascensor{" + "numAscensor=" + numAscensor + ", plantaActual=" + plantaActual + ", abierto=" + abierto + ", persona1=" + persona1 + ", persona2=" + persona2 + ", botoneraExt=" + botoneraExt + ", botoneraInt=" + botoneraInt + '}';
    }

    /**
     * Constructor pasando como parámetro el número que identificará al ascensor
     * y creando las botoneras interior y exterior 
     * (requiere pasar por parámetro el número de botones que tendrán)
     * @param numAscensor
     * @param numBotones
     */
    public Ascensor(int numAscensor, int numBotones) {
        this.numAscensor = numAscensor;

        this.botoneraExt = new BotoneraExt(numBotones);
        this.botoneraInt = new BotoneraInt(numBotones);
    }

    /**
     * Método para subir dos personas en el ascensor, abriendo la puerta para ello.
     * En caso de querer subir sólo una, dar valor null a la segunda.
     * @param persona1
     * @param persona2
     */
    public void subirPersona(Persona persona1, Persona persona2) {
        this.abierto=true;
        this.persona1 = persona1;
        this.persona2 = persona2;
    }

    /**
     * Método para sacar a las personas que puedan estar dentro del ascensor, 
     * dejándolo vacío y cerrado
     */
    public void bajarPersona() {
        this.persona1 = null;
        this.persona2 = null;
        this.botoneraExt.setActivado(false);
        this.botoneraInt.setActivado(false);
        this.abierto=false;
    }

    /**
     * Desplaza el ascensor ,en caso de que la botonera interior o exterior esté 
     * activada, a la planta que haya sido seleccionada en la botonera activa
     * @return planta actual del ascensor
     */
    public int desplazarse() {
        if (this.botoneraInt.isActivado()) {
            this.plantaActual = this.botoneraInt.getNumPlantaActivado();
            this.botoneraInt.setActivado(false);
        }
        else if (this.botoneraExt.isActivado()){
            this.plantaActual=this.botoneraExt.getNumPlantaActivado();
            this.botoneraExt.setActivado(false);
        }
        return this.plantaActual;
    }
}
