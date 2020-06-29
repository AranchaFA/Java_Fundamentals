package EJER1.Modelo;

import java.io.*;
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

    // Constructores
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

    public Cuenta leerUnObjeto() throws IOException, ClassNotFoundException {
        return (Cuenta) ois.readObject();
    }

    // GRABAR
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

    public void grabarUnObjeto(Cuenta objetoAGrabar) throws IOException {
        oos.writeObject(objetoAGrabar);
    }

    // Mostrar fichero por pantalla
    public void mostrarFichero() {
        try {
            // Abrir fichero para leer
            abrirLeer();
            
            // Leer y mostrar en bucle
            try {
                while (true) {
                    System.out.println(leerUnObjeto().toString());
                }
            } catch (EOFException ex) {
                System.out.println("Fichero de objetos terminado de mostrar. " + ex.getMessage());
                // Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase no encontada. "+ex.getMessage());
                Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Cerrar fichero
            cerrarLeer();
     
        } catch (IOException ex) {
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    // Buscar un objeto en el fichero QUE APARECE UNA SOLA VEZ
    // Devuelve el objeto si existe, si no está en el fichero devuelve null
    public Cuenta buscarUnObjeto(String numCuenta) {
        Cuenta objetoEncontrado = null;
        try {
            // Abrimos fichero para leer
            abrirLeer();

            // Comparamos en bucle hasta que se encuentre, o hasta fin de fichero (el objeto no existirá en el fichero)
            Cuenta objetoLeido = leerUnObjeto();
            while (objetoEncontrado == null && objetoLeido != null) {
                if (objetoLeido.getNumCuenta().equals(numCuenta)) {
                    objetoEncontrado = objetoLeido;
                }
                objetoLeido = leerUnObjeto();
            }

            // Cerramos fichero
            cerrarLeer();

        } catch (IOException ex) {
            // Salta el comentario al finalizar el fichero porque salta la IOEx
           // Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objetoEncontrado;
    }

}
