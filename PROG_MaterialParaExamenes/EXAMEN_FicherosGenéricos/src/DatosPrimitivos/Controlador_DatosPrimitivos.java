package DatosPrimitivos;

import DatosPrimitivos.DAO_DatosPrimitivos;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_DatosPrimitivos {

    // ATRIBUTOS
    DAO_DatosPrimitivos daoLectura;
    DAO_DatosPrimitivos daoGrabacion;

    // MÉTODOS
    // Getters + Setters
    public DAO_DatosPrimitivos getDaoLectura() {
        return daoLectura;
    }

    public void setDaoLectura(DAO_DatosPrimitivos daoLectura) {
        this.daoLectura = daoLectura;
    }

    public DAO_DatosPrimitivos getDaoGrabacion() {
        return daoGrabacion;
    }

    public void setDaoGrabacion(DAO_DatosPrimitivos daoGrabacion) {
        this.daoGrabacion = daoGrabacion;
    }

    // Constructor:
    public Controlador_DatosPrimitivos(String nombreFicheroLectura, String nombreFicheroGrabacion) {
        daoLectura = new DAO_DatosPrimitivos(nombreFicheroLectura);
        daoGrabacion = new DAO_DatosPrimitivos(nombreFicheroGrabacion);
    }

    // Para GRABAR UN FICHERO de INT, habría que adaptarlo para otros tipos de datos primitivos
    // Este método AÑADIRÍA los datos del fichero de lectura al de salida, en caso de que este
    // último ya estuviese generado.
    public void copiarFicheroAnhadir() {
        int enteroLeido;
        // Abrir ficheros
        try {
            daoLectura.abrirLeer();
            daoGrabacion.abrirGrabarAnhadir();

            // Copiar en bucle
            try {
                while (true) {
                    enteroLeido = daoLectura.leerUnRegistro();
                    daoGrabacion.grabarUnRegistro(enteroLeido);
                }
            } catch (EOFException ex) {
                System.out.println("Fin de grabado del fichero. " + ex.getMessage());
                //   Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar ficheros
            daoGrabacion.cerrarGrabar();
            daoLectura.cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontado. " + ex.getMessage());
            Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Para GRABAR UN FICHERO de INT, habría que adaptarlo para otros tipos de datos primitivos
    // Este método SOBREESCRIBIRÍA los datos del fichero de salida si existiese con los nuevos
    // datos del fichero de lectura 
    public void copiarFicheroSobreescribir() {
        int enteroLeido;
        // Abrir ficheros
        try {
            daoLectura.abrirLeer();
            daoGrabacion.abrirGrabarSobreescribir();

            // Copiar en bucle
            try {
                while (true) {
                    enteroLeido = daoLectura.leerUnRegistro();
                    daoGrabacion.grabarUnRegistro(enteroLeido);
                }
            } catch (EOFException ex) {
                System.out.println("Fin de grabado del fichero. " + ex.getMessage());
                //   Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Cerrar ficheros
            daoGrabacion.cerrarGrabar();
            daoLectura.cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontado. " + ex.getMessage());
            Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Copiar de manera selectiva según un criterio dado, por ejemplo, generar un nuevo fichero
    // grabando solamente el número que pasamos por parámetro, tantas veces como aparezca
    public void copiarSelectivamente(int numACopiar) {
        // Abrir flujos
        try {
            daoLectura.abrirLeer();
            daoGrabacion.abrirGrabarAnhadir();

            // Leemos y comparamos en bucle, y grabamos si es necesario
            int registroLeido = 0;
            try {
                while (true) {
                    registroLeido = daoLectura.leerUnRegistro();
                    if (registroLeido == numACopiar) {
                        daoGrabacion.grabarUnRegistro(registroLeido);
                    }
                }
            } catch (EOFException ex) {
                System.out.println("Fin de fichero al copiar selectivamente. " + ex.getMessage());
                Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            } 

            // Cerramos flujos
            daoGrabacion.cerrarGrabar();
            daoLectura.cerrarLeer();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado. " + ex.getMessage());
            Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al copiar selectivamente. " + ex.getMessage());
            Logger.getLogger(Controlador_DatosPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    // Para mostrar el fichero de entrada y el de salida para comprobar
    public void mostrarAmbosFicheros() {
        System.out.println("*** MOSTRANDO FICHERO DE ENTRADA ***");
        daoLectura.mostrarFichero();
        System.out.println("");
        System.out.println("*** MOSTRANDO FICHERO DE SALIDA ***");
        daoGrabacion.mostrarFichero();
    }
}
