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
public interface Prestable {
    
    // Interface vacía, sólo sirve para que tanto libros como CDs puedan comportarse del mismo modo
    // al ser pasados como parámetros en el método de préstamo, pero este método será del controlador
    
    // Al final necesitamos un método para obtener el código (getter, para la key del map de Prestamos)!!
    public String obtenerCodigo();
}
