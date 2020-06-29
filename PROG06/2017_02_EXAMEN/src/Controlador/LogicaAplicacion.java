package Controlador;

import Modelo.DAO_CSVs;
import Modelo.DAO_Objetos;
import Modelo.Opositor;
import Modelo.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arancha
 */
public class LogicaAplicacion {

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

    // Constructor

    public LogicaAplicacion(String nombreFicheroCSV, String nombreFicheroObjetos) {
        daoCSV = new DAO_CSVs(nombreFicheroCSV);
        daoObjetos = new DAO_Objetos(nombreFicheroObjetos);
    }

    // Generar un objeto a partir de un STRING PASADO POR PARÁMETRO
    public Opositor generarUnObjeto(String stringDeAtributos) {
        // Creamos un StringTokenizer para el String leido y la coma como separador
        StringTokenizer stk = new StringTokenizer(stringDeAtributos, ";");
        // Vamos tokenizando cada atributo y guardando en una variable auxiliar
        String nombre = stk.nextToken();
        String apellidos = stk.nextToken();
        // Pasamos los atributos de tipo entero (leídos como String) a int 
        // eliminando espacios en blanco antes o después de la difra para evitar errores
        int r1 = Integer.parseInt(stk.nextToken().trim());
        int r2 = Integer.parseInt(stk.nextToken().trim());
        int r3 = Integer.parseInt(stk.nextToken().trim());
        int r4 = Integer.parseInt(stk.nextToken().trim());
        int r5 = Integer.parseInt(stk.nextToken().trim());
        int r6 = Integer.parseInt(stk.nextToken().trim());
        int r7 = Integer.parseInt(stk.nextToken().trim());

        // Creamos el objeto con los atributos obtenidos
        Persona personaGenerada = new Persona(nombre, apellidos);
        Opositor objetoGenerado = new Opositor(personaGenerada, r1, r2, r3, r4, r5, r6, r7);

        return objetoGenerado;
    }

    public void leerCSVMostrarObjetos() {
        // Abrimos para leer CSV
        try {
            daoCSV.abrirLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero CSV no encontrado. " + ex.getMessage());
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Leemos el CSV, transformamos a Objeto y mostramos, en bucle hasta fin de fichero
        String stringLeido = null;

        try {
            stringLeido = daoCSV.leerUnString();
        } catch (IOException ex) {
            System.out.println("Error al leer el primer registro del CSV. " + ex.getMessage());
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (stringLeido != null) {
            Opositor objetoGenerado = generarUnObjeto(stringLeido);
            // Mostramos la información del objeto
            System.out.println(objetoGenerado.toString());
            try {
                stringLeido = daoCSV.leerUnString();
            } catch (IOException ex) {
                System.out.println("Error al leer un registro del CSV. " + ex.getMessage());
                Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Cerramos flujos de lectura de CSV y de salida del fichero de objetos
        try {
            daoCSV.cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar los ficheros tras copiar del CSV al fichero de objetos. " + ex.getMessage());
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void grabarFicheroCSVAObjetos_MediaMayor70() {
        // Abrimos para leer CSV y grabar fichero de objetos
        try {
            daoCSV.abrirLeer();
            daoObjetos.abrirGrabarSelectivo();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero CSV no encontrado. " + ex.getMessage());
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al abrir el fichero de objetos para grabar. " + ex.getMessage());
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Leemos el CSV, transformamos a Objeto y grabamos si la media es mayor que 70, en bucle hasta fin de fichero
        String stringLeido = null;

        try {
            stringLeido = daoCSV.leerUnString();
        } catch (IOException ex) {
            System.out.println("Error al leer el primer registro del CSV. " + ex.getMessage());
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (stringLeido != null) {
            Opositor objetoGenerado = generarUnObjeto(stringLeido);
            if (objetoGenerado.calcularMedia() > 70) {
                try {
                    getDaoObjetos().grabarUnObjeto(objetoGenerado);
                } catch (IOException ex) {
                    System.out.println("Error al grabar un objeto. " + ex.getMessage());
                    Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {

                stringLeido = daoCSV.leerUnString();
            } catch (IOException ex) {
                System.out.println("Error al leer un nuevo registro del CSV. " + ex.getMessage());
                Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Cerramos flujos de lectura de CSV y de salida del fichero de objetos
        try {
            daoCSV.cerrarLeer();
            daoObjetos.cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al cerrar los ficheros tras copiar del CSV al fichero de objetos. " + ex.getMessage());
            Logger.getLogger(LogicaAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
