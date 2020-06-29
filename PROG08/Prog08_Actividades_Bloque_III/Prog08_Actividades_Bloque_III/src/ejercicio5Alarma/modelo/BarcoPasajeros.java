
package ejercicio5Alarma.modelo;

public class BarcoPasajeros extends Barco{

    // ATRIBUTOS
    public int pasaje;
    
    // MÉTODOS
    // Constructor
    public BarcoPasajeros(int tripulacion, int eslora, String nombre,int pasaje) {
        super(tripulacion, eslora, nombre);
        this.pasaje = pasaje;
    }

    // Getters + Setters
    public int getPasaje() {
        return pasaje;
    }

    public void setPasaje(int pasaje) {
        this.pasaje = pasaje;
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
        return super.toString()+" Pesquero{" + "pasaje=" + pasaje +'}';
    }
}

