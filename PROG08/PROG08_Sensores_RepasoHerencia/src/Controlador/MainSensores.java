/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class MainSensores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creamos un gestor de sensores
        System.out.println("Creamos un gestor de sensores");
        GestorSensores g = new GestorSensores();

        // Creamos un sensor de cada tipo
        System.out.println("Creamos tres sensores");
        SensorLuz sl = new SensorLuz(1);
        SensorPolvo sp = new SensorPolvo(2);
        SensorTemperatura st = new SensorTemperatura(3);

        // Realizamos 10 mediciones con ellos aleatoriamente 
        System.out.println("Realizamos 10 mediciones eligiendo al azar el sensor y las registramos");
        for (int i = 0; i < 10; i++) {
            double valorMedido=0;
            int aleatorio = (int) (Math.random() * 3 + 1);
            System.out.println("Valor aleatorio "+aleatorio);
            switch (aleatorio) {
                case 1:
                    System.out.println("Elegido el 1");
                    sl.activar();
                    valorMedido=sl.tomarMedicion();
                    sl.desactivar();
                    g.registrarMedicion(new Medicion(sl, valorMedido));
                    break;
                case 2:
                    System.out.println("Elegido el 2");
                    sp.activar();
                    valorMedido=sp.tomarMedicion();
                    sp.desactivar();
                    g.registrarMedicion(new Medicion(sp, valorMedido));
                    break;
                case 3:
                    System.out.println("Elegido el 3");
                    st.activar();
                    valorMedido=st.tomarMedicion();
                    st.desactivar();
                    g.registrarMedicion(new Medicion(st, valorMedido));
                    break;
            }
            // No llega a salir del switch en algún caso...... ¿?
            System.out.println("Finalizando medición número "+(i+1));
        }
        System.out.println("Finalizadas las mediciones");
        // Mostramos todos los registros de un tipo de sensor
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿De qué tipo de sensor quieres saber la media?");
        String tipoSensor=teclado.nextLine();
        g.mediaSegunTipoSensor(tipoSensor);
        // Mostramos las mediciones de todos los sensores
        System.out.println("");
        g.mostrarTodo();
    }

}
