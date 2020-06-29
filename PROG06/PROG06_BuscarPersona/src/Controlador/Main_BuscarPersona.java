
package Controlador;

import Modelo.Persona;

public class Main_BuscarPersona {

    public static void main(String[] args) {
        
     Controlador c=new Controlador("ficheroPersonasGenerado.dat");
     
     Persona p1=new Persona("Cali", "Mera", 34);
     Persona p2=new Persona("Yo", "Misma", 37);
     c.getDaoBuscarPersona().setPersonaABuscar(p1);
     
     Persona encontrado=c.buscarPersonaEnTodoElFichero();
        if (encontrado!=null) {
            System.out.println("Se ha encontrado a la persona y es:");
            System.out.println(encontrado.toString());
        } else {
            System.out.println("No se ha encontrado la persona.");
        }
     
    }
    
}
