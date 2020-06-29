/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Arancha
 */
public class Casa extends Inmueble{

    // Constructor
    public Casa(String id) {
        super(id);
    }

    // toString
    @Override    
    public String toString() {
        return super.toString()+"InstanceOf: "+this.getClass().getSimpleName();
    }

    // Las casas no se pueden alquilar
    @Override
    public double calcularComisionAlquiler(double precio) {
        System.out.println("¡¡ Este inmueble no está disponible para alquilar !! (Es de tipo "+this.getClass().getSimpleName()+")");
        return 0;
    }

    @Override
    public double calcularComisionVenta(double precio) {
        return precio*0.1;
    }
    
    
}
