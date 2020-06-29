package BBDD;

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
    public VOObjeto generarUnVOObjeto(ResultSet resultSet) {
        VOObjeto voObjeto = null;
        try {
            String atributoString = resultSet.getString("NOMBRE_CAMPO");
            float precio = resultSet.getFloat("NOMBRE_CAMPO");

            voObjeto = new VOObjeto(stributoString,atributoFloat);
        } catch (SQLException ex) {
            System.out.println("Error al crear un VO. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voObjeto;
    }


    // GENERAR COLECCIÓN DE VOOBJETOS A PARTIR DE UN RESULTSET
    public HashMap<String, Interface> coleccionDesdeResultSetVOObjeto(ResultSet resultSet) {
        HashMap<String, Interface> mapVOObjetos = new HashMap<>();
        try {
            while (resultSet.next()) {
                VOObjeto voObjeto = generarUnVOObjeto(resultSet);
                // Guardamos la clave EN MAYÚSCULAS
                mapLibros.put(voObjeto.getAtributoIdentificador().toUpperCase(), voObjeto);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de VOs desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapVObjetos;
    }


    // EXTRAER EL VALOR DE UN RESULT SET DE UNA CONSULTA QUE DEVUELVE UN VALOR NUMÉRICO ( COUNT() )
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
