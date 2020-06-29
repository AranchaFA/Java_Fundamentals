package Controlador;

import Modelo.Persona;
import java.util.Arrays;
import java.util.Collections;

public class Main_OrdenarPersonas {

    public static void main(String[] args) {

        // Creamos un array 
        Persona[] arrayPersonas = {new Persona("Alfonsa", "a de DAM", 20),
            new Persona("Gorzalo", "barcía", 43),
            new Persona("SantaMARÍA", "gérez", 50),
            new Persona("Navi", "Tururú", 65)};

        // Lo mostramos
        System.out.println("Array desordenado: ");
        for (Persona persona : arrayPersonas) {
            System.out.println(persona.toString());
        }

        // Lo ordenamos (de menor a mayor por defecto)
        System.out.println("Ordenamos el array por orden alfabético de apellidos y nombre:");
        Arrays.sort(arrayPersonas);
        System.out.println("Array ordenado:");
        for (int i = 0; i < arrayPersonas.length; i++) {
            System.out.println(arrayPersonas[i].toString());
        }
/*
        // Ordenamos de mayor a menor
        System.out.println("Ordenamos de mayor a menor:");
        Arrays.sort(arrayPersonas, Collections.reverseOrder());
        System.out.println("Array ordenado de mayor a menor:");
        for (int i = 0; i < arrayPersonas.length; i++) {
            System.out.println(arrayPersonas[i].toString());
        }
*/
        // Buscamos una persona
        // Para usar Arrays.binarySearch tiene que estar ordenado ASCENDENTEMENTE!
        // Si no, compara en el centro del array si es > o <, y tira para arriba o abajo
        // "esperando" que los mayores estén hacia arriba y los menores hacia abajo
        Persona personaABuscar = new Persona("Gorzalo", "barcía", 43);
        int posicion = Arrays.binarySearch(arrayPersonas, personaABuscar);
        System.out.println("Posición: " + posicion);
        if (posicion >= 0) {
            System.out.println("Persona encontrada: ");
            System.out.println(arrayPersonas[posicion].toString());
        } else {
            System.out.println("La persona no se encuentra.");
        }

    }

}
