/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author Arancha
 */
public class MainVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos un gestor de ventas y un objeto de cada tipo
        GestorVentas g=new GestorVentas();
        Bota bota=new Bota("Bota", 10);
        Camisa camisa=new Camisa("Camisa", 35);
        Deportiva deportiva=new Deportiva("Tenis", 50);
        Pantalon pantalon=new Pantalon("Pantalón", 45);
        Zapato zapato=new Zapato("Zapatos", 67);
        
        // Generamos alguna venta individual y la guardamos en una lista para el total
        ArrayList<Venta> ventasATramitar=new ArrayList<>();
        ventasATramitar.add(g.generarUnObjetoVenta(zapato, 1));
        ventasATramitar.add(g.generarUnObjetoVenta(bota, 2));
        ventasATramitar.add(g.generarUnObjetoVenta(camisa, 3));
        
        // Tramitamos el pedido completo
        g.tramitarVentaVariosProductos(ventasATramitar);
        
        // Mostramos toda la recaudación por ahora
        g.mostrarVentasYRecaudacion();
        
        // Mostramos la recaudación de camisas y deportivas (no se vendieron)
        g.recaudacionSegunTipoProdcuto("Camisa");
        g.recaudacionSegunTipoProdcuto("deportiva");
        
        // Ejecutamos el menú
        g.mostrarMenu();
    }
    
}
