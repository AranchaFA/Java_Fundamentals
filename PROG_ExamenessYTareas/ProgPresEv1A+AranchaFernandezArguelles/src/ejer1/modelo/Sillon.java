package ejer1.modelo;

public class Sillon {

    // ATRIBUTOS
    private String id;
    private Persona usuario;
    private float precio;
    private float recaudacion;
    private int totalUsuarios;

    // MÉTODOS
    // Getters para todo
    public String getId() {
        return id;
    }

    public Persona getUsuario() {
        return usuario;
    }

    public float getPrecio() {
        return precio;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    // Setters para todo menos id que se asigna en constructor
    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setRecaudacion(float recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void setTotalUsuarios(int totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }

    @Override
    public String toString() {
        return "Sillon{" + "id=" + id + ", usuario=" + usuario + ", precio=" + precio + ", recaudacion=" + recaudacion + ", totalUsuarios=" + totalUsuarios + '}';
    }

    // Constructor con los valores iniciales PARA ESTE EJERCICIO
    // No establezco el precio como atributo constante para que sea más genérico
    public Sillon(String id) {
        this.id = id;
        this.precio = 2;
    }

    // Método para ocupar el sillón por un usuario y que nos devuelva
    // si ha podido ocuparlo o no
    public boolean ocuparSillon(Persona usuario) {
        if (this.usuario == null) {
            this.usuario = usuario;
            this.recaudacion += this.precio;
            this.totalUsuarios++;
            return true;
        } else {
            return false;
        }
    }

    // Método para desocupar el sillón
    public void desocuparSillon() {
        this.usuario = null;
    }
}
