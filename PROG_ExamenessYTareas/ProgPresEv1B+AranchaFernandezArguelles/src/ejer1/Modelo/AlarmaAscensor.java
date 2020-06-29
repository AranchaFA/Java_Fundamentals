package ejer1.Modelo;

public class AlarmaAscensor {

    // ATRIBUTOS
    private String nombreUbicacion;
    private boolean activo;
    private float valorActivacion;

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public float getValorActivacion() {
        return valorActivacion;
    }

    public void setValorActivacion(float valorActivacion) {
        this.valorActivacion = valorActivacion;
    }

    @Override
    public String toString() {
        return "AlarmaAscensor{" + "nombreUbicacion=" + nombreUbicacion + ", activo=" + activo + ", valorActivacion=" + valorActivacion + '}';
    }

    public AlarmaAscensor(String nombreUbicacion, float valorActivacion) {
        this.nombreUbicacion = nombreUbicacion;
        this.valorActivacion = valorActivacion;
    }

    public boolean activar(float valor) {
        if (this.valorActivacion > valor) {
            this.activo = true;
        } else {
            this.activo = false;
        }
        return this.activo;
    }
    
    public void desactivar(){
        this.activo=false;
    }
}
