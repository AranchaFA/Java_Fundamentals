
package Vista;

import java.awt.FlowLayout;
import java.io.File;
import javax.swing.*;
import Modelo.Baraja;
import Modelo.Carta;

public class Vista {
    public static void verMensaje(String txt){
        System.out.println(txt);
    }
    
    public static void verCarta(Carta c){
        System.out.println(c.toString());
    }
    
    public static void verBaraja(Baraja b){
        System.out.println(b.toString());
    }
    
    
    //metodo que mostraria la imagen de una carta concreta que le pasamos como parámetro
    public static void muestraCarta (Carta carta)
    {
        String directorio = "cartas"; //directorio del proyecto donde estan las imagenes
        
        String nomFichero = carta.getNombreFicheroImagen();
        
         JFrame frame = new JFrame(carta.getNombreFicheroImagen()); //mensaje que aparecerá en la parte de arriba de la ventana
 
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
 
        JLabel label = new JLabel("");
 
        //asignamos el dibujo que está almacenado en  cartas\fichero como imagen de la etiqueta
        label.setIcon(new ImageIcon(directorio+File.separator+nomFichero));
  
        //añade esa etiqueta al panel
        panel.add(label);
 
        //añade el panel al frame
        frame.add(panel);
        frame.setSize(400, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); //hace visible el frame, mostrándose una ventana con la imagen de la carta
    }
}
