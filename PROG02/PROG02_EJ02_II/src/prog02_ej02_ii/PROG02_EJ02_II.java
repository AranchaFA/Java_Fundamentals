/*
Pedimos una temperatura en centígrados y
devolverla en Farenheit
 */
package prog02_ej02_ii;


public class PROG02_EJ02_II {

    public static void main(String[] args) {
        double num1=2,num2=3;
        double num3=4;
        
        double cuadrado=Math.sqrt(num1);
        System.out.println("La raíz cuadrada de "+num1+"es: "+cuadrado);
        
        cuadrado=Math.sqrt(num2);
        System.out.println("La raíz cuadrada de "+num2+"es: "+cuadrado);
        
        double potencia=Math.pow(num2, num1);
        System.out.println(num2+" elevado a "+num1+" es "+potencia);
        
        potencia=Math.pow(num1, num2);
        System.out.println(num1+" elevado a "+num2+" es "+potencia);
        
    }
    
}
