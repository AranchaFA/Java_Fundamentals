package Modelo;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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

    // Generar el OBJETO FILE DE ESTE DAO
    // NUEVO / SOBREESCRIBIENDO si ya existiera
    public void generarNuevoFicheroDesdeColeccion(Map<String, Contacto> coleccion) {
        // Abrir fichero para grabar
        try {
            abrirGrabarSobreescribir();

            Iterator it = coleccion.values().iterator();

            while (it.hasNext()) {
                Contacto contactoLeido =(Contacto) it.next();
                String stringAGrabar = contactoLeido.getNombrePila() + "," + contactoLeido.getNombre() + ","
                     + contactoLeido.getApellidos() + "," + contactoLeido.getEmail() + ",";
                Iterator itTlfn = contactoLeido.getTelefonos().iterator();
                while (itTlfn.hasNext()) {
                    stringAGrabar += itTlfn.next();
                    // Añadimos coma tras el número de tlfn sólo si hay otro elemento a añadir,
                    // así evitamos dejar una coma al final del string
                    if (itTlfn.hasNext()) {
                        stringAGrabar += ",";
                    }
                }
                // Salto de línea al final del string generado
                stringAGrabar += "\n";
                // Grabamos el string obtenido
                grabarUnString(stringAGrabar);
            }

            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al generar fichero CSV. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // AÑADE un registro al fichero existente
    // Le pasamos la línea que tndremos que leer fuera del método con este mismo DAO
    public void anhadirUnRegistro(String stringAGrabar) {
        try {
            abrirGrabarAnhadir();
            grabarUnString(stringAGrabar);
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al grabar un registro en el CSV. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Crear un objeto CONTACTO desde el CSV
    // ABRIR y CERRAR cuando leamos la línea!!
    public Contacto generarUnContactoDesdeCSV(String stringDeAtributos) {
        StringTokenizer stk = new StringTokenizer(stringDeAtributos, ",");
        String nombrePila = stk.nextToken();
        String nombre = stk.nextToken();
        String apellidos = stk.nextToken();
        String email = stk.nextToken();
        List<String> telefonos = new LinkedList<>();
        while (stk.hasMoreTokens()) {
            telefonos.add(stk.nextToken());
        }
        Contacto contactoGenerado = new Contacto(nombrePila, nombre, apellidos, email, telefonos);;
        return contactoGenerado;
    }

    // Mostrar fichero por pantalla
    public void mostrarFicheroPorPantalla() {
        // Abrir fichero
        try {
            abrirLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero CSV a mostrar. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Cerramos fichero
        try {
            cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero CSV para mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
