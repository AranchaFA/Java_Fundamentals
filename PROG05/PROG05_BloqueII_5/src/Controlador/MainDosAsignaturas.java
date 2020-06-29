package Controlador;

import Modelo.Asignatura;
import Modelo.Leer;

public class MainDosAsignaturas {

    public static void main(String[] args) {

        // Objeto teclado para introducir datos
        Leer teclado = new Leer();

        // Creamos dos asignaturas
        System.out.println("Introduzca nombre de la asignatura nº1: ");
        Asignatura asig1 = new Asignatura(teclado.leerDato());
        System.out.println("Introduzca nombre de la asignatura nº2: ");
        Asignatura asig2 = new Asignatura(teclado.leerDato());

        // Mostrar toda la información inicial
        System.out.println("Información inicial de la asignatura nº1: " + '\n' + asig1.toString());
        System.out.println("Información inicial de la asignatura nº2: " + '\n' + asig2.toString());

        // Pedimos las notas de la asignatura 1 para las 3 evaluaciones por teclado
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduzca la nota de la evaluación nº" + (i + 1) + " de la asignatura nº1: ");
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
        // Pedimos las notas de la asignatura 2 para las 3 evaluaciones por teclado
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduzca la nota de la evaluación nº" + (i + 1) + " de la asignatura nº2: ");
            switch (i) {
                case 0:
                    asig2.setEval1(teclado.datoFloat());
                    break;
                case 1:
                    asig2.setEval2(teclado.datoFloat());
                    break;
                case 2:
                    asig2.setEval3(teclado.datoFloat());
                    break;
            }
        }

        // Calculamos la nota media final de ambas asignaturas
        asig1.notaMedia();
        asig2.notaMedia();
        // Mostrar toda la información final
        System.out.println("Información final de la asignatura: " + '\n' + asig1.toString());
        System.out.println("Información final de la asignatura: " + '\n' + asig2.toString());

        // Comprobar en qué asignatura se sacó la mejor nota individual
        // Mejor nota en la asignatura 1
        float mejorNota1 = 0;
        if (asig1.getEval1() > asig1.getEval2()) {
            if (asig1.getEval1() > asig1.getEval3()) {
                mejorNota1 = asig1.getEval1();
            } else {
                mejorNota1 = asig1.getEval3();
            }
        } else {
            if (asig1.getEval2() > asig1.getEval3()) {
                mejorNota1 = asig1.getEval2();
            } else {
                mejorNota1 = asig1.getEval3();
            }
        }
        // Mejor nota en la asignatura 2
        float mejorNota2 = 0;
        if (asig2.getEval1() > asig2.getEval2()) {
            if (asig2.getEval1() > asig2.getEval3()) {
                mejorNota2 = asig2.getEval1();
            } else {
                mejorNota2 = asig2.getEval3();
            }
        } else {
            if (asig2.getEval2() > asig2.getEval3()) {
                mejorNota2 = asig2.getEval2();
            } else {
                mejorNota2 = asig2.getEval3();
            }
        }
        // Float mejor nota total
        float mejorNotaTotal;
        String asignaturaMejorNota; 
        if (mejorNota1 > mejorNota2) {
            mejorNotaTotal = mejorNota1;
            asignaturaMejorNota=asig1.getNomAsignatura();
        } else {
            mejorNotaTotal = mejorNota2;
            asignaturaMejorNota=asig2.getNomAsignatura();
        }
        // Mostramos la nota más alta y la asignatura en que se sacó
        System.out.println("La mejor nota es un "+mejorNotaTotal+" sacada en "+asignaturaMejorNota);
    }
}
