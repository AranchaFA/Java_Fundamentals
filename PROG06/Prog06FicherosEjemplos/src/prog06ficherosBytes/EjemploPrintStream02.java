package prog06ficherosBytes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

//Usando printSream grabar en un fichero un caracter,un entero
//un real, una fecha, una nueva linea y un string
//acceder despues al fichero en el proyecto y comprobar si es legible

public class EjemploPrintStream02 {

    public static void main(String[] args) {
        File file = new File("filePrintStream.txt");
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            printStream = new PrintStream(fileOutputStream);
            
            // si quisieramos imprimirlo en pantalla, derivariamos el objeto printStream al System.out
            //  printStream = new PrintStream(System.out);

            //Imprimimos char value
            printStream.print('A');

            //Imprimimos int value
            printStream.print(100);

            //Imprimimos double value
            printStream.print(45.451);

            //Imprimimos una fecha date
            printStream.print(new Date().toString());

            //Imprimimos newline
            printStream.println();

            //Imprimimos String
            printStream.println("Esto es un ejemplo de la clase PrintStream, compruebalo en la carpeta del proyecto ");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (printStream != null) {
                    printStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
