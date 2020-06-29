package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_BBDD {

    // ATRIBUTOS
    // Conexión a la BBDD
    private Connection conexion = null;
    // Datos de la conexión
    private DatosConexionBBDD datosConexionBBDD;
    // Objeto con la colección de PrepareStatement que se usarán en las consultas y el tipo de ResultSet devuelto
    private ColeccionPreparedStatementsSQL sentenciasSQL;

    // MÉTODOS
    // Getters + Setters
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public DatosConexionBBDD getDatosConexionBBDD() {
        return datosConexionBBDD;
    }

    public void setDatosConexionBBDD(DatosConexionBBDD datosConexionBBDD) {
        this.datosConexionBBDD = datosConexionBBDD;
    }

    public ColeccionPreparedStatementsSQL getSentenciasSQL() {
        return sentenciasSQL;
    }

    public void setSentenciasSQL(ColeccionPreparedStatementsSQL sentenciasSQL) {
        this.sentenciasSQL = sentenciasSQL;
    }

    // Constructor
    public DAO_BBDD(DatosConexionBBDD datosConexionBBDD) {
        this.datosConexionBBDD = datosConexionBBDD;
        conexionBBDD();
        this.sentenciasSQL = new ColeccionPreparedStatementsSQL(conexion);
    }

    // ABRIR / CERRAR LA CONEXIÓN A LA BBDD
    public boolean conexionBBDD() {
        boolean exito = false;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            //  Logger.getLogger(DAO_BBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error con el driver,comprueba que lo has metido en el proyecto y que es el correcto");
        }

        //defino la url que se usará para la conexion; 1521 para oracle
        String url = "jdbc:oracle:thin:@" + this.datosConexionBBDD.getEquipo() + ":1521:" + this.datosConexionBBDD.getBd();
        System.out.println(url);
        try {
            //creo la conexion
            conexion = DriverManager.getConnection(url, this.datosConexionBBDD.getUsr(), this.datosConexionBBDD.getPwd());
            if (conexion != null) {
                System.out.println("Conexión establecida con exito");
                exito = true;
            }
        } catch (SQLException ex) {
            //System.out.println("Fallo en la conexion; verificar BBDD, nombre equipo, usuario o contraseña");
            System.out.println("Error al conectar con la BBDD, compruebe si está levantada");
            exito = false;
        }
        return exito;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DAO_BBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cerrar la conexion a la BBDD");
        }
    }

    /*  // Crear el objeto con las sentenciasSQL
    public void crearObjetoPreparedStatementsSQL() {
    this.sentenciasSQL = new ColeccionPreparedStatementsSQL(conexion);
    }*/

    // CERRAR LAS STATEMENT AL FINALIZAR LA CONEXIÓN A LA BBDD (mal fechu)
    public void cerrarPreparedStatement(PreparedStatement pstmtSQL) {
        try {
            if (pstmtSQL != null) {
                pstmtSQL.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DAO_BBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cerrar la preparedStatemen");
        }
    }

    public void cerrarStatement(Statement stmtSQL) {
        try {
            if (stmtSQL != null) {
                stmtSQL.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DAO_BBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cerrar la Statemen");
        }
    }

    // Obtener una PreparedStatement de la colección sentencias SQL pasando el índice que tiene en el Map
    // (luego insertaremos los ? en el controlador)
    public PreparedStatement obtenerPreparedStatement(String keyMap) {
        return sentenciasSQL.getSentenciasSQL().get(keyMap);
    }

    // Ejecutar PreparedStmt pasándola por parámetro SELECT
    public ResultSet ejecutarPreparedStatementSELECT(PreparedStatement pstmtSQL) {
        ResultSet resultSet = null;
        try {
            resultSet = pstmtSQL.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error en la consulta Statement, comprobar la SQL. " + ex.getMessage());
            Logger.getLogger(DAO_BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultSet;
    }

    // Ejecutar PreparedStmt pasándola por parámetro INSERT, DELETE, UPDATE
    public int ejecutarPreparedStatementNOSELECT(PreparedStatement pstmtSQL) {
        int numFilasAfectadasSQL = 0;
        try {
            numFilasAfectadasSQL = pstmtSQL.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en la consulta Statement, comprobar la SQL");
        }

        return numFilasAfectadasSQL;
    }
}
