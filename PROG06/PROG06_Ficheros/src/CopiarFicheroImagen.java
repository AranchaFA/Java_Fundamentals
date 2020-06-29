
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopiarFicheroImagen {

    public static void main(String[] args) {

        try {
            // Creamos los flujos de entrada y salida
            FileInputStream fisOrigen = null;
            FileOutputStream fosDestino = null;

            // Creamos dos objetos file
            File fileOrigen = new File("HAMTARA.png"); // Este tiene que existir para poder copiarlo
            File fileDestino = new File("destino.png"); // Este no hace falta que esté creado

            // Asignamos cada flujo al archivo creado correspondiente
            fisOrigen = new FileInputStream(fileOrigen);
            fosDestino = new FileOutputStream(fileDestino);

            /*
            Como el arhivo es de tipo imagen, y sus bytes no están agrupados siguiendo
            ningún patrón, tendremos que leer los bytes uno a uno e ir copiándolos uno
            a uno al archivo de destino. Por eso se usarán los métodos de las clases
            FileInputStream y FileOutputStream y no los de DatainputStream y DataOutputStream.
             */
            // Vamos leyendo los bytes individuales del archivo origen y escribiéndolos
            // en el de destino
            int byteLeido = 0;
            // FileInputStream.read() devuelve un int con el valor del siguiente byte
            // del fichero, hasta que llega al final y cuando no encuentra ningún byte
            // devuelve -1
            while ((byteLeido = fisOrigen.read()) != -1) {
                fosDestino.write(byteLeido);
            }
            System.out.println("Se ha terminado de grabar el fichero "+fileDestino.getPath());
        } catch (FileNotFoundException ex) {
            System.out.println("Problemas al buscar el archivo. " + ex.getMessage());
            Logger.getLogger(CopiarFicheroImagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Problemas con la lectura del fichero. " + ex.getMessage());
            Logger.getLogger(CopiarFicheroImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
