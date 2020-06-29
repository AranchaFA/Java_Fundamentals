package Modelo;

public class CuentaAhorro extends CuentaCorriente {

    // ATRIBUTOS
    private double interes;

    // MÉTODOS
    // Getters + Setters
    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\nCuentaAhorro{" + "interes=" + interes + '}';
    }

    // Constructores
    public CuentaAhorro(double interes, Titular titular, String numeroCuenta, double saldo) {
        super(titular, numeroCuenta, saldo);
        this.interes = interes;
    }

    public CuentaAhorro(Titular titular, String numeroCuenta) {
        super(titular, numeroCuenta, 0.0);
        this.interes = 2.5;
    }

    
    public void calcularIntereses(){
        super.ingreso(super.getSaldo()*(this.interes/100));
    }
    
    
}
