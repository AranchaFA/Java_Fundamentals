/*
Declarar una variable y decir si
es positiva/negativa
par/impar
múltiplo de 5
múltiplo de 10
mayor/menor que 100
*/
import java.util.Scanner;

public class PROG02_Ej01_II {

    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
        int c;
        
        System.out.println("Introduzca un número entero: ");
        c=teclado.nextInt();
        
        boolean positivo;
        boolean par;
        boolean mult5;
        boolean mult10;
        boolean mayor100;
        
        positivo=(c>0)?(true):(false);
        par=(c%2==0)?(true):(false);
        mult5=(c%5==0)?(true):(false);
        mult10=(c%10==0)?(true):(false);
        mayor100=(c>100)?(true):(false);
        
        System.out.println("¿Es positivo? "+positivo);
        System.out.println("¿Es par? "+par);
        System.out.println("¿Es múltiplo de 5? "+mult5);
        System.out.println("¿Es múltiplo de 10? "+mult10);
        System.out.println("¿Es mayor de 100? "+mayor100);
    }
}
