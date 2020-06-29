/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_demofile;

/**
 *
 * @author Arancha
 */
public class ED_DemoFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Construimos un objeto para aplicar las operaciones con ficheros
        OperacionesFicheros of = new OperacionesFicheros();
        
        of.listarDirectorio("");
        
    }
    
}
