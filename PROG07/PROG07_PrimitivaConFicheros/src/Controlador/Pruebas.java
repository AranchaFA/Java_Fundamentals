
package Controlador;

public class Pruebas {

    public static void main(String[] args) {
        
        Controlador c=new Controlador();
        Vista.Vista.mostrarColeccionJugadores(c.getJugadores());
        System.out.println("");
        System.out.println("");
        Vista.Vista.mostrarCombinacionGanadora(c.getCombinacionPremiada());
        System.out.println("");
        System.out.println("");
        c.asignarAciertosDeTodosLosJugadores();
        Vista.Vista.mostrarColeccionJugadoresPremioSiONo(c.getJugadores());
        System.out.println("");
        System.out.println("");
        c.grabarFicheroObjetosJugadoresPremiados(c.getJugadores());
        System.out.println("");
        System.out.println("");
        c.getDaoObjetos().mostrarFichero();
    }
    
}
