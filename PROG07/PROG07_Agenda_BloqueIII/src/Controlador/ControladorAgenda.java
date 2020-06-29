package Controlador;

import Modelo.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorAgenda {

    // ATRIBUTOS
    private DAO_CSVs daoCSV;
    private Agenda agenda;

    // MÉTODOS
    // Constructor
    public ControladorAgenda() {
        this.daoCSV = new DAO_CSVs("contactos.csv");
        this.agenda = new Agenda();
        cargarColeccionDesdeCSV();
    }

    // TAMAÑO de la colección
    public int tamanhoColeccion() {
        return agenda.tamanhoColeccion();
    }

    // BUSCAR contacto pasado por parámetro
    public Contacto buscarContacto(Contacto contactoABuscar) {
        return agenda.buscarUnContacto(contactoABuscar);
    }

    public Contacto buscarContactoPorNombre(String nombrePila) {
        return agenda.buscarUnContactoPorNombre(nombrePila);
    }

    // ELIMINAR un contacto pasado por parámetro
    public boolean eliminarUnContacto(Contacto contactoAEliminar) {
        Scanner teclado = new Scanner(System.in);
        boolean eliminar = false;
        Contacto contactoEncontrado = agenda.buscarUnContacto(contactoAEliminar);

        if (contactoEncontrado != null) {
            String confirmar = "";
            do {
                Vista.Vista.mostrarMensaje("El contacto que quieres eliminar es: \n"
                     + contactoEncontrado.toString() + "\n¿Estás seguro? (S/N):");
                confirmar = teclado.nextLine();
                if (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N")) {
                    Vista.Vista.mostrarMensaje("Opción no válida.");
                }
            } while (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N"));

            if (confirmar.equalsIgnoreCase("S")) {
                agenda.borrarUnContacto(contactoEncontrado);
                eliminar = true;
            }
        }
        return eliminar;
    }

    public boolean eliminarUnContactoPorNombre(String nombrePila) {
        Scanner teclado = new Scanner(System.in);
        boolean eliminar = false;
        Contacto contactoEncontrado = agenda.buscarUnContacto(new Contacto(nombrePila));

        if (contactoEncontrado != null) {
            String confirmar = "";
            do {
                Vista.Vista.mostrarMensaje("El contacto que quieres eliminar es: \n"
                     + contactoEncontrado.toString() + "\n¿Estás seguro? (S/N):");
                confirmar = teclado.nextLine();
                if (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N")) {
                    Vista.Vista.mostrarMensaje("Opción no válida.");
                }
            } while (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N"));

            if (confirmar.equalsIgnoreCase("S")) {
                agenda.borrarUnContacto(contactoEncontrado);
                eliminar = true;
            }
        }

        return eliminar;
    }

    // AÑADIR un contacto pasando el contacto por parámetro
    public boolean anhadirUnContacto(Contacto contactoAAnhadir) {
        Scanner teclado = new Scanner(System.in);
        boolean anhadir = true;
        Contacto contactoEncontrado = agenda.buscarUnContacto(contactoAAnhadir);
        if (contactoEncontrado != null) {
            String sobreescribir = "";
            do {
                Vista.Vista.mostrarMensaje("El contacto ya existe, ¿sobreescribir? (S/N):");
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
            agenda.anhadirUnContacto(contactoAAnhadir);
        }
        return anhadir;
    }

    // AÑADIR un contacto pidiendo los datos por pantalla
    public boolean anhadirContactosPidiendoDatos() {
        Scanner teclado = new Scanner(System.in);
        boolean anhadir = true;

        Vista.Vista.mostrarMensaje("Nombre de pila: ");
        String nombrePila = teclado.nextLine();

        if (agenda.getAgenda().containsKey(nombrePila)) {
            String sobreescribir = "";
            do {
                Vista.Vista.mostrarMensaje("El contacto ya existe, ¿sobreescribir? (S/N):");
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
            Vista.Vista.mostrarMensaje("Nombre: ");
            String nombre = teclado.nextLine();
            Vista.Vista.mostrarMensaje("Apellidos: ");
            String apellidos = teclado.nextLine();
            Vista.Vista.mostrarMensaje("Email: ");
            String email = teclado.nextLine();

            List<String> telefonos = new ArrayList<>();
            String anhadirOtroTelefono = "";
            do {
                Vista.Vista.mostrarMensaje("Telefono: ");
                telefonos.add(teclado.nextLine());
                do {
                    Vista.Vista.mostrarMensaje("¿Introducir otro teléfono? (S/N): ");
                    anhadirOtroTelefono = teclado.nextLine();
                    if (!anhadirOtroTelefono.equalsIgnoreCase("S") && !anhadirOtroTelefono.equalsIgnoreCase("N")) {
                        Vista.Vista.mostrarMensaje("Opción no válida.");
                    }
                } while (!anhadirOtroTelefono.equalsIgnoreCase("S") && !anhadirOtroTelefono.equalsIgnoreCase("N"));
            } while (anhadirOtroTelefono.equalsIgnoreCase("S"));
            Contacto contactoGenerado = new Contacto(nombrePila, nombre, apellidos, email, telefonos);
            agenda.anhadirUnContacto(contactoGenerado);
        }

        return anhadir;
    }

    // BUSCAR UN TELÉFONO
    public Contacto buscarUnTelefono(String telefonoABuscar) {
        Contacto contactoEncontrado = null;
        boolean encontrado = false;

        Iterator it = agenda.getAgenda().values().iterator();
        while (it.hasNext() && encontrado == false) {
            Contacto contactoLeido = (Contacto) it.next();
            encontrado = contactoLeido.buscarTelefono(telefonoABuscar);
            if (encontrado) {
                contactoEncontrado = contactoLeido;
            }
        }
        return contactoEncontrado;
    }

    // CARGAR COLECCIÓN desde el CSV
    public void cargarColeccionDesdeCSV() {
        try {

            daoCSV.abrirLeer();

            // Tokenizamos en bucle
            String stringLeido = daoCSV.leerUnString();
            while (stringLeido != null) {
                Contacto contacto = daoCSV.generarUnContactoDesdeCSV(stringLeido);
                this.agenda.getAgenda().put(contacto.getNombrePila(), contacto);
                stringLeido = daoCSV.leerUnString();
            }

            daoCSV.cerrarLeer();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControladorAgenda.class
                 .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ControladorAgenda.class
                 .getName()).log(Level.SEVERE, null, ex);
        }
    }

    // FINALIZAR SESIÓN grabando el estado de la colección en el CSV
    public void finalizarSesionGrabandoCSV() {
        daoCSV.generarNuevoFicheroDesdeColeccion(agenda.getAgenda());
    }

    // MOSTRAR COLECCIÓN por pantalla (conjunto con la Vista)
    public void mostrarColeccionCompleta() {
        Vista.Vista.mostrarColeccionCompleta(agenda.getAgenda());
    }

    public void mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("*** M E N Ú ***");
            System.out.println("1. Añadir contactos");
            System.out.println("2. Eliminar un contacto");
            System.out.println("3. Buscar un contacto");
            System.out.println("4. Buscar un teléfono");
            System.out.println("5. Mostrar todos los contactos");
            System.out.println("0. Salir");
            System.out.println("\n¿Qué quieres hacer?");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    anhadirContactosPidiendoDatos();
                    break;
                case 2:
                    Vista.Vista.mostrarMensaje("Nombre de pila del contacto a eliminar: ");
                    Contacto contactoAEliminar = new Contacto(teclado.nextLine());
                    eliminarUnContacto(contactoAEliminar);
                    break;
                case 3:
                    Vista.Vista.mostrarMensaje("Nombre de pila del contacto a buscar: ");
                    Contacto contactoABuscar = new Contacto(teclado.nextLine());
                    Contacto contactoEncontrado = buscarContacto(contactoABuscar);
                    if (contactoEncontrado != null) {
                        Vista.Vista.mostrarObjeto(contactoEncontrado);
                    } else {
                        Vista.Vista.mostrarMensaje("El contacto no existe.");
                    }

                    break;
                case 4:
                    Vista.Vista.mostrarMensaje("Teléfono a buscar: ");
                    String telefonoABuscar=teclado.nextLine();
                    Contacto contactoBuscado=buscarUnTelefono(telefonoABuscar);
                    if (contactoBuscado!=null) {
                        Vista.Vista.mostrarMensaje("El teléfono pertenece a: \n");
                        Vista.Vista.mostrarObjeto(contactoBuscado);
                    } else {
                         Vista.Vista.mostrarMensaje("El teléfono no se encuentra en la agenda.");
                    }
                    break;
                case 5:
                    mostrarColeccionCompleta();
                    break;
                case 0:
                    System.out.println("¡ Adiós !");
                    finalizarSesionGrabandoCSV();
                    break;
                default:
                    System.out.println("Opción no válida, por favor introduce un número entre 0 y 4:");
                    opcion = teclado.nextInt();
            }

        } while (opcion != 0);

    }

}
