package ejercicio3VehiculosCocheCamion.controlador;

import java.util.*;
import ejercicio3VehiculosCocheCamion.modelo.Camion;
import ejercicio3VehiculosCocheCamion.modelo.Coche;
import ejercicio3VehiculosCocheCamion.modelo.Remolque;
import ejercicio3VehiculosCocheCamion.modelo.Vehiculo;

public class GestionVehiculos {

    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList();

        listaVehiculos.add(new Coche("1234 AAA", 3));
        listaVehiculos.add(new Camion("2222 BBB"));
        listaVehiculos.add(new Coche("3333 CCC", 5));
        listaVehiculos.add(new Camion("4444 DDD"));

        //recorrer lista y ponemos remolque a los objetos Camion
        System.out.println("estado original de los vehiculos");
        for (Vehiculo v : listaVehiculos) {
            v.setVelocidad(Math.random() * 50 + 60);
            if (v instanceof Camion) {
                Remolque remolque = new Remolque(5000);
                ((Camion) v).ponRemolque(remolque);
            }
            System.out.println(v.toString());
        }

        //aceleramos 
        System.out.println("\n\n aceleramos y modificamos su velocidad");
        for (Vehiculo v : listaVehiculos) {
            //es aqui donde pueda saltar la excepción

            double acelerar = Math.random() * 50;
            System.out.println("\nAcelerando en " + acelerar + " a.... " + v.toString());
            v.acelerar(acelerar);   
            System.out.println("DESPUES DE ACELERAR "+v.toString()+"\n");

        }

    }

}
