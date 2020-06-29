package ejercicio3VehiculosCocheCamion.modelo;

public class Camion extends Vehiculo {

    private Remolque remolque;

    public Camion(String matricula) {
        super(matricula);
        remolque = null;
    }

    public void ponRemolque(Remolque remolque) {
        this.remolque = remolque;
    }

    public void quitarRemolque() {
        this.remolque = null;
    }

    @Override
    public void acelerar(double cantidad)  {   
            String mensaje ="";
            velocidad += cantidad;
            if (remolque != null && (velocidad  > 100)) {
                try {
                    //solo entra si se cumple y lanzando la excepcion y pasando
                    //el control al catch que gestiona dicha excepcion
                    throw new DemasiadoRapidoException("Excesiva velocidad para camion con remolque " + this.toString());
                } catch (DemasiadoRapidoException ex) {
                    velocidad=100;
                    mensaje="Desacelerando a los límites de camion con remolque \n";
                }
                finally{
                    System.out.println(mensaje+ " "+this.toString() +"\n");
                
                }
            }
    }

    @Override
    public String toString() {
        if (remolque != null) {
            return "CAMION " + super.toString() + " lleva un remolque " + remolque.toString();
        } else {
            return super.toString() + " sin remolque";
        }
    }
}
