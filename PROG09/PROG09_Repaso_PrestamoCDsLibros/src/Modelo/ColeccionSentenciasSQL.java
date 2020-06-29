package Modelo;

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
        return "ColeccionSentenciasSQL{" + "sentenciasSQL=" + sentenciasSQL + ", tipoResultado=" + tipoResultado + ", tipoActualizacion=" + tipoActualizacion + '}';
    }

    // Constructor (CON LOS DATOS ESPECÍFICOS DE CADA APLICACIÓN)
    // Le pasaremos la conexión creada por el DAO_BBDD para generar las PStmt
    public ColeccionSentenciasSQL(Connection conexion) {
        this.sentenciasSQL = new HashMap<>();
        // Grabar en la base de datos un nuevo préstamo
        sentenciasSQL.put("11", "INSERT INTO PRESTAMOS VALUES(?,?,?)");
        
        // Para generar las colecciones de cada tabla
        // Obtener todos los datos de cada tabla
        sentenciasSQL.put("21", "SELECT * FROM LIBROS");
        sentenciasSQL.put("22", "SELECT * FROM CD");
        sentenciasSQL.put("23", "SELECT * FROM SOCIOS");
        sentenciasSQL.put("24", "SELECT * FROM PRESTAMOS");
        
        // Para generar los atributos VO de los Prestamo 
        // (necesitamos el resgistro en concreto del Prestable y el Socio)
        // Obtener los datos de un registro (Socio,CD o Libro)
        sentenciasSQL.put("31", "SELECT * FROM LIBROS WHERE COD_LIBRO=?");
        sentenciasSQL.put("32", "SELECT * FROM CD WHERE COD_CD=?");
        sentenciasSQL.put("33", "SELECT * FROM SOCIOS WHERE COD_SOCIO=?");
        
        // Para generar la lista de fechas de los Prestamo
        // Obtener todas las fechas de los préstamos con igual socio y libro
        sentenciasSQL.put("41", "SELECT FECHA_PRESTAMOS FROM PRESTAMOS WHERE COD_SOCIO=? AND COD_ELEMENTO_PRESTADO=?");
    }

}
