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
public class SensorPolvo extends Sensor{
    
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
    public SensorPolvo(int numID) {
        super(numID);
        this.unidadesMedida = "mg/m3";
    }

    @Override
    public double tomarMedicion() {
        double media;
        double primerValor;
        double signo;

        // Calculamos un valor inicial dentro del rango
        primerValor = 200 + Math.random() * 2801;
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
                siguienteValor = primerValor + signo * Math.random() * 501;
                // Lo sumamos a la media a calcular
                
            } while (siguienteValor > 3000 || siguienteValor < 200);
            media += siguienteValor / 10;
        }
        return media;
    }
}
