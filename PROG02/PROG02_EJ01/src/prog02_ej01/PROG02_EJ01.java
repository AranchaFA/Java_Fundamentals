/*
Introducir un número por teclado y
mostrar el siguente y el anterior
 */
package prog02_ej01;

import java.util.Scanner;

public class PROG02_EJ01 {

    public static void main(String[] args) {
    
    // Definimos variable num y objeto Scanner para introducirlo:
    int num;
    Scanner teclado=new Scanner(System.in);
    
    // Pedimos introducir num y la almacenamos:
    System.out.println("Introduzca un número: ");
    num=teclado.nextInt();
    
    //Creamos una copia del número para operar con él:
    int copiaNum=num;

    // Mostramos por pantalla el número siguente con ayuda de la copiaNum:
    System.out.println("El número siguente a "+num+" es "+(++copiaNum));
    // Restauramos el valor de num para copiaNum (en este punto se le habrá sumado 1):
    copiaNum=num;
    // Mostramos por pantalla el número siguente con ayuda de la copiaNum:
    System.out.println("El número anterior a "+num+" es "+(--copiaNum));
        
    }
    
}
