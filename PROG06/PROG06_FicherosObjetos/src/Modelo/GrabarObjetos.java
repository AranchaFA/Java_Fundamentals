package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarObjetos {

    // ATRIBUTOS
    // File con el fichero de salida
    private File ficheroSalida;
    // Flujo de salida de datos
    private FileOutputStream fos;
    // Como trabajaremos con objetos usaremos un ObjectOS
    private ObjectOutputStream oos;
    // Mi clase OOS modificada para grabar sin cabecera
    private ModifyOOS modifyOOS;

    // MÉTODOS

    public File getFicheroSalida() {
        return ficheroSalida;
    }

    public void setFicheroSalida(File ficheroSalida) {
        this.ficheroSalida = ficheroSalida;
    }

    public FileOutputStream getFos() {
        return fos;
    }

    public void setFos(FileOutputStream fos) {
        this.fos = fos;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public ModifyOOS getModifyOOS() {
        return modifyOOS;
    }

    public void setModifyOOS(ModifyOOS modifyOOS) {
        this.modifyOOS = modifyOOS;
    }
    
    
    // Constructor, los atributos se inicializarán en el método grabar
    public GrabarObjetos() {
    }

    // Método para abrir un fichero
    public void abrirFichero(String nombreFichero) throws FileNotFoundException, IOException {
        // Inicializamos los atributos
        ficheroSalida = new File(nombreFichero);
        fos = new FileOutputStream(ficheroSalida, true);
        // Abrimos los dos frlujos oos para no tener que hacer los métdos abrir
        // y cerrar por duplicado y simplificar
        oos = new ObjectOutputStream(fos);
        modifyOOS = new ModifyOOS(fos);
    }

    // Método para grabar un objeto en un fichero (CON CABECERA)
    public void grabarObjetoConCabecera(Object objeto) {
        try {
            oos.writeObject(objeto);
        } catch (IOException ex) {
            System.out.println("Problemas al grabar en fichero. " + ex.getMessage());
            Logger.getLogger(GrabarObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para grabar un objeto en un fichero SIN CABECERA
    public void grabarObjetoSinCabecera(Object objeto) {
        try {
            modifyOOS.writeObject(objeto);
        } catch (IOException ex) {
            System.out.println("Problemas al grabar en fichero. " + ex.getMessage());
            Logger.getLogger(GrabarObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para cerrar el fichero
    public void cerrarFichero() throws IOException {
        oos.close();
        fos.close();
        modifyOOS.close();
    }
}
