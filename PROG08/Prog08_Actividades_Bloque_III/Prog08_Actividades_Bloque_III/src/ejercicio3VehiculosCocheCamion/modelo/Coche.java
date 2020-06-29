package ejercicio3VehiculosCocheCamion.modelo;


public class Coche extends Vehiculo {
    private int numPuertas;

    public Coche(String matricula, int numPuertas) {
        super(matricula);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    @Override
    public String toString() {
        return "COCHE "+ super.toString()+" numPuertas=" + numPuertas + '}';
    }  
    
}
