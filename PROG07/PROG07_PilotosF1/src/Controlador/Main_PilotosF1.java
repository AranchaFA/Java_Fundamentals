
package Controlador;

import java.util.Scanner;

public class Main_PilotosF1 {

    public static void main(String[] args) {
        
        Controlador_PilotosF1 controlador=new Controlador_PilotosF1();
        
        Scanner teclado=new Scanner(System.in);
        int opcion;
        do {
            controlador.mostrarMenu();
            opcion=teclado.nextInt();
            controlador.gestionMenu(opcion);
        } while (opcion!=0);
        
    }
    
}
