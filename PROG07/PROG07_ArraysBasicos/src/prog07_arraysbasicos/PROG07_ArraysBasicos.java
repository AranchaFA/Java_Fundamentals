package prog07_arraysbasicos;

import java.util.Arrays;
import java.util.Scanner;

public class PROG07_ArraysBasicos {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String[] arrayStrings = new String[4];

        for (int i = 0; i < arrayStrings.length; i++) {
            System.out.println("Introduce el String número " + i + ": ");
            arrayStrings[i] = teclado.nextLine();
        }

        for (int i = 0; i < arrayStrings.length; i++) {
            System.out.println("Posición="+i+", arrayStrings["+i+"]= "+arrayStrings[i]);
        }

        System.out.println(Arrays.toString(arrayStrings));

        // Calculamos la cadena más larga
        int posCadMasLarga=0;
        for (int i = 1; i < arrayStrings.length; i++) {
            if (arrayStrings[i].length()>arrayStrings[posCadMasLarga].length()) {
                posCadMasLarga=i;
            }
        }
        System.out.println("la posición de la cadena más larga es la "+posCadMasLarga+", y la cadena es "+arrayStrings[posCadMasLarga]);
        
        // for each, sólo nos "muestra" el contenido, no podemos saber la posición
        // ni trabajar con ningún aspecto de la estructura array.
        for (String cadena:arrayStrings) {
            System.out.println(cadena);
        }
        
        
        
        
    }

}
