/*
Introducir 3 Strings por teclado y
cambiar los valores de cadena1 --> cadena2 --> cadena3
 */
package prog02_ej003;

import java.util.Scanner;

public class PROG02_EJ003 {

    public static void main(String[] args) {
        
        // Definimos los 3 Strings:
        String cadena1,cadena2,cadena3;
        
        // Definimos el objeto teclado para introducir las cadenas:
        Scanner teclado=new Scanner(System.in);
        
        // Pedimos a introducimos las cadenas:
        // sc.nextLine(); Vaciar el buffer antes de meter un String para vaciarlo!!
        // Si no, puede quedar un Intro en el buffer y el programa lo guardará como nextLine.
        System.out.println("Introduzca la primera cadena de carácteres: ");
        cadena1=teclado.nextLine();
        
        System.out.println("Introduzca la segunda cadena de carácteres: ");
        cadena2=teclado.nextLine();
        
        System.out.println("Introduzca la tercera cadena de carácteres: ");
        cadena3=teclado.nextLine();
        
        // Creamos dos variables auxiliares para realizar el cambio:
        String copiaCadena1=cadena1;
        
        // Realizamos el cambio apoyándonos en la var. auxiliar:
        cadena1=cadena3;
        cadena3=cadena2;
        cadena2=copiaCadena1;
        
        // Mostramos las cadenas por pantalla:
        System.out.println("La primera cadena ahora es: "+cadena1);
        System.out.println("La segunda cadena ahora es: "+cadena2);
        System.out.println("La tercera cadena ahora es: "+cadena3);
        
    }
    
}
