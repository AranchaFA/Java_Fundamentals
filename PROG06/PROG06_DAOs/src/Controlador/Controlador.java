package Controlador;

import Modelo.Persona;
import java.io.EOFException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    private DAOEntrada daoEntrada;

    private DAOSalida daoSalidaMayores;

    private DAOSalida daoSalidaMenores;

    private DAOSalida daoSalidaTodos;

    public DAOEntrada getDaoEntrada() {
        return daoEntrada;
    }

    // Voy a asignarlo todo con setters de entrada para no liar, ya veré si habría
    // que iniciarlo en el constructor y con qué parámetros
    public void setDaoEntrada(DAOEntrada daoEntrada) {
        this.daoEntrada = daoEntrada;
    }

    public DAOSalida getDaoSalidaMayores() {
        return daoSalidaMayores;
    }

    public void setDaoSalidaMayores(DAOSalida daoSalidaMayores) {
        this.daoSalidaMayores = daoSalidaMayores;
    }

    public DAOSalida getDaoSalidaMenores() {
        return daoSalidaMenores;
    }

    public void setDaoSalidaMenores(DAOSalida daoSalidaMenores) {
        this.daoSalidaMenores = daoSalidaMenores;
    }

    public DAOSalida getDaoSalidaTodos() {
        return daoSalidaTodos;
    }

    public void setDaoSalidaTodos(DAOSalida daoSalidaTodos) {
        this.daoSalidaTodos = daoSalidaTodos;
    }

    public Controlador(String mayores, String menores, String todos) {
        daoEntrada = new DAOEntrada(todos);
        daoSalidaMayores = new DAOSalida(mayores);
        daoSalidaMenores = new DAOSalida(menores);
        daoSalidaTodos = new DAOSalida(todos);
    }

    // Vamos leyendo el fichero y grabando de manera selectiva en mayores/menores
    // El método grabar del DAOSalida se encarga de grabar con o sin cabecera cuando proceda
    public void copiarFicheroSelectivamente() throws IOException, ClassNotFoundException {
        // Abrimos el fichero de entrada
        // Los ficheros de salida se abren y cierran en cada grabación individual de un objeto
        // en el método grabar del DAOSalida, así que no se abrirán aquí
        daoEntrada.abrirFicheroEntrada();
        // daoSalidaMayores.abrirFicheroSinCabecera(); De prueba, pero fallaban
        // daoSalidaMenores.abrirFicheroSinCabecera();
        
        // GRABAMOS EN BUCLE HASTA FIN DE FICHERO
        try {
            Persona personaLeida = (Persona) daoEntrada.leerUnObjeto();
            while (personaLeida!=null) {               
                if (personaLeida.getEdad() >= 18) {
                    System.out.println("Grabando en el fichero de mayores de edad: "
                         + personaLeida.toString());
                    daoSalidaMayores.grabarUnObjeto(personaLeida);
                } else {
                    System.out.println("Grabando en el fichero de menores de edad: "
                         + personaLeida.toString());
                    daoSalidaMenores.grabarUnObjeto(personaLeida);
                }
                personaLeida = (Persona) daoEntrada.leerUnObjeto();
            }
        } catch (EOFException ex) {
            System.out.println("Fin de fichero. " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("----Error al grabar en fichero. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cerramos fichero de entrada, los de salida se habrán cerrado en el método grabar
        daoEntrada.cerrarFicheroEntrada();
        // daoSalidaMayores.cerrarFicheroSinCabecera();
        // daoSalidaMenores.cerrarFicheroSinCabecera();
    }

    // Vamos a leer los dos ficheros para comprobar
    public void mostrarFicherosPorPantalla() {
        // Creamos dos objetos DAOEntrada para poder leer los ficheros
        DAOEntrada entradaMayores = new DAOEntrada("mayores.dat");
        DAOEntrada entradaMenores = new DAOEntrada("menores.dat");
        
        System.out.println("Leyendo el fichero mayores.dat");      
        try {
            // Abrimos fichero
            entradaMayores.abrirFicheroEntrada();
            // Leemos y mostramos hasta fin de fichero
            Persona auxWhile= (Persona) entradaMayores.leerUnObjeto();
            while (auxWhile != null) {
                System.out.println("Mayor: " + auxWhile.toString());
                auxWhile= (Persona) entradaMayores.leerUnObjeto();
            }
        } catch (EOFException ex) {
            System.out.println("Fin de lectura al mostrar el fichero de mayores. " + ex.getMessage());
            // Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al mostrar el fichero de mayores por pantalla. " + ex.getMessage());
           // Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada al mostrar el fichero de mayores por pantalla. " + ex.getMessage());
          //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Cerramos fichero
        System.out.println("Cerrando fichero mayores.dat");
        try {
            entradaMayores.cerrarFicheroEntrada();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero mayores.dat");
           // Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("Leyendo fichero menores.dat");
        try {
            // Abrimos fichero
            entradaMenores.abrirFicheroEntrada();
            // Leemos y mostramos hasta fin de fichero
            Persona auxWhile = (Persona) entradaMenores.leerUnObjeto();
            while (auxWhile!= null) {
                System.out.println("Menor: " + auxWhile.toString());
                auxWhile = (Persona) entradaMenores.leerUnObjeto();
            }
        } catch (EOFException ex) {
            System.out.println("Fin de lectura al mostrar el fichero de menores. " + ex.getMessage());
          //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error al mostrar el fichero de menores por pantalla. " + ex.getMessage());
         //   Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada al mostrar el fichero de menores por pantalla. " + ex.getMessage());
          //  Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Cerramos fichero
        System.out.println("Cerrando fichero menores.dat");
        try {
            entradaMenores.cerrarFicheroEntrada();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero menores.dat");
           // Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
