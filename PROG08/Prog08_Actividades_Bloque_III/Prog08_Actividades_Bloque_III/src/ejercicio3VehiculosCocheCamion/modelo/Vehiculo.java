package ejercicio3VehiculosCocheCamion.modelo;


public class Vehiculo {
  protected String matricula;
    protected double velocidad;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
        velocidad =0;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getVelocidad() {
        return velocidad;
    }
    
    public void acelerar (double cantidad) {
        velocidad+=cantidad;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", velocidad=" + velocidad + '}';
    } 
  
}
