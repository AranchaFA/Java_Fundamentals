package Controlador;

import Modelo.Asignatura;
import Modelo.Leer;

public class MainAsignatura {

    public static void main(String[] args) {

        // Creamos una asignatura metiendo el nombre por teclado
        Leer teclado = new Leer();

        System.out.println("Introduzca nombre de la asignatura nº1: ");
        Asignatura asig1 = new Asignatura(teclado.leerDato());
        // Mostrar toda la información inicial
        System.out.println("Información inicial de la asignatura: " + '\n' + asig1.toString());
        // Pedimos las notas de las 3 evaluaciones por teclado
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduzca la nota de la evaluación nº" + (i + 1) + ": ");
            switch (i) {
                case 0:
                    asig1.setEval1(teclado.datoFloat());
                    break;
                case 1:
                    asig1.setEval2(teclado.datoFloat());
                    break;
                case 2:
                    asig1.setEval3(teclado.datoFloat());
                    break;
            }
        }
        // Calculamos la nota media final
        asig1.notaMedia();
        // Mostrar toda la información final
        System.out.println("Información final de la asignatura: " + '\n' + asig1.toString());
    }

}
