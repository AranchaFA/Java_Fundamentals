/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejer2.Modelo;

import Ejer2.Modelo.*;
import java.util.LinkedList;

/**
 *
 * @author Arancha
 */
public class Inmobiliaria {

    // ATRIBUTOS
    private LinkedList<Contrato> contratos;

    // MÉTODOS
    // Getters + Setters
    public LinkedList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(LinkedList<Contrato> contratos) {
        this.contratos = contratos;
    }

    // toString
    @Override
    public String toString() {
        return "Inmobiliaria{" + "contratos=" + contratos + '}';
    }

    // Constructor
    public Inmobiliaria() {
        this.contratos = new LinkedList<>();
    }

    // Método para generar un objeto contrato
    // NO REGISTRA LA TRANSACCIÓN EN LA LIST
    // En vez de pasar un inmueble como parámetro pasamos un AlquilableVendible
    public Contrato generarUnContrato(AlquilableVendible av,String tipo,double precio){
        return new Contrato(av, tipo, precio);
    }
    
    // Generar y registrar un contrato
    public void generarYRegistrarContrato(AlquilableVendible av,String tipo,double precio){
        Contrato contrato=generarUnContrato(av, tipo, precio);
        this.contratos.add(contrato);
    }
    
    // Calcular las comisiones finales
    public double recaudacionFinalMostrandoContratos(){
        double totalComisiones=0;
        for (Contrato contrato : contratos) {
            System.out.println(contrato.toString());
            totalComisiones+=contrato.getComision();
            // Las no válidas están registradas con comisión 0
            if (contrato.getComision()==0) {
                System.out.println("Esta operación no fue posible... (no válida)");
            }
        }
        return totalComisiones;
    }
}
