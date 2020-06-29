
package Controlador;

import Modelo.Producto;
import Modelo.Tienda;
import java.util.Scanner;

public class Main_Ej8 {

    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
        
        // Creamos tres productos y la tienda
        Producto producto1;
        Producto producto2;
        Producto producto3;
        
        Tienda tienda;
        
        // Inicializamos los 3 productos
        producto1=new Producto("garbanzos", (float) 5.0);
        producto2=new Producto("lentejas", (float) 4.0);
        producto3=new Producto("fabas", (float) 3.2);
        
        tienda=new Tienda("MiTiendina", "00000000A");
        
        // Adjudicamos los parámetros que faltan pedidos por teclado
        System.out.println("Marca del producto 1: ");
        producto1.setMarca(teclado.nextLine());
        System.out.println("Peso del producto 1: ");
        producto1.setPeso(teclado.nextFloat());
        teclado.nextLine(); // Vaciar el espacio del buffer
         
        System.out.println("Marca del producto 2: ");
        producto2.setMarca(teclado.nextLine());
        System.out.println("Peso del producto 2: ");
        producto2.setPeso(teclado.nextFloat());
        teclado.nextLine(); // Vaciar el espacio del buffer
        
        System.out.println("Marca del producto 3: ");
        producto3.setMarca(teclado.nextLine());
        System.out.println("Peso del producto 3: ");
        producto3.setPeso(teclado.nextFloat());
        teclado.nextLine(); // Vaciar el espacio del buffer
        
        // Asignamos los 3 productos como atributos a la tienda
        tienda.setProducto1(producto1);
        tienda.setProducto2(producto2);
        tienda.setProducto3(producto3);
        
        // Visualizamos todos los datos de los 3 productos con los métodos de los productos
        System.out.println("Los productos que tenemos en tienda son (con los métodos de los productos): ");
        System.out.println("Prodcuto 1: "+producto1.toString());
        System.out.println("Prodcuto 2: "+producto2.toString());
        System.out.println("Prodcuto 3: "+producto3.toString());
        // Visualizamos los datos de los 3 productos con los métodos de la tienda
        System.out.println("Los productos que tenemos en tienda son (con los métodos de la tienda): ");
        System.out.println("Producto 1: "+tienda.getProducto1().toString());
        System.out.println("Producto 2: "+tienda.getProducto2().toString());
        System.out.println("Producto 3: "+tienda.getProducto3().toString());
        
        // Mostrar el producto más caro de la tienda 
        System.out.println("El producto más caro de la tienda es: ");
        System.out.println(tienda.masCaro());
        
        // Vendemos una cantidad pedida por teclado de producto 1
        System.out.println("¿Qué cantidad de"+tienda.getProducto1().getDescripcion()+" desea?");
        tienda.getProducto1().setPeso(teclado.nextFloat());
        System.out.println("La información del producto es: "+tienda.getProducto1().toString());
        System.out.println("El importe a pagar es: "+tienda.venta(producto1));
    }
    
}
