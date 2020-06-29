package Controlador;

import Modelo.DatosConexionBBDD;

public class MiMain {

    public static void main(String[] args) {

        MiControlador c = new MiControlador(new DatosConexionBBDD("localhost", "XE", "prog", "prog"));
        c.mostrarEmplesOrdenadosPorDepart();
        c.calcularSueldoEmpleado(7788);
    }

}
