package Modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class VOPrestamo {

    // ATRIBUTOS
    private VOSocio socio;
    private Prestable prestable;
    private Date fecha_prestamos;

    // MÉTODOS
    // Getters + Setters
    public VOSocio getSocio() {
        return socio;
    }

    public void setSocio(VOSocio socio) {
        this.socio = socio;
    }

    public Prestable getPrestable() {
        return prestable;
    }

    public void setPrestable(Prestable prestable) {
        this.prestable = prestable;
    }

    public Date getFecha_prestamos() {
        return fecha_prestamos;
    }

    public void setFecha_prestamos(Date fecha_prestamos) {
        this.fecha_prestamos = fecha_prestamos;
    }

    // toString
    @Override
    public String toString() {
        return "VOPrestamo{" + "socio=" + socio + ", prestable=" + prestable + ", fecha_prestamos=" + fecha_prestamos + '}';
    }

    // Constructor
    public VOPrestamo(VOSocio socio, Prestable prestable, LinkedList<Date> fechas_prestamos) {
        this.socio = socio;
        this.prestable = prestable;
        // Pasamos la lista de fechas al generarla con la consulta a la BBDD cuando generamos
        // un VOPrestamo que ya existe
        this.fecha_prestamos = fecha_prestamos;
    }

    public VOPrestamo(VOSocio socio, Prestable prestable, Date fechaPrestamo) {
        this.socio = socio;
        this.prestable = prestable;
        this.fecha_prestamos = fechaPrestamo;
    }

    // equals + hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.socio);
        hash = 53 * hash + Objects.hashCode(this.prestable);
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
        final VOPrestamo other = (VOPrestamo) obj;
        if (!Objects.equals(this.socio, other.socio)) {
            return false;
        }
        if (!Objects.equals(this.prestable, other.prestable)) {
            return false;
        }
        return true;
    }

}
