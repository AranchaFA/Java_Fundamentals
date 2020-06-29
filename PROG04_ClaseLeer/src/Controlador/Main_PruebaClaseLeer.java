
package Controlador;

import Modelo.Leer;

public class Main_PruebaClaseLeer {

    public static void main(String[] args) {
        
        // Probamos todos los métodos creados en la clase leer:
        System.out.println("Introduce un String: ");
        String datoString=Leer.leerDato();
        System.out.println("Tu String: "+datoString);
        System.out.println("Introduce un short: ");
        short numShort=Leer.datoShort();
        System.out.println("Tu short: "+numShort);
        System.out.println("Introduce un int: ");
        int numInt=Leer.datoInt();
        System.out.println("Tu int: "+numInt);
        System.out.println("Introduce un long: ");
        long numLong=Leer.datoLong();
        System.out.println("Tu long: "+numLong);
        System.out.println("Introduce un float: ");
        float numFloat=Leer.datoFloat();
        System.out.println("Tu float: "+numFloat);
        System.out.println("Introduce un double: ");
        double numDouble=Leer.datoDouble();
        System.out.println("Tu double: "+numDouble);
    }
    
}
