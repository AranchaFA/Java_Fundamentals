
package juego;

public class MainJuego {

    public static void main(String[] args) {
       Jugador j1, j2;
       
       j1 = new Jugador("Jugador1");
       j2 = new Jugador("Jugador2");
       
       while (j1.getVidas()>0 && j2.getVidas()>0){
           System.out.println(j1.toString());
           System.out.println(j2.toString());
           j1.tirar();
           j2.tirar();
           System.out.println(j1.getNombre()+" saca un "+j1.getTirada());
           System.out.println(j2.getNombre()+" saca un "+j2.getTirada());
           if ( j1.getTirada()>j2.getTirada()){
               j2.setVidas(j2.getVidas()-1);
               System.out.println("Jugada para "+j1.getNombre());
           }
           else if (j2.getTirada()>j1.getTirada()){
               j1.setVidas(j1.getVidas()-1);
               System.out.println("Jugada para "+j2.getNombre());
         
           } else
               System.out.println(" Tablas");
           System.out.println(j1.toString());
           System.out.println(j2.toString());
           System.out.println("\n");           
       }
       
       String ganador  =(j1.getVidas()==0) ? j2.getNombre():j1.getNombre();
      System.out.println(" El Ganador es "+ ganador);
       
    }
    
}
