package Modelo;

public class VOSocio {

    // ATRIBUTOS
    private double cod_socio;
    private String nombre;
    private String direccion;
    private String provincia;
    private double tlf;

    // MÉTODOS
    // Getters + Setters
    public double getCod_socio() {
        return cod_socio;
    }

    public void setCod_socio(double cod_socio) {
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

    public double getTlf() {
        return tlf;
    }

    public void setTlf(double tlf) {
        this.tlf = tlf;
    }

    // toString
    @Override
    public String toString() {
        return "VOSocio{" + "cod_socio=" + cod_socio + ", nombre=" + nombre + ", direccion=" + direccion + ", provincia=" + provincia + ", tlf=" + tlf + '}';
    }

    // Constructor
    public VOSocio(double cod_socio, String nombre, String direccion, String provincia, double tlf) {
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
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.cod_socio) ^ (Double.doubleToLongBits(this.cod_socio) >>> 32));
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
        if (Double.doubleToLongBits(this.cod_socio) != Double.doubleToLongBits(other.cod_socio)) {
            return false;
        }
        return true;
    }

}
