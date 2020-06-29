/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Arancha
 */
public class SensorLuz extends Sensor{
    
    // ATRIBUTOS
    // Sin atributos específicos
    // MÉTODOS
    // Getters + Setters
    // Sin getters/setters específicos
    // toString
    // Sobreescribimos sólo para mostrar la clase de la instancia
    @Override
    public String toString() {
        return super.toString() + this.getClass().getSimpleName();
    }

    // Constructor
    public SensorLuz(int numID) {
        super(numID);
        this.unidadesMedida = "lumens";
    }

    @Override
    public double tomarMedicion() {
        double media;
        double primerValor;
        double signo;

        // Calculamos un valor inicial dentro del rango
        primerValor = 0 + Math.random() * 20001;
        media = primerValor / 10;

        // Calculamos el valor absoluto de las 9 mediciones siguientes
        for (int i = 0; i < 9; i++) {
            // Controlamos que el valor medido no se salga de los rangos, si se excede
            // repetimos la medición
            double siguienteValor;
            do {
                // Calculamos un signo aleatorio el incremento/decremento del valor inicial
                if (Math.random() * 2 == 1) {
                    signo = 1;
                } else {
                    signo = -1;
                }
                // Calculamos el incremento/decremento final
                siguienteValor = primerValor + signo * Math.random() * 1001;
                // Lo sumamos a la media a calcular
                
            } while (siguienteValor > 0 || siguienteValor < 20000);
            media += siguienteValor / 10;
        }
        return media;
    }
    
}
