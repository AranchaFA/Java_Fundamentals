
/**
 *
 * @author Arancha
 */
public abstract class Vehiculo implements VehiculoInterface {

    // ATRIBUTOS
    // Las variables static son propias de la clase, no de la instancia
    private static int totalVehiculos;
    private Vector posicion;
    private Vector velocidad;
    private int totalKilometros;

    // MÉTODOS
    // Getters + Setters

    /**
     *
     * @return
     */
    public static int getTotalVehiculos() {
        return totalVehiculos;
    }
    
    /**
     *
     * @param totalVehiculos
     */
    public static void setTotalVehiculos(int totalVehiculos) {
        Vehiculo.totalVehiculos = totalVehiculos;
    }
    
    /**
     *
     * @return
     */
    public Vector getPosicion() {
        return posicion;
    }
    
    /**
     *
     * @param posicion
     */
    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }
    
    /**
     *
     * @return
     */
    public Vector getVelocidad() {
        return velocidad;
    }
    
    /**
     *
     * @param velocidad
     */
    public void setVelocidad(Vector velocidad) {
        if (!(velocidad.componenteX > 100 || velocidad.componenteY > 100)) {
            this.velocidad = velocidad;
        }
    }
    
    /**
     *
     * @return
     */
    public int getTotalKilometros() {
        return totalKilometros;
    }
    
    /**
     *
     * @param totalKilometros
     */
    public void setTotalKilometros(int totalKilometros) {
        this.totalKilometros = totalKilometros;
    }

    // Constructor

    /**
     *
     * @param posicion
     */
    public Vehiculo(Vector posicion) {
        this.posicion = posicion;
    }
    
}
