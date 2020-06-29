package EJER1.Modelo;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_CSVs {

    // ATRIBUTOS
    private File ficheroCSV;
    // LEER
    private FileReader fr;
    private BufferedReader br;
    // GRABAR
    private FileWriter fw;
    private BufferedWriter bw;

    // MÉTODOS
    // Getters + Setters
    public File getFicheroCSV() {
        return ficheroCSV;
    }

    public void setFicheroCSV(File ficheroCSV) {
        this.ficheroCSV = ficheroCSV;
    }

    // Constructor
    public DAO_CSVs(String nombreFichero) {
        ficheroCSV = new File(nombreFichero);
    }

    // LEER
    public void abrirLeer() throws FileNotFoundException {
        fr = new FileReader(ficheroCSV);
        br = new BufferedReader(fr);
    }

    public void cerrarLeer() throws IOException {
        br.close();
        fr.close();
    }

    public String leerUnString() throws IOException {
        return br.readLine();
    }

    // GRABAR (no lo usamos para nada en este ejercicio)
    public void abrirGrabarAnhadir() throws IOException {
        fw = new FileWriter(ficheroCSV, true);
        bw = new BufferedWriter(fw);
    }

    public void cerrarGrabar() throws IOException {
        bw.close();
        fw.close();
    }

    public void grabarUnString(String stringAGrabar) throws IOException {
        bw.write(stringAGrabar);
    }

    // Mostrar fichero por pantalla
    public void mostrarFicheroPorPantalla() {
        try {
            // Abrir fichero
            abrirLeer();

            // Leemos y mostramos
            String cadenaLeida;

            cadenaLeida = br.readLine();
            while (cadenaLeida != null) {
                System.out.println(cadenaLeida);
                cadenaLeida = br.readLine();
            }

            // Cerramos fichero
            cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado. "+ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // Contar el número de registros del CSV

    public int contarRegistros() {
        int numRegistros = 0;
        try {
            // Abrimos para leer
            abrirLeer();
            // Leemos en bucle hasta fin de fichero y contamos cada registro
            String registroLeido = leerUnString();
            while (registroLeido != null) {
                numRegistros++;
                registroLeido = leerUnString();
            }
            // Cerramos fichero
            cerrarLeer();
        } catch (IOException ex) {
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numRegistros;
    }
}
