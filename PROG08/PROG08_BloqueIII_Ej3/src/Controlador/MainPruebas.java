/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Camion;
import Modelo.Coche;
import Modelo.DemasiadoRapidoException;
import Modelo.Remolque;
import Modelo.Vehiculo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arancha
 */
public class MainPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /*Camion c=new Camion("1234AAA");
        c.setRemolque(new Remolque(100));
        
        System.out.println(c.toString());
        c.acelerar(110);
        System.out.println(c.toString());
        c.acelerar(90);
        System.out.println(c.toString());*/
        // Creamos un controlador
        Controlador c = new Controlador();
        // Creamos 2 caminones y 2 coches con velocidades entre 50 y 100
        Camion camion1 = new Camion("1221ABC");
        camion1.setVelocidad((int) (50 + (Math.random() * 51)));
        Camion camion2 = new Camion("9889ZYX");
        camion2.setVelocidad((int) (50 + (Math.random() * 51)));
        Coche coche1 = new Coche("3333QQQ", 5);
        coche1.setVelocidad((int) (50 + (Math.random() * 51)));
        Coche coche2 = new Coche("7777FFF", 3);
        coche2.setVelocidad((int) (50 + (Math.random() * 51)));
        // Añadimos los 4 vehículos a la colección del controlador
        c.anhadirObjeto(camion1);
        c.anhadirObjeto(camion2);
        c.anhadirObjeto(coche1);
        c.anhadirObjeto(coche2);
        // Mostramos los objetos de la colección
        c.mostrarColeccion();
        // Poner un remolque de 5000kg a los camiones (de manera selectiva)
        for (Vehiculo vehiculo : c.getVehiculos()) {
            c.asignarRemolqueSiCamion(new Remolque(5000), vehiculo);
        }
        // Acelerar todos los vehículos con un valor entre 0 y 50
        for (Vehiculo vehiculo : c.getVehiculos()) {
            try {
                vehiculo.acelerar((int) (Math.random() * 51));
            } catch (DemasiadoRapidoException ex) {
                System.out.println(ex.getMessage()+"\nBajando velocidad a 100km/h...");
                //Logger.getLogger(MainPruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Volvemos a mostrar la información de todos los vehículos
        c.mostrarColeccion();
    }

}
