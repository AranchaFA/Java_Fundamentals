/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Cápsula para cafetera
 * @author Arancha
 */
public class Capsula {
    
    private String tipoCafe;
    private String marca;
    private String fechaCaducidad;
    
    /**
     * Constructor pasando por parámetro el tipo de café y la fecha de caducidad.
     * @param tipoCafe
     * @param fechaCaducidad
     */
    public Capsula(String tipoCafe, String fechaCaducidad) {
        this.tipoCafe = tipoCafe;
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * Constructor pasando por parámetro los tres atributos de la cápcula:
     * tipo y marca del café, y fecha de caducidad.
     * @param tipoCafe
     * @param marca
     * @param fechaCaducidad
     */
    public Capsula(String tipoCafe, String marca, String fechaCaducidad) {
        this.tipoCafe = tipoCafe;
        this.marca = marca;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
}
