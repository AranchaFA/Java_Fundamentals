
package Modelo;

public class PuertaManual extends Puerta{

    // MÉTODOS
    // toString 
    @Override
    public String toString() {
        return super.toString()+" PuertaManual{" + '}';
    }
    
    // Constructor
    public PuertaManual(int id) {
        super(id);
    }

    // Bloquear o Desbloquear
    @Override
    public void bloquear() {
        bloqueada=true;
    }
    
    @Override
    public void desbloquear() {
        bloqueada=false;
    }
    
    
    
}
