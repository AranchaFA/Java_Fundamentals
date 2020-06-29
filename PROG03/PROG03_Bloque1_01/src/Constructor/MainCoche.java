/*

 */
package Constructor;

import Modelo.Coche;
import Modelo.Motor;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class MainCoche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Declaramos un objeto de clase Coche
        Coche coche1;

        // Creamos un teclado de la clase Scanner
        Scanner teclado = new Scanner(System.in);

        // Pedimos atributos por pantalla
        System.out.println("Introduzca la marca: ");
        String marca = teclado.nextLine();
        System.out.println("Introduzca modelo: ");
        String modelo = teclado.nextLine();

        // Metemos los valores en Coche para crearlo
        coche1 = new Coche(marca, modelo);

        // De la segunda parte (120 CV y 1.9 L aceite):
        Motor motor = new Motor(120);
        motor.setLitrosAceite((float) 1.9);

        coche1.setMotor(motor);

        /* PRIMERA PARTE:
        
        // Visualizamos atributos
        System.out.println("Atributos del coche1: "+coche1.toString()); // me da referencia rara porque motor está sin inicializar.
        System.out.println("Atributos del coche1: "+coche1.getMarca()+" "+coche1.getModelo());
         */
        // SEGUNDA PARTE:
        System.out.println("Atributos del coche1: " + coche1.toString()); // me da referencia rara porque motor está sin inicializar.
        System.out.println("Atributos del coche1: " + coche1.getMarca() + " " + coche1.getModelo() + " Averias acumuladas=" + coche1.getImporteAcumuladoAverias() + " " + coche1.getMotor());

    }

}
