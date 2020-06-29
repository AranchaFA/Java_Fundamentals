package Modelo;

public class Timbre {

    // ATRIBUTOS
    private boolean activo;
    private String sonido;
    private int valorActivacion;
    // Variables para comprobar que se cumplen los porcentajes
    private int contadorTotal;
    private int contadorActivo;

    // MÉTODOS
    // Getters
    public boolean isActivo() {
        return activo;
    }

    public String getSonido() {
        return sonido;
    }

    public int getValorActivacion() {
        return valorActivacion;
    }

    public int getContadorTotal() {
        return contadorTotal;
    }

    public int getContadorActivo() {
        return contadorActivo;
    }
    
    // Setter para el valor de activación que definamos
    public void setValorActivacion(int valorActivacion) {
        this.valorActivacion = valorActivacion;
    }

    // Constructor (timbre desactivado por defecto)
    public Timbre() {
        this.activo = false;
        this.contadorActivo=0;
        this.contadorTotal=0;
    }

    // toString

    @Override
    public String toString() {
        return "Timbre{" + "activo=" + activo + ", sonido=" + sonido + ", valorActivacion=" + valorActivacion + ", contadorTotal=" + contadorTotal + ", contadorActivo=" + contadorActivo + '}';
    }

    // Método para comprobar si debe activarse según la señal de entrada
    public boolean activarse(int valorMedido) {
        if (this.valorActivacion > valorMedido) { // De 1 al porcentaje fijado
            this.activo=true;
            this.sonido = "RIIIIING";
            this.contadorActivo++;
            this.contadorTotal++;
            return true;
        } else {  // Del porcentaje fijado a 100
            this.activo=false;
            this.sonido="......";
            this.contadorTotal++;
            return false;
        }
    }
    
    // Método para comprobar los porcentajes
    public float porcentajeActivaciones(){
        // Hay que castear los contadores a float, si no redondea el resultado del cociente a 0 y siempre da 0%!!
        return ((float)this.contadorActivo/(float)this.contadorTotal)*100;
    }
}
