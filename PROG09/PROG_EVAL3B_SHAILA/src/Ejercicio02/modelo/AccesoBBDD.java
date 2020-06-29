package Ejercicio02.modelo;

import java.sql.*;
import java.util.logging.Logger;

/**
 *
 * @author Shaila
 */
public class AccesoBBDD {

    Connection conexion = null;
    ResultSet resultado = null;
    int resultadoFinal = 0;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Metodo que permite conectarse a la BBDD metiendo el nomEquipo =
     * localhost, nomBBDD = XE y usuario y contraseña
     *
     * @param nomEquipo
     * @param nomBBDD
     * @param usr
     * @param pwd
     * @return
     */
    public Connection conexionBBDD(String nomEquipo, String nomBBDD, String usr, String pwd) {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error con el driver,comprueba que lo has metido en el proyecto y que es el correcto.");
        }
        String servidor = nomEquipo;
        String bbdd = nomBBDD;
        String nomeUsr = usr;
        String password = pwd;
        //defino la url que se usará para la conexión
        String url = "jdbc:oracle:thin:@" + servidor + ":1521:" + bbdd;
        try {
            //creo la coexion
            conexion = DriverManager.getConnection(url, nomeUsr, password);//creas la conexion

        } catch (SQLException ex) {
            Logger.getLogger("Fallo en la conexión,puede ser que no exista la BBDD, o esté mal el usuario o la contraseña");
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /**
     * Cierra la conexion con la BBDD
     *
     */
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion con la BBDD.");
        }

    }

    /**
     * cierra una conexion de la BBDD para PreparedStatement
     *
     */
    public void cerrarPreparedStatement(PreparedStatement pstmtSQL) {
        try {
            if (pstmtSQL != null) {
                pstmtSQL.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MetodosGestionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cerrar la preparedStatemen");
        }
    }

    /**
     * cierra una conexion de la BBDD para Statement
     *
     */
    public void cerrarStatement(Statement stmtSQL) {
        try {
            if (stmtSQL != null) {
                stmtSQL.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(MetodosGestionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cerrar la Statemen");
        }
    }

    /**
     * Metodo para crear statements que sepas qué tipo va a
     * ser(Slect,Insert,Update,Delete) para luego ejecutarlos y hacer la
     * consulta, en el que le pasarás un objeto de tipo Statement para realizar
     * la conexion y le pasarás un tipo resultado que SIEMPRE SERÁ
     * ResultSet.TYPE_SCROLL_SENSITIVE y el tipo de actualización que siempre
     * será ResultSet.CONCUR_UPDATABLE
     *
     * @param tipoResultado
     * @param tipoActualizacion
     * @return
     */
    public Statement crearStatementFijo(int tipoResultado, int tipoActualizacion) {
        Statement stmt = null;
        try {
            stmt = conexion.createStatement(tipoResultado, tipoActualizacion);
        } catch (SQLException ex) {
            System.out.println("Error al crear el Statement.");
        }
        return stmt;
    }

    /**
     * Metodo para crear statements sin saber qué tipo va a
     * ser(Slect,Insert,Update,Delete) para luego ejecutarlos y hacer la
     * consulta, en el que le pasarás un objeto de tipo Statement para realizar
     * la conexion y le pasarás un tipo resultado que SIEMPRE SERÁ
     * ResultSet.TYPE_SCROLL_SENSITIVE y el tipo de actualización que siempre
     * será ResultSet.CONCUR_UPDATABLE. HAY QUE PASARLE YA LA CONSULTA SQL
     *
     * @param consultaSQL
     * @param tipoResultado
     * @param tipoActualizacion
     * @return
     */
    public PreparedStatement crearStatementSinSaberCual(String consultaSQL, int tipoResultado, int tipoActualizacion) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(consultaSQL, tipoResultado, tipoActualizacion);
        } catch (SQLException ex) {
            System.out.println("Error al crear el PreparedStatement.");
        }
        return pstmt;
    }

    /**
     * Ejecuta el statement donde antes tienes que guardar en una variable
     * statement algún de los dos métodos echos anteriormente, y le escribes la
     * consulta que quieras hacer
     *
     * @param consultaSQL
     * @param t
     * @return
     */
    public ResultSet ejecutarSecuenciaSelect(String consultaSQL, Statement t) {
        try {
            resultado = t.executeQuery(consultaSQL);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia.");
        }
        return resultado;
    }

    /**
     * Ejecuta el statement donde antes tienes que guardar en una variable
     * statement algún de los dos métodos echos anteriormente, y le escribes la
     * consulta que quieras hacer y será int,diciendote el número de fulas
     * afectadas
     *
     * @param consultaSQL
     * @param t
     * @return
     */
    public int ejecutarSecuenciaInsertUpdateDelete(String consultaSQL, Statement t) {

        try {
            System.out.println(consultaSQL);
            resultadoFinal = t.executeUpdate(consultaSQL);
            System.out.println("Se ha visto afectadas el numero de filas de: " + resultadoFinal);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia: " + consultaSQL);
        }
        return resultadoFinal;
    }

    /**
     * metodo para ejecutar una PreparedStatement SELECT
     *
     * @param pstmtSQL
     * @return
     */
    public ResultSet ejecutarPreparedStatementSELECT(PreparedStatement pstmtSQL) {
        ResultSet resultadoConsulta = null;
        try {
            resultadoConsulta = pstmtSQL.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error en la consulta Statement, comprobar la SQL");
        }
        return resultadoConsulta;
    }

    /**
     * Método para ejecutar una PreparedStatement UPDATE, INSERT, UPDATE
     * ejecutamos la preparedStatement completada en el DAO correspondiente
     *
     * @param pstmtSQL
     * @return
     */
    public int ejecutarPreparedStatementNOSELECT(PreparedStatement pstmtSQL) {
        int numFilasAfectadasSQL = 0;
        try {
            numFilasAfectadasSQL = pstmtSQL.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error en la consulta Statement, comprobar la SQL");
        }
        return numFilasAfectadasSQL;
    }

    /**
     * Método para cerrar todos los select
     *
     * @param s
     */
    public void cerrarTodoSelect(Statement s) {
        if (resultado != null) {
            try {
                resultado.close();
                System.out.println("Cerrado el resultado.");
            } catch (SQLException ex) {
                System.out.println("Imposible cerrar el resultado final.");
            }
        }
        if (s != null) {
            try {
                s.close();
                System.out.println("Cerrado el statement.");
            } catch (SQLException ex) {
                System.out.println("Imposible cerrar el statement.");
            }
        }
        if (conexion != null) {
            System.out.println("La conexión a la BBDD se ha realizado con éxito.");
            this.cerrarConexion();

        } else {
            System.out.println("No se ha podido conectar.");
        }
    }

}
