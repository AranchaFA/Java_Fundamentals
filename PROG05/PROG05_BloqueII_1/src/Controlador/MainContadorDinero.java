package Controlador;

import Modelo.ContadorDinero;
import Modelo.Leer;

public class MainContadorDinero {

    public static void main(String[] args) {

        // Creamos un contador
        ContadorDinero contadorDinero = new ContadorDinero();
        // Creamos objeto teclado
        Leer teclado = new Leer();
        // Pedimos una cantidad de dinero
        Vista.VistaContadorDinero.introducirCantidad();
        // Comprobamos que la cantidad es correcta, volvemos a pedir hasta que lo sea
        while (!contadorDinero.introducirCantidadDinero(teclado.datoFloat())) {
            Vista.VistaContadorDinero.cantidadIncorrecta();
            Vista.VistaContadorDinero.introducirCantidad();
            contadorDinero.introducirCantidadDinero(teclado.datoFloat());
        }
        // Desglosamos la cantidad introducida
        contadorDinero.desglosarCantidadDinero();
        // Mostramos el resultado final
        System.out.println(contadorDinero.toString());
        // Mostramos el resultado con asteriscos
        contadorDinero.resultadoConAsteriscos();
    }
}
