package Modelo;

import java.io.*;
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

    // Contar registros
    public int contarRegistros() {
        int numRegistros = 0;
        try {
            // Abrir fichero
            abrirLeer();
            // Leemos y contabilizamos
            String cadenaLeida;
            cadenaLeida = br.readLine();
            while (cadenaLeida != null) {
                numRegistros++;
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
        return numRegistros;
    }

    // Generar el OBJETO FILE DE ESTE DAO
    // NUEVO / SOBREESCRIBIENDO si ya existiera pidiendo atributos por teclado
    // Al incluir souts no es conveniento en la clase, pero bueno....
    public void generarNuevoFichero() {
        Scanner teclado = new Scanner(System.in);
        String opcion;

        try {
            // Abrir fichero para grabar
            abrirGrabarSobreescribir();
            // Grabar líneas en bucle
            do {
                System.out.println("Atributo 1:");
                String atributo1 = teclado.nextLine();
                System.out.println("Atributo 2 (INT):");
                String atributo2String = teclado.nextLine();
                // No hace falta pasar a int porque lo vamos a grabar como String
                String stringAGrabar = (atributo1 + "," + atributo2String);
                grabarUnString(stringAGrabar);

                System.out.println("¿Grabar otro String? (S/N)");
                opcion = teclado.nextLine();
                while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
                    System.out.println("Por favor, introduce S o N :");
                    opcion = teclado.nextLine();
                }
            } while (opcion.equalsIgnoreCase("s"));

            // Cerrar fichero
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al generar el fichero. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // AÑADE registros al fichero existente pidiendo atributos por teclado
    // Al incluir souts no es conveniento en la clase, pero bueno....
    public void anhadirRegistros() {
        Scanner teclado = new Scanner(System.in);
        String opcion;

        try {
            // Abrir fichero para grabar
            abrirGrabarAnhadir();
            // Grabar líneas en bucle
            do {
                System.out.println("Atributo 1:");
                String atributo1 = teclado.nextLine();
                System.out.println("Atributo 2 (INT):");
                String atributo2String = teclado.nextLine();
                // No hace falta pasar a int porque lo vamos a grabar como String
                String stringAGrabar = (atributo1 + "," + atributo2String);
                grabarUnString(stringAGrabar);
                System.out.println("¿Grabar otro String? (S/N)");
                opcion = teclado.nextLine();
                while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
                    System.out.println("Por favor, introduce S o N :");
                    opcion = teclado.nextLine();
                }
            } while (opcion.equalsIgnoreCase("s"));
            // Cerrar fichero
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al añadir registros. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Generar un objeto a partir de un STRING PASADO POR PARÁMETRO
    public Object generarUnObjeto(String stringDeAtributos) {
        // Creamos un StringTokenizer para el String leido y la coma como separador
        StringTokenizer stk = new StringTokenizer(stringDeAtributos, ",");
        // Vamos tokenizando cada atributo y guardando en una variable auxiliar
        String atributoString = stk.nextToken();
        String atributoINT_String = stk.nextToken();
        // Pasamos el atributo de tipo entero que hemos leído como String a int 
        // eliminando espacios en blanco antes o después de la difra para evitar errores
        int atributoINT_int = Integer.parseInt(atributoINT_String.trim());
        // Creamos el objeto con los atributos obtenidos
        Object objetoGenerado = null;
        // objetoGenerado = new Object(atributoString, atributoINT_int);

        return objetoGenerado;
    }

    // Generar un string de atributos a grabar, a partir de un OBJETO PASADO POR PARÁMETRO
    // También incluido en el CSV_Objetos
    public String generarUnStringDeAtributos(Object objeto) {
        String stringGenerado = "";
        /*
        String atributo1 = objeto.getAtibuto1;
        String atributo2 = objeto.getAtibuto2;
        stringGenerado = atributo1 + "," + atributo2;
        // Recorremos el atributo tipo lista, el datoLeido puede ser String,int,... ADAPTARLO
        for (String datoLeido : atributoColeccion) {
            stringGenerado += "," + datoLeido;
        }
        // Salto de línea final
        stringGenerado += "\n";
        */
        return stringGenerado;
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
            System.out.println("No existe el fichero CSV a mostrar. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al mostrar el fichero CSV. " + ex.getMessage());
            Logger.getLogger(DAO_CSVs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
