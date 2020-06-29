
package Modelo;

public class LlamadaLocal extends Llamada{
    
    // ATRIBUTOS
    private int precio; // Precio en céntimos/min
    
    // MÉTODOS
    // Getters + Setters
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    // toString
    @Override
    public String toString() {
        return super.toString()+"\nLlamadaLocal{" + "precio=" + precio + '}';
    }
    
    // Construtores
    public LlamadaLocal(String numeroOrigen, String numeroDestino, int duracion) {
        super(numeroOrigen, numeroDestino, duracion);
        this.precio=15;
    }

    // Calcular coste
    @Override
    public int calcularCoste() {
        return (this.precio*super.getDuracion()/60); // Coste en céntimos
    }
    
}
