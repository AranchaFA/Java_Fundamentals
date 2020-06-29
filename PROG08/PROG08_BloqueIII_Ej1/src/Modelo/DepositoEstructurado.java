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
public class DepositoEstructurado extends Deposito {

    // ATRIBUTOS
    private float porcentajeVariable; // % del capital total que será variable
    private float tipoInteresVariable; // tipo de interés a aplicar al tramo variable

    // MÉTODOS
    // Getters + Setters
    public float getPorcentajeVariable() {
        return porcentajeVariable;
    }

    public void setPorcentajeVariable(float porcentajeVariable) {
        this.porcentajeVariable = porcentajeVariable;
    }

    public float getTipoInteresVariable() {
        return tipoInteresVariable;
    }

    public void setTipoInteresVariable(float tipoInteresVariable) {
        this.tipoInteresVariable = tipoInteresVariable;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\nDepositoEstructurado{" + "porcentajeVariable=" + porcentajeVariable + ", tipoInteresVariable=" + tipoInteresVariable + '}';
    }

    //Constructor
    public DepositoEstructurado(String titular, float capital, float tipoInteres, int plazoDias, float porcentajeVariable, float tipoInteresVariable) {
        super(titular, capital, tipoInteres, plazoDias);
        this.porcentajeVariable=porcentajeVariable;
        this.tipoInteresVariable=tipoInteresVariable;
    }

    // Sobreescribimos el método para calcular los intereses

    @Override
    public float calcularIntereses() {
        float interesesFijos=this.plazoDias*this.capital*(1-(this.porcentajeVariable/100))*(this.tipoInteres/100)/365;
        float interesesVariables=this.plazoDias*this.capital*(this.porcentajeVariable/100)*(this.tipoInteresVariable/100)/365;
        return interesesFijos+interesesVariables;
    }
    
}
