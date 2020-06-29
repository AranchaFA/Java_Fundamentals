package Modelo;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Contacto implements Comparable<Contacto> {

    // ATRIBUTOS
    private String nombrePila;
    private String nombre;
    private String apellidos;
    private String email;
    private List<String> telefonos;

    // MÉTODOS
    // Getters + Setters
    public String getNombrePila() {
        return nombrePila;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    // toString
    @Override
    public String toString() {
        return "Contacto{" + "nombrePila=" + nombrePila + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", telefonos=" + telefonos + '}';
    }

    // Constructores
    public Contacto(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public Contacto(String nombrePila, String nombre, String apellidos, String email, List<String> telefonos) {
        this.nombrePila = nombrePila;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefonos = telefonos;
    }

    // equals + hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombrePila);
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
        final Contacto other = (Contacto) obj;
        if (!this.nombrePila.equalsIgnoreCase(other.nombrePila)) {
            return false;
        }
        return true;
    }

    // compareTo
    @Override
    public int compareTo(Contacto o) {
        return this.nombrePila.compareToIgnoreCase(o.nombrePila);
    }

    // BUSCAR TELÉFONO en la lista de este contacto
    public boolean buscarTelefono(String telefonoABuscar) {
        boolean encontrado = false;

        Iterator it = telefonos.iterator();
        while (it.hasNext() && encontrado == false) {
            String telefonoLeido=(String) it.next();
            if (telefonoLeido.trim().equals(telefonoABuscar)) {
                encontrado = true;
            }
        }
        return encontrado;
    }
}
