package Controlador;

import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaquinaControladora {

    // ATRIBUTOS
    // Colección con los productos a vender
    private HashMap<String, Producto> productos;
    // DAOS para controlar las consultas a la BBDD y el tratamiento de los resultados
    private DAO_BBDD daoBBDD;
    private DAO_VOs daoVO;

    // MÉTODOS
    // Getters + Setters
    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Producto> productos) {
        this.productos = productos;
    }

    public DAO_BBDD getDaoBBDD() {
        return daoBBDD;
    }

    public void setDaoBBDD(DAO_BBDD daoBBDD) {
        this.daoBBDD = daoBBDD;
    }

    public DAO_VOs getDaoVO() {
        return daoVO;
    }

    public void setDaoVO(DAO_VOs daoVO) {
        this.daoVO = daoVO;
    }

    // toString (por si viene bien en alguna comprobación)
    @Override
    public String toString() {
        return "MaquinaControladora{" + "productos=" + productos + ", daoBBDD=" + daoBBDD + ", daoVO=" + daoVO + '}';
    }

    // Constructor
    public MaquinaControladora(DatosConexionBBDD datosConexionBBDD) {
        this.daoBBDD = new DAO_BBDD(datosConexionBBDD);
        this.daoVO = new DAO_VOs();
        this.productos = new HashMap<>();
        // Cargamos toda la información de la BBDD al arrancar la aplicación
        generarColeccionProductos();
    }

    // Cargar colección de Productos desde la BBDD
    public void generarColeccionProductos() {
        // 1) Sacamos ResultSets de cada tabla con las consultas del Map de sentencias SQL (DAO_BBDD)
        // 2) Generamos un map de Productos con cada ResultSet (DAO_VOs) y los añadimos al Map de la máquina

        // Vamos a usar:
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;

        // Las PreparedStmt para sacar todos los datos de las tablas son las "1X"       
        // Vamos asignando la psmts para cada tabla, generando la coleccion a partir de cada ResultSet
        // y cargando cada colección generada a la colección de productos
        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("11"); // LIBROS
        resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        this.productos.putAll(daoVO.coleccionDesdeResultSetLibros(resultSet));

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("12"); // CD
        resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        this.productos.putAll(daoVO.coleccionDesdeResultSetCDs(resultSet));

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("13"); // DVD
        resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        this.productos.putAll(daoVO.coleccionDesdeResultSetDVDs(resultSet));

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("14"); // PERIODICOS
        resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        this.productos.putAll(daoVO.coleccionDesdeResultSetPeriodicos(resultSet));
    }

    // Mostrar cuántos productos hay de cada tipo
    public void cantidadDeCadaTipoDeProducto() {
        // 1) Sacamos ResultSets con el recuento de registros de cada tabla con las consultas del Map de sentencias SQL (DAO_BBDD)
        // 2) Mostramos el valor de cada ResultSet (será una columna única con un int).

        // Vamos a usar:
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;
        int cantidad = 0;

        // Las PreparedStmt para contar los registros de las tablas son las "2X"
        // Vamos asignando la psmts para cada tabla, y mostrando tamaño a partir de cada ResultSet
        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("21"); // LIBROS
        resultSet = this.daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        cantidad = daoVO.extraerValorNumericoConsulta(resultSet);
        System.out.println("Cantidad de LIBROS: " + cantidad);

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("22"); // CD
        resultSet = this.daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        cantidad = daoVO.extraerValorNumericoConsulta(resultSet);
        System.out.println("Cantidad de CDs: " + cantidad);

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("23"); // DVD
        resultSet = this.daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        cantidad = daoVO.extraerValorNumericoConsulta(resultSet);
        System.out.println("Cantidad de DVDs: " + cantidad);

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("24"); // PERIODICOS
        resultSet = this.daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        cantidad = daoVO.extraerValorNumericoConsulta(resultSet);
        System.out.println("Cantidad de PERIÓDICOS: " + cantidad);
    }

    // Mostrar todos los registros de cada tabla
    public void mostrarTodosLosLibros() {
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;
        HashMap<String, Producto> map = new HashMap<>();

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("11"); // LIBROS
        resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        map = daoVO.coleccionDesdeResultSetLibros(resultSet);

        Vista.Vista.mostrarColeccion(map);
    }

    public void mostrarTodosLosCDs() {
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;
        HashMap<String, Producto> map = new HashMap<>();

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("12"); // CD
        resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        map = daoVO.coleccionDesdeResultSetCDs(resultSet);

        Vista.Vista.mostrarColeccion(map);
    }

    public void mostrarTodosLosDVDs() {
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;
        HashMap<String, Producto> map = new HashMap<>();

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("13"); // DVD
        resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        map = daoVO.coleccionDesdeResultSetDVDs(resultSet);

        Vista.Vista.mostrarColeccion(map);
    }

    public void mostrarTodosLosPeriodicos() {
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;
        HashMap<String, Producto> map = new HashMap<>();

        pstmtSQL = this.daoBBDD.obtenerPreparedStatement("14"); // PERIÓDICOS
        resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pstmtSQL);
        map = daoVO.coleccionDesdeResultSetPeriodicos(resultSet);

        Vista.Vista.mostrarColeccion(map);
    }

    // Buscar un registro en la BBDD
    public Producto buscarUnRegistro(String codigoProducto, String nombreTabla) {
        Producto productoBuscado = null;
        PreparedStatement pStmt = null;
        ResultSet resultSet = null;

        try {
            // Las PStmt para obtener un registro concreto son las "3X"
            if (nombreTabla.equalsIgnoreCase("LIBROS")) {
                pStmt = daoBBDD.obtenerPreparedStatement("31");
                pStmt.setString(1, codigoProducto);
                resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pStmt);
                productoBuscado = daoVO.generarUnLibro(resultSet);
            } else if (nombreTabla.equalsIgnoreCase("CD")) {
                pStmt = daoBBDD.obtenerPreparedStatement("32");
                pStmt.setString(1, codigoProducto);
                resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pStmt);
                productoBuscado = daoVO.generarUnCD(resultSet);
            } else if (nombreTabla.equalsIgnoreCase("DVD")) {
                pStmt = daoBBDD.obtenerPreparedStatement("33");
                pStmt.setString(1, codigoProducto);
                resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pStmt);
                productoBuscado = daoVO.generarUnDVD(resultSet);
            } else if (nombreTabla.equalsIgnoreCase("PERIÓDICOS")) {
                pStmt = daoBBDD.obtenerPreparedStatement("34");
                pStmt.setString(1, codigoProducto);
                resultSet = daoBBDD.ejecutarPreparedStatementSELECT(pStmt);
                productoBuscado = daoVO.generarUnPeriodico(resultSet);
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar un Producto. " + ex.getMessage());
            Logger.getLogger(MaquinaControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productoBuscado;
    }

    // Borrar un registro de las tablas
    public int borrarUnLibroBBDD(String codigo) {
        PreparedStatement pstmt = null;
        int filasEliminadas = 0;

        try {
            // Para borrar un libro el PStmt es el "41"
            pstmt = daoBBDD.obtenerPreparedStatement("41");
            // Hay que "cargar" la PStmt con el codigo elegido
            pstmt.setString(1, codigo.toUpperCase());
            // Es una PStmt NO SELECT
            filasEliminadas = daoBBDD.ejecutarPreparedStatementNOSELECT(pstmt);
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasEliminadas;
    }

    public int borrarUnCDBBDD(String codigo) {
        PreparedStatement pstmt = null;
        int filasEliminadas = 0;

        try {
            // Para borrar un CD el PStmt es el "42"
            pstmt = daoBBDD.obtenerPreparedStatement("42");
            // Hay que "cargar" la PStmt con el codigo elegido
            pstmt.setString(1, codigo.toUpperCase());
            // Es una PStmt NO SELECT
            filasEliminadas = daoBBDD.ejecutarPreparedStatementNOSELECT(pstmt);
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasEliminadas;
    }

    public int borrarUnDVDBBDD(String codigo) {
        PreparedStatement pstmt = null;
        int filasEliminadas = 0;

        try {
            // Para borrar un DVD el PStmt es el "43"
            pstmt = daoBBDD.obtenerPreparedStatement("43");
            // Hay que "cargar" la PStmt con el codigo elegido
            pstmt.setString(1, codigo.toUpperCase());
            // Es una PStmt NO SELECT
            filasEliminadas = daoBBDD.ejecutarPreparedStatementNOSELECT(pstmt);
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasEliminadas;
    }

    public int borrarUnPeriodicoBBDD(String codigo) {
        PreparedStatement pstmt = null;
        int filasEliminadas = 0;

        try {
            // Para borrar un periódico el PStmt es el "44"
            pstmt = daoBBDD.obtenerPreparedStatement("44");
            // Hay que "cargar" la PStmt con el codigo elegido
            pstmt.setString(1, codigo.toUpperCase());
            // Es una PStmt NO SELECT
            filasEliminadas = daoBBDD.ejecutarPreparedStatementNOSELECT(pstmt);
        } catch (SQLException ex) {
            Logger.getLogger(MaquinaControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasEliminadas;
    }

    // Borrar un Producto de la colección general (es común a todos los tipos de Productos)
    public Producto borrarUnProductoMap(String codigo) {
        Producto productoEliminado = null;

        productoEliminado = productos.remove(codigo.toUpperCase());

        return productoEliminado;
    }

    // Menú
    public void menu() {
        Scanner teclado = new Scanner(System.in);
        int opcionMenu;
        String codigoProductoElegido = null;
        Producto objetoBorradoMap = null;
        int objetoBorradoBBDD = 0;

        do {
            System.out.println("¿Qué productos te interesan?");
            System.out.println("1- Libros.");
            System.out.println("2- CDs.");
            System.out.println("3- DVDs.");
            System.out.println("4- Periódicos.");
            System.out.println("5- Cantidad de cada tipo.");
            System.out.println("0- Ninguno (abandonar aplicación).");
            System.out.println("Introduce tu opción: ");
            opcionMenu = teclado.nextInt();
            teclado.nextLine();

            switch (opcionMenu) {
                case 1:
                    codigoProductoElegido = null;
                    objetoBorradoMap = null;
                    objetoBorradoBBDD = 0;
                    mostrarTodosLosLibros();
                    System.out.println("Introduce el código deseado: ");
                    codigoProductoElegido = teclado.nextLine();
                    // Borramos de la BBDD y de la colección el objeto con el código elegido
                    objetoBorradoBBDD = borrarUnLibroBBDD(codigoProductoElegido);
                    objetoBorradoMap = borrarUnProductoMap(codigoProductoElegido);
                    if (objetoBorradoMap != null || objetoBorradoBBDD > 0) {
                        System.out.println("OBJETO VENDIDO.");
                        System.out.println("Has comprado : " + objetoBorradoMap.toString());
                    } else {
                        System.out.println("El objeto no se encontraba entre los ofertados.");
                    }
                    break;
                case 2:
                    codigoProductoElegido = null;
                    objetoBorradoMap = null;
                    objetoBorradoBBDD = 0;
                    mostrarTodosLosCDs();
                    System.out.println("Introduce el código deseado: ");
                    codigoProductoElegido = teclado.nextLine();
                    // Borramos de la BBDD y de la colección el objeto con el código elegido
                    objetoBorradoBBDD = borrarUnCDBBDD(codigoProductoElegido);
                    objetoBorradoMap = borrarUnProductoMap(codigoProductoElegido);
                    if (objetoBorradoMap != null || objetoBorradoBBDD > 0) {
                        System.out.println("OBJETO VENDIDO.");
                        System.out.println("Has comprado : " + objetoBorradoMap.toString());
                    } else {
                        System.out.println("El objeto no se encontraba entre los ofertados.");
                    }
                    break;
                case 3:
                    codigoProductoElegido = null;
                    objetoBorradoMap = null;
                    objetoBorradoBBDD = 0;
                    mostrarTodosLosDVDs();
                    System.out.println("Introduce el código deseado: ");
                    codigoProductoElegido = teclado.nextLine();
                    // Borramos de la BBDD y de la colección el objeto con el código elegido
                    objetoBorradoBBDD = borrarUnDVDBBDD(codigoProductoElegido);
                    objetoBorradoMap = borrarUnProductoMap(codigoProductoElegido);
                    if (objetoBorradoMap != null || objetoBorradoBBDD > 0) {
                        System.out.println("OBJETO VENDIDO.");
                        System.out.println("Has comprado : " + objetoBorradoMap.toString());
                    } else {
                        System.out.println("El objeto no se encontraba entre los ofertados.");
                    }
                    break;
                case 4:
                    codigoProductoElegido = null;
                    objetoBorradoMap = null;
                    objetoBorradoBBDD = 0;
                    mostrarTodosLosPeriodicos();
                    System.out.println("Introduce el código deseado: ");
                    codigoProductoElegido = teclado.nextLine();
                    // Borramos de la BBDD y de la colección el objeto con el código elegido
                    objetoBorradoBBDD = borrarUnPeriodicoBBDD(codigoProductoElegido);
                    objetoBorradoMap = borrarUnProductoMap(codigoProductoElegido);
                    if (objetoBorradoMap != null || objetoBorradoBBDD > 0) {
                        System.out.println("OBJETO VENDIDO.");
                        System.out.println("Has comprado : " + objetoBorradoMap.toString());
                    } else {
                        System.out.println("El objeto no se encontraba entre los ofertados.");
                    }
                    break;
                case 5:
                    cantidadDeCadaTipoDeProducto();
                    break;
                case 0:
                    // Cerramos conexión
                    daoBBDD.cerrarConexion();
                    System.out.println("¡Adiós pues!");
                    break;
                default:
                    System.out.println("La opción introducida no es válida.");
            }
        } while (opcionMenu != 0);
    }
}
