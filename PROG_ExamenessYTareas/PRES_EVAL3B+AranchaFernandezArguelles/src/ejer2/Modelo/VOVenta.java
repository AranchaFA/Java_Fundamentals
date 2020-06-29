package ejer2.Modelo;

import ejer1.*;
import java.util.Objects;

public class VOVenta {

    // ATRIBUTOS
    private VOComercio comercio;
    private VOPrograma programa;
    private int unidadesVendidas;

    // MÉTODOS
    // Getters + Setters
    public VOComercio getComercio() {
        return comercio;
    }

    public void setComercio(VOComercio comercio) {
        this.comercio = comercio;
    }

    public VOPrograma getPrograma() {
        return programa;
    }

    public void setPrograma(VOPrograma programa) {
        this.programa = programa;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    // toString
    @Override
    public String toString() {
        return "Venta{" + "comercio=" + comercio + ", programa=" + programa + ", unidadesVendidas=" + unidadesVendidas + '}';
    }

    // Constructores
    // Hago uno por defecto por si fuera necesario crear la venta y luego asignar con setter los valores más adelante
    public VOVenta() {
    }

    public VOVenta(VOComercio comercio, VOPrograma programa, int unidadesVendidas) {
        this.comercio = comercio;
        this.programa = programa;
        this.unidadesVendidas = unidadesVendidas;
    }

    // equals + hashCode (dos ventas serán iguales si comparten programa y comercio)
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.comercio);
        hash = 43 * hash + Objects.hashCode(this.programa);
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
        final VOVenta other = (VOVenta) obj;
        if (!Objects.equals(this.comercio, other.comercio)) {
            return false;
        }
        if (!Objects.equals(this.programa, other.programa)) {
            return false;
        }
        return true;
    }

}
