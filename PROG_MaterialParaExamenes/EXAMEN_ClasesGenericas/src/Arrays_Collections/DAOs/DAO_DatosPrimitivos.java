package Arrays_Collections.DAOs;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_DatosPrimitivos {

    // ATRIBUTOS
    private File ficheroDatosPrimitivos;
    // Para leer el archivo
    private FileInputStream fis;
    private DataInputStream dis;
    // Para grabar el archivo
    private FileOutputStream fos;
    private DataOutputStream dos;

    // MÉTODOS
    // Getters + Setters
    public File getFicheroDatosPrimitivos() {
        return ficheroDatosPrimitivos;
    }

    public void setFicheroDatosPrimitivos(File ficheroDatosPrimitivos) {
        this.ficheroDatosPrimitivos = ficheroDatosPrimitivos;
    }

    /* CONSTRUCTORES:
    1.- Metiendo el OBJETO File ya creado.
    2.- Metiendo el NOMBRE del fichero para crear el objeto file.
    (Para leer debe existir el archivo, para grabar no obligatoriamente).
     */
    public DAO_DatosPrimitivos(File ficheroDatosPrimitivos) {
        this.ficheroDatosPrimitivos = ficheroDatosPrimitivos;
    }

    public DAO_DatosPrimitivos(String nombreFichero) {
        this.ficheroDatosPrimitivos = new File(nombreFichero);
    }

    // PARA LEER
    public void abrirLeer() throws FileNotFoundException {
        fis = new FileInputStream(ficheroDatosPrimitivos);
        dis = new DataInputStream(fis);
    }

    public void cerrarLeer() throws IOException {
        dis.close();
        fis.close();
    }

    // Método para leer un INT, habría que adaptarlo para otros tipos de datos primitivos
    // dis.readUTF() para STRING
    public int leerUnRegistro() throws IOException {
        int enteroLeido = dis.readInt();
        return enteroLeido;
    }

    // PARA GRABAR 
    // Añadiendo al final de un fichero existente
    public void abrirGrabarAnhadir() throws FileNotFoundException {
        fos = new FileOutputStream(ficheroDatosPrimitivos, true);
        dos = new DataOutputStream(fos);
    }

    // Sobreescribiendo un fichero existente
    public void abrirGrabarSobreescribir() throws FileNotFoundException {
        fos = new FileOutputStream(ficheroDatosPrimitivos);
        dos = new DataOutputStream(fos);
    }

    public void cerrarGrabar() throws IOException {
        dos.close();
        fos.close();
    }

    // Método para leer un INT, habría que adaptarlo para otros tipos de datos primitivos
    // dis.writeUTF() para STRING
    public void grabarUnRegistro(int enteroAGrabar) throws IOException {
        dos.writeInt(enteroAGrabar);
    }

    // Generar un fichero con X números aleatorios entre el 0 y el N
    // Pedimos X y N por teclado
    public void generarFicheroRegistrosAleatorios(int numRegistros, int valorMax) {

        try {
            // Abrimos para grabar
            abrirGrabarAnhadir();

            // Generamos enteros en bucle y grabamos
            for (int i = 0; i < numRegistros; i++) {
                int enteroAGrabar = (int) (Math.random() * (valorMax + 1));
                grabarUnRegistro(enteroAGrabar);
            }

            // Cerramos fichero
            cerrarGrabar();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al tratar generarlo. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al tratar de generar fichero. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Generar el OBJETO FILE de ints DE ESTE DAO
    // NUEVO / SOBREESCRIBIENDO pidiendo los enteros uno a uno por teclado
    public void generarNuevoFichero() {
        Scanner teclado = new Scanner(System.in);
        String opcion;

        try {
            // Abrir flujo de salida
            abrirGrabarSobreescribir();

            // Pedir datos en bucle
            do {
                int intAGrabar = 0;
                boolean correcto;
                do {
                    correcto = false;

                    System.out.println("Introduce un número entero (no tengas mala leche y mete un entero.....) : ");
                    String enteroString = teclado.nextLine();

                    try {
                        intAGrabar = Integer.parseInt(enteroString);
                        correcto = true;
                    } catch (NumberFormatException ex) {
                        System.out.println("Formato de número no válido, INTRODUCE UN ENTERO ¬¬ : ");
                    }

                } while (!correcto);

                grabarUnRegistro(intAGrabar);

                System.out.println("¿Introducir otro registro? (S/N)");
                opcion = teclado.nextLine();
                while (!opcion.equalsIgnoreCase("n") && !opcion.equalsIgnoreCase("s")) {
                    System.out.println("Por favor, introduce S o N");
                    opcion = teclado.nextLine();
                }
            } while (opcion.equalsIgnoreCase("s"));

            // Cerrar flujo de grabación
            cerrarGrabar();

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al intentar generarlo. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al generar fichero. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // AÑADIR al OBJETO FILE ya existente de ints DE ESTE DAO pidiendo enteros por teclado
    public void anhadirRegistros() {
        Scanner teclado = new Scanner(System.in);
        String opcion;

        try {
            // Abrir flujo de salida
            abrirGrabarAnhadir();

            // Pedir datos en bucle
            do {
                int intAGrabar = 0;
                boolean correcto;
                do {
                    correcto = false;

                    System.out.println("Introduce un número entero (no tengas mala leche y mete un entero.....) : ");
                    String enteroString = teclado.nextLine();

                    try {
                        intAGrabar = Integer.parseInt(enteroString);
                        correcto = true;
                    } catch (NumberFormatException ex) {
                        System.out.println("Formato de número no válido, INTRODUCE UN ENTERO ¬¬ : ");
                    }

                } while (!correcto);

                grabarUnRegistro(intAGrabar);

                System.out.println("¿Introducir otro registro? (S/N)");
                opcion = teclado.nextLine();
                while (!opcion.equalsIgnoreCase("n") && !opcion.equalsIgnoreCase("s")) {
                    System.out.println("Por favor, introduce S o N");
                    opcion = teclado.nextLine();
                }
            } while (opcion.equalsIgnoreCase("s"));

            // Cerrar flujo de grabación
            cerrarGrabar();

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al intentar generarlo. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al generar fichero. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Buscar un int QUE APARECE UNA SOLA VEZ
    // Devuelve la posición en que se encontró SI EXISTE, si no está en el fichero devuelve -1
    public int buscarUnRegistro(int numABuscar) {
        int posicionEncontrado = -1;
        int contadorPosicion = 0;
        try {
            // Abrimos fichero para leer
            abrirLeer();

            // Buscamos en bucle
            // Comparamos registro por registro hasta que se encuentre, o hasta EOF (el dato no existirá en el fichero)
            int registroLeido = 0;
            while (posicionEncontrado == -1) {
                registroLeido = dis.readInt();
                if (registroLeido == numABuscar) {
                    posicionEncontrado = contadorPosicion;
                }
                contadorPosicion++;
            }

            // Cerramos fichero
            cerrarLeer();

        } catch (EOFException ex) {
            System.out.println("Fin de fichero tras buscar registro. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al abrir fichero para buscar un registro. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return posicionEncontrado;
    }

    // Para MOSTRAR POR PANTALLA el fichero para comprobar
    public void mostrarFichero() {

        try {
            // Abrir fichero
            abrirLeer();

            // Mostrar en bucle
            try {
                while (true) {
                    int enteroLeido = leerUnRegistro();
                    System.out.print(enteroLeido + "  ");
                }
            } catch (EOFException ex) {
                System.out.println("Fin de fichero al visualizar. " + ex.getMessage());
                //   Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Cerrar fichero
            cerrarLeer();

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al tratar de mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al mostrar fichero. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
