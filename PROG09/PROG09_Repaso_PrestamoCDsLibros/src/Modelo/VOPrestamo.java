package Modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class VOPrestamo {

    // ATRIBUTOS
    private VOSocio socio;
    private Prestable prestable;
    private LinkedList<Date> fechas_prestamos;

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

    public LinkedList<Date> getFechas_prestamos() {
        return fechas_prestamos;
    }

    public void setFechas_prestamos(LinkedList<Date> fechas_prestamos) {
        this.fechas_prestamos = fechas_prestamos;
    }

    // toString
    @Override
    public String toString() {
        return "VOPrestamo{" + "socio=" + socio + ", prestable=" + prestable + ", fechas_prestamos=" + fechas_prestamos + '}';
    }

    // Constructor
    public VOPrestamo(VOSocio socio, Prestable prestable, LinkedList<Date> fechas_prestamos) {
        this.socio = socio;
        this.prestable = prestable;
        // Pasamos la lista de fechas al generarla con la consulta a la BBDD cuando generamos
        // un VOPrestamo que ya existe
        this.fechas_prestamos = fechas_prestamos;
    }

    public VOPrestamo(VOSocio socio, Prestable prestable, Date fechaPrimerPrestamo) {
        this.socio = socio;
        this.prestable = prestable;
        this.fechas_prestamos = new LinkedList<>();
        // Crearemos el objeto Prestamo para un determinado socio-libro la primera vez que quiera
        // llevarlo prestado, así que le meteremos la fecha de ese primer préstamo
        this.fechas_prestamos.add(fechaPrimerPrestamo);
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
