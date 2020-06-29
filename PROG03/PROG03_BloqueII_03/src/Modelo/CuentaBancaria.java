package Modelo;



public class CuentaBancaria {

    private Persona nombreTitular;

    private final String numeroCuenta;

    private Float saldo;

    public CuentaBancaria(Persona nombreTitular, String numeroCuenta, float saldo) {
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
