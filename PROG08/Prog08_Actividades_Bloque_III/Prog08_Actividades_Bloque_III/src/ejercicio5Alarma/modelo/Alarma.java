package ejercicio5Alarma.modelo;

public class Alarma {

    // ATRIBUTOS
    private Boolean alarma;
    private String motivo;

    // MÉTODOS
    // Constructor
    public Alarma() {
        this.alarma = false;
    }
    
    // Getters + Setters
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    
    public Boolean getAlarma() {
        return alarma;
    }

    public void setAlarma(Boolean alarma) {
        this.alarma = alarma;
    }

    // Métodos para activar / desactivar la alarma
    public void activarAlarma() {
        alarma = true;       
    }

    public void desactivarAlarma() {
        alarma = false;
        motivo = "";
    }
    
    // Método para mostrar el motivo de la activación de la alarma (pasado por parámetro)
    public void msgSocorro(String av) {
        motivo = av;
        System.out.println("¡¡¡SOS SOS!!!, " + motivo);
    }

    // toString
    @Override
    public String toString() {
        return "Alarma{" + "alarma=" + alarma + ", motivo=" + motivo + '}';
    }
    
    
}
