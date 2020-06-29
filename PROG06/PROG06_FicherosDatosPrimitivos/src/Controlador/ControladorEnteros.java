package Controlador;

import Modelo.GrabarFicheroEnteros;
import Modelo.LeerFicheroEnteros;
import java.io.*;
import java.util.Scanner;

/*
Programa que lea un fichero de números enteros y genere otros 3:
1) Con los números pares
2) Con los números impares
3) Con los números mayores que no pedido por teclado, adaptando el nombre
   del fichero a cada caso llamándolo ficheroMayoresQueX.
 */
public class ControladorEnteros {

    // ATRIBUTOS
    
    // Objetos para leer y grabar enteros (se inicializarán en el constructor)
    private LeerFicheroEnteros lector;
    private GrabarFicheroEnteros grabadora;

    /* Ficheros de salida.
    NO HARÍAN FALTA PORQUE LOS CREA EL MÉTODO GRABAR DE LA GRABADORA
    private File ficheroPares;
    private File ficheroImpares;
    private File ficheroNumsMayores;
     */
    // nombre del archivo de origen y número a comparar
    String nombreArchivoOrigen;
    int num;

    // MÉTODOS
    
    // Getter del lector para mostrar los números en la comprobación del main
    public LeerFicheroEnteros getLector() {    
        return lector;
    }
    // Getter de num y nombreFicheroOrigen, también lo necesitaremos en el 
    // main para mostrar el fichero
    public int getNum() {
        return num;
    }

    public String getNombreArchivoOrigen() {
        return nombreArchivoOrigen;
    }
    

    // Constructor. Inicializamos grabadora y lector.
    public ControladorEnteros() {
        grabadora = new GrabarFicheroEnteros();
        lector = new LeerFicheroEnteros();
    }

    // Método para pedir el archivo de entrada y el número X a comparar
    public void pedirInformacion() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Qué archivo desea leer?: ");
        nombreArchivoOrigen = teclado.nextLine();
        System.out.println("Desea conocer los números mayores de...: ");
        num = teclado.nextInt();
    }

    // Método leer y grabar selectivamente un entero del fichero origen
    // Devolverá true si ha podido ejecutar la lectura, si ha roto en el método
    // leer devolverá false. NOS HARÁ FALTA EN EL MAIN PARA CONTROLAR EL WHILE.
    public boolean leerYGrabarUnEntero() {
        boolean auxReturn=false; 
        
        // Inicializamos los File
        /* NO HACE FALTA, PORQUE NO LOS NECESITAMOS COMO ATRIBUTOS
        ficheroPares=new File("ficheroPares.dat");
        ficheroImpares=new File("ficheroImpares.dat");
        ficheroNumsMayores=new File("ficheroMayoresQue"+num+".dat");
        */ 
        
        try {
            // Leemos un entero del fichero de origen y guardamos su valor
            // en una variable auxiliar.
            int enteroLeido = lector.leerUnEntero(nombreArchivoOrigen);
            // Si ha roto el método leer enteroLeido quedará sin valor asignado,
            // y dividiendo cualquier número entre él me dará una excepción
            int auxExcepcion=1/enteroLeido;
            // Si no ha roto el método de lectura (EOFEx) cambiará a auxReturn=true
            auxReturn=true;
            
            // Comprobamos si es par o impar
            if (enteroLeido % 2 == 0) {
                // Grabamos el número en el fichero de Pares
                grabadora.grabarUnEntero(enteroLeido, "ficheroPares.dat");
            } else {
                // Grabamos el número en el fichero de Pares
                grabadora.grabarUnEntero(enteroLeido, "ficheroImpares.dat");
            }
            // Comprobamos si es mayor que num.
            if (enteroLeido > num) {
                // Grabamos el número en el fichero de mayores que num
                grabadora.grabarUnEntero(enteroLeido, "ficheroMayoresQue" + num + ".dat");
            }
            } catch (ArithmeticException e) {
                System.out.println("Final de fichero. "+e.getMessage());
            }        
        return auxReturn;
    }
}
