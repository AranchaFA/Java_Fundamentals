package Controlador;

import Modelo.DAO_ObjetosPersona;
import Modelo.Persona;

public class Main_CSV_a_Objeto {

    public static void main(String[] args) {
        /*
        PRUEBINAS PARA VER SI VALE EL OBJECT PARA HACERLO MÁS GENÉRICO
        Persona objeto1=new Persona("Firu", "Laisa", 23);
        Object auxObjeto1=objeto1;
        System.out.println(auxObjeto1.toString());
        auxObjeto1=(Persona)auxObjeto1;
        System.out.println(auxObjeto1.toString());
         */

        // Creamos un controlador
        Controlador c = new Controlador("CSVEntradaPersonas.csv", "ficheroPersonasGenerado.dat");

        // Generamos el fichero de personas
        c.generarFicheroPersonasDesdeCSV();

        // Visualizo el fichero de personas para comprobar
        System.out.println("");
        System.out.println("******************");
        System.out.println("");
        System.out.println("Mostramos el fichero de objetos:");
        c.mostrarFicheroObjetos();
        
        // Visualizamos el CSV por verlo....
        System.out.println("");
        System.out.println("******************");
        System.out.println("");
        System.out.println("Mostramos el fichero CSV:");
        c.mostrarFicheroCSV();
    }

}
