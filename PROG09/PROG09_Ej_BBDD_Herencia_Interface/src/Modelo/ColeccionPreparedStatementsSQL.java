package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColeccionPreparedStatementsSQL {

    // ATRIBUTOS
    // Colección de PrepareStatement que se usarán en las consultas 
    // Accederemos a ellas por un índice "11", "12",...
    private HashMap<String, PreparedStatement> sentenciasSQL;
    // Tipo de ResultSet devuelto
    int tipoResultado = ResultSet.TYPE_SCROLL_SENSITIVE;
    int tipoActualizacion = ResultSet.CONCUR_UPDATABLE;

    // MÉTODOS
    // Getters + Setters 
    public HashMap<String, PreparedStatement> getSentenciasSQL() {
        return sentenciasSQL;
    }

    public void setSentenciasSQL(HashMap<String, PreparedStatement> sentenciasSQL) {
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
    public ColeccionPreparedStatementsSQL(Connection conexion) {
        this.sentenciasSQL = new HashMap<>();
        // Cargamos en la colección de sentencias SQL aquellas que se usarán en la aplicación
        // Ponemos el tipo de resultado y el tipo de iteración que queremos para el resultSet devuelto
        try {
            // Obtener todos los datos de una tabla
            sentenciasSQL.put("11", conexion.prepareStatement("SELECT * FROM LIBROS",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("12", conexion.prepareStatement("SELECT * FROM CD",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("13", conexion.prepareStatement("SELECT * FROM DVD",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("14", conexion.prepareStatement("SELECT * FROM PERIODICOS",tipoResultado,tipoActualizacion));
            // Contar los registros de una tabla 
            sentenciasSQL.put("21", conexion.prepareStatement("SELECT COUNT(*) FROM LIBROS",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("22", conexion.prepareStatement("SELECT COUNT(*) FROM CD",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("23", conexion.prepareStatement("SELECT COUNT(*) FROM DVD",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("24", conexion.prepareStatement("SELECT COUNT(*) FROM PERIODICOS",tipoResultado,tipoActualizacion));
            // Seleccionar un registro ? de una tabla 
            sentenciasSQL.put("31", conexion.prepareStatement("SELECT * FROM LIBROS WHERE COD_LIBRO = ?",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("32", conexion.prepareStatement("SELECT * FROM CD WHERE ID_CD = ?",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("33", conexion.prepareStatement("SELECT * FROM DVD WHERE ID_DVD = ?",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("34", conexion.prepareStatement("SELECT * FROM PERIODICOS WHERE COD_PRESS = ?",tipoResultado,tipoActualizacion));
            // Eliminar un registro ? de una tabla
            sentenciasSQL.put("41", conexion.prepareStatement("DELETE FROM LIBROS WHERE COD_LIBRO = ?",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("42", conexion.prepareStatement("DELETE FROM CD WHERE ID_CD = ?",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("43", conexion.prepareStatement("DELETE FROM DVD WHERE ID_DVD = ?",tipoResultado,tipoActualizacion));
            sentenciasSQL.put("44", conexion.prepareStatement("DELETE FROM PERIODICOS WHERE COD_PRESS = ?",tipoResultado,tipoActualizacion));
        } catch (SQLException ex) {
            System.out.println("Error al generar la colección de PrepareStatement");
            Logger.getLogger(ColeccionPreparedStatementsSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
