package prog02_ej04_ii;

import java.util.Scanner;

public class PROG02_EJ04_II {

    public static void main(String[] args) {
        float num1, num2;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduzca el valor del primer cateto: ");
        num1 = teclado.nextFloat();

        System.out.println("Introduzca el valor del segundo cateto: ");
        num2 = teclado.nextFloat();

        float hipotenusa;

        hipotenusa = (float) Math.sqrt(Math.pow(num1, 2) + Math.pow(num2, 2));
        
        System.out.println("La hipotenusa vale: "+hipotenusa);
    }

}
