package Controlador;

import Modelo.AlarmaTemperatura;
import Modelo.Leer;

public class MainAlarmaTemperatura {

    public static void main(String[] args) throws InterruptedException {

        // Creamos una alarma pidiendo la temperaturaAlarma por teclado
        Leer teclado = new Leer();
        System.out.println("Temperatura de activación de la alarma (entre 20º-30º): ");
        AlarmaTemperatura alarma = new AlarmaTemperatura(teclado.datoInt());
        // Si el valor introducido no está dentro del intervalo permitido lo pedimos de nuevo
        while (alarma.getTemperaturaAlarma() < 20 && alarma.getTemperaturaAlarma() > 30) {
            System.out.println("Introduzca valor entre 20º-30º: ");
            alarma.setTemperaturaAlarma(teclado.datoInt());
        }
        // Medimos 10 veces una temperatura y comprobamos si debe saltar o no la alarma
        for (int i = 0; i < 10; i++) {
            System.out.println("");
            System.out.println("Valores antes de la comprobación Nº"+(i+1)+" de temperaturas: "+'\n'+alarma.toString());
            alarma.setTemperaturaActual((int) (20+Math.random()*10));
            alarma.comprobarTemperatura();
            System.out.println("Valores después de la comprobación Nº"+(i+1)+" de temperaturas: "+'\n'+alarma.toString());
            
            Thread.sleep(1000);
        }
        

    }

}
