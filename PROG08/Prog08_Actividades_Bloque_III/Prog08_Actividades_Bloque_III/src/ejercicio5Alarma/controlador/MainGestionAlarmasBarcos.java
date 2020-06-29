
package ejercicio5Alarma.controlador;

import ejercicio5Alarma.modelo.*;

public class MainGestionAlarmasBarcos {

    public static void main(String[] args) {
        
       Pesquero brabucon = new Pesquero(10,12, "Brabucon del Mar",447);
       Portaviones infantaLeonor = new Portaviones(150,100, "Infanta Leonor",20);
       BarcoPasajeros princesaDelNalon = new BarcoPasajeros(250,300, "Princesa del Nalon",2000);
       
       GestorAlarmas gestorAlarmas = new GestorAlarmas();
       
       //saltan las alarmas en los tres barcos
       gestorAlarmas.controlAlarmas(brabucon, "motor averiado");
       gestorAlarmas.controlAlarmas(infantaLeonor, "choque con iceberg, VIA DE AGUA");
       gestorAlarmas.controlAlarmas(princesaDelNalon, "golpe de mar, barco volcado");
       
       //mostrar situacion de los barcos     
        System.out.println("--------------------------\n"+brabucon.toString()+"\n\n");        
       System.out.println("--------------------------\n"+infantaLeonor.toString()+"\n\n");         
       System.out.println("--------------------------\n"+princesaDelNalon.toString()+"\n\n");
       
       
       //desactivar alarmas       
       gestorAlarmas.controlAlarmasOFF(brabucon);
        System.out.println("--------------------------\n"+brabucon.toString()+"\n\n");
        
       gestorAlarmas.controlAlarmasOFF(infantaLeonor);       
         System.out.println("--------------------------\n"+infantaLeonor.toString()+"\n\n");
         
       gestorAlarmas.controlAlarmasOFF(princesaDelNalon);
       System.out.println("--------------------------\n"+princesaDelNalon.toString()+"\n\n");
       
       
       
       
    }
    
}
