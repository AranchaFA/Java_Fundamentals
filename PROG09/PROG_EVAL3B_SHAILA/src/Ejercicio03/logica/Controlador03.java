package Ejercicio03.logica;

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
public class Controlador03 {

    private String cod_prod;
    private String cif;
    private Programas programas;
    private AccesoBBDD a;
    private ArrayList<Programas> coleccionProgramas = new ArrayList<Programas>();

    public Controlador03() {
        this.programas = new Programas();
        this.a = new AccesoBBDD();
    }

    public void menu() {
        int opcion;
        do {

            System.out.println("\nMENU \n");
            System.out.println("1. Realizar consulta de programas en BBDD.");
            System.out.println("2. Meter en colección todos los programas.");
            System.out.println("3. Realizar venta de programa.");
            System.out.println("4. Salir.");
            System.out.println("\n Introduce una opción (1 - 4)");

            opcion = Leer.datoInt();

            switch (opcion) {
                case 4:
                    break;

                case 1:
                    consultaProgramas();
                    break;
                case 2:
                    cargarProgramas();
                    verProgramas();
                    break;
                case 3:
                    comprobarVentas();
                    break;
                default:
                    System.out.println("Introduce una opción CORRECTA (1-4)");
            }

        } while (opcion != 4);
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

    public void comprobarVentas() {
        PreparedStatement pstmtVentas;
        ResultSet resultadoVentas;
        try {

            conexion();
            System.out.println("Introduzca el CIF de la empresa a buscar en la BBDD.");
            String cif = Leer.leerDato();
            System.out.println("Introduzca el COD_PROD del programa a buscar en la BBDD.");
            String cod_prod = Leer.leerDato();

            String cadenaSQL = "SELECT * FROM VENTA WHERE UPPER(CIF) = UPPER(?) and UPPER(COD_PROD) = UPPER(?)";
            pstmtVentas = a.crearStatementSinSaberCual(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pstmtVentas.setString(1, cif);
            pstmtVentas.setString(2, cod_prod);

            resultadoVentas = a.ejecutarPreparedStatementSELECT(pstmtVentas);

            if (resultadoVentas.first()) {
                int resultadoUpdate;
                System.out.println("Introduce cantidad de programas vendidos: ");
                int cantidadUpdate = Leer.datoInt();
                int aux=resultadoVentas.getInt(3)+cantidadUpdate;
                
                String UPDATE ="UPDATE VENTA SET CANTIDAD = ? WHERE UPPER(CIF) = UPPER(?) and UPPER(COD_PROD) = UPPER(?)"; 
                PreparedStatement pstmtUPDATE  = a.crearStatementSinSaberCual(UPDATE, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                
               //ojo 
               pstmtUPDATE.setInt(1,aux);
               pstmtUPDATE.setString(2,cif);
               pstmtUPDATE.setString(3,cod_prod);
               
                resultadoUpdate = a.ejecutarPreparedStatementNOSELECT(pstmtUPDATE);
                System.out.println("Numero de filas afectadas " + resultadoUpdate);
             /*System.out.println("El programa de COD_PROD: " + resultadoVentas.getString(2) + " se ha sido registrado por " + resultadoVentas.getString(1)
                        + " y ha sido vendido " + resultadoVentas.getInt(3) + " veces.");*/
                System.out.println("Cerrando conexión...");
                a.cerrarPreparedStatement(pstmtUPDATE);
                a.cerrarConexion();
                

            } else {
                int resultadoInsert;
                System.out.println("Introduce cantidad de programas vendidos: ");
                int cantidadInsert = Leer.datoInt();

                System.out.println("Realizando insercción...");
                String inserccion = "INSERT INTO VENTA (CIF,COD_PROD,CANTIDAD) values (UPPER(?),UPPER(?),?)";
                PreparedStatement pstmtInsert = a.crearStatementSinSaberCual(inserccion, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                pstmtInsert.setString(1, cif);
                pstmtInsert.setString(2, cod_prod);
                pstmtInsert.setInt(3, cantidadInsert);

                resultadoInsert = a.ejecutarPreparedStatementNOSELECT(pstmtInsert);
                System.out.println("Numero de filas afectadas " + resultadoInsert);
                System.out.println("Cerrando conexión...");
                a.cerrarPreparedStatement(pstmtInsert);
                a.cerrarConexion();

            }

        } catch (SQLException ex) {
            Logger.getLogger(Controlador03.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void consultaProgramas() {
        PreparedStatement pstmt = null;
        ResultSet resultado = null;

        conexion();
        System.out.println("Introduzca el COD_PROD del programa a buscar en la BBDD.");
        String cod_prod = Leer.leerDato();

        String cadenaSQL = "SELECT * FROM PROGRAMAS WHERE UPPER(COD_PROD)  = UPPER(?)";
        pstmt = a.crearStatementSinSaberCual(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        try {
            pstmt.setString(1, cod_prod);

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

            pstmt.setString(1, nombre);

            resultado = a.ejecutarPreparedStatementSELECT(pstmt);
            while (resultado.next()) {
                Programas p = new Programas(resultado.getString(1), resultado.getString(2), resultado.getString(3));

                System.out.println(p.toString());
                coleccionProgramas.add(p);
                if (coleccionProgramas.contains(p)) {
                    System.out.println("El programa se ha añadido correctamente a la colección.");
                    System.out.println("Hay " + coleccionProgramas.size() + " programas.");
                }

            }
            System.out.println("Cerrando conexión...");
            a.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
