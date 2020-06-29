package Controlador;

import Modelo.DAOSalidaCSV;
import Modelo.DAOEntradaObjetos;
import Modelo.Persona;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    private DAOSalidaCSV daoSalidaCSV;
    private DAOEntradaObjetos daoEntradaObj;

    public DAOSalidaCSV getDaoSalidaCSV() {
        return daoSalidaCSV;
    }

    public void setDaoSalidaCSV(DAOSalidaCSV daoSalidaCSV) {
        this.daoSalidaCSV = daoSalidaCSV;
    }

    public DAOEntradaObjetos getDaoEntradaObj() {
        return daoEntradaObj;
    }

    public void setDaoEntradaObj(DAOEntradaObjetos daoEntradaObj) {
        this.daoEntradaObj = daoEntradaObj;
    }

    public Controlador(String nombreFicheroEntradaObj, String nombreFicheroSalidaCSV) {
        daoEntradaObj = new DAOEntradaObjetos(nombreFicheroEntradaObj);
        daoSalidaCSV = new DAOSalidaCSV(nombreFicheroSalidaCSV);
    }

    public void abrirFicheros() throws IOException {
        daoEntradaObj.abrirFicheroEntrada();
        daoSalidaCSV.abrirFicheroSalida();
    }

    public void cerrarFicheros() throws IOException {
        daoEntradaObj.cerrarFicheroEntrada();
        daoSalidaCSV.cerrarFicheroSalida();
    }

    public void grabarAtributosEnCSV() {

        try {
            // Abrimos el fichero de lectura, el de salida se abre y cierra cada vez que
            // se ejecuta el método grabarSecuenciaDeDatos y grabamos una línea individual
            // con los atributos de un objeto
            daoEntradaObj.abrirFicheroEntrada();
        } catch (IOException ex) {
            System.out.println("Error al abrir el fichero de entrada. " + ex.getMessage());
            //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Leemos cada objeto hasta fin de fichero
        Persona auxObjeto;
        
        try {
            daoSalidaCSV.abrirFicheroSalida();
            auxObjeto = (Persona) daoEntradaObj.leerUnObjeto();
            System.out.println("Leído el objeto: " + auxObjeto.toString());
            while (auxObjeto != null) {
                // Guardamos los valores de los atributos en variables para generar un String con ellos
                String nombre = auxObjeto.getNombre();
                String apellidos = auxObjeto.getApellidos();
                String edad = String.valueOf(auxObjeto.getEdad());
                /*
            int edadInt=auxObjeto.getEdad();
            String edadString=String cadena = Integer.toString(edadInt); // Pasa el valor a String
                 */
                // Concatenamos los valores de los atributos con el formato xxxx, xxx, xxxxx, xx, ....
                String datos = nombre + "," + apellidos + "," + edad + "\n";
                // En el constructor del pw puse true en autoflush, no sé si sobraría el \n final

                // Grabamos el String con la secuencia de datos en el fichero de salida
                System.out.println("Grabando los datos: " + datos);
                daoSalidaCSV.grabarSecuenciaDeDatos(datos);
                // Leemos un nuevo objeto
                auxObjeto = (Persona) daoEntradaObj.leerUnObjeto();
                System.out.println("Leído el objeto: " + auxObjeto.toString());
            }
        } catch (IOException ex) {
            System.out.println("Error al leer o grabar ficheros. " + ex.getMessage());
            //   Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada al leer o grabar ficheros. " + ex.getMessage());
            //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Cerramos el fichero de entrada, el de salida habrá quedado cerrado tras la última
            // ejecución del método grabar
            daoEntradaObj.cerrarFicheroEntrada();
            daoSalidaCSV.cerrarFicheroSalida();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero de entrada. " + ex.getMessage());
            //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarFicheroCSV() {
        System.out.println("Leyendo fichero CSV....");
        FileReader fr = null;
        try {
            fr = new FileReader(daoSalidaCSV.getFicheroCSV());
            BufferedReader br = new BufferedReader(fr);
            String cadenaLeida = br.readLine();
            while (cadenaLeida!=null) {
                System.out.println(cadenaLeida);
                cadenaLeida = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al comprobar resultados. " + ex.getMessage());
            // Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al leer para mostrar resultador. " + ex.getMessage());
            //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("Problemas al cerrar el fichero tras comprobar resultados. " + ex.getMessage());
                //    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
