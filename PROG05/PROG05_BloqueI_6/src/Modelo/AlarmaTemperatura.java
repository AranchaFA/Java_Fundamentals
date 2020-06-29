
package Modelo;

public class AlarmaTemperatura {
    
    private int temperaturaActual;
    private int temperaturaAlarma;
    private Timbre timbre;

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

    public Timbre getTimbre() {
        return timbre;
    }

    public void setTimbre(Timbre timbre) {
        this.timbre = timbre;
    }

    @Override
    public String toString() {
        return "AlarmaTemperatura{" + "temperaturaActual=" + temperaturaActual + ", temperaturaAlarma=" + temperaturaAlarma + ", timbre=" + timbre + '}';
    }

    public AlarmaTemperatura(int temperaturaAlarma) {
        this.temperaturaAlarma = temperaturaAlarma;
        this.timbre=new Timbre();
    }
    
    // Comprueba si la temperatura alcanza el nivel fijado como máximo y activa
    // el timbre. Devuelve si el timbre queda activado (true) o desactivado (false)
    public boolean comprobarTemperatura(){
        boolean auxReturn;
        if (this.temperaturaActual>=this.temperaturaAlarma) {
            this.getTimbre().activar();
            auxReturn=true;
            
        } else {
            this.getTimbre().desactivar();
            auxReturn=false;
        }
        return auxReturn;
    }
}
