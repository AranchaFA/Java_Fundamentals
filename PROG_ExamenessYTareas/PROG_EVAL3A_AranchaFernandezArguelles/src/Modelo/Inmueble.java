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
public abstract class Inmueble implements AlquilableVendible {

    // ATRIBUTOS
    protected String id;

    // MÉTODOS
    // Getters + Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // toString
    @Override
    public String toString() {
        return "Inmueble{" + "id=" + id + '}';
    }

    // Constructor
    public Inmueble(String id) {
        this.id = id;
    }

}
