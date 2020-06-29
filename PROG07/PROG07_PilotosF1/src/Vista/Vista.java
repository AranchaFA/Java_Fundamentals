
package Vista;

import Modelo.Piloto;
import java.util.Scanner;

public class Vista {
    
       public static void verMensaje(String txt){
           System.out.println(txt);
       }
       
       public static void verPiloto(Piloto piloto){
           System.out.println(piloto);
       }
       
       public static Piloto datosParaBucarPiloto(){
           Scanner teclado=new Scanner(System.in);
           System.out.println("Introduce el nombre del piloto:");
           String nombre=teclado.nextLine();
           Piloto pilotoABuscar=new Piloto(nombre);
           return pilotoABuscar;
       }
}
