package Ficheros.Objetos_y_CSVs;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_ObjetosCSV {

    // ATRIBUTOS 
    private DAO_CSVs daoCSV;
    private DAO_Objetos daoObjetos;

    // MÉTODOS
    // Getters + Setters
    public DAO_CSVs getDaoCSV() {
        return daoCSV;
    }

    public void setDaoCSV(DAO_CSVs daoCSV) {
        this.daoCSV = daoCSV;
    }

    public DAO_Objetos getDaoObjetos() {
        return daoObjetos;
    }

    public void setDaoObjetos(DAO_Objetos daoObjetos) {
        this.daoObjetos = daoObjetos;
    }

    // Constructores
    public Controlador_ObjetosCSV(File ficheroCSV, File ficheroObjetos) {
        daoCSV = new DAO_CSVs(ficheroCSV);
        daoObjetos = new DAO_Objetos(ficheroObjetos);
    }

    public Controlador_ObjetosCSV(String nombreFicheroCSV, String nombreFicheroObjetos) {
        daoCSV = new DAO_CSVs(nombreFicheroCSV);
        daoObjetos = new DAO_Objetos(nombreFicheroObjetos);
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

    // Generar un String con los atributos de un objeto para grabar en CSV
    public String generarStringAtributos(Object objeto) {
        String stringAtributos = "";
        
        // String atributoString=objetoLeido.getAtributoString;
        // int atributoINT=objetoLeido.getAtributoINT;
        // String stringAtributos=(atributoString+","+atributoINT+"\n");
        
        return stringAtributos;
    }

    // CSV a OBJECT : Copiar los datos de un CSV a un fichero de objetos
    public void copiarFicheroCSVAObjetos() {
        // Abrimos para leer CSV y grabar fichero de objetos
        try {
            daoCSV.abrirLeer();
            daoObjetos.abrirGrabarSelectivo();
            // Leemos el CSV, transformamos a Objeto y grabamos, en bucle hasta fin de fichero
            String stringLeido = null;
            stringLeido = daoCSV.leerUnString();
            while (stringLeido != null) {
                Object objetoGenerado = generarUnObjeto(stringLeido);
                daoObjetos.grabarUnObjeto(objetoGenerado);
                stringLeido = daoCSV.leerUnString();
            }
            // Cerramos flujos de lectura de CSV y de salida del fichero de objetos
            daoCSV.cerrarLeer();
            daoObjetos.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero CSV no encontrado. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al copiar del CSV al fichero de objetos. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // OBJECT a CSV : Copiar los datos de un fichero de objetos a un CSV
    public void copiarFicheroObjetosACSV() throws ClassNotFoundException {
        // Abrimos para leer fichero de objetos y grabar CSV
        try {
            daoCSV.abrirGrabarAnhadir();
            daoObjetos.abrirLeer();
            // Leemos el fichero de objetos, guardamos los atributos de cada objeto en un String tipo xxxx,xxxx,xxxx,
            // y grabamos en el CSV, en bucle hasta fin de fichero
            Object objetoLeido = null;
            objetoLeido = daoObjetos.leerUnObjeto();
            while (objetoLeido != null) {
                // String atributoString=objetoLeido.getAtributoString;
                // int atributoINT=objetoLeido.getAtributoINT;
                String stringAGrabar = null;
                // String stringAGrabar=(atributoString+","+atributoINT);
                daoCSV.grabarUnString(stringAGrabar);
                objetoLeido = daoObjetos.leerUnObjeto();
            }
            // Cerramos flujos de lectura del fichero de objetos y de salida del CSV
            daoCSV.cerrarGrabar();
            daoObjetos.cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero de objetos no encontrado. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al copiar del fichero de objetos al CSV. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ejecutarMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("*** M E N Ú ***");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("0. Salir");
            System.out.println("\n¿Qué quieres hacer?");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    // Método de la opción 1
                    break;
                case 2:
                    // Método de la opción 2
                    break;
                case 0:
                    System.out.println("¡ Adiós !");
                    break;
                default:
                    System.out.println("Opción no válida, por favor introduce un número entre 0 y 2:");
                    opcion = teclado.nextInt();
            }
        } while (opcion != 0);
    }
}
