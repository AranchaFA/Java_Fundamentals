/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Camion;
import Modelo.Remolque;
import Modelo.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Arancha
 */
public class Controlador {

    // ATRIBUTOS
    private ArrayList<Vehiculo> vehiculos;

    
    
    // MÉTODOS
    
    // Getters + Setters
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    // Constructor
    public Controlador() {
        this.vehiculos = new ArrayList();
    }

    // Visualizar los objetos de la colección
    public void mostrarColeccion() {
        System.out.println("\n--  MOSTRANDO COLECCIÓN COMPLETA  --");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }
        System.out.println("");
    }

    // Añadir un objeto a la colección
    public void anhadirObjeto(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    /*   // Comprobar si un vehículo es camión
    public boolean comprobarSiCamion(Vehiculo vehiculo) {
    if (vehiculo instanceof Camion) {
    return true;
    } else {
    return false;
    }
    }*/

    // Asignar un remolque a un vehículo SI ES CAMIÓN
    public void asignarRemolqueSiCamion(Remolque remolque, Vehiculo vehiculo) {
        if (vehiculo instanceof Camion) {
            Camion camion = (Camion) vehiculo;
            camion.ponerRemolque(remolque);
        }
    }
}
