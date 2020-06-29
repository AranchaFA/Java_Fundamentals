package Controlador;

import Modelo.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraAplicacion {

    private DatosConexionBBDD datosConexion;
    private DAOEmpleEmpresa daoEmpleEmpresa;
    private DAODepart daoDepart;


    public ControladoraAplicacion() {
        //o introducirmos los datos de la conexion o los meto directamente
        datosConexion = new DatosConexionBBDD("localhost","XE","prog","prog");
        daoEmpleEmpresa = new DAOEmpleEmpresa(datosConexion);
        daoDepart= new DAODepart(datosConexion);
    }

  
    public void menu() {
        System.out.println("\n\nMENU");
        System.out.println("1. Consultar todos los empleados");
        System.out.println("2. Buscar Emple por emp_no");
        System.out.println("3. Consultar Empleados de un Departamento y grabar CSV");
        System.out.println("0. Salir Aplicacion");
        System.out.println("Introduce opcion:");
    }

    public void gestionMenu() {
        int opcion;
        Scanner teclado=new Scanner(System.in);
        
        //muestra el menu y lo gestion
        do {
            menu();
            opcion = teclado.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Cerrando aplicación");
                    daoDepart.cerrarConexionDao();
                    daoEmpleEmpresa.cerrarConexionDao();
                    break;
                case 1:
                    listarTodosLosEmpleados();
                    break;
                case 2:
                    buscarDatosDeUnEmpleado();
                    break;
                case 3:
                    consultaEmpleadosDeUnDepartamento();
                    break;
                default:
                    System.out.println("Error en opción introduce entre 0 y 1");
            }
        } while (opcion != 0);
    }

    //busca los datos de un empleado que se introduce por teclado
    public void buscarDatosDeUnEmpleado() {
        Scanner teclado=new Scanner(System.in);
        VOEmpleEmpresa voEmpleEmpresa = null;
        int emp_no;

        System.out.println("\n\nIntroduce e emp_no del empleado:");
        emp_no = teclado.nextInt();
        voEmpleEmpresa = daoEmpleEmpresa.buscarDatosEmpleado(emp_no);
        if (voEmpleEmpresa != null) {
            System.out.println(voEmpleEmpresa.toString());
            System.out.println("Su sueldo es " + daoEmpleEmpresa.calcularSueldo(voEmpleEmpresa));
        } else {
            System.out.println("No existe ese empleado");
        }
    }

    //lista todos los empleados
    public void listarTodosLosEmpleados() {
        VOEmple voEmple = null;
        VODepart voDepart = null;

        try {
            int totalEmpleados = 0;
            String sql = "select * from emple";

            ResultSet juegoResultados = daoEmpleEmpresa.devolverDatosConsulta(sql);

            //procesamos el juego de resultados
            System.out.println("\n EMP_NO\tAPELLIDO\tOFICIO\tJEFE\tFECHA_ALTA\tSALARIO\tCOMISION\tDEPART");
            while (juegoResultados.next()) {
                totalEmpleados++; //contabilizo
                //busco información del departamento 
                int dept_no = juegoResultados.getInt("dept_no");
                voDepart = daoDepart.buscarDatosUnDepartamento(dept_no);

                System.out.println(juegoResultados.getInt("emp_no")
                        + "\t" + juegoResultados.getString("apellido")
                        + "\t " + juegoResultados.getString("oficio")
                        + "\t  " + juegoResultados.getInt("dir")
                        + "\t" + juegoResultados.getDate("fecha_alt")
                        + "\t\t " + juegoResultados.getInt("salario")
                        + "\t" + juegoResultados.getInt("comision")
                        + "\t" + voDepart.toString());
            }
            System.out.println("\nTotal Empleados: " + totalEmpleados);
            juegoResultados.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladoraAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //lista todos los empleados de un departamento
    public void consultaEmpleadosDeUnDepartamento() {
        Scanner teclado=new Scanner(System.in);
        VOEmpleEmpresa voEmpleEmpresa = null;
        VODepart voDepart = null;
        int dept_no;
        ArrayList<VOEmpleEmpresa> empleadosDeUnDepart = new ArrayList<VOEmpleEmpresa>();

        try {
            GregorianCalendar fecha = null;
            System.out.println("\nIntroduce el número de departamento a consultar:");
            dept_no = teclado.nextInt();
            String sql = "select * from emple where dept_no=" + dept_no;

            //buscamos la información del departamento
            voDepart = daoDepart.buscarDatosUnDepartamento(dept_no);

            //información de los empleados de un departamento X
            ResultSet juegoResultados = daoEmpleEmpresa.devolverDatosConsulta(sql);

            //procesamos el juego de resultados cargandolo en la coleccion
            while (juegoResultados.next()) {
                               
                //genero el objeto empleado que añadiré a la coleccion
                voEmpleEmpresa = daoEmpleEmpresa.buscarDatosEmpleado(juegoResultados.getInt("emp_no"));
         
                //añadimos el objeto
                empleadosDeUnDepart.add(voEmpleEmpresa);
            }
            //una vez cargados todos los empleados de la consulta en la coleccion
            //los visualizo
            System.out.println("\n\nEmpleados del departamento: " + voDepart.toString());
            for (VOEmpleEmpresa v_emple : empleadosDeUnDepart) {
                System.out.println(v_emple.toString());
            }

            //una vez visualizados los grabamos en el fichero CSV
            grabarCSV_EmpleadosDeUnDepartamento(empleadosDeUnDepart);

            juegoResultados.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladoraAplicacion.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    //procedimiento que graba la coleccion de empleados de un depart en un csv
    public void grabarCSV_EmpleadosDeUnDepartamento(List<VOEmpleEmpresa> colec) {
        try {
            //grabarArchivoCSV(empleadosDeUnDepart,"empleadosDeUnDepart");
            String lineaAGrabar = null;
            VODepart voDepart;
            
            FileWriter fw = null;
            
            fw = new FileWriter("empleadosDeUnDepart.csv");
            
            for (VOEmpleEmpresa v_emple : colec) {
                System.out.println("Grabando...." + v_emple.toString());
                //preparamos la linea a grabar en el csv separando los campos por ,
                lineaAGrabar = v_emple.getEmple().getEmp_no()
                        + "," + v_emple.getEmple().getApellido()
                        + "," + v_emple.getOficio()
                        + "," + v_emple.getJefe().getEmp_no()
                        + "," + v_emple.verFecha()
                        + "," + v_emple.getSalario()
                        + "," + v_emple.getComision()
                        + "," + v_emple.getDepart().getDept_no()
                        + "," + v_emple.getDepart().getNomDepart()
                        + "," + v_emple.getDepart().getLocalidad()
                        + "\n";
                //preparada la linea grabo en el fichero
                System.out.println("linea a grabar: " + lineaAGrabar);
                fw.write(lineaAGrabar);
                System.out.println("Grabada");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(ControladoraAplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
