
package Controlador;

import Modelo.Centralita;
import Modelo.Llamada;
import Modelo.LlamadaLocal;
import Modelo.LlamadaProvincial;

public class Main_CentralitaTelefonica {

    public static void main(String[] args) {
        
        // Creamos una centralita
        Centralita c=new Centralita();
        // Registramos varias llamadas y vamos mostrando el estado de la colección completa
        c.registrarLlamada(new LlamadaLocal("985625126", "985625121", 94));
        c.mostrarRegistroLlamadas();
        c.registrarLlamada(new LlamadaLocal("985625082", "985625084", 124));
        c.mostrarRegistroLlamadas();
        c.registrarLlamada(new LlamadaProvincial("985649403", "925676890", 86, 1));
        c.mostrarRegistroLlamadas();
        c.registrarLlamada(new LlamadaProvincial("985649403", "915989760", 166, 2));
        c.mostrarRegistroLlamadas();
        c.registrarLlamada(new LlamadaProvincial("985649403", "984607034", 48, 3));
        c.mostrarRegistroLlamadas();
        
        System.out.println("MOSTRANDO toString DE LA CENTRALITA:\n"+c.toString());
    }
    
}
