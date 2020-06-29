
package Modelo;

public class CuentaBancaria {
    
    // ATRIBUTOS
    private Persona titular;
    private String numeroCuenta;
    private float saldo;
    
    // MÉTODOS

    /* Getters para los atributos; setter para nº cuenta no porque no se podrá modificar, 
    el saldo se modifica con los métodos ingresar/retirarDinero,
    el titular sí se puede modificar más adelante, así que SÍ le pongo setter*/
    
    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public Persona getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }
    // Constructor que requiera el titular y el número de cuenta.
    public CuentaBancaria(Persona titular, String numeroCuenta) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
    }
    // toString
    @Override
    public String toString() {
        return "CuentaBancaria{" + "titular=" + titular + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }
    // Realizar ingresos / retiradas de dinero
    public void ingresarDinero(float cantidad) {
        this.saldo+=cantidad;
    }
    public boolean sacarDinero(float cantidad) {
        if (this.saldo<cantidad) {
            this.saldo-=cantidad;
            return true;
        }
        else return false;
    }
    
}