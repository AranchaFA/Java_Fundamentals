package Controlador;

import Modelo.ModifyObjectOutputStream;
import java.io.*;

public class DAOSalida {

    private File fichero;

    private FileOutputStream fos;

    private ObjectOutputStream oos;

    private ModifyObjectOutputStream moos;

    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
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

    public ModifyObjectOutputStream getMoos() {
        return moos;
    }

    public void setMoos(ModifyObjectOutputStream moos) {
        this.moos = moos;
    }

    public DAOSalida(String nombreFichero) {
        fichero = new File(nombreFichero);
    }

    public DAOSalida(File fichero) {
        this.fichero = fichero;
    }

    // Hacemos dos métodos diferentes para abrir los flujos de datos en función de si
    // se grabará con cabecera (oos) o sin cabecera (moos), para que no genere problemas
    // tener uno de los dos flujos abierto sin usar.
    public void abrirFicheroConCabecera() throws FileNotFoundException, IOException {
        fos = new FileOutputStream(fichero, true);
        oos = new ObjectOutputStream(fos);
    }

    public void abrirFicheroSinCabecera() throws FileNotFoundException, IOException {
        fos = new FileOutputStream(fichero, true);
        moos = new ModifyObjectOutputStream(fos);
    }

    public void grabarConCabecera(Object objeto) throws IOException {
        oos.writeObject(objeto);
    }

    public void grabarSinCabecera(Object objeto) throws IOException {
        moos.writeObject(objeto);
    }

    public void grabarUnObjeto(Object objeto) throws IOException{
        // Comprobamos si existe el fichero donde vamos a grabar ya existe
        // Si NO existe, grabaremos el objeto CON CABECERA
        // Si SÍ existe, grabaremos el objeto SIN CABECERA
        
        // Hay que abrir los OutputStreams cada vez que se graba un objeto individual,
        // si no da error si los abro al principio y no los cierro hasta el final como
        // con los InputStreams. Para que no de problemas al intentar inicializarlo de
        // nuevo la siguiente vez no se dejan abiertos y cerramos al final.
        if (fichero.exists()) {
            abrirFicheroSinCabecera();
            grabarSinCabecera(objeto);
            cerrarFicheroSinCabecera();
        } else {
            abrirFicheroConCabecera();
            grabarConCabecera(objeto);
            cerrarFicheroConCabecera();
        }
    }
    
    public void cerrarFicheroConCabecera() throws IOException {
        oos.close();
        fos.close();
    }

    public void cerrarFicheroSinCabecera() throws IOException {
        moos.close();
        fos.close();
    }
}
