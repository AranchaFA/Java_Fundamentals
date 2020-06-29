package Modelo;

public class PuertaAutomatica extends Puerta implements Automatizable{

    // MÉTODOS
    // toString
    @Override
    public String toString() {
        return super.toString() + " PuertaAutomatica{" + '}';
    }

    // Constructores
    public PuertaAutomatica(int id) {
        super(id);
    }

    // Bloquear o Desbloquear
    @Override
    public void bloquear() {
        bloqueada = true;
    }

    @Override
    public void desbloquear() {
        bloqueada = false;
    }

    // Bloquear o desbloquear de manera automática y selectiva
    public void timeOut(){
        if (bloqueada) {
            desbloquear();
        } else {
            bloquear();
        }
    }
}
