package ejer1;

import java.util.Objects;

public class Venta {

    // ATRIBUTOS
    private Comercio comercio;
    private Programa programa;
    private int unidadesVendidas;

    // MÉTODOS
    // Getters + Setters
    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
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
    public Venta() {
    }

    public Venta(Comercio comercio, Programa programa, int unidadesVendidas) {
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.comercio, other.comercio)) {
            return false;
        }
        if (!Objects.equals(this.programa, other.programa)) {
            return false;
        }
        return true;
    }

}
