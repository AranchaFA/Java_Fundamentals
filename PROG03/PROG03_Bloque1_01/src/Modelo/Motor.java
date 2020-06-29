/*

 */
package Modelo;

/**
 *
 * @author Arancha
 */
public class Motor {
    
    // ATRIBUTOS
    private int cv;
    private float litrosAceite;
    
    // MÉTODOS

    public Motor(int cv) {
        this.cv = cv;
    }

    public int getCv() {
        return cv;
    }

    public float getLitrosAceite() {
        return litrosAceite;
    }

    public void setLitrosAceite(float litrosAceite) {
        this.litrosAceite = litrosAceite;
    }

    /*
    Hay que crear el método toString() para mostrar los valores más adelante en MainCoche,
    si no usa el toString por defecto de Object que sólo nos muestra el ID de referencia del objeto en cuestión
    */
    @Override // Sale cuandoa un método se hereda del padre y hace algo distinto en el padre que en el hijo
    public String toString() {
        return "Motor{" + "cv=" + cv + ", litrosAceite=" + litrosAceite + '}';
    }
    
    
}
