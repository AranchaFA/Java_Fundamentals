
package Modelo;

import java.io.*;

public class DAOSalidaCSV {
    
    private File ficheroCSV;
    private FileOutputStream fos;
    //private PrintWriter pw;
    private OutputStreamWriter osw;
    private BufferedWriter bw;

    public File getFicheroCSV() {
        return ficheroCSV;
    }

    public void setFicheroCSV(File ficheroCSV) {
        this.ficheroCSV = ficheroCSV;
    }
/*
    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }
*/
    public DAOSalidaCSV(String nombreFichero) {
        ficheroCSV=new File(nombreFichero);
    }
    
    public void abrirFicheroSalida() throws FileNotFoundException{
        fos=new FileOutputStream(ficheroCSV);
        //pw=new PrintWriter(fos, true);
        osw=new OutputStreamWriter(fos);
        bw=new BufferedWriter(osw);
    }
    
    public void cerrarFicheroSalida() throws IOException{
        //pw.close();
        bw.close();
        osw.close();
        fos.close();
    }
    
    public void grabarSecuenciaDeDatos(String secuenciaDatos) throws FileNotFoundException, IOException{
        // ¿HABRÍA QUE ABRIR CADA VEZ PARA HACER TRUE EL AUTOFLUSH?
        // SI ABRO Y CIERRO EL FLUJO DE SALIDA CADA VEZ QUE GRABO UNA LÍNEA, SIEMPRE SE SITÚA EN LA 
        // PRIMERA POSICIÓN Y GRABA PISANDO LA LÍNEA ANTERIOR :(
        // Si se abre, siempre hay que cerrar al final para que no de error al intentar
        // volver a abrir en la siguiente ejecución del método
       // abrirFicheroSalida();
       // pw.write(secuenciaDatos);
       bw.write(secuenciaDatos);
       // Si pongo el flush envía a grabar la secuencia de datos guardada en el buffer al ejecutarse,
       // si no lo pusiera no se enviaría hasta cerrar el fichero, que mandaría todas las líneas que
       // hayamos ido metiendo juntas de un bloque
       bw.flush();
       // cerrarFicheroSalida();
    }
}
