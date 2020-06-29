/*

 */
package Controlador;

import Modelo.Motor; // import Modelo.*;   Importa TODAS las clases de un paquete
import java.util.Scanner;

public class MotorMain {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Motor motor1 = new Motor();
        Motor motor2 = new Motor();

        System.out.println("CV por defecto: " + motor1.getCV());
        System.out.println("Litros de aceite por defecto: " + motor1.getLitrosAceite());

        System.out.println("Introducir CV del motor 1: ");
        motor1.setCV(teclado.nextInt());
        System.out.println("Introducir litros de aceite del motor 1: ");
        motor1.setLitrosAceite(teclado.nextDouble());

        System.out.println("CV finales del motor 1: " + motor1.getCV());
        System.out.println("Litros de aceite finales del motor 1: " + motor1.getLitrosAceite());

        System.out.println("Introducir CV del motor 2: ");
        motor2.setCV(teclado.nextInt());
        System.out.println("Introducir litros de aceite del motor 2: ");
        motor2.setLitrosAceite(teclado.nextDouble());

        System.out.println("CV finales del motor 2: " + motor2.getCV());
        System.out.println("Litros de aceite finales del motor 2: " + motor2.getLitrosAceite());

        if (motor1.getCV() > motor2.getCV()) {
            System.out.println("El motor 1 (" + motor1.getCV() + "CV) es más potente que el motor 2(" + motor2.getCV() + "CV)");
        } else {
            System.out.println("El motor 1 (" + motor1.getCV() + "CV) es menos potente que el motor 2(" + motor2.getCV() + "CV)");
        }
    }
}
