/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arancha
 */
public class Main_BBDD1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // 1- CARGAR DRIVER
        try {
            // Vamos a usar Oracle:
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("");
            Logger.getLogger(Main_BBDD1.class.getName()).log(Level.SEVERE, null, ex);
        }

        // 2- CREAR CONEXIÓN
        // Definimos la conexión
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            Connection conexion = DriverManager.getConnection(url, "system", "system");

            // 3- CREAR SENTENCIA SQL Y EJECUTAR
            // Creamos el Statement
            Statement stmtSQL = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // Creamos la sentencia SQL a ejecutar
            String sentenciaSQL = "SELECT * FROM EMPLE";
            // Ejecutamos y guardamos el resultado en una variable de tipo ResulSet (juego de resultados:
            // nos devolverá varias filas)
            ResultSet resultado = stmtSQL.executeQuery(sentenciaSQL);

            // 4- PROCESAR RESULTADO
            // Iteramos el ResultSet (el conjunto de filas obtenidas)
            while (resultado.next()) {
                // Guardamos los datos de la fila en variables
                String empno = resultado.getString("EMPNO"); // En el objeto es int -> PARSEARLO
                String nombre = resultado.getString("NOMBRE");
                String oficio = resultado.getString("OFICIO");
                Date fechaAlta = resultado.getDate("FECALTA");
                String manager = resultado.getString("MGR"); // En el objeto es int -> PARSEARLO
                int salario = resultado.getInt("SAL");
                String deptno = resultado.getString("DEPT_NO"); // En el objeto es int -> PARSEARLO
                // Creamos un objeto empleado con estos datos
                // Emple empleado=new Emple(Integer.parseInt(empno), nombre, oficio, Integer.parseInt(manager), fechaAlta, salario, new Depart(deptno, "tal", loquetoque));
                // Mostramos lo que queramos con un sout
                System.out.println("taltal");
            }

            // 5- CERRAR 
            // En orden inverso a la apertura (como en ficheros)
            if (resultado != null) {
                resultado.close();
            }
            if (sentenciaSQL != null) {
                stmtSQL.close();
            }
            if (conexion != null) {
                conexion.close();
            }

        } catch (SQLException ex) {
            System.out.println("Problemas para conectarse al usuario: system\n"+ex.getMessage());
            Logger.getLogger(Main_BBDD1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
