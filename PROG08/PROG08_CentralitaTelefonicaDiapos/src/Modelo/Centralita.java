
package Modelo;

import java.util.LinkedList;

public class Centralita {
    
    // ATRIBUTOS
    protected int totalLlamadas;
    protected int costeTotal;
    protected LinkedList<Llamada> llamadas;
 
    // MÉTODOS
    // Getters + Setters
    public int getTotalLlamadas() {
        return totalLlamadas;
    }

    public void setTotalLlamadas(int totalLlamadas) {
        this.totalLlamadas = totalLlamadas;
    }

    public int getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(int costeTotal) {
        this.costeTotal = costeTotal;
    }

    public LinkedList<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(LinkedList<Llamada> llamadas) {
        this.llamadas = llamadas;
    }
    
    // toString
    @Override
    public String toString() {
        return "Centralita{" + "totalLlamadas=" + totalLlamadas + ", costeTotal=" + costeTotal + ", llamadas=" + llamadas + '}';
    }
    
    // Constructor
    public Centralita() {
        this.llamadas=new LinkedList<>();
    }
    
    // Registrar llamada
    public void registrarLlamada(Llamada llamada){
        this.costeTotal+=llamada.calcularCoste();
        this.totalLlamadas++;
        this.llamadas.addFirst(llamada);
        // Mostramos la llamada a registrar
        System.out.println("Llamada registrada:\n"+llamada.toString());
    }
    
    // Mostrar colección de llamadas
    public void mostrarRegistroLlamadas(){
        System.out.println("MOSTRANDO LISTADO DE LLAMADAS REGISTRADAS:");
        for (Llamada llamada : llamadas) {
            System.out.println(llamada.toString());
        }
        System.out.println("");
    }
}
