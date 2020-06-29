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
public class Carta {
    
     // ATRIBUTOS
    private String dibujoNumCarta;
    private int valorNumerico;
    private String palo;

    
    // MÉTODOS
    
    // Setters
    public void setDibujoNumCarta(String dibujoNumCarta) {
        this.dibujoNumCarta = dibujoNumCarta;
    }
    
    public void setValorNumerico(int valorNumerico) {
        this.valorNumerico=valorNumerico;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    // Getters
    public String getDibujoNumCarta() {
        return dibujoNumCarta;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }
    
    public String getPalo() {
        return palo;
    }

    // Mostrar atributos
    public void mostrarAtributos() {
        System.out.println("La carta es el "+dibujoNumCarta+" de "+palo);
    }
    
    public String verTodosLosAtributosCarta() {
        return "palo= "+palo+"\n"
                +"valorNumerico= "+valorNumerico+"\n"
                +"dibujoNumCarta= "+dibujoNumCarta+"\n";
    }
    public String verTodosLosAtributosCarta2() {
        String cadena="palo= "+palo+"\n"
                +"valorNumerico= "+valorNumerico+"\n"
                +"dibujoNumCarta= "+dibujoNumCarta+"\n";
        return cadena;
    }
    
    
}
