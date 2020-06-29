/*

 */
package Modelo;

public class Motor {
    
    // ATRIBUTOS
    
    private double litrosAceite;
    private int cv;
    
    // MÉTODOS
    
    // Setters
    
    public void setLitrosAceite(double x){
        litrosAceite=x;
    }
    public void setCV(int x){
        cv=x;
    }
    
    //Getters
    
    public double getLitrosAceite(){
        return litrosAceite;
    }
    public int getCV(){
        return cv;
    }  
    
}
