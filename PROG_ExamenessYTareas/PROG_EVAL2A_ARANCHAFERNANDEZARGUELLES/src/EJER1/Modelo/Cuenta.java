
package EJER1.Modelo;

import java.io.Serializable;

public class Cuenta implements Serializable{
    
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

    
    
    
}
