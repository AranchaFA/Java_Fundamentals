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
public class Slot {

    // ATRIBUTO
    private int valor;
    private String dibujo;

    // MÉTODOS
    // Getters + Setters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDibujo() {
        return dibujo;
    }

    public void setDibujo(String dibujo) {
        this.dibujo = dibujo;
    }

    // toString
    @Override
    public String toString() {
        return "Slot{" + "valor=" + valor + ", dibujo=" + dibujo + '}';
    }

    /**
     * Constructor (por defecto los atributos a 0
     */
    public Slot() {
    }

    /**
     * Método para girar el slot Devuelve el resultado: un valor aleatorio enrte
     * 0 y 9 Asigna el dibujo que sale según el valor ☺☻♀♂♠♣♥♦♪♫
     */
    public int girarSlot() {
        valor = (int) (Math.random() * 10);

        switch (valor) {
            case 0:
                this.dibujo = "☺";
                break;
            case 1:
                this.dibujo = "☻";
                break;
            case 2:
                this.dibujo = "♀";
                break;
            case 3:
                this.dibujo = "♂";
                break;
            case 4:
                this.dibujo = "♠";
                break;
            case 5:
                this.dibujo = "♣";
                break;
            case 6:
                this.dibujo = "♥";
                break;
            case 7:
                this.dibujo = "♦";
                break;
            case 8:
                this.dibujo = "♪";
                break;
            case 9:
                this.dibujo = "♫";
                break;
        }
        
        return valor;
    }

    /**
     * Método para comparar el valor de dos slots true = iguales false =
     * diferentes
     */
    public boolean compararSlots(Slot slot) {
        if (this.valor == slot.getValor()) {
            return true;
        } else {
            return false;
        }
    }
}
