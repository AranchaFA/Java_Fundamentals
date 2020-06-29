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
public interface AlquilableVendible {
    
    public double calcularComisionAlquiler(double precio);
    public double calcularComisionVenta(double precio);
}
