package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_ObjetosPersona {

    private File ficheroPersonas;
    private FileInputStream fis;
    private FileOutputStream fos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private ModifyObjectOutputStream moos;

    public DAO_ObjetosPersona(String nombreFichero) {
        this.ficheroPersonas = new File(nombreFichero);
    }

    public void abrirLeer() throws FileNotFoundException, IOException {
        fis = new FileInputStream(ficheroPersonas);
        ois = new ObjectInputStream(fis);
    }

    public void abrirGrabarConCabecera() throws FileNotFoundException, IOException {
        fos = new FileOutputStream(ficheroPersonas);
        oos = new ObjectOutputStream(fos);
    }

    public void abrirGrabarSinCabecera() throws FileNotFoundException, IOException {
        fos = new FileOutputStream(ficheroPersonas, true);
        moos = new ModifyObjectOutputStream(fos);
    }

    public void cerrarLeer() throws IOException {
        ois.close();
        fis.close();
    }

    public void cerrarGrabarConCabecera() throws IOException {
        oos.close();
        fos.close();
    }

    public void cerrarGrabarSinCabecera() throws IOException {
        moos.close();
        fos.close();
    }

    public void grabarUnObjetoPersona(Object objeto) throws IOException {
        // ¿¿ SI PASO COMO PARÁMETRO LA PERSONA PERO EN FORMA DE OBJECT SERÍA MÁS GENÉRICO ??
        // Creo que no haría falta castearlo al tipo persona para grabarlo, porque de todos
        // modos lo grabará como Object al ser serializable.....

        // Si el fichero NO EXISTE grabamos CON CABECERA
        // Si el fichero SÍ EXISTE grabamos SIN CABECERA
        if (ficheroPersonas.exists()) { // SIN
            // PARA ESTE CASO ABRIREMOS Y CERRAREMOS EL FICHERO EN EL MÉTODO DEL
            // CONTROLADOR, PARA NO HACERLO CADA VEZ QUE GRABEMOS UN OBJETO INDIVIDUAL
            // DURANTE EL BUCLE DE COPIADO DEL FICHERO   
            
            // SI LO HAGO COMO PONE ARRIBA NO GRABA CORRECTAMENTE.....
            // Grabamos el objeto SIN CABECERA (MOOS)
            abrirGrabarSinCabecera();
            moos.writeObject(objeto);
            cerrarGrabarSinCabecera();
        } else { // CON
            // EN ESTE CASO ABRIMOS Y CERRAMOS AQUÍ PORQUE SÓLO SE GRABARÁ UN ÚNICO
            // OBJETO DE ESTA MANERA, Y SERÍA ENGORROSO CONTROLAR CUÁNDO SE DA ESTE
            // CASO EN EL MÉTODO DEL CONTROLADOR Y ABRIR/CERRAR ALLÍ
            
            // SI SE HACE COMO DICE ARRIBA DA ERROR AL GRABAR CON CABECERA :(
            abrirGrabarConCabecera();
            oos.writeObject(objeto);
            cerrarGrabarConCabecera();           
        }
    }

    public Object leerUnObjetoPersona() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    public void mostrarFicheroPorPantalla() {
        try {
            abrirLeer();
        } catch (IOException ex) {
            System.out.println("Error al abrir para mostrar resultados. "+ex.getMessage());
            Logger.getLogger(DAO_ObjetosPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Object auxObjeto=leerUnObjetoPersona();
            while (auxObjeto!=null) {
                System.out.println(auxObjeto.toString());
                auxObjeto=leerUnObjetoPersona();
            }
        } catch (EOFException ex) {
            System.out.println("Fin de fichero mostrando resultados. " + ex.getMessage());
            // Logger.getLogger(DAO_ObjetosPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO_ObjetosPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO_ObjetosPersona.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cerrarLeer();
            } catch (IOException ex) {
                Logger.getLogger(DAO_ObjetosPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
