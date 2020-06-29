package Modelo;

public class CuentaBancaria {

    private String nombreTitular;

    private final String numeroCuenta;

    private Float saldo;

    public CuentaBancaria(String nombreTitular, String numeroCuenta, float saldo) {
        this.nombreTitular = nombreTitular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "nombreTitular=" + nombreTitular + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }

    public void ingresarDinero(float cantidadIngresada) {
        this.saldo += cantidadIngresada;
    }
    // Sería mejor hacerlo tipo boolean como en el que hicimos en clase!!
    public void retirarDinero(float cantidadRetirada) {
        if (this.saldo < cantidadRetirada) {
            saldoInsuficiente();
        } else {
            this.saldo -= cantidadRetirada;
        }
    }

    public float mostrarSaldo() {
        return saldo;
    }

    public void saldoInsuficiente() {
        System.out.println("Saldo insuficiente, escriba una cantidad más pequeña.");
    }
}
