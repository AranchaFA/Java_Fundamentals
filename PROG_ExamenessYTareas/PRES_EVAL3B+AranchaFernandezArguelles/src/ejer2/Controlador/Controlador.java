package ejer2.Controlador;

import ejer2.Modelo.*;
import ejer2.Vista.Vista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    // ATRIBUTOS
    private DAO_BBDD daoBBDD;
    private DAO_VOs daoVO;
    private HashMap<String, VOPrograma> mapProgramas;

    // MÉTODOS
    // Getter + Setter
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

    public HashMap<String, VOPrograma> getColeccion() {
        return mapProgramas;
    }

    public void setMapProgramas(HashMap<String, VOPrograma> mapProgramas) {
        this.mapProgramas = mapProgramas;
    }

    // toString
    @Override
    public String toString() {
        return "Controlador_BBDD{" + "daoBBDD=" + daoBBDD + ", daoVO=" + daoVO + ", programas=" + mapProgramas + '}';
    }

    // Constructor
    public Controlador() {
        this.daoBBDD = new DAO_BBDD();
        this.daoVO = new DAO_VOs();
        this.mapProgramas = new HashMap<>();
        // Cargamos la colección de la BBDD al arrancar la aplicación
        cargarColeccionProgCompleta();
    }

    
    // Generar una colección con todos los Programas
    public void cargarColeccionProgCompleta() {
        // Vamos a usar:
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;
        // Clave="6";
        pstmtSQL = this.daoBBDD.obtenerPrepareStatement("6");
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        this.mapProgramas = daoVO.coleccionDesdeResultSetProgramas(resultSet);
        
        daoVO.cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pstmtSQL);
    }
    
    ///////////////////////////////////////////////////////////
    // EJER 2.1
    ///////////////////////////////////////////////////////////
    // Generar una colección de Programas con igual nombre desde la BBDD 
    public HashMap<String, VOPrograma> generarColeccionProgMismoNombre(String nombrePrograma) {
        // 1) Sacamos ResultSet de la tabla con la consulta del Map de sentencias SQL (DAO_BBDD) clave="2";
        // 2) Generamos un map con cada ResultSet (DAO_VOs) y los añadimos al Map del controlador
        HashMap<String, VOPrograma> programas = new HashMap<>();
        // Vamos a usar:
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;

        pstmtSQL = this.daoBBDD.obtenerPrepareStatement("2");
        try {
            // Asignamos el nombrePrograma en mayúsculas porque en la SELECT comparamos mayúsculas
            pstmtSQL.setString(1, nombrePrograma.toUpperCase());
        } catch (SQLException ex) {
            System.out.println("Error al asignar el nombre de un prog al ? de una PrepStat. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        programas = daoVO.coleccionDesdeResultSetProgramas(resultSet);

        daoVO.cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pstmtSQL);

        return programas;
    }

    // Generar, mostrar y contabilizar todos los progs con un nombre dado
    public void mostrarProgMismoNombre(String nombrePrograma) {
        HashMap<String, VOPrograma> programas = new HashMap<>();
        // Generamos la colección
        programas = generarColeccionProgMismoNombre(nombrePrograma);
        // Visualizamos la colección
        Vista.mostrarColeccionMap(programas);
        // Mostramos el tamaño de la colección
        System.out.println("Nº programas llamados " + nombrePrograma + ": " + programas.size());
    }

    ///////////////////////////////////////////////////////////
    // EJER 2.2
    ///////////////////////////////////////////////////////////
    public void buscarYMostrarUnProg (String codigoPrograma) {
        // Sacamos la información de un programa según su código (EN MAYÚSCULAS) clave="1"
        // Generamos un objeto con el result set y lo mostramos

        VOPrograma programa = null;
        // Vamos a usar:
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;

        pstmtSQL = this.daoBBDD.obtenerPrepareStatement("1");
        try {
            // Asignamos el codigoPrograma en mayúsculas porque en la SELECT comparamos mayúsculas
            pstmtSQL.setString(1, codigoPrograma.toUpperCase());
        } catch (SQLException ex) {
            System.out.println("Error al asignar el código de un prog al ? de una PrepStat. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        programa = daoVO.generarUnPrograma(resultSet);

        System.out.println("El programa buscado (cod=" + codigoPrograma + ") es: " + programa.toString());

        daoVO.cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pstmtSQL);
    }

    ///////////////////////////////////////////////////////////
    // EJER 3
    ///////////////////////////////////////////////////////////
    // COMPROBAR SI EXISTE UN REGISTRO EN LA BBDD
    public boolean existeVenta(String cifComercio, String codigoPrograma) {
        boolean existe;
        int numRegistros = 0;

        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        // Usaremos, de la colección de sentenciasSQL clave="3"
        pstmt = daoBBDD.obtenerPrepareStatement("3");
        try {
            // Asignamos los valores del ?
            pstmt.setString(1, cifComercio);
            pstmt.setString(2, codigoPrograma);
        } catch (SQLException ex) {
            System.out.println("Error al asignar cif y cod a ?? para comprobar si existe una venta. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmt);
        numRegistros = daoVO.extraerValorNumericoConsulta(resultSet);
        if (numRegistros > 0) {
            existe = true;
        } else {
            existe = false;
        }

        daoVO.cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pstmt);

        return existe;
    }

    // Insertar un registro de la BBDD
    public int insertarNuevaVentaBBDD(String cifComercio, String codigoPrograma, int unidades) {
        PreparedStatement pstmt = null;
        int filasInsertadas = 0;

        // Clave="4"
        pstmt = daoBBDD.obtenerPrepareStatement("4");
        try {
            // Hay que "cargar" la PStmt (EN MAYÚSCULAS)
            pstmt.setString(1, cifComercio.toUpperCase());
            pstmt.setString(2, codigoPrograma.toUpperCase());
            pstmt.setInt(3, unidades);
        } catch (SQLException ex) {
            System.out.println("Error al insertar nueva venta. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Es una PStmt NO SELECT
        filasInsertadas = daoBBDD.ejecutarPrepareStatementNOSELECT(pstmt);

        daoBBDD.cerrarPrepareStatement(pstmt);
        return filasInsertadas;
    }

    // Actualizar el número de unidades vendidas 
    public int actualizarVentaBBDD(String cifComercio, String codigoPrograma, int unidades) {
        PreparedStatement pstmt = null;
        int filasModificadas = 0;

        // Clave="5"
        pstmt = daoBBDD.obtenerPrepareStatement("5");
        try {
            // Hay que "cargar" la PStmt (EN MAYÚSCULAS)
            pstmt.setString(2, cifComercio.toUpperCase());
            pstmt.setString(3, codigoPrograma.toUpperCase());
            pstmt.setInt(1, unidades);
        } catch (SQLException ex) {
            System.out.println("Error al insertar nueva venta. " + ex.getMessage());
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Es una PStmt NO SELECT
        filasModificadas = daoBBDD.ejecutarPrepareStatementNOSELECT(pstmt);

        daoBBDD.cerrarPrepareStatement(pstmt);
        return filasModificadas;
    }

    public void realizarVenta(String cifComercio, String codigoPrograma, int unidades) {
        if (existeVenta(cifComercio, codigoPrograma)) {
            System.out.println("La venta ya existía en la BBDD, se actualiza la cantidad vendida.");
            actualizarVentaBBDD(cifComercio, codigoPrograma, unidades);
        } else {
            System.out.println("La venta no existía en la BBDD, se inserta un nuevo registro.");
            insertarNuevaVentaBBDD(cifComercio, codigoPrograma, unidades);
        }
    }

    public void mostrarMenu() {
        int opcion;
        do {
            Scanner teclado = new Scanner(System.in);

            System.out.println("*** M E N Ú ***");
            System.out.println("1. Buscar un programa por cógigo.");
            System.out.println("2. Buscar programas por nombre.");
            System.out.println("3. Realizar compra.");
            System.out.println("0. Salir");
            System.out.println("\n¿Qué quieres hacer?");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    // Vaciamos buffer
                    teclado.nextLine();
                    System.out.println("Código del programa a buscar: ");
                    buscarYMostrarUnProg(teclado.nextLine());
                    break;
                case 2:
                    // Vaciamos buffer
                    teclado.nextLine();
                    System.out.println("Nombre de los programas: ");
                    mostrarProgMismoNombre(teclado.nextLine());
                    break;
                case 3:
                    // Vaciamos buffer
                    teclado.nextLine();
                    Vista.mostrarColeccionMap(mapProgramas);
                    System.out.println("Código del programa deseado: ");
                    String codPrograma=teclado.nextLine();
                    System.out.println("Cif del comercio vendedor: ");
                    String cifComercio=teclado.nextLine();
                    System.out.println("Número de unidades: ");
                    int unidades=teclado.nextInt();
                    realizarVenta(cifComercio, codPrograma, unidades);
                    break;
                case 0:
                    System.out.println("¡ Adiós !");
                    break;
                default:
                    System.out.println("Opción no válida, por favor introduce un número entre 0 y 2:");
                    opcion = teclado.nextInt();
            }

        } while (opcion != 0);

    }
}
