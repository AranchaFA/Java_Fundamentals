package EJER1.Modelo;

import java.io.Serializable;
import java.util.Objects;

public class Cuenta implements Serializable,Comparable<Cuenta>{

    // ATRIBUTOS
    private String numCuenta;
    private Persona Titular;
    private int saldo;

    // MÉTODOS
    // Getters + Setters
    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Persona getTitular() {
        return Titular;
    }

    public void setTitular(Persona Titular) {
        this.Titular = Titular;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    // toString
    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", Titular=" + Titular + ", saldo=" + saldo + '}';
    }

    // Constructor
    public Cuenta(String numCuenta, Persona Titular, int saldo) {
        this.numCuenta = numCuenta;
        this.Titular = Titular;
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numCuenta);
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
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.numCuenta, other.numCuenta)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Cuenta cuenta) {
        return this.numCuenta.compareToIgnoreCase(cuenta.getNumCuenta());
    }

}
