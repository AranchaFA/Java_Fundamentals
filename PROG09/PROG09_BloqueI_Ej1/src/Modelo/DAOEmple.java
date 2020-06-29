package Modelo;

import java.sql.*;

public class DAOEmple {

    private MetodosGestionBBDD bbdd;   // metodos de bbdd a utilizar sobre la coleccion
    private VOEmple voEmple;
    private DatosConexionBBDD datosConexion;
    int tipoResultado = ResultSet.TYPE_SCROLL_SENSITIVE;
    int tipoActualizacion = ResultSet.CONCUR_UPDATABLE;

    //en el constructor le paso el objeto bbdd que indica la conexion de la BBDD
    //con la que vamos a trabajar, sino tendria que en cada método
    //pasar como parámetro dicha conexion
    public DAOEmple(DatosConexionBBDD datosConexion) {
        this.datosConexion = datosConexion;
        //abrimos la conexion a la BBDD cuando creamos un objeto DAODepart
        this.bbdd = new MetodosGestionBBDD();
        bbdd.conexionBBDD(datosConexion);
    }

    public ResultSet devolverDatosConsulta(String sql) {
        ResultSet juegoResultados;
        juegoResultados = bbdd.ejecutarStatementSELECT(sql, tipoResultado, tipoActualizacion);
        return juegoResultados;
    }

    public VOEmple buscarDatosEmpleado(int emp_no) {
        //VOEmple empleBuscado=null; // Para hacer una prueba pq falla con el director
        //suponemos que solo hay un empleado y no hay repeticiones
        ResultSet juegoResultados;

        //creo la sentencia sql
        String sql = "select emp_no, apellido from emple where emp_no = " + emp_no;
        juegoResultados = bbdd.ejecutarStatementSELECT(sql, tipoResultado, tipoActualizacion);

        if (juegoResultados != null) {
            try {               
                while (juegoResultados.next()) {                 
                            voEmple = new VOEmple(juegoResultados.getInt("emp_no"),
                            juegoResultados.getString("apellido"));                                   
                }
                juegoResultados.close();
            } catch (SQLException ex) {
                System.out.println("Problemas con el empleado no existe");
            }
        } else {
            voEmple = null;
        }
     return voEmple;
    } 
    
    public void cerrarConexionDao(){
           bbdd.cerrarConexion();
       }
}
