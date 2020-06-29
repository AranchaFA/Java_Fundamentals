package BBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;


public class ColeccionSentenciasSQL {

    // ATRIBUTOS
    // Colección de PrepareStatement que se usarán en las consultas 
    // Accederemos a ellas por un índice "11", "12",...
    private HashMap<String, String> sentenciasSQL;
    // Tipo de ResultSet devuelto
    int tipoResultado = ResultSet.TYPE_SCROLL_SENSITIVE;
    int tipoActualizacion = ResultSet.CONCUR_UPDATABLE;

    // MÉTODOS
    // Getters + Setters 
    public HashMap<String, String> getSentenciasSQL() {
        return sentenciasSQL;
    }

    public void setSentenciasSQL(HashMap<String, String> sentenciasSQL) {
        this.sentenciasSQL = sentenciasSQL;
    }

    public int getTipoResultado() {
        return tipoResultado;
    }

    public void setTipoResultado(int tipoResultado) {
        this.tipoResultado = tipoResultado;
    }

    public int getTipoActualizacion() {
        return tipoActualizacion;
    }

    public void setTipoActualizacion(int tipoActualizacion) {
        this.tipoActualizacion = tipoActualizacion;
    }

    // toString
    @Override
    public String toString() {
        return "PreparedStatementsSQL{" + "sentenciasSQL=" + sentenciasSQL + ", tipoResultado=" + tipoResultado + ", tipoActualizacion=" + tipoActualizacion + '}';
    }

    // Constructor (CON LOS DATOS ESPECÍFICOS DE CADA APLICACIÓN)
    // Le pasaremos la conexión creada por el DAO_BBDD para generar las PStmt
    public ColeccionSentenciasSQL(Connection conexion) {
        this.sentenciasSQL = new HashMap<>();
        // Obtener todos los datos de una tabla
        sentenciasSQL.put("11", "SELECT * FROM LIBROS");
        sentenciasSQL.put("12", "SELECT * FROM CD");
        sentenciasSQL.put("13", "SELECT * FROM DVD");
        sentenciasSQL.put("14", "SELECT * FROM PERIODICOS");
        // Contar los registros de una tabla
        sentenciasSQL.put("21", "SELECT COUNT(*) FROM LIBROS");
        sentenciasSQL.put("22", "SELECT COUNT(*) FROM CD");
        sentenciasSQL.put("23", "SELECT COUNT(*) FROM DVD");
        sentenciasSQL.put("24", "SELECT COUNT(*) FROM PERIODICOS");
        // Seleccionar un registro ? de una tabla
        sentenciasSQL.put("31", "SELECT * FROM LIBROS WHERE COD_LIBRO = ?");
        sentenciasSQL.put("32", "SELECT * FROM CD WHERE ID_CD = ?");
        sentenciasSQL.put("33", "SELECT * FROM DVD WHERE ID_DVD = ?");
        sentenciasSQL.put("34", "SELECT * FROM PERIODICOS WHERE COD_PRESS = ?");
        // Eliminar un registro ? de una tabla
        sentenciasSQL.put("41", "DELETE FROM LIBROS WHERE COD_LIBRO = ?");
        sentenciasSQL.put("42", "DELETE FROM CD WHERE ID_CD = ?");
        sentenciasSQL.put("43", "DELETE FROM DVD WHERE ID_DVD = ?");
        sentenciasSQL.put("44", "DELETE FROM PERIODICOS WHERE COD_PRESS = ?");
    }

}
