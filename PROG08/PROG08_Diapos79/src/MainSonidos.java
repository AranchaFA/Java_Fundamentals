/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arancha
 */
public class MainSonidos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Reproductor reproductor = new Reproductor();
        
        Gato gato=new Gato();
        Perro perro = new Perro();
        Canario canario = new Canario();
        RelojCuco relojCuco = new RelojCuco();
        
        reproductor.emitirSonido(gato);
        reproductor.emitirSonido(perro);
        reproductor.emitirSonido(canario);
        reproductor.emitirSonido(relojCuco);
        
    }
    
}
