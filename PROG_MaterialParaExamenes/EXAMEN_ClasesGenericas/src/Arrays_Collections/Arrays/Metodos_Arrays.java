package Arrays_Collections.Arrays;

import Arrays_Collections.DAOs.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodos_Arrays {

    // ATRIBUTOS
    private Object[] arrayObjetos;
    private int[] arrayInts;
    private int[][] arrayIntsDosDimensiones;
    private DAO_CSVs daoCSV;
    private DAO_Objetos daoObjetos;

    public Object[] getArrayObjetos() {
        return arrayObjetos;
    }

    public void setArrayObjetos(Object[] arrayObjetos) {
        this.arrayObjetos = arrayObjetos;
    }

    public int[] getArrayInts() {
        return arrayInts;
    }

    public void setArrayInts(int[] arrayInts) {
        this.arrayInts = arrayInts;
    }

    public DAO_CSVs getDaoCSV() {
        return daoCSV;
    }

    public void setDaoCSV(DAO_CSVs daoCSV) {
        this.daoCSV = daoCSV;
    }

    public DAO_Objetos getDaoObjetos() {
        return daoObjetos;
    }

    public void setDaoObjetos(DAO_Objetos daoObjetos) {
        this.daoObjetos = daoObjetos;
    }

    
    
    // LOS MÉTDOS NO DEVUELVEN LOS ARRAYS CREADOS/CARGADOS, LOS ASIGNAN A LOS
    // ATRIBUTOS DE ESTA CLASE!!! HAY QUE ADAPTARLO A CADA CASO
    // Crear un array de DOS DIMENSIONES VACÍO pasando las dimensiones por parámetro
    // Para datos tipo INT, adaptarlo a cada caso
    public void crearArrayDosDimensionesVacio(int numFilas, int numColumnas) {
        this.arrayIntsDosDimensiones = new int[numFilas][numColumnas];
    }

    // Crear un array de UNA DIMENSIÓN VACÍO pasando las dimensiones por parámetro
    // Para datos tipo OBJECT, adaptarlo a cada caso
    public void crearArrayUnaDimensionVacio(int dimension) {
        this.arrayInts = new int[dimension];
    }

    //Cargar un array con INT random entre 0 y 100
    public void cargarArrayIntAleatorios() {
        for (int i = 0; i < arrayInts.length; i++) {
            arrayInts[i] = (int) (Math.random() * 101);
        }
    }
/*
    // Cargar un array con objetos creados a partir de un CSV
    // (YA CREADO, con dimensión ya definida por tanto)
    // Este método iría en el CONTROLADOR pues utiliza un DAO
    public void cargarArrayObjetosDesdeCSV() {
        try {
            daoCSV.abrirLeer();
            for (int i = 0; i < this.arrayObjetos.length; i++) {
                Object objetoCreado = daoCSV.generarUnObjeto();
                this.arrayObjetos[i] = objetoCreado;
            }
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero CSV no encontrado. "+ex.getMessage());
            Logger.getLogger(Metodos_Arrays.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al leer CSV. "+ex.getMessage());
            Logger.getLogger(Metodos_Arrays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    
    
    // Crear y cargar un array con objetos creados a partir de un CSV
    // (NO CREADO, sacamos la dimensión según el nº de registros del CSV)
    // Este método iría en el CONTROLADOR pues utiliza un DAO
    public void crearArrayObjetosDesdeCSV() {
        this.arrayObjetos = new Object[daoCSV.contarRegistros()];
        try {
            daoCSV.abrirLeer();
            for (int i = 0; i < this.arrayObjetos.length; i++) {
                Object objetoCreado = daoCSV.generarUnObjeto(daoCSV.leerUnString());
                this.arrayObjetos[i] = objetoCreado;
            }
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero CSV no encontrado. "+ex.getMessage());
            Logger.getLogger(Metodos_Arrays.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al leer CSV. "+ex.getMessage());
            Logger.getLogger(Metodos_Arrays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Crear un fichero de objetos a partir de un array  de objetos
    // Este método iría en el CONTROLADOR pues utiliza un DAO
    public void generarFicheroObjDesdeArray() {
        try {
            daoObjetos.abrirGrabarSelectivo();
            for (Object objetoLeido : arrayObjetos) {
                daoObjetos.grabarUnObjeto(objetoLeido);
            }
            daoObjetos.cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al grabar objetos. " + ex.getMessage());
            Logger.getLogger(Metodos_Arrays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Crear un fichero CSV a partir de un array  de objetos
    // Este método iría en el CONTROLADOR pues utiliza un DAO
    public void generarFicheroCSVDesdeArray() {
        try {
            daoCSV.abrirGrabarAnhadir();
            for (Object objetoLeido : arrayObjetos) {
                String stringAGrabar=daoObjetos.generarStringAtributos(objetoLeido);
                daoCSV.grabarUnString(stringAGrabar);
            }
            daoCSV.cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al grabar objetos. " + ex.getMessage());
            Logger.getLogger(Metodos_Arrays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Mostrar los objetos del array mostrando su posición y las posiciones vacías
    public void mostrarObjetosArray() {
        for (int i = 0; i < arrayObjetos.length; i++) {
            if (arrayObjetos[i] != null) {
                System.out.println(i + ") " + arrayObjetos[i].toString());
            } else {
                System.out.println(i + ") Vacío");
            }
        }
    }

    // Mostrar el estado de las distintas posiciones del array
    public void mostrarEstadoPosicionesArray() {
        for (int i = 0; i < arrayObjetos.length; i++) {
            if (arrayObjetos[i] == null) {
                System.out.println("Posición libre.");
            } else {
                System.out.println("Posición ocupada.");
            }
        }
    }
    

    // Buscar la primera posición vacía del array
    // -1 si no hay ninguna posición vacía
    public int primeraPosicionVacia() {
        int posicionVacia = -1;
        int posicion = 0;
        while (posicionVacia < 0 && posicion < arrayObjetos.length) {
            if (arrayObjetos[posicion] == null) {
                posicionVacia = posicion;
            }
            posicion++;
        }
        return posicionVacia;
    }

    
    // BUSCAR UN OBJETO en el array (usando EQUALS)
    // Los objeto deben implementar Comparable<NombreClase> y sobreescribir equals y compareTo
    // Crearemos un objeto con el atributo por el que queremos comparar para pasar por parámetro
    // Si se encuentra, DEVOLVER EL ENCONTRADO y no el objetoABuscar, pues este último no incorpora
    // toda la información del objeto sino sólo el atributo a comparar
    public Object buscarUnObjetoEnArray(Object objetoABuscar) {
        Object objetoEncontrado = null;
        int posicion = 0;
        while (objetoEncontrado == null && posicion < arrayObjetos.length) {
            if (arrayObjetos[posicion].equals(objetoABuscar)) {
                objetoEncontrado = arrayObjetos[posicion];
            }
            posicion++;
        }
        return objetoEncontrado;
    }

    // Buscar un INT en un array de enteros, devuelve la posición en que se
    // encontró, -1 si no existe
    public int buscarUnNumero(int numeroABuscar){
        // Ordenamos el array para aplicar binarySearch
        Arrays.sort(arrayInts);
        // Buscamos el número, nos devuelve su posición (-1 si no existe)
        return Arrays.binarySearch(arrayInts, numeroABuscar);
    }
    
    // Ordenar array de INTs de manera ascendente
    public void ordenarArrayIntAScendente() {
        Arrays.sort(arrayInts);
    }

    
    // Ordenar array de INTs de manera descendente
    // Deben ser Integer, Collection no trabaja con datos primitivos
    public void ordenarArrayIntDescendente() {
        Integer[] arrayIntegers = new Integer[arrayInts.length];
        for (int i = 0; i < arrayInts.length; i++) {
            arrayIntegers[i] = Integer.valueOf(arrayInts[i]);
        }
        Arrays.sort(arrayIntegers, Collections.reverseOrder());
        // Copiamos el valor de los integer en las posiciones del array de ints
        // para que nos quede ordenado, pues nosotros queríamos ordenar
        // arrayInts y no arrayIntegers
        for (int i = 0; i < arrayIntegers.length; i++) {
            arrayInts[i] = arrayIntegers[i].intValue();
        }
    }

    
    // Ordenar un array de OBJETOS según el criterio del COMPARETO DE LA CLASE ORIGINAL
    public void ordenarArrayObjetos() {
        Arrays.sort(arrayObjetos);
    }

    
    // Ordenar un array de OBJETOS según el criterio del COMPARETO DE OTRA CLASE != LA ORIGINAL
    // En ClaseComparatorAtributo2 tenemos que cambiar implements Comparator<NOMBRECLASE> por 
    // la clase con la que trabajemos en cada caso
    public void ordenarArrayObjetosAtributo2() {
        Arrays.sort(arrayObjetos, new ClaseComparatorAtributo2());
    }

    
    
}
