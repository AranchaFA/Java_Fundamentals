package Arrays_Collections.Collections;

import Arrays_Collections.DAOs.*;
import Ficheros.Objetos_y_CSVs.Controlador_ObjetosCSV;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodos_Collections {

    // Los distintos tipos de colecciones
    List<Object> list;
    Set<Object> set;
    Map<Object, Object> map;
    // DAOs
    DAO_CSVs daoCSV;
    DAO_DatosPrimitivos daoInts;
    DAO_Objetos daoObjetos;

    // TAMAÑO de la colección
    public int tamanhoColeccionList() {
        return list.size();
    }

    public int tamanhoColeccionSet() {
        return set.size();
    }

    public int tamanhoColeccionMap() {
        return map.size();
    }

    // AÑADIR UN OBJETO (desde la clase que contiene la colección)
    // MAP: Devuelve el objeto que había asociado a esa key en caso de existir,
    // null si no existía
    // SET,LIST: True si el objeto se ha añadido (no existía previamente)
    public Object anhadirUnObjetoMap(Object key, Object objetoAAnhadir) {
        return map.put(key, objetoAAnhadir);
    }

    public boolean anhadirUnObjetoSet(Object objetoAAnhadir) {
        return set.add(objetoAAnhadir);
    }

    public boolean anhadirUnObjetoList(Object objetoAAnhadir) {
        return list.add(objetoAAnhadir);
    }

    // BORRAR UN OBJETO (desde la clase que contiene la colección)
    // MAP: Devuelve el objeto que había asociado a esa key en caso de existir,
    // null si no existía
    // SET,LIST: True si el objeto se ha borrado (sí existía en la colección)
    public Object borrarUnObjetoMap(Object objetoABorrar) {
        // Remove pasando por parámetro el ÍNDICE, que puede ser de cualquier
        // tipo, por eso en la API aparece como Object key!!!
        return map.remove(objetoABorrar.getAtributoKey());
    }

    public boolean borrarUnObjetoSet(Object objetoABorrar) {
        return set.remove(objetoABorrar);
    }

    public boolean borrarUnObjetoList(Object objetoABorrar) {
        return list.remove(objetoABorrar);
    }

    
    // ELIMINAR UN OBJETO pasado por parámetro (en controlador)
    // Devuelve true si se ha eliminado, false si no se ha eliminado finalmente
    // o si no existía
    public boolean eliminarUnObjetoMapControlador(Object objetoAEliminar) {
        Scanner teclado = new Scanner(System.in);
        boolean eliminar = false;
        // Habremos metido el método buscarUnObjeto en la clase que contenga la colección
        Object objetoEncontrado = map.buscarUnObjeto(objetoAEliminar);
        if (objetoEncontrado != null) {
            String confirmar = "";
            do {
                Vista.Vista.mostrarMensaje("El objeto que quieres eliminar es: \n"
                     + objetoEncontrado.toString() + "\n¿Estás seguro? (S/N):");
                confirmar = teclado.nextLine();
                if (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N")) {
                    Vista.Vista.mostrarMensaje("Opción no válida.");
                }
            } while (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N"));

            if (confirmar.equalsIgnoreCase("S")) {
                // Habremos metido el método borrarUnObjeto en la clase que contenga la colección
                map.borrarUnObjeto(objetoEncontrado);
                eliminar = true;
            }
        }
        return eliminar;
    }

    public boolean eliminarUnObjetoSetControlador(Object objetoAEliminar) {
        Scanner teclado = new Scanner(System.in);
        boolean eliminar = false;
        // Habremos metido el método buscarUnObjeto en la clase que contenga la colección
        Object objetoEncontrado = set.buscarUnObjeto(objetoAEliminar);
        if (objetoEncontrado != null) {
            String confirmar = "";
            do {
                Vista.Vista.mostrarMensaje("El objeto que quieres eliminar es: \n"
                     + objetoEncontrado.toString() + "\n¿Estás seguro? (S/N):");
                confirmar = teclado.nextLine();
                if (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N")) {
                    Vista.Vista.mostrarMensaje("Opción no válida.");
                }
            } while (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N"));

            if (confirmar.equalsIgnoreCase("S")) {
                // Habremos metido el método borrarUnObjeto en la clase que contenga la colección
                set.borrarUnObjeto(objetoEncontrado);
                eliminar = true;
            }
        }
        return eliminar;
    }

    public boolean eliminarUnObjetoListControlador(Object objetoAEliminar) {
        Scanner teclado = new Scanner(System.in);
        boolean eliminar = false;
        // Habremos metido el método buscarUnObjeto en la clase que contenga la colección
        Object objetoEncontrado = list.buscarUnObjeto(objetoAEliminar);
        if (objetoEncontrado != null) {
            String confirmar = "";
            do {
                Vista.Vista.mostrarMensaje("El objeto que quieres eliminar es: \n"
                     + objetoEncontrado.toString() + "\n¿Estás seguro? (S/N):");
                confirmar = teclado.nextLine();
                if (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N")) {
                    Vista.Vista.mostrarMensaje("Opción no válida.");
                }
            } while (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N"));

            if (confirmar.equalsIgnoreCase("S")) {
                // Habremos metido el método borrarUnObjeto en la clase que contenga la colección
                list.borrarUnObjeto(objetoEncontrado);
                eliminar = true;
            }
        }
        return eliminar;
    }
    
    
    // COMPROBAR QUE EXISTE UN OBJETO en la colección
    public boolean comprobarExisteObjetoMap_Objeto(Object objetoABuscar){
        boolean encontado=false;
        if (map.containsValue(objetoABuscar)) {
            encontado=true;
        }
        return encontado;
    }
    public boolean comprobarExisteObjetoMap_Key(Object keyABuscar){
        boolean encontado=false;
        if (map.containsKey(keyABuscar)) {
            encontado=true;
        }
        return encontado;
    }
    public boolean comprobarExisteObjetoSet(Object objetoABuscar){
        boolean encontado=false;
        if (set.contains(objetoABuscar)) {
            encontado=true;
        }
        return encontado;
    }
    public boolean comprobarExisteObjetoList(Object objetoABuscar){
        boolean encontado=false;
        if (list.contains(objetoABuscar)) {
            encontado=true;
        }
        return encontado;
    }
    
    // BUSCAR y SACAR UN OBJETO (null si no existe en la colección)
    // (desde la clase que contiene la colección)
    // Es KEY SENSITIVE porque busca y compara la clave, que es un String,
    // y usa para ello el equals de la clase String que diferencia mayúsc./minúsc.
    public Object buscarUnObjetoMap(Object objetoABuscar) {
        // GET pasando por parámetro el ÍNDICE, que puede ser de cualquier
        // tipo, por eso en la API aparece como Object key!!!
        return map.get(objetoABuscar.getAtributoKey());
    }

    public Object buscarUnObjetoSet(Object objetoABuscar) {
        Object objetoEncontrado = null;
        // Comprobamos si existe, y lo buscamos si procede
        if (set.contains(objetoABuscar)) {
            Iterator it = set.iterator();
            Object objetoLeido = null;
            while (it.hasNext() && objetoLeido != objetoABuscar) {
                objetoLeido = it.next();
                if (objetoLeido == objetoABuscar) {
                    objetoEncontrado = objetoLeido;
                }
            }
        }
        return objetoEncontrado;
    }

    public Object buscarUnObjetoList(Object objetoABuscar) {
        Object objetoEncontrado = null;
        // Comprobamos si existe, y lo buscamos si procede
        if (list.contains(objetoABuscar)) {
            Iterator it = list.iterator();
            Object objetoLeido = null;
            while (it.hasNext() && objetoLeido != objetoABuscar) {
                objetoLeido = it.next();
                if (objetoLeido == objetoABuscar) {
                    objetoEncontrado = objetoLeido;
                }
            }
        }
        return objetoEncontrado;
    }

    // GENERAR COLECCIÓN DESDE CSV (en el controlador)
    public void generarColeccionDesdeCSVMap() {
        try {
            daoCSV.abrirLeer();
            // Tokenizamos en bucle
            String stringLeido = daoCSV.leerUnString();
            while (stringLeido != null) {
                Object objetoGenerado = daoCSV.generarUnObjeto(stringLeido);
                anhadirUnObjetoMap(objetoGenerado.getAtributoKey(), objetoGenerado);
                // map.put(objetoGenerado.getAtributoKey(), objetoGenerado);
                stringLeido = daoCSV.leerUnString();
            }
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarColeccionDesdeCSVSet() {
        try {
            daoCSV.abrirLeer();
            // Tokenizamos en bucle
            String stringLeido = daoCSV.leerUnString();
            while (stringLeido != null) {
                Object objetoGenerado = daoCSV.generarUnObjeto(stringLeido);
                //set.add(objetoGenerado);
                stringLeido = daoCSV.leerUnString();
            }
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarColeccionDesdeCSVList() {
        try {
            daoCSV.abrirLeer();
            // Tokenizamos en bucle
            String stringLeido = daoCSV.leerUnString();
            while (stringLeido != null) {
                // Habrá que concretar el método generarUnObjeto para cada caso
                Object objetoGenerado = daoCSV.generarUnObjeto(stringLeido);
                //list.add(objetoGenerado);
                //list.addLast(objetoGenerado); // Si necesitamos añadir al final o principio de la pila
                //list.addFirst(objetoGenerado);
                stringLeido = daoCSV.leerUnString();
            }
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // GENERAR COLECCIÓN DESDE FICHERO DE OBJETOS (en el controlador)
    public void generarColeccionDesdeFicheroObjetosList() throws ClassNotFoundException {
        // Abrimos para leer fichero de objetos
        try {
            daoObjetos.abrirLeer();
            // Leemos el fichero de objetos, guardamos los atributos de cada objeto en un String tipo xxxx,xxxx,xxxx,
            // y grabamos en el CSV, en bucle hasta fin de fichero
            Object objetoLeido = null;
            objetoLeido = daoObjetos.leerUnObjeto();
            while (objetoLeido != null) {
                //list.add(objetoLeido);
                //list.addLast(objetoLeido); // Si necesitamos añadir al final o principio de la pila
                //list.addFirst(objetoLeido);
                objetoLeido = daoObjetos.leerUnObjeto();
            }
            // Cerramos flujos de lectura del fichero de objetos 
            daoObjetos.cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero de objetos no encontrado. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al copiar del fichero de objetos al CSV. " + ex.getMessage());
            Logger.getLogger(Controlador_ObjetosCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // GENERAR COLECCIÓN DESDE FICHERO DE INTS (BYTES) (en el controlador)
    public void generarColeccionDesdeFicheroIntsSet() {
        try {
            // Abrir fichero
            daoInts.abrirLeer();

            // Leer y cargar en bucle
            try {
                while (true) {
                    int enteroLeido = daoInts.leerUnRegistro();
                    set.add(Integer.valueOf(enteroLeido));
                }
            } catch (EOFException ex) {
                System.out.println("Fin de fichero al cargar colección. " + ex.getMessage());
                //   Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Cerrar fichero
            daoInts.cerrarLeer();

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al cargar colección. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al cargar colección. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void generarColeccionDesdeFicheroIntsList() {
        try {
            // Abrir fichero
            daoInts.abrirLeer();

            // Leer y cargar en bucle
            try {
                while (true) {
                    int enteroLeido = daoInts.leerUnRegistro();
                    list.add(Integer.valueOf(enteroLeido));
                }
            } catch (EOFException ex) {
                System.out.println("Fin de fichero al cargar colección. " + ex.getMessage());
                //   Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Cerrar fichero
            daoInts.cerrarLeer();

        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado al cargar colección. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al cargar colección. " + ex.getMessage());
            Logger.getLogger(DAO_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // GENERAR CSV DESDE LA COLECCIÓN (en controlador) SOBREESCRIBIENDO
    public void generarCSVDesdeColeccionMap() {
        try {
            daoCSV.abrirGrabarSobreescribir();
            // Grabar strings de atributos en bucle
            for (Object object : map.values()) {
                String stringAtributos=daoCSV.generarUnStringDeAtributos(object);
                daoCSV.grabarUnString(stringAtributos);
            }
            daoCSV.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarCSVDesdeColeccionSet() {
        try {
            daoCSV.abrirGrabarSobreescribir();
            // Grabar strings de atributos en bucle
            for (Object object : set) {
                String stringAtributos=daoCSV.generarUnStringDeAtributos(object);
                daoCSV.grabarUnString(stringAtributos);
            }
            daoCSV.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarCSVDesdeColeccionList() {
        try {
            daoCSV.abrirGrabarSobreescribir();
            // Grabar strings de atributos en bucle
            for (Object object : list) {
                String stringAtributos=daoCSV.generarUnStringDeAtributos(object);
                daoCSV.grabarUnString(stringAtributos);
            }
            daoCSV.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // GENERAR FICHERO DE OBJETOS DESDE COLECCIÓN (en controlador)
    public void generarFicheroObjetosDesdeColeccionMap() {
        try {
            daoObjetos.abrirGrabarSobreescribir();
            // Grabar objetos de atributos en bucle
            for (Object object : map.keySet()) {
                daoObjetos.grabarUnObjeto(map.get(object));
            }
            daoObjetos.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generarFicheroObjetosDesdeColeccionList() {
        try {
            daoObjetos.abrirGrabarSobreescribir();
            // Grabar objetos de atributos en bucle
            for (Object object : list) {
                daoObjetos.grabarUnObjeto(object);
            }
            daoObjetos.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // GENERAR FICHERO DE INTS DESDE LA COLECCIÓN (en controlador) SOBREESCRIBIENDO
    public void generarFicheroIntsDesdeColeccionSet() {
        try {
            daoInts.abrirGrabarSobreescribir();
            // Grabar en bucle
            for (Object integerLeido : set) {
                int intLeido=integerLeido.intValue();
                daoInts.grabarUnRegistro(intLeido);
            }
            daoInts.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void generarFicheroIntsDesdeColeccionList() {
        try {
            daoInts.abrirGrabarSobreescribir();
            // Grabar en bucle
            for (Object integerLeido : list) {
                int intLeido=integerLeido.intValue();
                daoInts.grabarUnRegistro(intLeido);
            }
            daoInts.cerrarGrabar();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // AÑADIR un objeto pasado por parámetro PIDIENDO CONFIRMACIÓN, para MAP (en controlador)
    public boolean anhadirUnObjetoControladorMap(Object objetoAAnhadir) {
        Scanner teclado = new Scanner(System.in);
        boolean anhadir = true;
        // Habremos metido el método buscarUnObjeto en la clase que contenga la colección
        Object objetoEncontrado = map.buscarUnObjeto(objetoAAnhadir);
        if (objetoEncontrado != null) {
            String sobreescribir = "";
            do {
                Vista.Vista.mostrarMensaje("El objeto ya existe, ¿sobreescribir? (S/N):");
                sobreescribir = teclado.nextLine();
                if (!sobreescribir.equalsIgnoreCase("S") && !sobreescribir.equalsIgnoreCase("N")) {
                    Vista.Vista.mostrarMensaje("Opción no válida.");
                }
            } while (!sobreescribir.equalsIgnoreCase("S") && !sobreescribir.equalsIgnoreCase("N"));
            if (sobreescribir.equalsIgnoreCase("N")) {
                anhadir = false;
            }
        }
        if (anhadir) {
            map.anhadirUnObjeto(objetoAAnhadir);
        }
        return anhadir;
    }
    
    
    // MOSTRAR COLECCIÓN (está en el paquete de la vista)
}
