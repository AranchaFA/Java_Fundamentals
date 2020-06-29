package prog06ficherosCSV;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrabarFicheroCSV {

    public static void main(String[] args) {

        Persona p;

        FileWriter fw = null;
        try {
            fw = new FileWriter("nombres.csv");
            BufferedWriter fsalida = new BufferedWriter(fw);
            //BufferedReader registro = new BufferedReader(new FileReader("c:/ficheros/libros.csv"));
            //leemos el primer registro
            p = new Persona("Dolores", "Fuertes", 32);
            fsalida.write(p.getNombre() + "," + p.getApellido() + "," + p.getEdad());
            fsalida.write("\n");

            p = new Persona("Onofre", "Nadol", 25);
            fsalida.write(p.getNombre() + "," + p.getApellido() + "," + p.getEdad());
            fsalida.write("\n");

            p = new Persona("Casimiro", "Novena", 45);
            fsalida.write(p.getNombre() + "," + p.getApellido() + "," + p.getEdad());
            fsalida.write("\n");

            p = new Persona("Agustin", "Dormido", 33);
            fsalida.write(p.getNombre() + "," + p.getApellido() + "," + p.getEdad());
            fsalida.write("\n");
            fsalida.close();
        } catch (IOException ex) {
            Logger.getLogger(GrabarFicheroCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
