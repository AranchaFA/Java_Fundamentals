
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainClase {

    public static void main(String[] args) {
       
        File fichero;
        FileReader fr=null;
        BufferedReader br = null;
        try {
            fichero=new File("personas.csv");
            fr = new FileReader(fichero);
            br=new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado. "+ex.getMessage());
            Logger.getLogger(MainClase.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        String cadena;
        try {
            while ((cadena=br.readLine())!=null) {
                System.out.println(cadena);
            }
        } catch (IOException ex) {
            System.out.println("Problema al mostrar el fichero por pantalla. "+ex.getMessage());
            Logger.getLogger(MainClase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            br.close();
        } catch (IOException ex) {
            System.out.println("Problemas al cerrar el archivo. "+ex.getMessage());
            Logger.getLogger(MainClase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
