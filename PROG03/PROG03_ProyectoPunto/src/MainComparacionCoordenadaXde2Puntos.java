/*
Pues eso...
 */

public class MainComparacionCoordenadaXde2Puntos {

    public static void main(String[] args) {
        //ATRIBUTOS
        // MÉTODOS
        //Declaración
        Punto pto1, pto2;

        pto1 = new Punto();
        pto2 = new Punto();

        pto1.setX(6);
        pto1.setY((float) 3.5);

        pto2.setX((float) 16.3);
        pto2.setY(12);

        System.out.println("pto1: x=" + pto1.getX() + " y=" + pto1.getY() + ".");
        System.out.println("pto2: x=" + pto2.getX() + " y=" + pto2.getY() + ".");

        System.out.println("Comparamos las coordenadas X de punto1 u punto2: ");
        if (pto1.getX() < pto2.getX()) {
            System.out.println("La coordenada X de punto1 (" + pto1.getX() + ") es menor que la de punto2 (" + pto2.getX() + ")");
        } else {
            System.out.println("La coordenada X de punto1 (" + pto1.getX() + ") es mayor que la de punto2 (" + pto2.getX() + ")");
        }
    }

}
