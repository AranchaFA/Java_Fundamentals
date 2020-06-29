package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Resultado {

    private Resultado resultado;
    private File ficheroObjetosResultados;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private ModifyOOS moos;
    private FileInputStream fis;
    private ObjectInputStream ois;

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    // Construyo con el nombre del fichero de salida por defecto, porque no vamos
    // a trabajar con ningún fichero que nosotros podamos seleccionar
    public DAO_Resultado() {
        ficheroObjetosResultados = new File("resultados.dat");
    }

    public void abrirGrabarConCabecera() throws IOException {
        fos = new FileOutputStream(ficheroObjetosResultados, true);
        oos = new ObjectOutputStream(fos);
    }

    public void abrirGrabarSinCabecera() throws IOException {
        fos = new FileOutputStream(ficheroObjetosResultados, true);
        moos = new ModifyOOS(fos);
    }

    public void cerrarGrabarConCabecera() throws IOException {
        oos.close();
        fos.close();
    }

    public void cerrarGrabarSinCabecera() throws IOException {
        fos.close();
        moos.close();
    }

    public void grabarUnResultado() throws IOException {
        // COMPROBAMOS SI EXISTE YA O NO EL FICHERO DE SALIDA PARA SABER
        // SI GRABAMOS CON O SIN CABECERA
        if (ficheroObjetosResultados.exists()) { // SIN CABECERA (MOOS)
            abrirGrabarSinCabecera();
            moos.writeObject(resultado);
            cerrarGrabarSinCabecera();
        } else { // CON CABECERA (OOS)
            abrirGrabarConCabecera();
            oos.writeObject(resultado);
            cerrarGrabarConCabecera();
        }
    }

    public void mostrarFicheroPorPantalla() {
        fis = null;
        ois = null;
        try {
            fis = new FileInputStream(ficheroObjetosResultados);
            ois = new ObjectInputStream(fis);
        } catch (IOException ex) {
            System.out.println("Error al abrir el fichero para leer. " + ex.getMessage());
            Logger.getLogger(DAO_Resultado.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object resultadoLeido = null;
        try {
            resultadoLeido = ois.readObject();

            while (resultadoLeido != null) {
                System.out.println(resultadoLeido.toString());
                resultadoLeido = ois.readObject();
            }
        } catch (EOFException ex) {
            System.out.println("Fin de fichero. " + ex.getMessage());
            // Logger.getLogger(DAO_Resultado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al leer el resultado del fichero. " + ex.getMessage());
            Logger.getLogger(DAO_Resultado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada al leer resultado. " + ex.getMessage());
            Logger.getLogger(DAO_Resultado.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ois.close();
            fis.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero para mostrar resultados. " + ex.getMessage());
            Logger.getLogger(DAO_Resultado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
