
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Arancha
 */
public class Coche extends Vehiculo{
    
    private List<Rueda> ruedas;
    private int color;

    public Coche(int color, Vector posicion) {
        super(posicion);
        this.color = color;
        
        
        Rueda rueda1 = new Rueda(235, 17, 25);
        Rueda rueda2 = new Rueda(235, 17, 25);
        Rueda rueda3 = new Rueda(235, 17, 25);
        Rueda rueda4 = new Rueda(235, 17, 25);
        
        this.ruedas.add(rueda1);
        this.ruedas.add(rueda2);
        this.ruedas.add(rueda3);
        this.ruedas.add(rueda4);
    }
    
    public List<Rueda> verificarPresionRuedas(){
        List<Rueda> ruedasSinPresion=new ArrayList<>();
        for (Rueda rueda : ruedas) {
            if (rueda.getPresion()<25) {
                ruedasSinPresion.add(rueda);
            } 
        }
        return ruedasSinPresion;
    }

    @Override
    public Vector mover(Vector destino) {
        this.setPosicion(destino);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector desplazar(Vector desplazamiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
