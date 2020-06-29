package modelo;
import java.util.*;

/**
 *
 * @author rpe
 */
public class Baraja {

   static String DIBUJOCARTAS[] = {"AS", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "J", "Q", "K"};
    
   static char PALOS[] = {'♥', '♦', '♣', '♠'};
   
    private LinkedList<Carta> baraja;

    public Baraja() {
        //inicializar y cargar baraja
        baraja = new LinkedList<Carta>();

        Carta carta;
        for (char palo : PALOS) {
            for (String dibujo : DIBUJOCARTAS) {
                carta = new Carta(dibujo, palo);
                baraja.add(carta);
               
            }
        }
    }

    public List<Carta> getBaraja() {
        return baraja;
    }

    public void setBaraja(List<Carta> baraja) {
        this.baraja = (LinkedList<Carta>) baraja;
    }

    public Carta repartirUnaCarta(){   
        
       int numAleatorio = (int) (Math.random()*baraja.size());
       
       return baraja.remove(numAleatorio);   
    }
    
    
    @Override
    public String toString() {
        String cadenaCartas="";
        char dibujoPalo = ' '; 
       
        for (Carta c: baraja){
            if  (dibujoPalo != c.getPaloCarta()){
                cadenaCartas+="\n";
                dibujoPalo = c.getPaloCarta();                
            }
            cadenaCartas+=c.getPaloCarta()+ c.getDibujoCarta()+" ";
        }
         return cadenaCartas;
                 
        // return "Baraja{" + "baraja=" + baraja + '}';
    }
    
   
    
}
