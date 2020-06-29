
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainClone {

    public static void main(String[] args) {
        
        Persona p1,p2 = null;
        
        p1=new Persona();
        p1.setNombre("Iluminada");
        p1.setApellidos("Fundida");
        p1.setAnhoNacimiento(1992);
        
        try {
            p2=(Persona) p1.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(MainClone.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        p2.setNombre("Bombilla");
        
        System.out.println("Valores de ambas personas...");
        System.out.print(p1.toString());
        p1.imprime();
        System.out.print(p2.toString());
        p2.imprime();
         
        System.out.println("¿Los objetos son iguales?");
        System.out.println(p1.equals(p2)?"Iguales":"Diferentes");
    }
    
}
