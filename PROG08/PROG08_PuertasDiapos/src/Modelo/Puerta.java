package Modelo;

public abstract class Puerta {

    // ATRIBUTOS
    protected int id;
    protected boolean bloqueada;

    // MÉTODOS
    // Getters + Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    // toString
    @Override
    public String toString() {
        return "Puerta{" + "id=" + id + ", bloqueada=" + bloqueada + '}';
    }

    // Constructores
    public Puerta(int id) {
        this.id = id;
        this.bloqueada = false;
    }

    // Bloquear y Desbloquear
    public abstract void bloquear();
    public abstract void desbloquear();
}
