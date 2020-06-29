package ejer1.Controlador;

import ejer1.Modelo.*;
import ejer1.Vista.Vista;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    // ATRIBUTOS
    private DAO_CSVs daoCSV;
    private Set<Luchador> luchadores;

    // MÉTODOS  
    // Getters + Setters
    public DAO_CSVs getDaoCSV() {
        return daoCSV;
    }
    
    public void setDaoCSV(DAO_CSVs daoCSV) {
        this.daoCSV = daoCSV;
    }
    
    public Set<Luchador> getLuchadores() {
        return luchadores;
    }
    
    public void setLuchadores(Set<Luchador> luchadores) {
        this.luchadores = luchadores;
    }

    // Constructor
    public Controlador() {
        daoCSV = new DAO_CSVs("Luchadores.csv");
        // No cargamos el fichero en memoria al crear el controlador porque se hará
        // al elegir la opción del menú
        luchadores = new HashSet<>();
    }

    // Cargar colección desde CSV
    public void generarColeccionDesdeCSVSet() {
        try {
            daoCSV.abrirLeer();
            // Tokenizamos en bucle
            String stringLeido = daoCSV.leerUnString();
            while (stringLeido != null) {
                Luchador objetoGenerado = daoCSV.generarUnObjeto(stringLeido);
                luchadores.add(objetoGenerado);
                stringLeido = daoCSV.leerUnString();
            }
            daoCSV.cerrarLeer();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Mostrar luchadores con número de cinturones y cinturón actual
    public void mostrarLuchadoresYCinturones() {
        for (Luchador luchador : luchadores) {
            System.out.println(luchador.toString());
            System.out.println("Tiene " + luchador.getNumeroCinturones() + "cinturones, actualmente es " + luchador.getCinturones().getLast());
            System.out.println("");
        }
    }

    // Mostrar número de luchadores
    public int numeroLuchadores() {
        return luchadores.size();
    }

    // Añadir nuevo luchador, devuelve true si se añadió
    public boolean anhadirNuevoLuchador() {
        Scanner teclado = new Scanner(System.in);
        boolean anhadir = true;
        
        Vista.mostrarMensaje("Nombre: ");
        String nombre = teclado.nextLine();
        boolean existe = luchadores.contains(new Luchador(nombre));
        // No me coge el ignoreCase del equals y el compareTo
        if (existe) {
            String sobreescribir = "";
            do {
                Vista.mostrarMensaje("El luchador ya existe, ¿sobreescribir? (S/N):");
                sobreescribir = teclado.nextLine();
                if (!sobreescribir.equalsIgnoreCase("S") && !sobreescribir.equalsIgnoreCase("N")) {
                    Vista.mostrarMensaje("Opción no válida.");
                }
            } while (!sobreescribir.equalsIgnoreCase("S") && !sobreescribir.equalsIgnoreCase("N"));
            if (sobreescribir.equalsIgnoreCase("N")) {
                anhadir = false;
            }
        }
        
        if (anhadir) {
            Vista.mostrarMensaje("Apellidos: ");
            String apellidos = teclado.nextLine();
            Vista.mostrarMensaje("Edad: ");
            String edad = teclado.nextLine();
            
            LinkedList<String> cinturones = new LinkedList<>();
            cinturones.add("blanco");
            
            Luchador luchadorAAnhadir = new Luchador(nombre, apellidos, edad, cinturones);
            luchadores.add(luchadorAAnhadir);
        }
        return anhadir;
    }

    // Eliminar luchador por nombre
    public boolean eliminarLuchador() {
        Scanner teclado = new Scanner(System.in);
        boolean eliminar = true;
        
        Vista.mostrarMensaje("Nombre: ");
        String nombre = teclado.nextLine();
        Luchador luchadorBuscado = new Luchador(nombre);
        boolean existe = luchadores.contains(luchadorBuscado);
        // No me muesta nada a partir de aquí
        if (existe) {
            String confirmar = "";
            boolean encontrado = false;
            Iterator it = luchadores.iterator();
            // Lo buscamos en la colección para mostrarlo y pedir confirmación
            while (encontrado == false) {
                Luchador luchadorLeido = (Luchador) it.next();
                
                if (luchadorLeido == luchadorBuscado) {
                    encontrado = true;
                    System.out.println("El luchador que deseas eliminar es: \n" + luchadorLeido.toString());
                    do {
                        Vista.mostrarMensaje("Estás seguro de que deseas eliminarlo (S/N):");
                        confirmar = teclado.nextLine();
                        if (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N")) {
                            Vista.mostrarMensaje("Opción no válida.");
                        }
                    } while (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N"));
                    
                    if (confirmar.equalsIgnoreCase("S")) {
                        luchadores.remove(luchadorLeido);
                    }
                }
            }
        } else {
            Vista.mostrarMensaje("El luchador no está registrado.");
        }
        return eliminar;
    }
    
    public void ejecutarMenu() {
        int opcion;
        do {
            Scanner teclado = new Scanner(System.in);
            
            System.out.println("*** M E N Ú ***");
            System.out.println("1. Cargar fichero en memoria.");
            System.out.println("2. Mostrar luchadores desde memoria");
            System.out.println("3. Mostar número de luchadores.");
            System.out.println("4. Añadir luchador.");
            System.out.println("5. Eliminar luchador (por nombre)");
            System.out.println("0. Salir");
            System.out.println("\n¿Qué quieres hacer?");
            opcion = teclado.nextInt();
            
            switch (opcion) {
                case 1:
                    generarColeccionDesdeCSVSet();
                    break;
                case 2:
                    mostrarLuchadoresYCinturones();
                    break;
                case 3:
                    
                    Vista.mostrarMensaje("Hay " + String.valueOf(numeroLuchadores()) + " luchadores en el club.");
                    break;
                case 4:
                    anhadirNuevoLuchador();
                    
                    break;
                case 5:
                    eliminarLuchador();
                    
                    break;
                case 0:
                    System.out.println("¡ Adiós !");
                    break;
                default:
                    System.out.println("Opción no válida, por favor introduce un número entre 0 y 5:");
                    opcion = teclado.nextInt();
            }
            
        } while (opcion != 0);
    }
}
