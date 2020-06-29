/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_demofile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Arancha
 */
public class OperacionesFicheros {

    // Método que me liste un directorio
    public File[] listarDirectorio(String ruta, String criterioOrdenacion) throws NullPointerException {
        // Trabajaremos con la clase File
        File fichero = new File(ruta);

        // Creamos un FicleNameFilter para usar más abajo
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith("a")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        // Creamos un array de ficheros
        File[] arrayDeFicheros = fichero.listFiles();

        // Creamos un Comparator para ordenar el array por tamaño
        Comparator<File> comparatorTamanio = new Comparator<File>() {
            @Override
            public int compare(File fichero1, File fichero2) {
                if (fichero1.length() < fichero2.length()) {
                    return 1;
                }
                if (fichero1.length() > fichero2.length()) {
                    return -1;
                }
                return 0;
            }
        };

        // Creamos un Comparator para ordenar el array por tamaño de nombre
        Comparator<File> comparatorLongitudNombre = new Comparator<File>() {
            @Override
            public int compare(File fichero1, File fichero2) {
                if (fichero1.getName().length() < fichero2.getName().length()) {
                    return 1;
                }
                if (fichero1.length() > fichero2.length()) {
                    return -1;
                }
                return 0;
            }
        };

        // Ordenamos el array con el criterio del comparator
        Arrays.sort(arrayDeFicheros, comparatorTamanio);

        // Pasamos el array a una List
        List<File> listFicheros = Arrays.asList(arrayDeFicheros);
        

        // Gestionamos el criterio de ordenación introducido
        if (criterioOrdenacion.equalsIgnoreCase("t")) {
            
        } else if (criterioOrdenacion.equalsIgnoreCase("l")) {
            
        }
        listFicheros.sort(comparadorElegido);
        
        return arrayDeFicheros;
    }
}
