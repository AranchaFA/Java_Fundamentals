
package EJER3_y_4;

import java.sql.ResultSet;


public class main {

    
    public static void main(String[] args) {
       
        
        logica_aplicacion l=new logica_aplicacion();
        
        l.conectar("BELTHOR","belthor");
        // ejercicio 3--MOSTRAR DATOS  INTRODUCIENDO UN DNI QUE DEVUELVA EL EMPLEADO Y LA EMPRESA DE ESE EMPLEADO
       ResultSet r=l.prepare_statement_sentencia_empleados("12030430");
        l.mostrar_datos_emple(r);
        //ejercicio4-cargar en coleccion
        ResultSet r2=l.prepare_statement_sentencia_empleados_EJER4("13000000J");
       l.CARGAR_COLECCION(r2);
       l.visualizar_extructura();
        
    }
    
}
