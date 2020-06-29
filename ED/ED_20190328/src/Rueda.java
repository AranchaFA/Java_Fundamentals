
/**
 * Ruedas de vehiculo
 * @author Arancha
 */
public class Rueda {
    
    private int ancho;
    private int llanta;
    private int totalKilometros;
    private int presion;
    
    

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLlanta() {
        return llanta;
    }

    public void setLlanta(int llanta) {
        this.llanta = llanta;
    }

    public int getTotalKilometros() {
        return totalKilometros;
    }

    public void setTotalKilometros(int totalKilometros) {
        this.totalKilometros = totalKilometros;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }
    
    public Rueda(int ancho, int llanta, int presion) {
        this.ancho = ancho;
        this.llanta = llanta;
        this.totalKilometros=0;
        this.presion = presion;
    }
    
    
}
