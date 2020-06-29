
package ejercicio5Alarma.modelo;

public class Pesquero extends Barco{

    public int potencia;
    
    public Pesquero(int tripulacion, int eslora, String nombre,int potencia) {
        super(tripulacion, eslora, nombre);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    
    @Override
    public void saltarAlarma(String msg) {
       System.out.println("SALTA LA ALARMA EN...... "+ this.getClass().getSimpleName()+" "+nombre);
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
        return super.toString()+" Pesquero{" + "potencia=" + potencia +'}';
    }

}

