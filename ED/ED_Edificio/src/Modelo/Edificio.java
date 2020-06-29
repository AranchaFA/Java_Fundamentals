/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Edificio con dos ascensores
 *
 * @author Arancha
 */
public class Edificio {

    private int numPlantas;
    private Ascensor ascensor1;
    private Ascensor ascensor2;

    /**
     * Da el número de plantas del edificio
     * @return número de plantas del edificio
     */
    public int getNumPlantas() {
        return numPlantas;
    }

    /**
     *
     * @param numPlantas
     */
    public void setNumPlantas(int numPlantas) {
        this.numPlantas = numPlantas;
    }

    /**
     * Devuelve el ascensor nº1 del edificio
     * @return ascensor nº1 del edificio
     */
    public Ascensor getAscensor1() {
        return ascensor1;
    }

    /**
     *
     * @param ascensor1
     */
    public void setAscensor1(Ascensor ascensor1) {
        this.ascensor1 = ascensor1;
    }

    /**
     * Devuelve el ascensor nº2 del edificio
     * @return ascensor nº2 del edificio
     */
    public Ascensor getAscensor2() {
        return ascensor2;
    }

    /**
     *
     * @param ascensor2
     */
    public void setAscensor2(Ascensor ascensor2) {
        this.ascensor2 = ascensor2;
    }

    @Override
    public String toString() {
        return "Edificio{" + "numPlantas=" + numPlantas + ", ascensor1=" + ascensor1 + ", ascensor2=" + ascensor2 + '}';
    }

    /**
     * Constructor pasando el número de plantas que tendrá el edificio como parámetro.
     * Se crean los dos ascensores que tendrá el edificio, con sus números identificativos
     * y el número de botones (numPlantas) que tendrán sus botoneras.
     * @param numPlantas
     */
    public Edificio(int numPlantas) {
        this.numPlantas = numPlantas;

        this.ascensor1 = new Ascensor(1, numPlantas);
        this.ascensor2 = new Ascensor(2, numPlantas);
    }

    /**
     * Método para el uso del ascensor (implementa todo el proceso completo)
     * @param numAscensor
     * @param numPlantaOrigen
     * @param numPlantaDestino
     * @param persona1
     * @param persona2
     * @return Planta actual del ascensor tras aplicar el métdo
     */
    public int usarAscensor(int numAscensor, int numPlantaOrigen, int numPlantaDestino, Persona persona1, Persona persona2) {
        int auxPlantaActual = 0;
        if (this.ascensor1.getNumAscensor() == numAscensor) {
            this.ascensor1.getBotoneraExt().activarBoton(numPlantaOrigen);
            this.ascensor1.desplazarse();
            this.ascensor1.subirPersona(persona1, persona2);
            this.ascensor1.getBotoneraInt().activarBoton(numPlantaDestino);
            this.ascensor1.desplazarse();
            this.ascensor1.bajarPersona();

            auxPlantaActual = this.ascensor1.getPlantaActual();
        } else if (this.ascensor2.getNumAscensor() == numAscensor) {
            this.ascensor2.getBotoneraExt().activarBoton(numPlantaOrigen);
            this.ascensor2.desplazarse();
            this.ascensor2.subirPersona(persona1, persona2);
            this.ascensor2.getBotoneraInt().activarBoton(numPlantaDestino);
            this.ascensor2.desplazarse();
            this.ascensor2.bajarPersona();

            auxPlantaActual = this.ascensor2.getPlantaActual();
        }
        return auxPlantaActual;
    }

}
