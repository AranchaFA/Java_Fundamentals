package Modelo;

import java.io.*;
import javax.imageio.stream.FileImageInputStream;

public class DAO_BuscarPersona {

    // ATRIBUTOS
    private File ficheroPersonas;
    private FileInputStream fis;
    private ObjectInputStream ois;
    private Persona personaABuscar;

    // MÉTODOS
    public File getFicheroPersonas() {
        return ficheroPersonas;
    }

    public void setFicheroPersonas(File ficheroPersonas) {
        this.ficheroPersonas = ficheroPersonas;
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

    public Persona getPersonaABuscar() {
        return personaABuscar;
    }

    public void setPersonaABuscar(Persona personaABuscar) {
        this.personaABuscar = personaABuscar;
    }

    // Constructor
    public DAO_BuscarPersona(File ficheroPersonas) {
        this.ficheroPersonas = ficheroPersonas;
    }

    public DAO_BuscarPersona(String nombreFichero) {
        ficheroPersonas = new File(nombreFichero);
    }
    // Métodos para LEER
    public void abrirParaLeer() throws IOException {
        fis = new FileInputStream(ficheroPersonas);
        ois = new ObjectInputStream(fis);
    }
    public void cerrarParaLeer() throws IOException{
        ois.close();
        fis.close();
    }
    public Persona leerUnaPersona() throws IOException, ClassNotFoundException{
        Persona personaLeida=(Persona) ois.readObject();
        return personaLeida;
    }
    public boolean compararDosPersonas(Persona personaABuscar){
        if (this.personaABuscar.getNombre().equals(personaABuscar.getNombre())) {
            return true;
        } else {
            return false;
        }
    }
}
