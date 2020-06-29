
package ejercicio5Alarma.modelo;

public class Portaviones extends Barco{

    public int numAviones;
    
    public Portaviones(int tripulacion, int eslora, String nombre,int numAviones) {
        super(tripulacion, eslora, nombre);
        this.numAviones = numAviones;
    }

    public int getNumAviones() {
        return numAviones;
    }

    public void setNumAviones(int numAviones) {
        this.numAviones = numAviones;
    }

    
    
     @Override
    public void saltarAlarma(String msg) {
       System.out.println("SALTA LA ALARMA EN ..... "+ this.getClass().getSimpleName()+" "+nombre);
       alarma.activarAlarma();
       alarma.msgSocorro(msg);
    }

    @Override
    public void anularAlarma() {
        alarma.desactivarAlarma(); 
        System.out.println("Alarma desactivada en "+ this.getClass().getSimpleName()+" "+nombre);
    }   
       
    @Override
    public String toString() {
        return super.toString()+" Pesquero{" + "numAviones=" + numAviones +'}';
    }

}

