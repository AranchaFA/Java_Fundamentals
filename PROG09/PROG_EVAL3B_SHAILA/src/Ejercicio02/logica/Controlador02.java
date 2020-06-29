package Ejercicio02.logica;

import Ejercicio02.modelo.AccesoBBDD;
import Ejercicio02.modelo.Programas;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import paqueteLeerDatos.Leer;

/**
 *
 * @author Shaila
 */
public class Controlador02 {

    private int res;
    private Programas programas;
    private AccesoBBDD a;
    private ArrayList<Programas> coleccionProgramas = new ArrayList<Programas>();

    public Controlador02() {
        this.programas = new Programas();
        this.a = new AccesoBBDD();
    }

    public void menu() {
        int opcion;
        do {

            System.out.println("\nMENU \n");
            System.out.println("1. Realizar consulta de programas en BBDD.");
            System.out.println("2. Meter en colección todos los programas.");
            System.out.println("3. Salir.");
            System.out.println("\n Introduce una opción (1 - 3)");

            opcion = Leer.datoInt();

            switch (opcion) {
                case 3:
                    break;

                case 1:
                    consultaProgramas();
                    break;
                case 2:
                    cargarProgramas();
                    verProgramas();
                    break;

                default:
                    System.out.println("Introduce una opción CORRECTA (1-3)");
            }

        } while (opcion != 3);
    }

    public void conexion() {

        System.out.println("Creando conexión...");
        a.conexionBBDD("localhost", "XE", "D3", "D3");

    }

    public void verProgramas() {
        Iterator<Programas> nombreIterator = coleccionProgramas.iterator();
        while (nombreIterator.hasNext()) {
            Programas elemento = nombreIterator.next();
            System.out.print("\nCódigo del programa: " + elemento.getCod_prod() + ", nombre: " + elemento.getNombre()
                    + ", versión: " + elemento.getVersion());
        }
    }

    public void consultaProgramas() {
        PreparedStatement pstmt = null;
        ResultSet resultado = null;

        conexion();
        System.out.println("Introduzca el COD_PROD del programa a buscar en la BBDD.");
        String cod_prod = Leer.leerDato();

        String cadenaSQL = "SELECT * FROM PROGRAMAS WHERE COD_PROD = ?";
        pstmt = a.crearStatementSinSaberCual(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        try {
            pstmt.setString(1, cod_prod.toUpperCase());

            resultado = a.ejecutarPreparedStatementSELECT(pstmt);

            while (resultado.next()) {

                System.out.println("El programa de COD_PROD: " + cod_prod + " se llama " + resultado.getString(2)
                        + " y su versión es " + resultado.getString(3));
                programas = new Programas(resultado.getString(1), resultado.getString(2), resultado.getString(3));
                System.out.println(programas.toString());
            }
        } catch (SQLException ex) {
            System.out.println("Error en el juego de resultados.");
        }
    }

    private void cargarProgramas() {
        PreparedStatement pstmt = null;
        ResultSet resultado = null;
        try {
            conexion();
            System.out.println("Introduzca el NOMBRE del programa a buscar en la BBDD.");
            String nombre = Leer.leerDato();

            String cadenaSQL = "SELECT * FROM PROGRAMAS WHERE UPPER(NOMBRE) = UPPER(?)";
            pstmt = a.crearStatementSinSaberCual(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstmt.setString(1, nombre.toUpperCase());

            resultado = a.ejecutarPreparedStatementSELECT(pstmt);
            while (resultado.next()) {
                Programas p = new Programas(resultado.getString(1), resultado.getString(2), resultado.getString(3));

                System.out.println(p.toString());
                coleccionProgramas.add(p);
                if (coleccionProgramas.contains(p)) {
                    System.out.println("El programa se ha añadido correctamente a la colección.");
                    System.out.println("Hay " + coleccionProgramas.size() + " progrmas.");
                }

            }
            System.out.println("Cerrando conexión...");
            a.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
