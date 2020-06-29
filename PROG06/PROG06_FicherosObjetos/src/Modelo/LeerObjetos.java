package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerObjetos {

    // ATRIBUTOS
    // File con el fichero de entrada, se inicializará en el método abrir fichero
    // para pasar por parámetro el nombre del fichero
    private File ficheroEntrada;
    // Flujo de entrada de datos (en bytes) FileIS
    private FileInputStream fis;
    // Trabajamos con objetos, así que usaremos un objeto ObjectIS
    private ObjectInputStream ois;

    // MÉTODOS
    public File getFicheroEntrada() {
        return ficheroEntrada;
    }

    public void setFicheroEntrada(File ficheroEntrada) {
        this.ficheroEntrada = ficheroEntrada;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    // Es más aconsejable hacer throws a las Exceptions que tratarlas en los métodos
    // de las clases, porque si no al dar error en los programas principales no
    // sabemos de dónde viene el problema (los try-catch se quedan "dentro" de los
    // métodos del objeto.
    // Constructor: Los atributos no se inicializan, lo harán en el método leer
    public LeerObjetos() {
    }

    // Método para abrir el fichero, inicializará los objetos atributos
    public void abrirFichero(String nombreFichero) throws FileNotFoundException, IOException {
        ficheroEntrada = new File(nombreFichero);
        fis = new FileInputStream(ficheroEntrada);
        ois = new ObjectInputStream(fis);
    }

    // Método para leer UN SOLO objeto del fichero
    public Object leerObjeto() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    // Método para cerrar los flujos de datos usados para trabajar con el fichero
    public void cerrarFichero() throws IOException {
        ois.close();
        fis.close();
    }

    // El método para mostrar todos los datos de un fichero por pantalla lo 
    // incorporo en el controlador
}
