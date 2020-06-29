/*
Introducir el nombre y precio de un producto y mostrar:
Producto:  xxxxx
Precio: xxx,xx€
IVA (21%): xxx,xx€
PRECIO VENTA: xxx,xx€
 */
package prog02_ej004;

import java.util.Scanner;


public class PROG02_EJ004 {

    public static void main(String[] args) {
        // Definir las variables:
        float precio;
        String nombre;
        final float IVA=(float) 0.21;
        
        // Definimos objeto Scanner para introducir las variables:
        Scanner teclado=new Scanner(System.in);
        
        // Pedimos e introducimos por teclado las variables:
        System.out.println("Introduzca el nombre: ");
        nombre=teclado.nextLine();
        System.out.println("Introduzca el precio: ");
        precio=teclado.nextInt();
        
        // Calculamos IVA y PRECIO TOTAL:
        float iva=precio*IVA;
        float precioVenta=precio*(1+IVA);
        
        // Mostramos la información:
        System.out.println("Producto: "+nombre);
        System.out.println("Precio: "+precio);
        System.out.println("IVA (21%): "+iva);
        System.out.println("PRECIO VENTA: "+precioVenta);
    }
    
}
