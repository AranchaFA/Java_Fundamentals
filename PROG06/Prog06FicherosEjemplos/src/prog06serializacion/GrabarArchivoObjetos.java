package prog06serializacion;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarArchivoObjetos {
    
    public static void main(String[] args) {
        
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Coche coche;
        Scanner teclado = new Scanner(System.in);
        char continuar = 's';
        try {
            //Se crea el fichero
          
            fos = new FileOutputStream("coches.dat");
            salida = new ObjectOutputStream(fos);

            do {
                //Se crea el primer objeto Coche
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
                salida.writeObject(coche);

                System.out.println("Quieres continuar (s/n):");        
            }while (((continuar=(char)System.in.read())!='n') && ((continuar=(char)System.in.read())!='N'));
            fos.close();
        } catch (FileNotFoundException ex) {
                       System.out.println("1"+ex.getMessage());
        } catch (IOException ex) {
                        System.out.println("2"+ex.getMessage());
        }
        

    }

}
