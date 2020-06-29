package Controlador;

import Modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiControlador {

    // ATRIBUTOS
    private DAOEmple daoEmple;
    private DAOEmpleEmpresa daoEmpleEmpresa;
    private DAODepart daoDepart;
    private DatosConexionBBDD datosConexion;

    // MÉTODOS
    // Getters + Setters
    public DAOEmple getDaoEmple() {
        return daoEmple;
    }

    public void setDaoEmple(DAOEmple daoEmple) {
        this.daoEmple = daoEmple;
    }

    public DAOEmpleEmpresa getDaoEmpleEmpresa() {
        return daoEmpleEmpresa;
    }

    public void setDaoEmpleEmpresa(DAOEmpleEmpresa daoEmpleEmpresa) {
        this.daoEmpleEmpresa = daoEmpleEmpresa;
    }

    public DAODepart getDaoDepart() {
        return daoDepart;
    }

    public void setDaoDepart(DAODepart daoDepart) {
        this.daoDepart = daoDepart;
    }

    public DatosConexionBBDD getDatosConexion() {
        return datosConexion;
    }

    public void setDatosConexion(DatosConexionBBDD datosConexion) {
        this.datosConexion = datosConexion;
    }

    // toString
    @Override
    public String toString() {
        return "MiControlador{" + "daoEmple=" + daoEmple + ", daoEmpleEmpresa=" + daoEmpleEmpresa + ", daoDepart=" + daoDepart + ", datosConexion=" + datosConexion + '}';
    }

    // Constructor
    public MiControlador(DatosConexionBBDD datosConexion) {
        this.datosConexion = datosConexion;
        daoDepart = new DAODepart(datosConexion);
        daoEmple = new DAOEmple(datosConexion);
        daoEmpleEmpresa = new DAOEmpleEmpresa(datosConexion);
    }

    // EJ_1 : Mostrar listado de todos los empleados ordenados por departamento
    public void mostrarEmplesOrdenadosPorDepart() {
        // Vamos a utilizar objetos del tipo:
        String sentenciaSQL;
        // Statement stmt; // Este se crea y emplea en el DAOEmple
        ResultSet resultSet;
        // Creamos la sentencia SQL
        sentenciaSQL = "SELECT * FROM emple ORDER BY dept_no";
        // Obtenemos el ResultSet con el método para efectuar una consulta del DAOEmple
        resultSet = daoEmple.devolverDatosConsulta(sentenciaSQL);
        // Tratamos el juego de resultados para ir leyendo cada registro y mostrando su información
        try {
            System.out.println("DEPT_NO -- EMP_NO -- APELLIDO -- OFICIO -- JEFE -- SALARIO -- COMISIÓN -- SUELDO");
            while (resultSet.next()) {
                // Depart y Jefe se pueden mostrar como ints porque no vamos a crear los objetos
                int dept_no = resultSet.getInt("DEPT_NO");
                int emp_no = resultSet.getInt("EMP_NO");
                String apellido = resultSet.getString("APELLIDO");
                String oficio = resultSet.getString("OFICIO");
                int dir = resultSet.getInt("DIR");
                int salario = resultSet.getInt("SALARIO");
                int comision = resultSet.getInt("COMISION");
                System.out.println(
                     dept_no + " -- "
                     + emp_no + " -- "
                     + apellido + " -- "
                     + oficio + " -- "
                     + dir + " -- "
                     + salario + " -- "
                     + comision + " -- "
                     + (salario + comision)
                );
            }
            // Para saber el tamaño de un resultSet no hay un método especiífico:
            // Nos posicionamos en el último registro del resulsSet
            resultSet.last();
            // Sacamos el nº de fila en que nos encontramos (la última, luego coincide con el size)
            int totalEmpleados = resultSet.getRow();
            System.out.println("Total de empleados: " + totalEmpleados);
        } catch (SQLException ex) {
            System.out.println("Error al tratar el juego de resultados. " + ex.getMessage());
            Logger.getLogger(MiControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // EJ_2 : Calcular el sueldo de un empleado
    public int calcularSueldoEmpleado(int emp_no) {
        int sueldo = 0;

        // Vamos a usar una sentencia SQL y un ResultSet
        String sentenciaSQL;
        ResultSet resultSet;

        // La sentencia SQL será:
        sentenciaSQL = "SELECT salario,comision FROM emple WHERE emp_no=" + emp_no;
        // Generamos el ResultSet de la consulta con la sentencia SQL
        resultSet = daoEmpleEmpresa.devolverDatosConsulta(sentenciaSQL);
        // Procesamos el ResultSet

        try {
            while (resultSet.next()) {
                System.out.println("El salario del empleado nº " + emp_no 
                     + " es de " + (resultSet.getInt("salario")+resultSet.getInt("comision")) +"€.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MiControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sueldo;
    }
}
