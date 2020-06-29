
package EJER1.Controlador;

public class Main_EJER1 {

    public static void main(String[] args) {
        
        // Creamos un controlador y ejecutamos su menú
        Controlador_ObjetosCSV controlador=new Controlador_ObjetosCSV("fileCuentas.csv","saldoNegativo.dat");
        controlador.ejecutarMenu();
    }
    
}
