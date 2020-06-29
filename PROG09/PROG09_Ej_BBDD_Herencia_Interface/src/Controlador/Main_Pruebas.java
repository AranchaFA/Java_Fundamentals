
package Controlador;

import Modelo.*;

public class Main_Pruebas {

    public static void main(String[] args) {
        
        
        // Creamos controlador con nuestros datos de conexión
        DatosConexionBBDD datosConexion = new DatosConexionBBDD("localhost","XE","MAQUINA","MAQUINA");
        MaquinaControladora controladora=new MaquinaControladora(datosConexion);
        
        // Ejecutamos el menú
        controladora.menu();
    }
    
}
