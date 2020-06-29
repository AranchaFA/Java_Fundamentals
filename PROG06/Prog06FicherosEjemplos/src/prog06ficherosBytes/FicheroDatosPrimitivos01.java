package prog06ficherosBytes;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FicheroDatosPrimitivos01 {

    public static void main(String[] args) throws FileNotFoundException {
        //programa que lee de un fichero 
        //un mensaje =" Ejemplo mensaje" en un fichero
        //y a continuación 20 números (1 numero real y número entero alternativamente ) 
        int numInt;
        float numFloat;
        String mensaje = "Ejemplo Mensaje";
        File ficheroSalida = new File("FicheroDatosPrimitivos.dat");
        DataOutputStream fsal = new DataOutputStream(new FileOutputStream(ficheroSalida));

        try {
            fsal.writeUTF(mensaje); //escribimos el string
            System.out.println(mensaje+" grabado");

            //escribimos 10 números reales aleatorios
            for (int i = 0; i < 10; i++) {
                //calculo los números
                numInt = (int) (Math.random() * 6 + 1);
                numFloat = (float) Math.random();
                System.out.println(numInt+ " "+ numFloat);

                //escribimos en el fichero
                fsal.writeInt(numInt);
                fsal.writeFloat(numFloat);
            }
        } catch (IOException ex) {
            System.out.println("Error en la escritura del fichero");
        } finally {
            try {
                fsal.close();
            } catch (IOException ex) {
                Logger.getLogger(FicheroDatosPrimitivos01.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
