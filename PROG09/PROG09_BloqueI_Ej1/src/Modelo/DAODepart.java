/*
 * clase que contiene los métodos mas generícos para
 *  trabajar con la tabla de la BD Depart
 */
package Modelo;

import java.sql.*;

/**
 *
 * @author rpe
 */
public class DAODepart {

    private MetodosGestionBBDD bbdd;   // metodos de bbd a utilizar sobre la coleccion
    private VODepart voDepart;
    private DatosConexionBBDD datosConexion;
    int tipoResultado = ResultSet.TYPE_SCROLL_SENSITIVE;
    int tipoActualizacion = ResultSet.CONCUR_UPDATABLE;

    /**
     * constructor al que le pasamos el objeto DatosConexion con los datos para crear 
     * el objeto MetodosGestionBBDD, que tiene los métodos genéricos de BBDD y abre la conexión.
     *
     * @param datosConexion objeto con los datos para crear el objeto MetodosGestionBBDD,
     * que tiene los métodos genéricos de BBDD y abre la conexión.
     */
    public DAODepart(DatosConexionBBDD datosConexion) {
        this.datosConexion = datosConexion;
        //abrimos la conexion a la BBDD cuando creamos un objeto DAODepart
        this.bbdd = new MetodosGestionBBDD();
        bbdd.conexionBBDD(datosConexion);
    }

    public VODepart buscarDatosUnDepartamento(int dept_no) {

        //suponemos que solo hay un empleado y no hay repeticiones
        ResultSet juegoResultados;
        String sql = "select * from depart where dept_no = " + dept_no;
        juegoResultados = bbdd.ejecutarStatementSELECT(sql, tipoResultado, tipoActualizacion);

        if (juegoResultados != null) {
            try {
                while (juegoResultados.next()) {

                    voDepart = new VODepart(juegoResultados.getInt("dept_no"),
                            juegoResultados.getString("dnombre"),
                            juegoResultados.getString("loc"));
                }
                juegoResultados.close();
            } catch (SQLException ex) {
                System.out.println("Problemas con el empleado no existe");
            }
        } else {
            voDepart = null;
        }

        return voDepart;

    }

    public ResultSet devolverDatosConsultaDepart(String sql) {
        ResultSet juegoResultados;
        juegoResultados = bbdd.ejecutarStatementSELECT(sql, tipoResultado, tipoActualizacion);
        return juegoResultados;
    }

    public void cerrarConexionDao() {
        bbdd.cerrarConexion();
    }
}
