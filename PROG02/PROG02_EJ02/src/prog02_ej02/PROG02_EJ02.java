/*
Introducir dos variables por teclado e
intercambiar sus valores.
Mostrar por pantalla sus valores antes y después del cambio.
 */
package prog02_ej02;

import java.util.Scanner;


public class PROG02_EJ02 {


    public static void main(String[] args) {
        
        // Definimos las variables:
        int num1,num2;
        
        // Definimos objeto teclado para introducir las variables:
        Scanner teclado=new Scanner(System.in);
        
        // Pedimos por pantalla los valores y los asignamos:
        System.out.println("Introduzca el primer número: ");
        num1=teclado.nextInt();
        
        System.out.println("Introdfuzca el segundo número: ");
        num2=teclado.nextInt();
        
        // Mostramos por pantalla los valores iniciales:
        System.out.println("Los valores iniciales son: num1="+num1+" num2="+num2);
        
        // Creamos una variable auxiliar para guardar  copia de una de las variables mientras realizamos el cambio:
        int copiaNum=num1;
        num1=num2;
        num2=copiaNum;
        
        // Mostramos por pantalla los valores finales:
        System.out.println("Los valores finales son: num1="+num1+" num2="+num2);
        
    }
    
}
