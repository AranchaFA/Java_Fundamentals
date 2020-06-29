
package ejercicio5Alarma.modelo;

public class GestorAlarmas {
    public void controlAlarmas( ElementoConAlarma x, String msg){
        x.saltarAlarma(msg);
    }
    
    public void controlAlarmasOFF( ElementoConAlarma x){
        x.anularAlarma();
    }
}
