package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_CSV {

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

    // Constructores
    public DAO_CSV(File ficheroCSV) {
        this.ficheroCSV = ficheroCSV;
    }

    public DAO_CSV(String nombreFichero) {
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

    // GRABAR
    public void abrirGrabarSobreescribir() throws IOException {
        fw = new FileWriter(ficheroCSV);
        bw = new BufferedWriter(fw);
    }

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

    // Generar un objeto Piloto a partir de un String leido del CSV
    public Piloto generarUnObjeto(String stringAtributos) throws IOException {
        Piloto objetoGenerado = null;
        List<Double> tiempos = new ArrayList<>();
        // Creamos un StringTokenizer para tokenizar el String introducido desde el CSV
        StringTokenizer stk = new StringTokenizer(stringAtributos, ",");
        // Sacamos los 3 primeros atributos que siempre son "fijos"
        String nombre = stk.nextToken();
        String pais = stk.nextToken();
        String escuderia = stk.nextToken();
        // La cantidad de tiempos no es constante, así que leemos tokens en bucle
        while (stk.hasMoreTokens()) {
            tiempos.add(Double.parseDouble(stk.nextToken().trim()));
        }
        // Ya tenemos los 4 atibutos para crear el objeto Piloto
        objetoGenerado = new Piloto(nombre, pais, escuderia, tiempos);
        return objetoGenerado;
    }
    
    // Mostrar fichero por pantalla
    public void mostrarFicheroPorPantalla() {
        try {
            // Abrir fichero
            abrirLeer();
            // Leemos y mostramos
            String cadenaLeida = br.readLine();
            while (cadenaLeida != null) {
                System.out.println(cadenaLeida);
                cadenaLeida = br.readLine();
            }
            // Cerramos fichero
            cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero CSV a mostrar. " + ex.getMessage());
            Logger.getLogger(DAO_CSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero CSV para mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Contar cuántos registros hay en el CSV
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
            Logger.getLogger(DAO_CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numRegistros;
    }
}
