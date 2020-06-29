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
public class Deposito {

    // ATRIBUTOS
    protected String titular;
    protected float capital;
    protected float tipoInteres;
    protected int plazoDias;

    // MÉTODOS
    // Getters + Setters
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public float getCapital() {
        return capital;
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }

    public float getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(float tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public int getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(int plazoDias) {
        this.plazoDias = plazoDias;
    }

    // toString
    @Override
    public String toString() {
        return "Deposito{" + "titular=" + titular + ", capital=" + capital + ", tipoInteres=" + tipoInteres + ", plazoDias=" + plazoDias + '}';
    }

    // Constructor
    public Deposito(String titular, float capital, float tipoInteres, int plazoDias) {
        this.titular = titular;
        this.capital = capital;
        this.tipoInteres = tipoInteres;
        this.plazoDias = plazoDias;
    }

    // Calcular intereses al finalizar el plazo
    public float calcularIntereses(){
        float intereses=this.capital*this.plazoDias*(this.tipoInteres/100)/365;
        return intereses;
    }
    
    // Liquidar el depósito al finalizar el plazo
    public float liquidarDeposito(){
        float total=this.capital+calcularIntereses();
        this.capital=0;
        return total;
    }
}
