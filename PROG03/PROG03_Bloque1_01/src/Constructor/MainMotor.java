/*

 */
package Constructor;

import Modelo.Motor;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class MainMotor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Motor motor1, motor2;

        Scanner teclado = new Scanner(System.in);

        // Introducimos valores para motor1:
        System.out.println("Introduzca CV de motor1: ");
        motor1 = new Motor(teclado.nextInt());

        System.out.println("Introduzca los litros de aceite de motor1: ");
        motor1.setLitrosAceite(teclado.nextFloat());

        // Introducimos valores para motor2:
        System.out.println("Introduzca los CV de motor2: ");
        motor2 = new Motor(teclado.nextInt());

        System.out.println("Introduzca los litros de aceite de motor2: ");
        motor2.setLitrosAceite(teclado.nextFloat());

        // Visualizamos los valores de los atributos de motor1:
        System.out.println("Atributos de motor1: " + motor1.toString());

        // Visualizamos los valores de los atributos de motor1:
        System.out.println("Atributos de motor2: " + motor2.toString());
    }

}
