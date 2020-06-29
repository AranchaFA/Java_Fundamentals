
import java.util.Scanner;


public class Main_ClaseString {

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        String auxCadena;
        int primeraVocal;
        int ultimaVocal;
        
        // Pedimos String por teclado
        System.out.println("Introduzca una cadena de caracteres: ");
        cadena=teclado.nextLine();
        // Mostramos en mayúsculas
        System.out.println("Cadena pasada a mayúsculas: ");
        System.out.println(cadena.toUpperCase());
        // Mostramos en minúsculas
        System.out.println("Cadena pasada a minúsculas: ");
        System.out.println(cadena.toLowerCase());
        // Calculamos las primeras posiciones de cada vocal
        auxCadena=cadena.toLowerCase();
        int posicionA=auxCadena.indexOf("a");
        int posicionE=auxCadena.indexOf("e");
        int posicionI=auxCadena.indexOf("i");
        int posicionO=auxCadena.indexOf("o");
        int posicionU=auxCadena.indexOf("u");
        
        primeraVocal=posicionA;
        if (primeraVocal>posicionE||primeraVocal<0) primeraVocal=posicionE;
        if (primeraVocal>posicionI) primeraVocal=posicionI;
        if (primeraVocal>posicionO) primeraVocal=posicionO;
        if (primeraVocal>posicionU) primeraVocal=posicionU;
        
        ultimaVocal=posicionA;
        if (ultimaVocal<posicionE) ultimaVocal=posicionE;
        if (ultimaVocal<posicionI) ultimaVocal=posicionI;
        if (ultimaVocal<posicionO) ultimaVocal=posicionO;
        if (ultimaVocal<posicionU) ultimaVocal=posicionU;
        
        System.out.println("La posición de la primera vocal es: "+(primeraVocal+1));
        System.out.println("La posición de la última vocal es: "+(ultimaVocal+1));
        
        System.out.println("La longitud de la cadena es: "+cadena.length());
        
        auxCadena=cadena.replace('a', '*');
        System.out.println("Reemplazamos las 'a' por '*': "+'\n'+auxCadena);
        
        
    }
    
}
