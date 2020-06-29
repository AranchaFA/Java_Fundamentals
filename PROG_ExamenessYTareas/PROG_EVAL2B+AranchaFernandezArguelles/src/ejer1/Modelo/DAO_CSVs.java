package ejer1.Modelo;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
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


    // Generar un objeto a partir de un STRING PASADO POR PARÁMETRO
    public Luchador generarUnObjeto(String stringDeAtributos) {
        // Creamos un StringTokenizer para el String leido y la coma como separador
        StringTokenizer stk = new StringTokenizer(stringDeAtributos, ",");
        // Vamos tokenizando cada atributo y guardando en una variable auxiliar
        String nombre = stk.nextToken();
        String apellidos = stk.nextToken();
        String edad = stk.nextToken();
        LinkedList<String> cinturones=new LinkedList();
        while (stk.hasMoreTokens()) {
            // Vamos grabando los cinturones POR ORDEN 8el nuevo leído al final)
            cinturones.addLast(stk.nextToken());
        }
        // Creamos el objeto con los atributos obtenidos
        Luchador objetoGenerado = new Luchador(nombre, apellidos, edad, cinturones);

        return objetoGenerado;
    }

    // Mostrar fichero por pantalla (por si hay que comprobar)
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
            System.out.println("No existe el fichero CSV a mostrar. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al mostrar el fichero CSV. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
