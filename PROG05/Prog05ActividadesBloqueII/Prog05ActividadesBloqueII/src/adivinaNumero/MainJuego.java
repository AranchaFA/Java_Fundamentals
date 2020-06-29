package adivinaNumero;

import paqueteLeerDatos.Leer;

public class MainJuego {

    public static void main(String[] args) {
        NumeroAdivinar n = new NumeroAdivinar();
        int num, intentos = 0;
        String mensaje=null;

        do {
            intentos++;
            System.out.println("intento :"+intentos);
            do {
                System.out.print("Introduce un numero entre 1 y 100: ");
                num = Leer.datoInt();
                if (num <= 0 || num > 100) {
                    System.out.println("error en el numero");
                }
            } while (num <1 || num > 100);
            switch (n.comparar(num)) {
                case -1:
                    mensaje = "El número a adivinar es menor";
                    break;
                case 0:
                    mensaje = "Enhorabuena has acertado";
                    break;
                case 1:
                    mensaje = "El número a adivinar es mayor";
                    break;
            }      
            System.out.println(mensaje);

        } while (n.comparar(num) != 0);
        System.out.println("El número a adivinar era: " + n.getNum());
        System.out.println("Has necesitado " + intentos + " intentos");

    }

}
