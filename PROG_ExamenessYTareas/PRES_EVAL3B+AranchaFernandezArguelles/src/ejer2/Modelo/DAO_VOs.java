package ejer2.Modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_VOs {

    // ATRIBUTOS
    // Este DAO no va a acceder a la BBDD
    
    
    // MÉTODOS
    // Constructor (por defecto)
    public DAO_VOs() {
    }
    
    // CERRAR RESULTSET
    public void cerrarResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar el ResultSet. "+ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // GENERAR UN VOOBJETO INDIVIDUAL A PARTIR DE UN RESULTSET
    public VOPrograma generarUnPrograma(ResultSet resultSet) {
        VOPrograma programa = null;
        try {
            String cod = resultSet.getString("COD");
            String nombre = resultSet.getString("NOMBRE");
            String version = resultSet.getString("VERSION");

            programa = new VOPrograma(cod, nombre, version);
        } catch (SQLException ex) {
            System.out.println("Error al crear un Programa. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programa;
    }


    // GENERAR COLECCIÓN DE VOOBJETOS A PARTIR DE UN RESULTSET
    public HashMap<String, VOPrograma> coleccionDesdeResultSetProgramas(ResultSet resultSet) {
        HashMap<String, VOPrograma> mapProgramas = new HashMap<>();
        try {
            while (resultSet.next()) {
                VOPrograma programa = generarUnPrograma(resultSet);
                // Guardamos la clave EN MAYÚSCULAS
                mapProgramas.put(programa.getCod().toUpperCase(), programa);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de Programas desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapProgramas;
    }


    // EXTRAER EL VALOR DE UN RESULT SET DE UNA CONSULTA QUE DEVUELVE UN VALOR NUMÉRICO ( COUNT() )
    // (No la usaremos si sacamos la cantidad desde una colección)
    public int extraerValorNumericoConsulta(ResultSet resultSet) {
        int resultado = 0;
        try {
            resultSet.next();
            resultado = resultSet.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Error al extraer el valor numérico de un ResultSet. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

}
