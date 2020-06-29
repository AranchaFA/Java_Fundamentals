/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Depósito de agua para cafetera
 * @author Arancha
 */
public class DepositoAgua {
    
    private int maxCafes;
    private int numCafesRestantes;

    /**
     * Constructor por defecto que nos crea un depósito con capacidad para 20 
     * cafés espressos. El número de cafés restantes se creará por defecto a 0 
     * (se creará vacía).
     */
    public DepositoAgua() {
    }

    /**
     * Constructor que nos permita crear un depósito con capacidad máxima para 
     * el número de cafés que nosotros deseemos, pasándolo por parámetro. Se 
     * creará vacío (numCafesRestantes = 0).
     * @param maxCafes
     */
    public DepositoAgua(int maxCafes) {
        this.maxCafes = maxCafes;
    }
    
    /**
     * Devuelve el número de cafés que puede realizar con la carga que tiene 
     * tras rellenar.
     * @return
     */
    public int llenarDeposito (){
        
    }
}
