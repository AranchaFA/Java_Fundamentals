package repasoexameneval2;

import Modelo.DAO_CSVs;
import Modelo.DAO_DatosPrimitivos;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RepasoExamenEval2 {

    public static void main(String[] args) {

        // DAOS
        Scanner teclado = new Scanner(System.in);
        DAO_CSVs daoCSV = new DAO_CSVs("enterosmayorde50.csv");
        DAO_DatosPrimitivos daoInt = new DAO_DatosPrimitivos("enterosaleatorios.dat");

        // Generamos un fichero de N enteros aleatorios de 1 a 100
        Vista.Vista.mostrarMensaje("¿Cuántos números quieres generar?");
        daoInt.generarFicheroRegistrosAleatorios(teclado.nextInt(), 100);
        // Mostramos para comprobar
        daoInt.mostrarFichero();

        // Lo pasamos a un CSV
        String stringGenerado="";
        try {
            // Abrir para leer el fichero de int y grabar CSV
            daoCSV.abrirGrabarAnhadir();
            daoInt.abrirLeer();

            // Leemos cada int y grabamos en CSV
             int enteroLeido;
             
            while (true) {
                enteroLeido = daoInt.leerUnRegistro();
                if (enteroLeido>50) {
                    stringGenerado+=String.valueOf(enteroLeido)+",";
                }
            }
        } catch (EOFException ex) {
            System.out.println("Fin de grabado del fichero. " + ex.getMessage());
            //   Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepasoExamenEval2.class.getName()).log(Level.SEVERE, null, ex);
        } 
           
        try {
            // Borramos la última coma, que sobra
            stringGenerado=stringGenerado.substring(0,stringGenerado.length()-1);
            // Salto de línea al final del copiado
            stringGenerado+="\n";
            // Grabamos el sting
            daoCSV.grabarUnString(stringGenerado);
            // Cerramos ficheros
            daoCSV.cerrarGrabar();
            daoInt.cerrarLeer();
        } catch (IOException ex) {
            Logger.getLogger(RepasoExamenEval2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Mostramos CSV para comprobar
        daoCSV.mostrarFicheroPorPantalla();
        
    }

}
