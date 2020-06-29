
package Modelo;

public class Papel {
    
    // ATRIBUTOS
    private String formato;
    private int capacidadCaracteres;
    private String textoContenido;
    private Color colorPapel;
    
    // MÉTODOS

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getCapacidadCaracteres() {
        return capacidadCaracteres;
    }

    public void setCapacidadCaracteres(int capacidadCaracteres) {
        this.capacidadCaracteres = capacidadCaracteres;
    }

    public String getTextoContenido() {
        return textoContenido;
    }

    public void setTextoContenido(String textoContenido) {
        this.textoContenido = textoContenido;
    }

    public Color getColorPapel() {
        return colorPapel;
    }

    public void setColorPapel(Color colorPapel) {
        this.colorPapel = colorPapel;
    }

    @Override
    public String toString() {
        return "Papel{" + "formato=" + formato + ", capacidadCaracteres=" + capacidadCaracteres + ", textoContenido=" + textoContenido + ", colorPapel=" + colorPapel + '}';
    }

    public Papel(String formato, int capacidadCaracteres) {
        this.formato = formato;
        this.capacidadCaracteres = capacidadCaracteres;
    }
    
    public String leer(int posicionInicio,int posicionFinal){
        String textoLeido="";
        // Todavía no lo podemos programar
        return textoLeido;
    }
}
