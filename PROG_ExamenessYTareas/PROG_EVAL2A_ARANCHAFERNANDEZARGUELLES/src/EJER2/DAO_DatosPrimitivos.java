package EJER2;

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

    // CONSTRUCTOR
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

    public int leerUnRegistro() throws IOException {
        int enteroLeido = dis.readInt();
        return enteroLeido;
    }

    // PARA GRABAR (no lo vamos a usr en este ejercicio)
    public void abrirGrabarAnhadir() throws FileNotFoundException {
        fos = new FileOutputStream(ficheroDatosPrimitivos, true);
        dos = new DataOutputStream(fos);
    }

    public void cerrarGrabar() throws IOException {
        dos.close();
        fos.close();
    }

    public void grabarUnRegistro(int enteroAGrabar) throws IOException {
        dos.writeInt(enteroAGrabar);
    }

    // Buscar un int QUE APARECE VARIAS VECES
    // Devuelve el número de veces que aparece en el fichero
    public int buscarUnRegistroYContabilizar(int numABuscar) {
        int contador = 0;
        try {
            // Abrimos fichero para leer
            abrirLeer();

            // Buscamos en bucle
            // Comparamos registro por registro y sumamos al contador si existe
            int registroLeido = 0;
            try {
                while (true) {
                    registroLeido = dis.readInt();
                    if (registroLeido == numABuscar) {
                        contador++;
                    }
                }
            } catch (EOFException ex) {
                System.out.println("Fin de fichero. " + ex.getMessage());
            }

            // Cerramos fichero
            cerrarLeer();

        } catch (IOException ex) {
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contador;
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
                System.out.println("Fin de fichero. " + ex.getMessage());
                //   Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println("Error al visualizar el fichero de datos primitivos. " + ex.getMessage());
                Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar fichero
            cerrarLeer();

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al tratar de mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al cerrar fichero tras mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
