package EJER1.Controlador;

import EJER1.Modelo.*;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_ObjetosCSV {

    // ATRIBUTOS 
    private DAO_CSVs daoCSV;
    private DAO_Objetos daoObjetos;

    // MÉTODOS
    // Getters + Setters
    public DAO_CSVs getDaoCSV() {
        return daoCSV;
    }

    public void setDaoCSV(DAO_CSVs daoCSV) {
        this.daoCSV = daoCSV;
    }

    public DAO_Objetos getDaoObjetos() {
        return daoObjetos;
    }

    public void setDaoObjetos(DAO_Objetos daoObjetos) {
        this.daoObjetos = daoObjetos;
    }

    // Constructor
    public Controlador_ObjetosCSV(String nombreFicheroCSV, String nombreFicheroObjetos) {
        daoCSV = new DAO_CSVs(nombreFicheroCSV);
        daoObjetos = new DAO_Objetos(nombreFicheroObjetos);
    }

    // Generar un objeto a partir de un STRING PASADO POR PARÁMETRO
    public Cuenta generarUnObjeto(String stringDeAtributos) {
        // Creamos un StringTokenizer para el String leido y la coma como separador
        StringTokenizer stk = new StringTokenizer(stringDeAtributos, ",");
        // Vamos tokenizando cada atributo y guardando en una variable auxiliar
        String numCuenta = stk.nextToken();
        String nombreTitular = stk.nextToken();
        String apellidoTitutlar = stk.nextToken();

        String saldo_String = stk.nextToken();
        // Pasamos el atributo de tipo entero que hemos leído como String a int 
        // eliminando espacios en blanco antes o después de la difra para evitar errores
        int saldo_int = Integer.parseInt(saldo_String.trim());

        // Creamos el objeto persona que será atributo de la cuenta
        Persona titular = new Persona(nombreTitular, apellidoTitutlar);
        // Creamos el objeto cuenta con los atributos obtenidos
        Cuenta objetoGenerado = new Cuenta(numCuenta, titular, saldo_int);

        return objetoGenerado;
    }

    // Generar fichero de objetos sólo con ls cuentas con saldo negativo
    public void generarFicheroObjetosSaldoNegativo() {
        try {
            // Abrimos para leer CSV y grabar fichero de objetos
            daoCSV.abrirLeer();
            daoObjetos.abrirGrabarSelectivo();

            // Leemos el CSV, transformamos a Objeto, comprobamos el valor del atibuto saldo y si procede grabamos,
            // en bucle hasta fin de fichero
            String stringLeido = null;
            stringLeido = daoCSV.leerUnString();
            while (stringLeido != null) {
                Cuenta objetoGenerado = generarUnObjeto(stringLeido);
                if (objetoGenerado.getSaldo() < 0) {
                    getDaoObjetos().grabarUnObjeto(objetoGenerado);
                }
                stringLeido = daoCSV.leerUnString();
            }

            // Cerramos flujos de lectura de CSV y de salida del fichero de objetos
            daoCSV.cerrarLeer();
            daoObjetos.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Menú para manejar la aplicación en el main
    public void ejecutarMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("*** M E N Ú ***");
            System.out.println("1. Leer y mostrar a partir del CSV.");
            System.out.println("2. Indicar el total de cuentas.");
            System.out.println("3. Generar un fichero de objetos con las cuentas con saldo negativo.");
            System.out.println("4. Visualizar el fichero de objetos con las cuentas con saldo negativo.");
            System.out.println("5. Buscar una cuenta por su número de cuenta.");
            System.out.println("6. Salir");
            System.out.println("\n¿Qué quieres hacer?");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiamos buffer

            switch (opcion) {
                case 1:
                    System.out.println("");
                    daoCSV.mostrarFicheroPorPantalla();
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("El total de cuentas es ");
                    System.out.println(daoCSV.contarRegistros());
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    generarFicheroObjetosSaldoNegativo();
                    System.out.println("Fichero de objetos con las cuentas en números rojos generado.");
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    daoObjetos.mostrarFichero();
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("¿Qué número de cuenta buscas?");
                    Cuenta cuentaBuscada=daoObjetos.buscarUnObjeto(teclado.nextLine());
                    if (cuentaBuscada!=null) {
                        System.out.println("Se ha encontrado la cuenta:");
                        System.out.println(cuentaBuscada.toString());
                    } else {
                        System.out.println("La cuenta no existe en el fichero.");
                    }
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("");
                    System.out.println("¡ Adiós !");
                    System.out.println("");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opción no válida, por favor introduce un número entre 1 y 6:");
                    opcion = teclado.nextInt();
                    System.out.println("");
            }
        } while (opcion != 6);
    }
}
