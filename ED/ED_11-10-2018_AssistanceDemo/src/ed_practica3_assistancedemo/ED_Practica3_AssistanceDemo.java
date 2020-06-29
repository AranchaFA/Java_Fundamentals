/*
 */
package ed_practica3_assistancedemo;

import java.io.File;

/**
 *
 * @author Arancha
 */
public class ED_Practica3_AssistanceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int firstNumber = 1;
        int secondNumber = 2;

        int i = firstNumber;
        int j = secondNumber;

        int valorMaximoInteger = Integer.MAX_VALUE;
        int valorMinimoInteger = Integer.MIN_VALUE;

        Integer numeroPrimero = new Integer(firstNumber);
        Integer numeroSegundo = new Integer(secondNumber);

        File file1 = new File("cadena1");
        File file2 = new File("cadena2");
        File file3 = new File("cadena3");
        File file4 = new File("cadena4");
        

        
        /* BufferedReader bufferedReader= new BufferedReader(in); */
        
        System.out.println("numero1= "+firstNumber);
        System.out.println("numero2= "+secondNumber);
        
        System.err.println("Error de datos");
        
    }

}
