/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class GestorSensores {

    // ATRIBUTOS
    ArrayList<Medicion> mediciones;

    // MÉTODOS
    // Getters + Setters
    public ArrayList<Medicion> getMediciones() {
        return mediciones;
    }

    public void setMediciones(ArrayList<Medicion> mediciones) {
        this.mediciones = mediciones;
    }

    // toString
    @Override
    public String toString() {
        return "GestorSensores{" + "mediciones=" + mediciones + '}';
    }

    // Constructores
    public GestorSensores() {
        mediciones = new ArrayList<>();
    }

    // Registrar una medición
    public void registrarMedicion(Medicion medicion) {
        this.mediciones.add(medicion);
    }

    // Calcular media de las mediciones de un determinado tipo de sensor y mostrarlas
    public double mediaSegunTipoSensor(String tipoSensor) {
        double total = 0;
        int contador = 0;
        System.out.println("MEDICIONES DE LOS SENSORES DE TIPO " + tipoSensor);
        for (Medicion medicion : mediciones) {
            if (medicion.getClass().getSimpleName().equalsIgnoreCase(tipoSensor)) {
                System.out.println(medicion.toString());
                contador++;
                total += medicion.getValorMedicion();
            }
        }
        return total / contador;
    }

    // Mostrar todas las mediciones de todos los sensores
    public void mostrarTodo() {
        System.out.println("MEDICIONES DE TODOS LOS SENSORES");
        for (Medicion medicion : mediciones) {
            System.out.println(medicion.toString());
        }
    }

}
