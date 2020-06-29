package Controlador;

import Modelo.DescomponerNumero;
import Modelo.Leer;

public class MainDescomponerNumero {

    public static void main(String[] args) {

        // Creamos objeto descomponerNumero
        DescomponerNumero descompositor = new DescomponerNumero();
        // Creamos teclado para introducir el número
        Leer teclado = new Leer();
        // Pedimos un número por pantalla verificando que es correcto
        // y volviendo a pedirlo hasta que sea correcto
        do {
            if (descompositor.getNumero()>9999) {
                Vista.VistaDescomponerNumero.numeroMayor4Cifras();
            }
            Vista.VistaDescomponerNumero.pedirNumero();
            descompositor.setNumero(teclado.datoInt());
        } while (!descompositor.numeroMenor9999(descompositor.getNumero()));
        // Descomponemos y mostramos resultado
        descompositor.descomponerNumero();
        System.out.println(descompositor.toString());
    }

}
