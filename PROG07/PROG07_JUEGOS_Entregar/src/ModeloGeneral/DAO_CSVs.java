package ModeloGeneral;

import java.io.*;
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

    // Constructores
    public DAO_CSVs(File ficheroCSV) {
        this.ficheroCSV = ficheroCSV;
    }

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

    // AÑADE registros al fichero existente
    public void anhadirUnResultado(String stringAGrabar) {
        try {
            // Abrir fichero para grabar
            abrirGrabarAnhadir();
            // Grabar línea
            grabarUnString(stringAGrabar+"\n"); // No nos mete el salto de línea solo
            // Cerrar fichero
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero tras añadir registros. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero CSV para mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
