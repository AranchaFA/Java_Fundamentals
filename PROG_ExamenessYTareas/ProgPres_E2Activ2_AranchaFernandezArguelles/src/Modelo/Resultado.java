
package Modelo;

import java.io.Serializable;

public class Resultado implements Serializable{
    
    // ATRIBUTOS
    private String nombreJugador;
    private int importeInicial;
    private int numPremio1,numPremio2,numPremio3;
    private int premioTotal;

    
    // MÉTODOS
    // Getters + Setters
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getImporteInicial() {
        return importeInicial;
    }

    public void setImporteInicial(int importeInicial) {
        this.importeInicial = importeInicial;
    }

    public int getNumPremio1() {
        return numPremio1;
    }

    public void setNumPremio1(int numPremio1) {
        this.numPremio1 = numPremio1;
    }

    public int getNumPremio2() {
        return numPremio2;
    }

    public void setNumPremio2(int numPremio2) {
        this.numPremio2 = numPremio2;
    }

    public int getNumPremio3() {
        return numPremio3;
    }

    public void setNumPremio3(int numPremio3) {
        this.numPremio3 = numPremio3;
    }

    public int getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(int premioTotal) {
        this.premioTotal = premioTotal;
    }

    @Override
    public String toString() {
        return "Resultado{" + "nombreJugador=" + nombreJugador + ", importeInicial=" + importeInicial + ", numPremio1=" + numPremio1 + ", numPremio2=" + numPremio2 + ", numPremio3=" + numPremio3 + ", premioTotal=" + premioTotal + '}';
    }

    
    /**
     * Constructor para un resultado de una jugada que se creará al seleccionar hacer
     * una jugada en el menú de la tragaperras que pediremos el nombre y el importe a jugar
     * 
     * @param nombreJugador
     * @param importeInicial 
     */
    public Resultado(String nombreJugador, int importeInicial) {
        this.nombreJugador = nombreJugador;
        this.importeInicial = importeInicial;
    }
    
    /**
     * Métodos que suman a los atributos los premios ganados
     */   
    public void sumarPremio1(int valorPremio1){
        numPremio1++;
        premioTotal+=valorPremio1;
    }
    public void sumarPremio2(int valorPremio2){
        numPremio2++;
        premioTotal+=valorPremio2;
    }
    public void sumarPremio3(int valorPremio3){
        numPremio3++;
        premioTotal+=valorPremio3;
    }
    public void restarPremio1(int valorPremio1){
        numPremio1--;
        premioTotal-=valorPremio1;
    }
    
    public void restarPremio2(int valorPremio2){
        numPremio2--;
        premioTotal-=valorPremio2;
    }
    
}
