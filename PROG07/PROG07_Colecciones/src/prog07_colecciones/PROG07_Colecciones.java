package prog07_colecciones;

import java.util.*;

public class PROG07_Colecciones {

    public static void main(String[] args) {

        // Creamos una colección, como Set genérica para luego poder inicializarla como TreeSet,HashSet y LinkedSet
        Set<Persona> coleccionPersonas;

        /*
        // TreeSet
        coleccionPersonas = new TreeSet<>();
        // Añadimos personas a la colección
        coleccionPersonas.add(new Persona("Lola", "Hilo", 45));
        coleccionPersonas.add(new Persona("Lalo", "Coo", 18));
        coleccionPersonas.add(new Persona("Viti", "Cultor", 120));
        coleccionPersonas.add(new Persona("Marco", "Gol", 17));
        if (coleccionPersonas.add(new Persona("Lalo", "Coo", 333))) {
            // Con TreeSet no lo deja meter porque está repetido
            System.out.println("Se ha añadido.");
        } else {
            System.out.println("Ya existía esa persona.");
        }
        System.out.println("Número de personas en la ejecución: " + coleccionPersonas.size());

        // Recorrer y visualizar colección
        Iterator iterator = coleccionPersonas.iterator();
        while (iterator.hasNext()) {
            Persona persona = (Persona) iterator.next(); // Nos devuelve un Object genérico, lo convertimos en persona
            System.out.println(persona.toString());
        }
*/
        
       
        // HashSet
        coleccionPersonas = new HashSet<>();
        // Añadimos personas a la colección
        coleccionPersonas.add(new Persona("Lola", "Hilo", 45));
        coleccionPersonas.add(new Persona("Lalo", "Coo", 18));
        coleccionPersonas.add(new Persona("Viti", "Cultor", 120));
        coleccionPersonas.add(new Persona("Marco", "Gol", 17));
        // Metemos una persona con apellidos+nombre ya existente, según nuestro equals estará repetido
        if (coleccionPersonas.add(new Persona("Lalo", "Coo", 333))) {
            // Con HashSet sí me lo deja meter repetido ¿?
            System.out.println("Se ha añadido.");
        } else {
            System.out.println("Ya existía esa persona.");
        }
        System.out.println("Número de personas en la ejecución: " + coleccionPersonas.size());

        // Recorrer y visualizar colección
        Iterator iterator = coleccionPersonas.iterator();
        while (iterator.hasNext()) {
            Persona persona = (Persona) iterator.next(); // Nos devuelve un Object genérico, lo convertimos en persona
            System.out.println(persona.toString());
        }

 
 /*
        // LinkedSet
        coleccionPersonas = new LinkedHashSet<>();
        // Añadimos personas a la colección
        coleccionPersonas.add(new Persona("Lola", "Hilo", 45));
        coleccionPersonas.add(new Persona("Lalo", "Coo", 18));
        coleccionPersonas.add(new Persona("Viti", "Cultor", 120));
        coleccionPersonas.add(new Persona("Marco", "Gol", 17));
        // Metemos una persona con apellidos+nombre ya existente, según nuestro equals estará repetido
        if (coleccionPersonas.add(new Persona("Lalo", "Coo", 333))) {
            // Con LinkedHashSet sí me lo deja meter repetido ¿?
            System.out.println("Se ha añadido.");
        } else {
            System.out.println("Ya existía esa persona.");
        }
        System.out.println("Número de personas en la ejecución: " + coleccionPersonas.size());

        // Recorrer y visualizar colección, en colecciones hay que hacerlo con un objeto de la clase Iterator
        Iterator iterator = coleccionPersonas.iterator();
        while (iterator.hasNext()) {
            Persona persona = (Persona) iterator.next(); // Nos devuelve un Object genérico, lo convertimos en persona
            System.out.println(persona.toString());
        }
*/
 
        // Buscamos un objeto en la colección
        Persona personaABuscar=new Persona("Lola", "Hilo", 35);
        if (coleccionPersonas.contains(personaABuscar)) {
             iterator = coleccionPersonas.iterator(); // iterator ya estaba creado, reinicializamos para evitar errores
             Persona personaLeida;
         do {
            personaLeida=(Persona)iterator.next();
        } while (!personaLeida.equals(personaABuscar));
            System.out.println("Persona encontrada: \n"+personaLeida.toString());
            
            // Borramos un objeto de la colección
            System.out.println("Vamos a borrar a esta persona.");
            coleccionPersonas.remove(personaLeida);
        } else {
            System.out.println("La persona "+personaABuscar.toString()+" no existe en la colección.");
        }
        
        System.out.println("Visualiamos la colección final: ");
        iterator = coleccionPersonas.iterator();
        while (iterator.hasNext()) {
            Persona persona = (Persona) iterator.next(); // Nos devuelve un Object genérico, lo convertimos en persona
            System.out.println(persona.toString());
        }
        
    }
}
