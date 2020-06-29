package ejer1.Modelo;

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

    // Mostrar fichero por pantalla
    public void mostrarFichero() {
        // Abrir fichero para leer
        try {
            abrirLeer();
        } catch (IOException ex) {
            System.out.println("Error al abrir fichero de objetos para mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Leer y mostrar en bucle
        try {
            while (true) {
                System.out.println(ois.readObject().toString());
            }
        } catch (EOFException ex) {
            System.out.println("Fichero de objetos terminado de mostrar. " + ex.getMessage());
            // Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al mostrar fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada al mostrar fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cerrar fichero
        try {
            cerrarLeer();
        } catch (IOException ex) {
            System.out.println("Error al cerrar fichero de objetos tras mostrarlo. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Generar el OBJETO FILE de Objects DE ESTE DAO pidiendo los atributos por pantalla
    // NUEVO / SOBREESCRIBIENDO si ya existe
    public void generarNuevoFichero() {
        // Abrir par grabar
        try {
            abrirGrabarSobreescribir();
        } catch (IOException ex) {
            System.out.println("Error al abrir para generar el fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        try {
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al cerrr tras generar el fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // AÑADIR al OBJETO FILE ya existente (si no existe lo crea) DE ESTE DAO pidiendo los atributos por pantalla
    public void anhadirObjetos() {
        // Abrir par grabar
        try {
            abrirGrabarSelectivo();
        } catch (IOException ex) {
            System.out.println("Error al abrir para añadir registros al fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        try {
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al cerrr tras añadir registros el fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Buscar un objeto en el fichero QUE APARECE UNA SOLA VEZ
    // Devuelve el objeto si existe, si no está en el fichero devuelve null
    public Object buscarUnObjeto(String atributoIdentificativo) {
        // Abrimos fichero para leer
        try {
            abrirLeer();
        } catch (IOException ex) {
            System.out.println("Error al abrir fichero para buscar un objeto. "+ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Buscamos en bucle
        Object objetoEncontrado = null;
        // Comparamos objeto por objeto hasta que se encuentre, o hasta EOF (el objeto no existirá en el fichero)
        while (objetoEncontrado == null) {
            Object objetoLeido = null;
            try {
                objetoLeido = ois.readObject();
            } catch (IOException ex) {
                System.out.println("Error al leer un objeto para comparar. " + ex.getMessage());
                Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase no encontrada intentando comparar. " + ex.getMessage());
                Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
            if (objetoLeido.getAtributoIdentificativo.equals(atributoIdentificativo)) {
                objetoEncontrado=objetoLeido;
            }
             */
        }

        // Cerramos fichero
        try {
            cerrarLeer();
        } catch (IOException ex) {
             System.out.println("Error al cerrar fichero tras buscar un objeto. "+ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetoEncontrado;
    }
    
    /*
    public void grabarFicheroPersonas() {
        // Abrir para grabar
        try {
            abrirGrabarSobreescribir();
        } catch (IOException ex) {
            System.out.println("Error al abrir para generar el fichero de objetos. " + ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            
            try {
                grabarUnObjeto(objetoAGrabar);
            } catch (IOException ex) {
                System.out.println("Error al grabar el objeto. "+ex.getMessage());
                Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("¿Grabar otro objeto? (S/N)");
            opcion = teclado.nextLine();
            while (!opcion.equalsIgnoreCase("s") && !opcion.equalsIgnoreCase("n")) {
                System.out.println("Por favor, introduce S o N :");
                opcion = teclado.nextLine();
            }
        } while (opcion.equalsIgnoreCase("s"));
        
        // Cerrar tras grabar
        try {
            cerrarGrabar();
        } catch (IOException ex) {
            System.out.println("Error al cerrr tras generar el fichero de objetos. "+ex.getMessage());
            Logger.getLogger(DAO_Objetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */ 
}
