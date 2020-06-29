package Modelo;

public class VOSocio {

    // ATRIBUTOS
    private float cod_socio;
    private String nombre;
    private String direccion;
    private String provincia;
    private float tlf;

    // MÉTODOS
    // Getters + Setters
    public float getCod_socio() {
        return cod_socio;
    }

    public void setCod_socio(float cod_socio) {
        this.cod_socio = cod_socio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public float getTlf() {
        return tlf;
    }

    public void setTlf(float tlf) {
        this.tlf = tlf;
    }

    // toString
    @Override
    public String toString() {
        return "VOSocio{" + "cod_socio=" + cod_socio + ", nombre=" + nombre + ", direccion=" + direccion + ", provincia=" + provincia + ", tlf=" + tlf + '}';
    }

    // Constructor
    public VOSocio(float cod_socio, String nombre, String direccion, String provincia, float tlf) {
        this.cod_socio = cod_socio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.provincia = provincia;
        this.tlf = tlf;
    }

    // equals + hashCode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Float.floatToIntBits(this.cod_socio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VOSocio other = (VOSocio) obj;
        if (Float.floatToIntBits(this.cod_socio) != Float.floatToIntBits(other.cod_socio)) {
            return false;
        }
        return true;
    }
    
}
