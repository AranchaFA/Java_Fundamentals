
package Controlador;

import Modelo.Persona;
import Modelo.Aseo;

public class Main_Aseo {

    public static void main(String[] args) {
        
        // Creamos 3 personas usuarias
        Persona usuario1=new Persona("M","Calimera");
        Persona usuario2=new Persona("H","Priscilo");
        Persona usuario3=new Persona("M","Edemira");
        // Creamos un baño
        Aseo aseo=new Aseo();
        // Mostramos los datos de los tres usuarios
        System.out.println("Estos son los datos de los tres usuarios: ");
        System.out.println(usuario1.toString()+'\n'+usuario2.toString()+'\n'+usuario3.toString());
        // Metemos a usuario1
        System.out.println("Intentamos meter a usuario1: ");
        if (aseo.entrarUsuario(usuario1)) {
            System.out.println("LIBRE");
            aseo.entrarUsuario(usuario1);
        } else {
            System.out.println("OCUPADO");
        }
        System.out.println("Mostramos el estado actual del baño: "+'\n'+aseo.toString());
        // Intentamos meter a usuario2 sin haber sacado a usuario1
        System.out.println("Intentamos meter a usuario2 sin sacar a usuario1: ");
        if (aseo.entrarUsuario(usuario2)) {
            System.out.println("LIBRE");
            aseo.entrarUsuario(usuario2);
        } else {
            System.out.println("OCUPADO");
        }
        System.out.println("Mostramos el estado actual del baño: "+'\n'+aseo.toString());
        // Sacamos a usuario1
        System.out.println("Sacamos a usuario1.");
        aseo.salirUsuario();
        System.out.println("¡HASTA LUEGO!");
        System.out.println("Mostramos el estado actual del baño: "+'\n'+aseo.toString());
        // Intentamos meter a usuario2 habiendo sacado a usuario1
        System.out.println("Intentamos meter a usuario2: ");
        if (aseo.entrarUsuario(usuario2)) {
            System.out.println("LIBRE");
            aseo.entrarUsuario(usuario2);
        } else {
            System.out.println("OCUPADO");
        }
        System.out.println("Mostramos el estado actual del baño: "+'\n'+aseo.toString());
        // Sacamos a usuario2
        System.out.println("Sacamos a usuario2");
        aseo.salirUsuario();
        System.out.println("¡HASTA LUEGO!");
        System.out.println("Mostramos el estado actual del baño: "+'\n'+aseo.toString());
        // Intentamos meter a usuario3 habiendo sacado a usuario2
        System.out.println("Intentamos meter a usuario3: ");
        if (aseo.entrarUsuario(usuario3)) {
            System.out.println("LIBRE");
            aseo.entrarUsuario(usuario3);
        } else {
            System.out.println("OCUPADO");
        }
        System.out.println("Mostramos el estado actual del baño: "+'\n'+aseo.toString());
        
    }
    
}
