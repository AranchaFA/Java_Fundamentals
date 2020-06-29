package Modelo;

import Controlador.Controlador;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Int {

    // ATRIBUTOS
    private File ficheroEnteros;
    private FileInputStream fis;
    private DataInputStream dis;
    private FileOutputStream fos;
    private DataOutputStream dos;

    // MÉTODOS
    // Getters + Setters
    public File getFicheroEnteros() {
        return ficheroEnteros;
    }

    public void setFicheroEnteros(File ficheroEnteros) {
        this.ficheroEnteros = ficheroEnteros;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public DataInputStream getDis() {
        return dis;
    }

    public void setDis(DataInputStream dis) {
        this.dis = dis;
    }

    public FileOutputStream getFos() {
        return fos;
    }

    public void setFos(FileOutputStream fos) {
        this.fos = fos;
    }

    public DataOutputStream getDos() {
        return dos;
    }

    public void setDos(DataOutputStream dos) {
        this.dos = dos;
    }

    // Constructores
    public DAO_Int(File ficheroEnteros) {
        this.ficheroEnteros = ficheroEnteros;
    }

    public DAO_Int(String nombreFichero) {
        ficheroEnteros = new File(nombreFichero);
    }

    // LEER
    public void abrirLeer() throws FileNotFoundException {
        fis = new FileInputStream(ficheroEnteros);
        dis = new DataInputStream(fis);
    }

    public void cerrarLeer() throws IOException {
        dis.close();
        fis.close();
    }

    public int leerUnEntero() throws IOException {
        return dis.readInt();
    }

    // GRABAR
    public void abrirGrabarAnhadir() throws FileNotFoundException {
        fos = new FileOutputStream(ficheroEnteros, true);
        dos = new DataOutputStream(fos);
    }

    public void abrirGrabarNuevo() throws FileNotFoundException {
        fos = new FileOutputStream(ficheroEnteros);
        dos = new DataOutputStream(fos);
    }

    public void cerrarGrabar() throws IOException {
        dos.close();
        fos.close();
    }

    public void grabarUnEntero(int enteroAGrabar) throws IOException {
        dos.writeInt(enteroAGrabar);
    }

    // Comparar dos enteros (devuelve el menor de los dos enteros)
    public int menorDeDosEnteros(int entero1, int entero2) {
        int enteroMenor;
        if (entero1 < entero2) {
            enteroMenor = entero1;
        } else {
            enteroMenor = entero2;
        }
        return enteroMenor;
    }

    public void mostrarFichero() {
        try {
            // Abrir para leer
            abrirLeer();
            // Leer en bucle hasta EOF
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir el fichero para mostrar (no encontrado). " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (true) {
                System.out.print(leerUnEntero()+"  ");
            }
        } catch (EOFException ex) {
            System.out.println("Fin de fichero al mostrar. " + ex.getMessage());
            //    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al leer el fichero para mostrar. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // Cerrar para leer
            cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero para mostrar. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
