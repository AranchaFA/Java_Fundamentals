package Modelo;

public class CuentaCorriente {

    // ATRIBUTO
    private Titular titular;
    private String numeroCuenta;
    private double saldo;

    // MÉTODOS
    // Getters + Setters
    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // toString
    @Override
    public String toString() {
        return "CuentaCorriente{" + "titular=" + titular + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }

    // Constructores
    public CuentaCorriente(Titular titular, String numeroCuenta, double saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public CuentaCorriente(Titular titular, String numeroCuenta) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
    }

    // Ingreso (devuelve el saldo final)
    public double ingreso(double cantidadDinero) {
        this.saldo += cantidadDinero;
        return this.saldo;
    }

    // Reintegro (devuelve el saldo final)
    public double reintegro(double cantidadDinero) {
        this.saldo -= cantidadDinero;
        return this.saldo;
    }
}
