/*

 */
package Constructor;

import Modelo.Coche;
import Modelo.Motor;

public class Main_Ej04 {

    public static void main(String[] args) {

        // Creamos un objeto motor
        Motor motor1 = new Motor(170);

        motor1.setLitrosAceite((float) 2.5);

        Coche cocheArancha = new Coche("seat", "cordoba");

        cocheArancha.setMotor(motor1);

        cocheArancha.acumularAveria(100);
        cocheArancha.acumularAveria(270);

        System.out.println("Atributos de cocheArancha: " + cocheArancha.toString());
    }

}
