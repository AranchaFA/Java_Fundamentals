package ejer2.Modelo;

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
