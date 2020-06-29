package controlador;

import modelo.*;
import vista.*;

/* ejemplo de repartir 10 cartas a un jugador mostrar sus diez cartas y las que quedan en la baraja
    si quisieramos hacerlo con dos jugadores sería eliminar los comentarios del j2
*/
public class MainJuegoRepartir10Cartas {

    public static void main(String[] args) {

        //creamos la baraja
        Baraja baraja = new Baraja();
        Carta c=null;

        //creamos los jugadores      
        JugadorJuegoCartas j1, j2;
        j1 = new JugadorJuegoCartas("j1");
      //  j2 = new JugadorJuegoCartas("j2");

        for (int i = 0; i < 10; i++) {
            //coger una carta de la baraja
            c = baraja.repartirUnaCarta();
            j1.anhadirCartaMazo(c);
            Vista.verMensaje("\na J1 se le ha repartido la carta");
            Vista.verCarta(c);
   /*         
            c = baraja.repartirUnaCarta();
            Vista.verMensaje("\na J2 se le ha repartido la carta");
            Vista.verCarta(c);
            j2.anhadirCartaMazo(c);
    */    
   Vista.verMensaje("\n------------------");
        }
        
        //mostramos las cartas del J1
        Vista.verMensaje("\n\nMAZO DE CARTAS DE J1");
        for (Carta carta: j1.getMazoCartas()){
            Vista.verCarta(carta);
        }
        
   /*     
         //mostramos las cartas del J2
        Vista.verMensaje("\nMAZO DE CARTAS DE J2");
        for (Carta carta: j2.getMazoCartas()){
            Vista.verCarta(carta);
        }
 */
      
        //muestra las cartas que quedan en la baraja
        System.out.print("\n\n Las cartas que quedan en la baraja son...");
        System.out.println(baraja.toString());
    }

}
