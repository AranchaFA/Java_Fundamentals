
import Modelo.Timbre;
import java.util.Scanner;

public class Main_SuenaTimbre {

    public static void main(String[] args) {
        // Creamos teclado para meter el porcentaje
        Scanner teclado = new Scanner(System.in);

        // Creamos un timbre
        Timbre timbre = new Timbre();

        // Pedimos el porcentaje de veces activado y se lo asignamos al timbre
        System.out.println("¿Qué porcentaje (%) de veces quieres que suene el timbre?: ");
        timbre.setValorActivacion(teclado.nextInt());
        // Generamos un valor al azar (entre 1 y 100)
        int valorMedido = (int) ((Math.random() * 100 )+ 1);
        // Aplicamos el método activarse para ese valor
        timbre.activarse(valorMedido);
        // Mostramos el sonido, y el resultado completo con todos los atributos finales del timbre
        System.out.println("Primera intento: ");
        System.out.println(timbre.getSonido());
        System.out.println(timbre.toString());
        // Repetimos hasta 10 veces para comprobar que los porcentajes se cumplen
        System.out.println("Lo intentamos otras 9 veces más...");
        valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
        valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
        valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
        valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
        valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
        valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
        valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
        valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
       valorMedido = (int) ((Math.random() * 100 )+ 1);
        timbre.activarse(valorMedido);
        // Mostramos resultado completo con todos los atributos finales del timbre
        System.out.println("Décima prueba: ");
        System.out.println(timbre.toString());
        // Mostramos los valores de los porcentajes
        System.out.println("Comprobamos que los porcentajes se cumplen: ");
        System.out.println("Tiradas totales: " + timbre.getContadorTotal());
        System.out.println("Porcentaje de activaciones: " + timbre.porcentajeActivaciones() + "%");
    }

}
