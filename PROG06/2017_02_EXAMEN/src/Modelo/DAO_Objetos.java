package Modelo;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Objetos {

    // ATRIBUTOS
    private File ficheroObjetos;
    // LEER
    private FileInputStream fis;
    private ObjectInputStream ois;
    // GRABAR
    private FileOutputStream fos;
    private ObjectOutputStream oos;

    // MÉTODOS
    // Getters + Setters
    public File getFicheroObjetos() {
        return ficheroObjetos;
    }

    public void setFicheroObjetos(File ficheroObjetos) {
        this.ficheroObjetos = ficheroObjetos;
    }

    // Constructor
    public DAO_Objetos(String nombreFichero) {
        ficheroObjetos = new File(nombreFichero);
    }

    // LEER
    public void abrirLeer() throws FileNotFoundException, IOException {
        fis = new FileInputStream(ficheroObjetos);
        ois = new ObjectInputStream(fis);
    }

    public void cerrarLeer() throws IOException {
        ois.close();
        fis.close();
    }

    public Object leerUnObjeto() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    // GRABAR
    // El método "normal" que usamos para añadir si existe/generar si no existe
    public void abrirGrabarSelectivo() throws FileNotFoundException, IOException {
        if (ficheroObjetos.exists()) {
            fos = new FileOutputStream(ficheroObjetos, true);
            oos = new ModifyObjectOutputStream(fos);
        } else {
            fos = new FileOutputStream(ficheroObjetos);
            oos = new ObjectOutputStream(fos);
        }
    }
    
    public void cerrarGrabar() throws IOException {
        oos.close();
        fos.close();
    }

    // Poner las clases como IMPLEMENTS SERIALIZABLE!!!
    public void grabarUnObjeto(Object objetoAGrabar) throws IOException {
        oos.writeObject(objetoAGrabar);
    }

    // Mostrar fichero por pantalla (para comprobar que se ha generado bien)
    public void mostrarFichero() {
        // Abrir fichero para leer
        try {
            abrirLeer();
        } catch (IOException ex) {
            System.out.println("Error al abrir fichero de objetos para mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Leer y mostrar en bucle
        try {
            while (true) {
                System.out.println(ois.readObject().toString());
            }
        } catch (EOFException ex) {
            System.out.println("Fichero de objetos terminado de mostrar. " + ex.getMessage());
            // Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al mostrar fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada al mostrar fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cerrar fichero
        try {
            cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar fichero de objetos tras mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
