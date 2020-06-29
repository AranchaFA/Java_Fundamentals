
package Modelo;

public class Color {
    
    // ATRIBUTOS
    private String nombre;
    private int componenteR;
    private int componenteG;
    private int componenteB;
    
    // MÉTODOS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getComponenteR() {
        return componenteR;
    }

    public void setComponenteR(int componenteR) {
        this.componenteR = componenteR;
    }

    public int getComponenteG() {
        return componenteG;
    }

    public void setComponenteG(int componenteG) {
        this.componenteG = componenteG;
    }

    public int getComponenteB() {
        return componenteB;
    }

    public void setComponenteB(int componenteB) {
        this.componenteB = componenteB;
    }

    @Override
    public String toString() {
        return "Color{" + "nombre=" + nombre + ", componenteR=" + componenteR + ", componenteG=" + componenteG + ", componenteB=" + componenteB + '}';
    }

    public Color(String nombre) {
        this.nombre = nombre;
    }

    public Color(int componenteR, int componenteG, int componenteB) {
        this.componenteR = componenteR;
        this.componenteG = componenteG;
        this.componenteB = componenteB;
    }
    
}
