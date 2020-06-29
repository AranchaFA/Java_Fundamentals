package ejer1.Modelo;

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
    
    // Adaptar pasando el nombre de los ficheros con los que vamos a tabajar al final
    public Controlador_ObjetosCSV(String nombreFicheroCSV, String nombreFicheroObjetos) {
        daoCSV = new DAO_CSVs(nombreFicheroCSV);
        daoObjetos = new DAO_Objetos(nombreFicheroObjetos);
    }

    // Generar un objeto a partir de un STRING PASADO POR PARÁMETRO
    public Object generarUnObjeto(String stringDeAtributos) {
        // Creamos un StringTokenizer para el String leido y la COMA COMO NSEPARADOR
        StringTokenizer stk = new StringTokenizer(stringDeAtributos, ",");
        // Vamos tokenizando cada atributo y guardando en una variable auxiliar
        String atributoString = stk.nextToken();
        String atributoINT_String = stk.nextToken();
        // Pasamos el atributo de tipo entero que hemos leído como String a int 
        // eliminando espacios en blanco antes o después de la difra para evitar errores
        int atributoINT_int = Integer.parseInt(atributoINT_String.trim());
        // Creamos el objeto con los atributos obtenidos
        // Si tiene algún atributo de tipo objeto lo tendremos que generar también para pasárselo
        // por parámetro, debe ser también SERIALIZABLE!
        Object objetoGenerado = null;
        // objetoGenerado = new Object(atributoString, atributoINT_int);

        return objetoGenerado;
    }

    // CSV a OBJECT : Copiar los datos de un CSV a un fichero de objetos
    public void copiarFicheroCSVAObjetos() {
        // Abrimos para leer CSV y grabar fichero de objetos
        try {
            daoCSV.abrirLeer();
            daoObjetos.abrirGrabarSelectivo();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero CSV no encontrado. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al abrir el fichero de objetos para grabar. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Leemos el CSV, transformamos a Objeto y grabamos, en bucle hasta fin de fichero
        String stringLeido = null;

        try {
            stringLeido = daoCSV.leerUnString();
        } catch (IOException ex) {
            System.out.println("Error al leer el primer registro del CSV. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (stringLeido != null) {
            Object objetoGenerado=generarUnObjeto(stringLeido); 
            try {
                getDaoObjetos().grabarUnObjeto(objetoGenerado);
                stringLeido = daoCSV.leerUnString();
            } catch (IOException ex) {
                System.out.println("Error al grabar un objeto y leer un nuevo registro del CSV. " + ex.getMessage());
                Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Cerramos flujos de lectura de CSV y de salida del fichero de objetos
        try {
            daoCSV.cerrarLeer();
            daoObjetos.cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al cerrar los ficheros tras copiar del CSV al fichero de objetos. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // OBJECT a CSV : Copiar los datos de un fichero de objetos a un CSV
    public void copiarFicheroObjetosACSV() throws ClassNotFoundException {
        // Abrimos para leer fichero de objetos y grabar CSV
        try {
            daoCSV.abrirGrabarAnhadir();
            daoObjetos.abrirLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero de objetos no encontrado. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al abrir el CSV para grabar. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Leemos el fichero de objetos, guardamos los atributos de cada objeto en un String tipo xxxx,xxxx,xxxx,
        // y grabamos en el CSV, en bucle hasta fin de fichero
        Object objetoLeido = null;

        try {
            objetoLeido = daoObjetos.leerUnObjeto();
        } catch (IOException ex) {
            System.out.println("Error al leer el primer registro del fichero de objetos. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (objetoLeido != null) {
           
            // String atributoString=objetoLeido.getAtributoString;
            // int atributoINT=objetoLeido.getAtributoINT;

            String stringAGrabar=null;
            try {
                // String stringAGrabar=(atributoString+","+atributoINT);
                daoCSV.grabarUnString(stringAGrabar);
            } catch (IOException ex) {
                System.out.println("Error al grabar un String en el CSV. "+ex.getMessage());
                Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Cerramos flujos de lectura del fichero de objetos y de salida del CSV
        try {
            daoCSV.cerrarGrabar();
            daoObjetos.cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar los ficheros tras copiar del fichero de objetos al CSV. " + ex.getMessage());
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
                    opcion=teclado.nextInt();
            }
        } while (opcion!=0);
    }
}
