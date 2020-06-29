/*

 */
package Controlador;

import Modelo.Carta;

public class CartaMain {

    public static void main(String[] args) {

        // Declaración:
        Carta carta1, carta2;
        carta1 = new Carta();
        carta2 = new Carta();

        System.out.println("Valores de la carta al generarlos (con nuestro método verTodosLosAtributosCarta(): ");
        System.out.println(carta1.verTodosLosAtributosCarta());
        System.out.println("Valores de la carta al generarlos (con el método genérico toString(): ");
        System.out.println(carta1.toString());

        // Entrada:
        carta1.setDibujoNumCarta("12");
        carta1.setPalo("espadas");
        carta1.setValorNumerico(10);

        carta1.setDibujoNumCarta("7");
        carta2.setPalo("oros");
        carta2.setValorNumerico(7);

        // Salida:
        System.out.println("Atributos después de asignar valores: ");
        System.out.println(carta1.verTodosLosAtributosCarta());
        System.out.println(carta2.verTodosLosAtributosCarta());

        if (carta1.getValorNumerico() > carta2.getValorNumerico()) {
            System.out.println("La carta 1: " + carta1.verTodosLosAtributosCarta() + " es mayor que la carta 2: " + carta2.verTodosLosAtributosCarta());
        } else {
            System.out.println("La carta 1: " + carta1.verTodosLosAtributosCarta() + " es menor que la carta 2: " + carta2.verTodosLosAtributosCarta());
        }

        if (carta1.getValorNumerico() > carta2.getValorNumerico()) {
            System.out.println("La carta 1 (" + carta1.getValorNumerico() + ") es mayor que la carta 2 (" + carta2.getValorNumerico() + ")");
        } else {
            System.out.println("La carta 1 (" + carta1.getValorNumerico() + ") es menor que la carta 2 (" + carta2.getValorNumerico() + ")");
        }
    }

}
