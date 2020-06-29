/*

 */
package Modelo;

/**
 *
 * @author Arancha
 */
public class Coche {
    // ATRIBUTOS
    private Motor motor;
    private String marca;
    private String modelo;
    private float importeAcumuladoAverias;
    
    // MÉTODOS
    // getters para todo
    public Motor getMotor() {
        return motor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public float getImporteAcumuladoAverias() {
        return importeAcumuladoAverias;
    }
    
    // Setter para el motor que nos hará falta en el apartado 3

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    // Constructor
    public Coche(String marca, String modelo){
        this.marca=marca;
        this.modelo=modelo;
    }
    
    // Método que vaya sumando los gastos en averías
    public float acumularAveria(float precio){
        this.importeAcumuladoAverias+=precio;
        return importeAcumuladoAverias;
    }

    @Override
    public String toString() {
        return "Coche{" + "motor=" + motor + ", marca=" + marca + ", modelo=" + modelo + ", importeAcumuladoAverias=" + importeAcumuladoAverias + '}';
    }
    
    
}
