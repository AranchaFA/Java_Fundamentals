/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Depósito de cápsulas usadas de una cafetera
 *
 * @author Arancha
 */
public class DepositoCapsulasUsadas {

    private int MaxCapsulas;
    private int numCapsulas;

    /**
     *  * Constructor por defecto para un depósito con capacidad para 10
     * cápsulas usadas.
     */
    public DepositoCapsulasUsadas() {
        this.MaxCapsulas = 10;
    }

    /**
     * * Constructor para un depósito con capacidad para tantas cápsulas usadas
     * como nosotros definamos, pasándole este valor por parámetro.
     *
     * @param MaxCapsulas
     */
    public DepositoCapsulasUsadas(int MaxCapsulas) {
        this.MaxCapsulas = MaxCapsulas;
    }

    /**
     * Devuelve el número de cápsulas totales que se encuentran en el depósito
     * tras meter la cápcula. Las cápsulas sólo pueden ser introducidas de una
     * en una, luego no hace falta pasar parámetros.
     *
     * @return
     */
    public int recibirCapsula() {
    }

    /**
     *
     * Nos devuelve el número de cápculas que había en el depósito en el momento
     * de vaciarlo.
     *
     * @return
     */
    public int vaciarDeposito() {
    }

}
