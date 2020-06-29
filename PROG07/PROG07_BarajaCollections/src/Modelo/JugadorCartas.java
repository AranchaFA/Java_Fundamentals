
package Modelo;

import java.util.*;

public class JugadorCartas {
    
    // ATRIBUTOS
    private String nombre;
    private LinkedList<Carta> mazo;
    
    
    // MÉTODOS
    // Getter + Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(LinkedList<Carta> mazo) {
        this.mazo = mazo;
    }
    
    // toString
    @Override
    public String toString() {
        return "JugadorCartas{" + "nombre=" + nombre + ", listCartas=" + mazo + '}';
    }
 
    // Constructor
    public JugadorCartas(String nombre) {
        this.nombre = nombre;
        // Creamos la colección de cartas
        mazo=new LinkedList<>();
    }
    
    // Añadir una carta al taaco del jugador (al principio del mazo)
    public void anhadirCartaAlMazo(Carta carta){
        mazo.addFirst(carta);
    }
    
    // Quitar una carta del mazo del jugador (la primera)
    public Carta quitarUnaCartaDelMazo(){
        Carta cartaCogida;
        cartaCogida=mazo.removeFirst();
        return cartaCogida;
        // return mazo.removeFirst();
    }
    
    // Mostrar mazo
    public void mostrarMazo() {
        for (Carta carta : mazo) {
            System.out.print(carta.toString()+" ");
        }
    }
}
