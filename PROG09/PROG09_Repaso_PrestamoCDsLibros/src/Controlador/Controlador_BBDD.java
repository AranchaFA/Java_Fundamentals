package Controlador;

import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_BBDD {

    // ATRIBUTOS
    private DAO_BBDD daoBBDD;
    private DAO_VOs daoVO;
    private HashMap<String, HashMap> coleccion; // Si la manda hacer

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

    public HashMap<String, HashMap> getColeccion() {
        return coleccion;
    }

    public void setColeccion(HashMap<String, HashMap> coleccion) {
        this.coleccion = coleccion;
    }

    // toString
    @Override
    public String toString() {
        return "Controlador_BBDD{" + "daoBBDD=" + daoBBDD + ", daoVO=" + daoVO + ", coleccion=" + coleccion + '}';
    }

    // Constructor
    public Controlador_BBDD() {
        this.daoBBDD = new DAO_BBDD();
        this.daoVO = new DAO_VOs();
        this.coleccion = new HashMap<>();
        // Cargamos toda la información de la BBDD al arrancar la aplicación
        generarColeccion();
    }

    ///////////////////////////////////////////////////////////
    // CARGAR COLECCIÓN DESDE BBDD
    ///////////////////////////////////////////////////////////
    // Cargar colección desde la BBDD (se carga automáticamente al crear el Controlador)
    // (Map con subMaps)
    public void generarColeccion() {
        // 1) Sacamos ResultSets de cada tabla con las consultas del Map de sentencias SQL (DAO_BBDD)
        // 2) Generamos un map con cada ResultSet (DAO_VOs) y los añadimos al Map del controlador

        // Vamos a usar:
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;

        // Las PreparedStmt para sacar todos los datos de las tablas son las "2X"       
        // Vamos asignando la psmts para cada tabla, generando la coleccion a partir de cada ResultSet
        // y cargando cada colección generada a la colección del controlador
        pstmtSQL = this.daoBBDD.obtenerPrepareStatement("21"); // LIBROS
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        this.coleccion.put("LIBROS", daoVO.coleccionDesdeResultSetLibro(resultSet));
        
        pstmtSQL = this.daoBBDD.obtenerPrepareStatement("22"); // CD
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        this.coleccion.put("CD", daoVO.coleccionDesdeResultSetCD(resultSet));
        
        pstmtSQL = this.daoBBDD.obtenerPrepareStatement("23"); // SOCIOS
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        this.coleccion.put("SOCIOS", daoVO.coleccionDesdeResultSetSocio(resultSet));
        
        /*pstmtSQL = this.daoBBDD.obtenerPrepareStatement("24"); // PRESTAMOS
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        this.coleccion.put("PRESTAMOS", daoVO.coleccionDesdeResultSetPrestamo(resultSet));*/

        daoVO.cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pstmtSQL);
    }

    public Prestable hacerPrestamo() {
        Scanner teclado = new Scanner(System.in);
        Prestable objetoAPrestar = null;
        String codigoElegido;
        double codigoSocio;

        System.out.println("¿Cuál es tu código de socio?");
        codigoSocio = teclado.nextDouble();
        System.out.println("\nTODOS LOS OBJETOS A PRESTAR:");
        System.out.println("LIBROS:");
        Vista.Vista.mostrarColeccionMap(coleccion.get("LIBROS"));
        System.out.println("CDs:");
        Vista.Vista.mostrarColeccionMap(coleccion.get("CD"));
        System.out.println("\n¿Cuál te interesa?");
        codigoElegido = teclado.nextLine();

        grabarPrestamoEnBBDD(codigoSocio, codigoElegido);

        return objetoAPrestar;
    }

    public boolean grabarPrestamoEnBBDD(double codSocio, String codPrestable) {
        boolean nuevo;

        PreparedStatement pStmt = null;

        String clavePrestamo = codSocio + codPrestable;
        if (coleccion.containsKey(clavePrestamo)) {
            System.out.println("Ese socio ya había sacado ese libro, (igualmente se añade un registro con este nuevo préstamo).");
            nuevo = false;
        } else {
            System.out.println("Ese socio NO había sacado ese libro antes, se añade un registro.");
            nuevo = true;
        }

        // De cualquier modo añadiremos un registro
        try {
            // Usamos la sentenciaSQL "11"
            pStmt = daoBBDD.obtenerPrepareStatement("11");
            // Asignamos los valores a insertar a las ? de la pStmt
            pStmt.setDouble(1, codSocio);
            pStmt.setString(2, codPrestable);
            // El objeto Date al crearse ya coge el valor de la fecha del sistema en ese momento
            pStmt.setDate(3, (java.sql.Date) new Date());

            daoBBDD.ejecutarPrepareStatementNOSELECT(pStmt);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        daoBBDD.cerrarPrepareStatement(pStmt);
        
        return nuevo;
    }
}
