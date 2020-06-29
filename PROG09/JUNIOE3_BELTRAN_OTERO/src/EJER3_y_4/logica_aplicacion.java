package EJER3_y_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class logica_aplicacion {

    //atributos
    private Connection conexion;
    public List<Empleado> lista_empleados;

    //constructor
    public logica_aplicacion() {
        lista_empleados = new ArrayList<Empleado>();
    }

    public void conectar(String usuarioBBDD, String pasw) {
        try {
            //1//CARGO DRIVER
            Class.forName("oracle.jdbc.OracleDriver");
            //2///DEFINO URL QUE SE USARA EN LA CONEXION
            String url = "jdbc:oracle:thin:@localhost:1521:XE";//direccion al driver
            //3///CREO LA CONEXION
            conexion = DriverManager.getConnection(url, usuarioBBDD, pasw);
            /*el metodo getconection de la clase drivermanager devuelve un objeto de tipo
            conection"intenta establecer conexion con la base de datos"
             */
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(logica_aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(" ERROR SQLException ex :CONTRASEÑA O USUARIO INCORRECTOS");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(logica_aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////////////////////////////////////////////////////////
    ////////////METODOS EJERCICIO 3////////////////////////////
    ////////////////////////////////////////////////////////////
    public ResultSet prepare_statement_sentencia_empleados(String dni) {
        ResultSet resultset = null;
        String cadenaSQL = "SELECt * FROM EMPLEADOS WHERE DNI= ?";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareCall(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);//PRECOMPILO LA CONSULTA
            //METO PARAMETROS A LA CONSULTA PRECOMPILADA
            sentenciaSQL.setString(1, dni);//EL UNO REFERENCIA AL PRIMER INTERROGANTE
            //MANDO SENTENCIA Y ALMACENO  EL VALOR EN EL RESULTSET
            resultset = sentenciaSQL.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(logica_aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultset;

    }
    ////////////////////////////////////////////////////////////////////////////////////////

    public void mostrar_datos_emple(ResultSet resultado) {
        Empleado e = null;
        Empresa emp = null;
        try {
            while (resultado.next()) {
                String dni = resultado.getString("DNI");
                String nombre = resultado.getString("NOMBRE");
                String apellido = resultado.getString("APELLIDO1");
                String apellido2 = resultado.getString("APELLIDO2");
                String direccion = resultado.getString("DIRECCION");
                String telf = resultado.getString("TELEFONO");
                int edad = resultado.getInt("EDAD");
                String cif = resultado.getString("CIF");

                e = new Empleado(dni, nombre, apellido, apellido2, direccion, telf, edad);

                ResultSet r = this.prepare_statement_sentencia_empresa(cif);
                emp = cargar_en_objeto_empresa(r);

                System.out.println(e.toString());
                System.out.println(emp.toString());

            };
        } catch (SQLException ex) {
            Logger.getLogger(logica_aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////
    public ResultSet prepare_statement_sentencia_empresa(String cif) {
        ResultSet resultset = null;
        String cadenaSQL = "SELECt * FROM EMPRESAS WHERE CIF= ?";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareCall(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);//PRECOMPILO LA CONSULTA
            //METO PARAMETROS A LA CONSULTA PRECOMPILADA
            sentenciaSQL.setString(1, cif);//EL UNO REFERENCIA AL PRIMER INTERROGANTE
            //MANDO SENTENCIA Y ALMACENO  EL VALOR EN EL RESULTSET
            resultset = sentenciaSQL.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(logica_aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultset;

    }

    /////////////////////////////////////////////////////////////////////////////////
    public Empresa cargar_en_objeto_empresa(ResultSet resultado) {
        Empresa e = null;
        try {
            while (resultado.next()) {
                String cif = resultado.getString("CIF");
                String nombre = resultado.getString("NOMBRE");
                String direccion = resultado.getString("DIRECCION");
                String telefono = resultado.getString("TELEFONO");

                e = new Empresa(cif, nombre, direccion, telefono);

            };
        } catch (SQLException ex) {
            Logger.getLogger(logica_aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    //////////////////////////////////////////////////////////////////////////
    ////////////METODOS EJERCICIO 4/////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    public ResultSet prepare_statement_sentencia_empleados_EJER4(String CIF) {
        ResultSet resultset = null;
        String cadenaSQL = "SELECt * FROM EMPLEADOS WHERE CIF= ?";
        try {
            PreparedStatement sentenciaSQL = conexion.prepareCall(cadenaSQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);//PRECOMPILO LA CONSULTA
            //METO PARAMETROS A LA CONSULTA PRECOMPILADA
            sentenciaSQL.setString(1, CIF);//EL UNO REFERENCIA AL PRIMER INTERROGANTE
            //MANDO SENTENCIA Y ALMACENO  EL VALOR EN EL RESULTSET
            resultset = sentenciaSQL.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(logica_aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultset;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public void CARGAR_COLECCION(ResultSet resultado) {
        Empleado e = null;
        Empresa emp = null;
        try {
            while (resultado.next()) {
                String dni = resultado.getString("DNI");
                String nombre = resultado.getString("NOMBRE");
                String apellido = resultado.getString("APELLIDO1");
                String apellido2 = resultado.getString("APELLIDO2");
                String direccion = resultado.getString("DIRECCION");
                String telf = resultado.getString("TELEFONO");
                int edad = resultado.getInt("EDAD");
                String cif = resultado.getString("CIF");

                e = new Empleado(dni, nombre, apellido, apellido2, direccion, telf, edad);
                lista_empleados.add(e);

            };
        } catch (SQLException ex) {
            Logger.getLogger(logica_aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void visualizar_extructura() {//

        Iterator objetoIterator = lista_empleados.iterator();
        while (objetoIterator.hasNext()) {
            System.out.println(objetoIterator.next());
        }

    }

}
