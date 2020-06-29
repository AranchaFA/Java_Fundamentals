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
public class ContadorCreditos {
    
    // ATRIBUTOS
    private int cantidadCreditos;
    
    // MÉTODOS
    // Getters + Setters
    public int getCantidadCreditos() {
        return cantidadCreditos;
    }

    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }
    // toString
    @Override
    public String toString() {
        return "ContadorCreditos{" + "cantidadCreditos=" + cantidadCreditos + '}';
    }
    // Constructor (por defecto 0 créditos)
    public ContadorCreditos() {
    }
    /**
     * Método para sumar créditos
     * devuelve el número de créditos totales finales
     */
    public int sumarCreditos(int cantidadCreditos){
        this.cantidadCreditos+=cantidadCreditos;
        return this.cantidadCreditos;
    }
    /**
     * Método para restar créditos (los créditos se restarán de 1 en 1, 
     * pues se emplea sólo 1 crédito en cada jugada)
     * devuelve el número de créditos totales finales
     */
    public int restarCreditos(){
        this.cantidadCreditos--;
        return this.cantidadCreditos;
    }
}
