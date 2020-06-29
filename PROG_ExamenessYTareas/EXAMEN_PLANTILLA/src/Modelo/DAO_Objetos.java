package Modelo;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_Objetos {

    // ATRIBUTOS
    private File ficheroObjetos;
    // LEER
    private FileInputStream fis;
    private ObjectInputStream ois;
    // GRABAR
    private FileOutputStream fos;
    private ObjectOutputStream oos;

    // MÉTODOS
    // Getters + Setters
    public File getFicheroObjetos() {
        return ficheroObjetos;
    }

    public void setFicheroObjetos(File ficheroObjetos) {
        this.ficheroObjetos = ficheroObjetos;
    }

    // Constructores
    public DAO_Objetos(File ficheroObjetos) {
        this.ficheroObjetos = ficheroObjetos;
    }

    public DAO_Objetos(String nombreFichero) {
        ficheroObjetos = new File(nombreFichero);
    }

    // LEER
    public void abrirLeer() throws FileNotFoundException, IOException {
        fis = new FileInputStream(ficheroObjetos);
        ois = new ObjectInputStream(fis);
    }

    public void cerrarLeer() throws IOException {
        ois.close();
        fis.close();
    }

    public Object leerUnObjeto() throws IOException, ClassNotFoundException {
        return ois.readObject();
    }

    // GRABAR
    // SÓLO para GENERAR NUEVO FILE
    public void abrirGrabarSobreescribir() throws FileNotFoundException, IOException {
        fos = new FileOutputStream(ficheroObjetos);
        oos = new ObjectOutputStream(fos);
    }

    // El método "normal" que usamos para añadir si existe/generar si no existe
    public void abrirGrabarSelectivo() throws FileNotFoundException, IOException {
        if (ficheroObjetos.exists()) {
            fos = new FileOutputStream(ficheroObjetos, true);
            oos = new ModifyObjectOutputStream(fos);
        } else {
            fos = new FileOutputStream(ficheroObjetos);
            oos = new ObjectOutputStream(fos);
        }
    }

    public void cerrarGrabar() throws IOException {
        oos.close();
        fos.close();
    }

    // Poner las clases como IMPLEMENTS SERIALIZABLE!!!
    public void grabarUnObjeto(Object objetoAGrabar) throws IOException {
        oos.writeObject(objetoAGrabar);
    }

    // Generar un string de atributos a grabar, a partir de un OBJETO PASADO POR PARÁMETRO
    // También incluido en el CSV_Objetos
    public String generarUnStringDeAtributos(Object objeto) {
        String stringGenerado = "";
        /*
        String atributo1 = objeto.getAtibuto1;
        String atributo2 = objeto.getAtibuto2;
        stringGenerado = atributo1 + "," + atributo2;
        // Recorremos el atributo tipo lista, el datoLeido puede ser String,int,... ADAPTARLO
        for (String datoLeido : atributoColeccion) {
            stringGenerado += "," + datoLeido;
        }
        // Salto de línea final
        stringGenerado += "\n";
        */
        return stringGenerado;
    }
    
    // Mostrar fichero por pantalla
    public void mostrarFichero() {
        try {
            // Abrir fichero para leer
            abrirLeer();
            try {
                // Leer y mostrar en bucle
                while (true) {
                    System.out.println(ois.readObject().toString());
                }
            } catch (EOFException ex) {
                System.out.println("Fichero de objetos terminado de mostrar. " + ex.getMessage());
                // Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Cerrar fichero
            cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al mostrar fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada al mostrar fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Generar el OBJETO FILE de Objects DE ESTE DAO pidiendo los atributos por pantalla
    // NUEVO / SOBREESCRIBIENDO si ya existe
    public void generarNuevoFicheroSobreescribir() {
        try {
            // Abrir par grabar
            abrirGrabarSobreescribir();
            // Pedir atributos en bucle
            Scanner teclado = new Scanner(System.in);
            String opcion;
            do {
                System.out.println("Atributo String:");
                String atibutoString = teclado.nextLine();
                // Para introducir un atributo tipo INT
                System.out.println("Atributo INT):");
                int atributoINT = teclado.nextInt();
                teclado.nextLine(); // Vaciamos buffer

                // Object objetoAGrabar=new Object(atibuto1,atributo2INT);
                // grabarUnObjeto(objetoAGrabar);
                System.out.println("¿Grabar otro objeto? (S/N)");
                opcion = teclado.nextLine();
                while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
                    System.out.println("Por favor, introduce S o N :");
                    opcion = teclado.nextLine();
                }
            } while (opcion.equalsIgnoreCase("s"));
            // Cerrar tras grabar
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al generar el fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // AÑADIR al OBJETO FILE ya existente (si no existe lo crea) DE ESTE DAO pidiendo los atributos por pantalla
    public void anhadirObjetos() {
        try {
            // Abrir par grabar
            abrirGrabarSelectivo();
            // Pedir atributos en bucle
            Scanner teclado = new Scanner(System.in);
            String opcion;
            do {
                System.out.println("Atributo String:");
                String atibutoString = teclado.nextLine();
                // Para introducir un atributo tipo INT
                System.out.println("Atributo INT):");
                int atributoINT = teclado.nextInt();
                teclado.nextLine(); // Vaciamos buffer

                // Object objetoAGrabar=new Object(atibuto1,atributo2INT);
                // grabarUnObjeto(objetoAGrabar);
                System.out.println("¿Grabar otro objeto? (S/N)");
                opcion = teclado.nextLine();
                while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
                    System.out.println("Por favor, introduce S o N :");
                    opcion = teclado.nextLine();
                }
            } while (opcion.equalsIgnoreCase("s"));
            // Cerrar tras grabar
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al añadir registros el fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Buscar un objeto en el fichero QUE APARECE UNA SOLA VEZ
    // Devuelve el objeto si existe, si no está en el fichero devuelve null
    public Object buscarUnObjeto(String atributoIdentificativo) {
        Object objetoEncontrado = null;
        try {
            // Abrimos fichero para leer
            abrirLeer();
            // Buscamos en bucle
            // Comparamos objeto por objeto hasta que se encuentre, o hasta EOF (el objeto no existirá en el fichero)
            try {
                while (objetoEncontrado == null) {
                    Object objetoLeido = null;

                    objetoLeido = ois.readObject();

                    /*
                    // Se puede hacer pasando por parámetro un objeto con el atributo a comparar, y el compareTo
            if (objetoLeido.getAtributoIdentificativo.equalsIgnoreCase(atributoIdentificativo)) {
                objetoEncontrado=objetoLeido;
            }
                     */
                }
            } catch (EOFException ex) {
                System.out.println("Fin de fichero de objetos. " + ex.getMessage());
                // Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Cerramos fichero
            cerrarLeer();
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada buscando un objeto. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetoEncontrado;
    }

    
    // GRABAR FICHERO pidiendo los datos por teclado
    /*
    public void grabarFicheroPersonas() {      
        try {
            // Abrir para grabar
            abrirGrabarSobreescribir();
        
        // Pedir atributos en bucle
        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("Nombre:");
            String nombre=teclado.nextLine();
            System.out.println("Apellidos:");
            String apellidos=teclado.nextLine();
            // Para introducir un atributo tipo INT
            System.out.println("Edad:");
            String edadString=teclado.nextLine();
            int edadINT=Integer.parseInt(edadString.trim());
            
            Object objetoAGrabar=new Persona(nombre,apellidos,edadINT);

                grabarUnObjeto(objetoAGrabar);
            
            System.out.println("¿Grabar otro objeto? (S/N)");
            opcion = teclado.nextLine();
            while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
                System.out.println("Por favor, introduce S o N :");
                opcion = teclado.nextLine();
            }
        } while (opcion.equalsIgnoreCase("s"));
        
        // Cerrar tras grabar
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al generar el fichero de objetos. "+ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     */
}
