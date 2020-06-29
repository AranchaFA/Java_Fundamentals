/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class GestorVentas {

    // ATRIBUTOS
    private ArrayList<Venta> ventas;

    // MÉTODOS
    // Getters + Setters
    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    // toString
    @Override
    public String toString() {
        return "GestorVentas{" + "ventas=" + ventas + '}';
    }

    // Constructor
    public GestorVentas() {
        ventas = new ArrayList<>();
    }

    // Registrar una venta (no la uso al final)
    public void registrarVenta(Venta venta) {
        ventas.add(venta);
    }

    // Generar un objeto venta de x unidades de UN producto
    // NO REGISTRA LA VENTA EN LA LISTA DE VENTAS !!!
    public Venta generarUnObjetoVenta(Producto producto, int numUnidades) {
        System.out.println("Venta de "+numUnidades+" unidades de "+producto.getClass().getSimpleName());
        Venta venta = new Venta(producto, numUnidades, producto.calcularImporte(numUnidades));
        return venta;
    }
    
    // Tramitar la venta de VARIOS productos diferentes
    // SÍ REGISTRA TODAS LAS VENTAS INDIVIDUALES DE LOS PRODUCTOS EN LA LISTA DE VENTAS
    public void tramitarVentaVariosProductos(ArrayList<Venta> ventas){
        double importeTotal = 0;
        for (Venta venta : ventas) {
            importeTotal+=venta.getImporte();
        }
        this.ventas.addAll(ventas);
        System.out.println("Importe total : "+importeTotal+"€");
    }
    
    // Mostrar listado ventas y recaudación final
    public void mostrarVentasYRecaudacion(){
        double recaudacion = 0;
        System.out.println("VENTAS DEL DÍA :");
        for (Venta venta : ventas) {
            recaudacion+=venta.getImporte();
            System.out.println(venta.toString());
        }
        System.out.println("RECAUDACIÓN DEL DÍA : "+recaudacion+"\n");
    }
    
    // Mostrar la recaudación y el nº de unidades vendidas de un tipo de producto pasado por parámetro
    public void recaudacionSegunTipoProdcuto(String tipoProducto){
        int unidadesVendidas=0;
        double recaudacion=0;
        for (Venta venta : ventas) {
            if (venta.getProducto().getClass().getSimpleName().equalsIgnoreCase(tipoProducto)) {
                recaudacion+=venta.getImporte();
                unidadesVendidas+=venta.getNumUnidades();
            }
        }
        System.out.println("VENTAS DEL DÍA DE "+tipoProducto+" : ");
        System.out.println("Unidades : "+unidadesVendidas);
        System.out.println("Recaudación : "+recaudacion);
    }
    
    
    public void mostrarMenu() {
        int opcion;
        do {
            Scanner teclado = new Scanner(System.in);

            System.out.println("*** M E N Ú ***");
            System.out.println("1. Visualizar ventas totales");
            System.out.println("2. Visualizar ventas de un tipo");
            System.out.println("0. Salir");
            System.out.println("\n¿Qué quieres hacer?");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    mostrarVentasYRecaudacion();
                    break;
                case 2:
                    System.out.println("¿De qué tipo de producto?");
                    teclado.nextLine();
                    String tipoProducto=teclado.nextLine();
                    recaudacionSegunTipoProdcuto(tipoProducto);
                    break;
                case 0:
                    System.out.println("¡ Adiós !");
                    break;
                default:
                    System.out.println("Opción no válida, por favor introduce un número entre 0 y 2:");
                    opcion=teclado.nextInt();
            }

        } while (opcion!=0);

    }
}
