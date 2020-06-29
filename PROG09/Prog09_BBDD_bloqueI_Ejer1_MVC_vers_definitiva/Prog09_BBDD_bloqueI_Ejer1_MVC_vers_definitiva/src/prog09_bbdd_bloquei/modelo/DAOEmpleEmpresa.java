package prog09_bbdd_bloquei.modelo;

import java.sql.*;
import java.util.GregorianCalendar;

public class DAOEmpleEmpresa {

    private MetodosGestionBBDD bbdd;   // metodos de bbd a utilizar sobre la coleccion
    private VOEmpleEmpresa voEmpleEmpresa;
    private DatosConexionBBDD datosConexion;
    int tipoResultado = ResultSet.TYPE_SCROLL_SENSITIVE;
    int tipoActualizacion = ResultSet.CONCUR_UPDATABLE;

    //en el constructor le paso el objeto bbdd que indica la conexion de la BBDD
    //con la que vamos a trabajar, sino tendria que en cada método
    //pasar como parámetro dicha conexion
    public DAOEmpleEmpresa(DatosConexionBBDD datosConexion) {
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

    public VOEmpleEmpresa buscarDatosEmpleado(int emp_no) {

        //suponemos que solo hay un empleado y no hay repeticiones
        ResultSet juegoResultados;

        //como voy a tener que buscar un objeto departamento en la BBDD
        //preparo el objeto que lo va a recibir y el objeto que tiene 
        //el método que me lo va a buscar
        VODepart voDepartamento;
        DAODepart daoDepart = new DAODepart(datosConexion); //abro un objeto con la conexion a la BBDD

        DAOEmple daoEmple = new DAOEmple(datosConexion);
        VOEmple voEmple, voEmpleJefe;

        //creo la sentencia sql
        String sql = "select * from emple where emp_no = " + emp_no;
        juegoResultados = bbdd.ejecutarStatementSELECT(sql, tipoResultado, tipoActualizacion);

        if (juegoResultados != null) {
            try {
                while (juegoResultados.next()) {
                    //adapto la fecha de la fila que estoy procesando
                    GregorianCalendar fecha = new GregorianCalendar();
                    fecha.setTime(juegoResultados.getDate("fecha_alt"));

                    //como el atributo departamento es un objeto de tipo 
                    //VODepart, lo busco usando un método del DAODepart
                    voDepartamento = daoDepart.buscarDatosUnDepartamento(juegoResultados.getInt("dept_no"));

                    //miramos los datos básicos del empleado
                    voEmpleJefe = new VOEmple(juegoResultados.getInt("emp_no"),
                            juegoResultados.getString("apellido"));

                    //miro los datos básicos del empleado Jefe (su emp_no y apellido)
                    voEmple = daoEmple.buscarDatosEmpleado(juegoResultados.getInt("dir"));

                    voEmpleEmpresa = new VOEmpleEmpresa(voEmple,
                                voDepartamento,
                                juegoResultados.getString("oficio"),
                                voEmpleJefe,
                                fecha,
                                juegoResultados.getInt("salario"),
                                juegoResultados.getInt("comision"));
                    } 
                juegoResultados.close();
                }catch (SQLException ex) {
                System.out.println("Problemas con el empleado no existe");
            }
            }else {
            voEmpleEmpresa = null;
        }
            daoDepart.cerrarConexionDao(); //es una variable local en este método
            return voEmpleEmpresa;
        }

    

    public int calcularSueldo(VOEmpleEmpresa empleEmpresa) {
        return (empleEmpresa.getComision() + empleEmpresa.getSalario());
    }

    public void cerrarConexionDao() {
        bbdd.cerrarConexion();
    }
}
