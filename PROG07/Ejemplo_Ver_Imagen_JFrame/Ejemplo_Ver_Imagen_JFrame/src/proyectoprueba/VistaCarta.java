/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprueba;

import java.awt.FlowLayout;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaCarta {       
    public static void muestraCarta (String fichero)
    {
        //creamos un objeto frame que contendra al final un panel y el panel contendra una etiqueta
        // la etiqueta contendrá al final la imagen a partir de su nombre de fichero
        
        String carpeta = "imagenes"; //carpeta  donde metí la imagen
        
        //creamos el frame
        JFrame frame = new JFrame("Titulo De la Ventana");
 
        //creamos un objeto panel 
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
 
        //creamos la etiqueta
        JLabel label = new JLabel("");
 
        //asignamos a la etiqueta un objeto ImagenIcon especificando donde esta la directorio/imagen
        label.setIcon(new ImageIcon(carpeta+File.separator+fichero));
        
        //añadimos la etiqueta al panel
        panel.add(label);
 
        //añadimos el panel al frame
        frame.add(panel);
        
        //especificamos el tamaño, posicion relativa y que aparezca la X para cerrar la ventana
        frame.setSize(400, 550);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //hacemos visible el frame
        frame.setVisible(true);
    }
    
}
