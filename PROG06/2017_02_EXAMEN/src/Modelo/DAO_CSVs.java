package Modelo;

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

    // GRABAR
    /**
     * Método de apertura para añadir registros al fichero existente
     * @throws IOException 
     */
    public void abrirGrabarAnhadir() throws IOException {
        fw = new FileWriter(ficheroCSV, true);
        bw = new BufferedWriter(fw);
    }
    /**
     * Común para cualquier modalidad de grabado (añadir/sobreescribir)
     * @throws IOException 
     */
    public void cerrarGrabar() throws IOException {
        bw.close();
        fw.close();
    }
    /**
     * Graba un string pasado por parámetro en el fichero
     * @param stringAGrabar
     * @throws IOException 
     */
    public void grabarUnString(String stringAGrabar) throws IOException {
        bw.write(stringAGrabar);
    }

    // AÑADE registros al fichero existente pidiendo atributos por teclado
    // Al incluir souts no es conveniento en la clase, pero bueno....
    public void anhadirRegistros() {
        Scanner teclado = new Scanner(System.in);
        String opcion;

        // Abrir fichero para grabar
        try {
            abrirGrabarAnhadir();
        } catch (IOException ex) {
            System.out.println("Error al abrir fichero para añadir registros. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Grabar líneas en bucle
        do {
            System.out.println("Atributo 1:");
            String atributo1 = teclado.nextLine();
            System.out.println("Atributo 2 (INT):");
            String atributo2String = teclado.nextLine();
            // No hace falta pasar a int porque lo vamos a grabar como String

            String stringAGrabar = (atributo1 + "," + atributo2String);

            try {
                grabarUnString(stringAGrabar);
            } catch (IOException ex) {
                System.out.println("Error al grabar el String para añadirlo al fichero. " + ex.getMessage());
                Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("¿Grabar otro String? (S/N)");
            opcion = teclado.nextLine();
            while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
                System.out.println("Por favor, introduce S o N :");
                opcion = teclado.nextLine();
            }
        } while (opcion.equalsIgnoreCase("s"));

        // Cerrar fichero
        try {
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero tras añadir registros. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Mostrar fichero por pantalla
    public int contarNumRegistros() {
        // Abrir fichero
        try {
            abrirLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero CSV a mostrar. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Leemos y contamos la cantidad de registros
        String cadenaLeida;
        int contador=0;
        try {
            cadenaLeida = br.readLine();
            while (cadenaLeida != null) {
                contador++;
                cadenaLeida = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al mostrar el fichero CSV. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Cerramos fichero
        try {
            cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero CSV para mostrarlo. "+ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contador;
    }
}
