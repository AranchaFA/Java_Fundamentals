
package Modelo;

import java.util.*;
import java.util.List;

public class Baraja {
    
    // ATRIBUTOS
    // Las cartas serán una lista tipo arraylist porque nos permite trabajar como pila o cola
    // (sacar cartas por arriba y guardarlas por abajo)
    
    // Si la definimos como list genérica luego no nos deja usar addFirst o addLast en el constructor
    private LinkedList<Carta> listBaraja;
    
    
    // MÉTODOS
    // Getter + Setter

    public List<Carta> getBaraja() {
        return listBaraja;
    }

    public void setBaraja(LinkedList<Carta> baraja) {
        this.listBaraja = baraja;
    }
    
    // Mostrar baraja
    public void mostrarBaraja() {
        char paloActual=' ';
        for (Carta carta : listBaraja) {
            if (paloActual!=carta.getPalo()) {
                paloActual=carta.getPalo();
                System.out.println("\n");
            }
            System.out.print(carta.toString()+" ");
        }
    }
    
    // Constructor
    public Baraja() {
        // Usamos dos arrays para recorrer los distintos palos y valores de las cartas
        char[] palos = {'♦', '♠', '♥', '♣'};
        String[] dibujos = {"AS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // Inicializamos la lista que contendrá las cartas
        listBaraja=new LinkedList<>();
        // Vamos asignando cada carta al arraylist
        for (char palo : palos) {
            for (String dibujo : dibujos) {
                listBaraja.add(new Carta(palo, dibujo));
            }
        }
        /*
        for (int i = 0; i < palo.length; i++) {
            for (int j = 0; j < dibujo.length; j++) {
                this.listBaraja.add(new Carta(palo[i], dibujo[j]));
            }
        }
        */
    }
    
    // Repartir una carta de la baraja
    public Carta repartirUnaCarta(){
        return listBaraja.remove((int) (Math.random() * listBaraja.size()));
    }    
}
