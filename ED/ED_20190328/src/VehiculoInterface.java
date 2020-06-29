
public interface VehiculoInterface {
    /**
     * Mueve un vehículo
     * @param destino
     * @return nueva posición del vehículo
     */
    Vector mover(Vector destino);
    /**
     * Desplaza un vehículo
     * @param desplazamiento
     * @return nueva posición del vehículo
     */
    Vector desplazar(Vector desplazamiento);
}
