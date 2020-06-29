package Modelo;

public class Aseo {

    // ATRIBUTOS
    private Persona usuario;
    private int totalUsuarios;
    private String sexoUsuarios;
    private final float precio = (float) 0.1;
    private float recaudacion;

    // MÉTODOS
    // Sólo getters, adjudicar valor al resto se hace con los métodos específicos
    public Persona getUsuario() {
        return usuario;
    }

    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public String getSexoUsuarios() {
        return sexoUsuarios;
    }

    public float getPrecio() {
        return precio;
    }

    // Constructor
    public Aseo() {
        this.usuario = null;
        this.totalUsuarios = 0;
        this.sexoUsuarios = "";
        this.recaudacion=0;
    }

    // toString
    @Override
    public String toString() {
        return "Aseo{" + "usuario=" + usuario + ", totalUsuarios=" + totalUsuarios + ", sexoUsuarios=" + sexoUsuarios + ", precio=" + precio + ", recaudacion=" + recaudacion + '}';
    }

    // Método para meter usuarios
    public boolean entrarUsuario(Persona usuario) {
        if (this.usuario == null) {
            this.usuario = usuario;
            this.totalUsuarios++;
            this.sexoUsuarios = this.sexoUsuarios.concat(usuario.getSexo());
            this.recaudacion += this.precio;
            return true;
        } else {
            return false;
        }
    }

    // Método para sacar usuarios
    public void salirUsuario() {
        this.usuario = null;
    }
}
