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
public abstract class Ventana {
    
    // ATRIBUTOS
    protected int id;
    protected boolean bloqueada;

    // MÉTODOS
    // Getters + Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    // toString
    @Override
    public String toString() {
        return "Ventana{" + "id=" + id + ", bloqueada=" + bloqueada + '}';
    }

    // Constructores
    public Ventana(int id) {
        this.id = id;
        this.bloqueada = false;
    }

    // Bloquear y Desbloquear
    public abstract void bloquear();
    public abstract void desbloquear();
}

