package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_CSV {

    private File ficheroCSV;
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private BufferedWriter bw;

    public DAO_CSV(String nombreFichero) {
        this.ficheroCSV = new File(nombreFichero);
    }

    public void abrirLeer() throws FileNotFoundException {
        fr = new FileReader(ficheroCSV);
        br = new BufferedReader(fr);
    }

    public void abrirGrabar() throws IOException {
        fw = new FileWriter(ficheroCSV, true);
        bw = new BufferedWriter(fw);
    }

    public void cerrarLeer() throws IOException {
        br.close();
        fr.close();
    }

    public void cerrarGrabar() throws IOException {
        bw.close();
        fw.close();
    }

    public String leerUnString() throws EOFException, IOException {
        String line = br.readLine();

        return line;

    }

    public void grabarUnString(String string) throws IOException {
        bw.write(string);
    }

    public void mostrarFicheroPorPantalla() {
        // Abrir fichero
        try {
            abrirLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero CSV a mostrar. " + ex.getMessage());
            Logger.getLogger(DAO_CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Leemos y mostramos 
        String cadenaLeida;
        try {
            cadenaLeida = br.readLine();
            while (cadenaLeida != null) {
                System.out.println(cadenaLeida);
                cadenaLeida = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al mostrar el fichero CSV. " + ex.getMessage());
            Logger.getLogger(DAO_CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Cerramos fichero
        try {
            cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero CSV para mostrarlo. "+ex.getMessage());
            Logger.getLogger(DAO_CSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
