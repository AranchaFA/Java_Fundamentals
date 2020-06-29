package Controlador;

import Modelo.DAO_Int;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    // ATRIBUTOS
    DAO_Int daoPares;
    DAO_Int daoImpares;
    DAO_Int daoTodosOrdenados;

    // MÉTODOS
    // Getters + Setters
    public DAO_Int getDaoPares() {
        return daoPares;
    }

    public void setDaoPares(DAO_Int daoPares) {
        this.daoPares = daoPares;
    }

    public DAO_Int getDaoImpares() {
        return daoImpares;
    }

    public void setDaoImpares(DAO_Int daoImpares) {
        this.daoImpares = daoImpares;
    }

    public DAO_Int getDaoTodosOrdenados() {
        return daoTodosOrdenados;
    }

    public void setDaoTodosOrdenados(DAO_Int daoTodosOrdenados) {
        this.daoTodosOrdenados = daoTodosOrdenados;
    }

    // Constructor, no vamos a pasarle nombres de ficheros por parámetro porque 
    // los generamos nosotros
    public Controlador() {
        daoImpares = new DAO_Int("ficheroImpares.dat");
        daoPares = new DAO_Int("ficheroPares.dat");
        daoTodosOrdenados = new DAO_Int("ficheroTodosOrdenados.dat");
    }

    public void menu() {

        Scanner teclado = new Scanner(System.in);
        int opcionElegida;

        // Mostramos opciones
        do {
            System.out.println("- - M E N Ú - -");
            System.out.println("1. Generar dos ficheros de pares e impares.");
            System.out.println("2. Generar un fichero con todos los números ordenados.");
            System.out.println("3. Mostrar los tres ficheros.");
            System.out.println("4. Salir");
            System.out.println("Elija una opción: ");
            opcionElegida = teclado.nextInt();

            switch (opcionElegida) {
                case 1: {
                    try {
                        generarDosFicherosParesEImpares();
                    } catch (IOException ex) {
                        System.out.println("Error al generar los ficheros de pares/impares. " + ex.getMessage());
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 2:
                    if (daoImpares.getFicheroEnteros().exists()&&daoPares.getFicheroEnteros().exists()) {
                        generarFicheroTodosOrdenados();
                    }
                    else {
                        System.out.println("¡No existen los ficheros de pares e impares!\nDebes crearlos primero");
                    }
                    break;
                case 3:
                    if (daoImpares.getFicheroEnteros().exists()&&daoPares.getFicheroEnteros().exists()&&daoTodosOrdenados.getFicheroEnteros().exists()) {
                         mostrarFicheros();
                    }
                    else {
                        System.out.println("¡No existen los 3 ficheros!\nDebes crearlos primero");
                    }
                   
                    break;
                case 4:
                    System.out.println("¡ Adiós !");
                    break;
                default:
                    System.out.println("Opción no válida, por favor elija una opción del 1 al 3:");
                    opcionElegida = teclado.nextInt();
            }
        } while (opcionElegida != 4);

    }

    // Generar un fichero de enteros
    public void generarDosFicherosParesEImpares() throws IOException {
        // Generamos el fichero de pares
        daoPares.abrirGrabarNuevo();
        int contadorPares = 0;
        while (contadorPares < 10) {
            // Me dará un número entre 0-9, y le suma 0,10,20,... a medida que vaya
            // aumentando el contador. Dará una secuencia de números 0-9, 10-19, 20-29,...
            // de esta manera saldrán ordenados de menor a mayor, con el random solo
            // saldrían sin ordenar!
            int numGenerado = (int) ((Math.random() * 10)+contadorPares*10);
            if (numGenerado % 2 == 0) {
                daoPares.grabarUnEntero(numGenerado);
                contadorPares++;
            }
        }
        daoPares.cerrarGrabar();

        // Generamos el fichero de impares
        daoImpares.abrirGrabarNuevo();
        int contadorImpares = 0;
        while (contadorImpares < 10) {
            // Me dará un número entre 0-9, y le suma 0,10,20,... a medida que vaya
            // aumentando el contador. Dará una secuencia de números 0-9, 10-19, 20-29,...
            // de esta manera saldrán ordenados de menor a mayor, con el random solo
            // saldrían sin ordenar!
            int numGenerado = (int) ((Math.random() * 10)+contadorImpares*10);
            if (numGenerado % 2 != 0) {
                daoImpares.grabarUnEntero(numGenerado);
                contadorImpares++;
            }
        }
        daoImpares.cerrarGrabar();
    }

    // Generar un fichero con todos los números ordenados
    public void generarFicheroTodosOrdenados() {
        // Abrimos flujos de lectura/escritura
        try {
            daoImpares.abrirLeer();
            daoPares.abrirLeer();
            daoTodosOrdenados.abrirGrabarNuevo();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al abrir flujos para generar un fichero ordenado. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Leemos y grabamos ordenadamente en bucle
        int leidoPar = 110;
        int leidoImpar = 110;
        try {
            leidoPar = daoPares.leerUnEntero();
            leidoImpar = daoImpares.leerUnEntero();
        } catch (IOException ex) {
            System.out.println("Error al leer los primeros datos. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (leidoPar != 110 || leidoImpar != 110) {

            // DOY VALOR 110 A LOS ENTEROS LEÍDOS CUANDO SALTA EL EOFEx DE SU RESPECTIVO FICHERO
            // ASÍ ESE VALOR SIEMPRE SERÁ MAYOR QUE EL DEL ENTERO LEÍDO EN EL FICHERO QUE AÚN
            // NO SE HA TERMINADO Y SIEMPRE EJECUTARÁ EL IF QUE LEE Y GRABA LOS ENTEROS DE ESE
            // FICHERO SIN TERMINAR, HASTA LLEGAR AL FINAL DE ÉSTE. CUANDO LOS DOS HAYAN TERMINADO
            // Y SUS ENTEROS LEÍDOS VALGAN 110 SE DEJARÁ DE CUMPLIR LA CONDICIÓN DEL WHILE
            if (leidoPar < leidoImpar) {
                // Si el par es menor, grabamos ese número y leemos el siguiente del fichero de
                // pares para compararlo con el impar que aún no hemos grabado (no se lee un nuevo impar)
                try {
                    daoTodosOrdenados.grabarUnEntero(leidoPar);
                } catch (IOException ex) {
                    System.out.println("Error al grabar un dato par. " + ex.getMessage());
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    leidoPar = daoPares.leerUnEntero();
                } catch (EOFException ex) {
                    // Cuando finalice el archivo daremos valor 101 al entero supuestamente leído
                    leidoPar = 110;
                    System.out.println("Fin de fichero de pares. " + ex.getMessage());
                    //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("Error al leer un dato par. " + ex.getMessage());
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // Si el impar es menor, grabamos ese número y leemos el siguiente del fichero de
                // impares para compararlo con el par que aún no hemos grabado (no se lee un nuevo par)
                try {
                    daoTodosOrdenados.grabarUnEntero(leidoImpar);
                } catch (IOException ex) {
                    System.out.println("Error al grabar un dato impar. " + ex.getMessage());
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    leidoImpar = daoImpares.leerUnEntero();
                } catch (EOFException ex) {
                    // Cuando finalice el archivo daremos valor 101 al entero supuestamente leído
                    leidoImpar = 110;
                    System.out.println("Fin de fichero de impares. " + ex.getMessage());
                    //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("Error al leer un dato impar. " + ex.getMessage());
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // Cerramos flujos de lectura/escritura
        try {
            daoImpares.cerrarLeer();
            daoPares.cerrarLeer();
            daoTodosOrdenados.cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al cerrar flujos para generar un fichero ordenado. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Mostrar ficheros por pantalla para comprobar
    public void mostrarFicheros() {
        System.out.println("MOSTRANDO FICHERO DE IMPARES");
        daoImpares.mostrarFichero();

        System.out.println("");
        System.out.println("********************");
        System.out.println("");

        System.out.println("MOSTRANDO FICHERO DE PARES");
        daoPares.mostrarFichero();

        System.out.println("");
        System.out.println("********************");
        System.out.println("");

        System.out.println("MOSTRANDO FICHERO DE TODOS ORDENADOS");
        daoTodosOrdenados.mostrarFichero();
    }
    
   
}
