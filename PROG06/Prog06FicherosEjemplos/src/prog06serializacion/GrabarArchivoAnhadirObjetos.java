package prog06serializacion;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarArchivoAnhadirObjetos {
    
       public static void main(String[] args) {
        
        ObjectOutputStream fsalida = null;
        Coche coche;
        Scanner teclado = new Scanner(System.in);
        char continuar = 's';
        try {
                 
            //creamos el ObjetOutputStream como  MyAppendingObjetStream  para que no escriba la cabecera del nuevo bloque de registros
            MyAppendingObjectOutputStream oos = new MyAppendingObjectOutputStream(new FileOutputStream("coches.dat", true));

           do {
                //Se crea el  objeto Persona
                System.out.print("Introduce la marca: ");
                String marca = teclado.nextLine();
                System.out.print("Introduce el modelo: ");
                String modelo = teclado.nextLine();
                System.out.print("Introduce los caballos: ");
                int cv = teclado.nextInt();
                //vacio el \n del entero
                teclado.nextLine();
                
                coche = new Coche(marca, modelo, cv);                
                //Se escribe el objeto en el fichero
                System.out.println(coche.toString());
                oos.writeObject(coche);

                System.out.println("Quieres continuar (s/n):");        
            }while (((continuar=(char)System.in.read())!='n') && ((continuar=(char)System.in.read())!='N'));
            oos.close();
        } catch (FileNotFoundException ex) {
                       System.out.println("1"+ex.getMessage());
        } catch (IOException ex) {
                        System.out.println("2"+ex.getMessage());
        }
        

    }

}
