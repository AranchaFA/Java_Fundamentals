package Arrays;

import DAOS.DAO_CSVs;
import DAOS.DAO_Objetos;

public class Main_ArraysPruebas {

    public static void main(String[] args) {

        Metodos_Arrays c = new Metodos_Arrays();

        // Ctrl+Espacio para ver el listado de métodos
        //c.
        
        Object[] arrayObjetos = new Object[4];
        arrayObjetos[2] = new Persona("Calimera", "Calimérez", 45);
        arrayObjetos[1] = new Persona("Tururú", "Tururúrez", 75);
        arrayObjetos[0] = new Persona("Tururú", "Tururúrez", 75);
        arrayObjetos[3] = new Persona("Tururú", "Tururúrez", 75);

        c.setArrayObjetos(arrayObjetos);
        /*
        System.out.println(c.primeraPosicionVacia());
        
        Object objetoEncontrado=c.buscarUnObjetoEnArray(new Persona("Calimera", "Tález", 0));
        if (objetoEncontrado!=null) {
            System.out.println(objetoEncontrado.toString());
        } else {
            System.out.println("Objeto no encontrado.");
        }
        
        
        c.mostrarEstadoPosicionesArray();
        c.mostrarObjetosArray();
         */

 /*
        int[] arrayEnteros = new int[5];
        c.setArrayInts(arrayEnteros);
        c.cargarArrayIntAleatorios();
        c.ordenarArrayIntsAScendente();
        for (int i = 0; i < c.getArrayInts().length; i++) {
            System.out.println(c.getArrayInts()[i]);
        }
        c.ordenarArrayIntsDescendente();
        for (int intLeido : c.getArrayInts()) {
             System.out.println(intLeido);
        }
         */
 /*
        // Habría que meter el fichero CSV en la carpeta del proyecto para probar
        c.setDaoCSV(new DAO_CSVs("pruebaCSV.csv"));
        c.setDaoObjetos(new DAO_Objetos("pruebaObjetos.dat"));
        c.crearArrayObjetosDesdeCSV();
        c.getDaoCSV().mostrarFicheroPorPantalla();
        c.generarFicheroObjDesdeArray();
        c.getDaoObjetos().mostrarFichero();
         */
    }

}
