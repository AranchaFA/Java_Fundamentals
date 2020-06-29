/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Arancha
 */
public class DepositoMonedas {
    
    // ATRIBUTOS
    private int valorMonedas;
    
    // MÉTODOS
    // Getters + Setters
    public int getValorMonedas() {
        return valorMonedas;
    }

    public void setValorMonedas(int valorMonedas) {
        this.valorMonedas = valorMonedas;
    }
    // toString
    @Override
    public String toString() {
        return "DepositoMonedas{" + "valorMonedas=" + valorMonedas + '}';
    }
    /**
     * Constructor pasando como parámetro la cantidad inicial de monedas
     */
    public DepositoMonedas(int valorMonedas) {
        this.valorMonedas = valorMonedas;
    }
    /**
     * Método para sacar monedas
     * devuelve el valor de las monedas sacadas
     */
    public int sacarMonedas(int valorPremio){
        valorMonedas-=valorPremio;
        return valorPremio;
    }
    /**
     * Método para introducir monedas
     * devuelve el valor de las monedas introducidas
     */
    public int meterMonedas(int valorMonedas){
        this.valorMonedas+=valorMonedas;
        return valorMonedas;
    }
}
