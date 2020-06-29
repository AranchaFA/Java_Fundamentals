/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmaTemperatura;

/**
 *
 * @author J
 */
public class AlarmaTemperatura {

    private int temperaturaActual;
    private int temperaturaAlarma;
    private Timbre timbreAlarma;

    public AlarmaTemperatura(int temperaturaAlarma) {
        this.temperaturaAlarma = temperaturaAlarma;
        temperaturaActual = 0;
        timbreAlarma = new Timbre();
    }

    public int getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(int temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }

    public int getTemperaturaAlarma() {
        return temperaturaAlarma;
    }

    public void setTemperaturaAlarma(int temperaturaAlarma) {
        this.temperaturaAlarma = temperaturaAlarma;
    }

    public Timbre getTimbreAlarma() {
        return timbreAlarma;
    }

    public void setTimbreAlarma(Timbre timbreAlarma) {
        this.timbreAlarma = timbreAlarma;
    }

    public void comprobarTemperaturaAlarma() {
        if (temperaturaActual >= temperaturaAlarma) {
            timbreAlarma.activar();
        } else {
            timbreAlarma.desactivar();
        }
    }

    @Override
    public String toString() {
        return "AlarmaTemperatura{" + "temperaturaActual=" + temperaturaActual + ", temperaturaAlarma=" + temperaturaAlarma + ", timbreAlarma=" + timbreAlarma.toString() + '}';
    }
    
}
