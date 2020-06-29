/*
Clase para crear puntos (x,y).
 */

/**
 *
 * @author Arancha
 */
public class Punto {
    
    // ATRIBUTOS
    
    private float x;
    private float y;
    
    // MÉTODOS
    
    // Mostrar valor de los atributos:
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    
    // Asignar valor a los atributos:
    public void setX(float numero){
        x=numero;
    }
    public void setY(float numero){
        y=numero;
    }
    
    // Visualizar por pantalla los atributos
    // Forma 1:
    public void mostrarAtributos1(){
        System.out.println("x="+x+" y="+y);
    }
    // Forma 2:
    public String mostrarAtributos2(){
        String coordenadas=new String();
        coordenadas="x="+x+" y="+y;
        return coordenadas;
    }
}
