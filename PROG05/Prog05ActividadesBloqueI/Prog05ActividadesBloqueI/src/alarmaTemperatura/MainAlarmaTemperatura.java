/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarmaTemperatura;

import java.util.logging.Level;
import java.util.logging.Logger;
import gestionLibros_MVC.Modelo.Leer;

/**
 *
 * @author J
 */
public class MainAlarmaTemperatura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlarmaTemperatura alarma;
        int temperaturaQueActivaAlarma;
        int temperaturaAmbiente;
        
        System.out.println("introduce la temperatura a la que tiene que saltar la alarma:");
        temperaturaQueActivaAlarma= Leer.datoInt();
        alarma = new AlarmaTemperatura(temperaturaQueActivaAlarma);
        
        for (int i=0; i<=10;i++){
            temperaturaAmbiente = 20+((int)(Math.random()*10));
            alarma.setTemperaturaActual(temperaturaAmbiente);
            //visualizamos valores de la alarma
            System.out.println("Valor alarma antes de comprobar la temperatura: "+alarma.toString());
            alarma.comprobarTemperaturaAlarma();
            System.out.println("Valor alarma despues de comprobar la temperatura: "+alarma.toString()+"\n\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainAlarmaTemperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                        
    }
    
}
