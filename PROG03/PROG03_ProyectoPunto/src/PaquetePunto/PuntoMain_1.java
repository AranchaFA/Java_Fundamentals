package PaquetePunto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class PuntoMain_1 {

    public static void main(String[] args) {

        // Declaración de variables
        Punto punto1;
        Punto punto2;
        float valorX;
        float valorY;

        punto1 = new Punto(); // Reserva espacio en memoria a la "caja" UML para este objeto
        punto2= new Punto();
        // Entrada de datos:
        valorX = (float) 5.3;
        valorY = (float) 10.1;

        // Proceso:
        System.out.println("Coordenadas iniciales de punto1");
        System.out.println("Coordenada X = " + punto1.getX());
        System.out.println("Coordenada Y = " + punto1.getY());

        System.out.println("Modificando coordenadas de punto1");
        punto1.setX(valorX);
        punto1.setY(valorY);

        // Salida:
        System.out.println("Coordenadas finales de punto1");
        System.out.println("Coordenada X = " + punto1.getX());
        System.out.println("Coordenada Y = " + punto1.getY());
        
        
        // Trabajamos con el punto 2:
        System.out.println("Trabajamos con punto2");
        punto2.setX(2);
        punto2.setY(5);
        
        System.out.println("Comparamos las coordenadas X de punto1 u punto2: ");
        if (punto1.getX()<punto2.getX()) {
            System.out.println("La coordenada X de punto1 ("+punto1.getX()+") es menor que la de punto2 ("+punto2.getX()+")");
        }
        else {
            System.out.println("La coordenada X de punto1 ("+punto1.getX()+") es mayor que la de punto2 ("+punto2.getX()+")");
        }
        
        System.out.println("Damos los atributos con un método que devuelva un String:");
        System.out.println(punto1.mostrarAtributos2());
        
        System.out.println("Damos los atributos con un método void que muestre un SOUT:");
        punto1.mostrarAtributos1();
    }

}
