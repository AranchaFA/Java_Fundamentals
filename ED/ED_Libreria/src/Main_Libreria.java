/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arancha
 */
public class Main_Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector posicion = null;
        
        
        Coche coche=new Coche(0, posicion);
        Vehiculo v=new Vehiculo(posicion) {
            @Override
            public Vector mover(Vector vector) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public Vector desplazar(Vector vector) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
    }
    
}
