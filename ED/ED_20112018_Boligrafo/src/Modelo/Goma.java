
package Modelo;

class Goma {
    
    // ATRIBUTOS
    private float cantidadInicial;
    private  float cantidadRestante;
    private Color color;
    
    // MÉTODOS

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Goma{" + "cantidadInicial=" + cantidadInicial + ", cantidadRestante=" + cantidadRestante + ", color=" + color + '}';
    }

    public Goma(float cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }
    
    public String borrar(int numeroCaracteres,int posicionInicio,int papel,int sentido){
        String textoBorrado = null;
        
        return textoBorrado;
    }
}
