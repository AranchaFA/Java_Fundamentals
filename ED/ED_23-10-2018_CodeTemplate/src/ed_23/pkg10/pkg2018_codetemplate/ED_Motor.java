/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_23.pkg10.pkg2018_codetemplate;

/**
 * Clase que representa un motor
 *
 * @author Arancha
 */
public class ED_Motor {

    int cv;
    float litrosAceite;
    String modelo;

    /**
     * Retorna el total de Watios (potencia en Watios)
     *
     * @return total de Watios (entero)
     */
    public int totalWatios() {
        return this.cv * 235;
    }

    /**
     * Retorna el total de CV
     *
     * @return total de CV
     */
    public int getCv() {
        return cv;
    }

    /**
     * Asigna el valor a CV
     *
     * @param cv
     */
    public void setCv(int cv) {
        this.cv = cv;
    }

    /**
     * Retorna el total de litros de aceite
     *
     * @return total de litrosAceite
     */
    public float getLitrosAceite() {
        return litrosAceite;
    }

    /**
     *
     * @param litrosAceite
     */
    public void setLitrosAceite(float litrosAceite) {
        this.litrosAceite = litrosAceite;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Si selecciono un texto y doy a la bombillita >> surround with /* */ me lo pone en comentario
}
