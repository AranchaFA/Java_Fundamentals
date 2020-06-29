/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;

/**
 * Class JugadorJuegoCartas que permite crear objetos jugador
 * @author rpe
 */
public class JugadorJuegoCartas {
    private Jugador jugador;
    private LinkedList<Carta> coleccionCartas;


    /**
     * Constructor de la clase donde es necesario enviar el nombre del jugador
     * @param nombre String con el nombre del jugador 
     */
    public JugadorJuegoCartas(String nombre) {
        this.jugador  = new Jugador (nombre);
        coleccionCartas = new LinkedList<>();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public LinkedList<Carta> getColeccionCartas() {
        return coleccionCartas;
    }

    public void setColeccionCartas(LinkedList<Carta> coleccionCartas) {
        this.coleccionCartas = coleccionCartas;
    }

    
    //añadir carta a mazo del jugador
    public void anhadirCartaMazo(Carta c){
        coleccionCartas.addFirst(c);
    }
    
    //sacar carta del mazo
    public Carta tirarCartaDelMazo(){
       
       return coleccionCartas.removeFirst();      
    }
    
    @Override
    public String toString() {
        return "JugadorJuegoCartas{" + "jugador=" + jugador + ", coleccionCartas=" + coleccionCartas + '}';
    }

    
}
