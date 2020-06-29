package Controlador;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.Leer;

public class MainAlumno {

    public static void main(String[] args) {
        
        // Creamos un alumno con nombre introducido por teclado
        Leer teclado=new Leer();
        System.out.println("Introduzca el nombre del alumno: ");
        Alumno alum1=new Alumno(teclado.leerDato());
        // Creamos dos asignaturas
        Asignatura asig1=new Asignatura("PROGRAMACIÓN");
        Asignatura asig2=new Asignatura("BBDD");
        // Las pasamos al alumno
        alum1.setAsig1(asig1);
        alum1.setAsig2(asig2);
        
    }

}
