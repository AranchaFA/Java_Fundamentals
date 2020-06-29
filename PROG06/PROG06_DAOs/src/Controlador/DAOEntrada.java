package Controlador;

import java.io.*;

public class DAOEntrada {

    private File fichero;

    private FileInputStream fis;

    private ObjectInputStream ois;

    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
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

    public DAOEntrada(String nombreFichero) {
        fichero = new File(nombreFichero);
    }

    public DAOEntrada(File fichero) {
        this.fichero = fichero;
    }

    public void abrirFicheroEntrada() throws FileNotFoundException, IOException {
        fis = new FileInputStream(fichero);
        ois = new ObjectInputStream(fis);
    }

    public Object leerUnObjeto() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    public void cerrarFicheroEntrada() throws IOException {
        ois.close();
        fis.close();
    }
}
