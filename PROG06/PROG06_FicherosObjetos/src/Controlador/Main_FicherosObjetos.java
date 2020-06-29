package Controlador;

import Modelo.Persona;

public class Main_FicherosObjetos {

    public static void main(String[] args) {

        // Creamos un controlador y 4 objetos persona para hacer la prueba
        ControladorObjetos c = new ControladorObjetos();
        Persona p1 = new Persona("Firulaisa", "Tal y Tal", 25);
        Persona p2 = new Persona("Calimera", "Cual y Tal", 45);
        Persona p3 = new Persona("Segismundo", "Talez y Cualez", 76);

        // Grabamos la primera persona con cabecera
        c.grabarUnObjetoConCabecera("personas.dat",p1);
        // Grabamos las otras 3 personas sin cabecera
        c.grabarUnObjetoSinCabecera("personas.dat", p2);
        c.grabarUnObjetoSinCabecera("personas.dat", p3);
        c.grabarUnObjetoSinCabecera("personas.dat", p4);

        // Mostramos por pantalla los objetos del fichero para comprobar
        /* 
        ME SACA SIEMPRE EL PRIMER REGISTRO (Firulais)
        Si no sobreescribo el toString en la clase Persona sí me muestra
        tantas direcciones de memoria diferentes como veces ejecuto leer,
        si pongo i=10 saca 10 punteros diferentes y no debería porque se 
        supone que sólo hay 4 objetos en el fichero, debería dar error.
        */
        for (int i = 0; i < 4; i++) {
          System.out.println(c.leerUnObjeto("personas.dat").toString());  
        }
        
    }

}
