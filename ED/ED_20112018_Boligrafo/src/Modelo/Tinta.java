
package Modelo;

class Tinta {
    
    // ATRIBUTOS
    private Color color;
    private float cantidadInicial;
    private float cantidadRestante;
    
    // MÉTODOS

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(float cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public float getCantidadRestante() {
        return cantidadRestante;
    }

    public void setCantidadRestante(float cantidadRestante) {
        this.cantidadRestante = cantidadRestante;
    }

    @Override
    public String toString() {
        return "Tinta{" + "color=" + color + ", cantidadInicial=" + cantidadInicial + ", cantidadRestante=" + cantidadRestante + '}';
    }

    public Tinta(Color color, float cantidadInicial) {
        this.color = color;
        this.cantidadInicial = cantidadInicial;
    }
    
    
}
