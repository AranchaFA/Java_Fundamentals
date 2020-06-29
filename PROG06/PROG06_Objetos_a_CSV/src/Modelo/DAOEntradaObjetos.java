package Modelo;

import java.io.*;

public class DAOEntradaObjetos {

    private File fileObjetos;
    private FileInputStream fis;
    private ObjectInputStream ois;

    public File getFileObjetos() {
        return fileObjetos;
    }

    public void setFileObjetos(File fileObjetos) {
        this.fileObjetos = fileObjetos;
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

    public DAOEntradaObjetos(String nombreFichero) {
        fileObjetos = new File(nombreFichero);
    }

    public void abrirFicheroEntrada() throws FileNotFoundException, IOException {
        fis = new FileInputStream(fileObjetos);
        ois = new ObjectInputStream(fis);
    }

    public void cerrarFicheroEntrada() throws IOException {
        fis.close();
        ois.close();
    }

    public Object leerUnObjeto() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }
}
