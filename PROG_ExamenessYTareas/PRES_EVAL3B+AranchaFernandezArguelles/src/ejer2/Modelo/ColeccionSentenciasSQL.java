package ejer2.Modelo;

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
        
        // Obtener todos los datos de un programa (código en mayúsculas)
        sentenciasSQL.put("1", "SELECT * FROM PROGRAMAS WHERE UPPER(COD)=?");
        // Obtener los datos de todos los programas con un determinado nombre (mayús. o minús.)
        sentenciasSQL.put("2", "SELECT * FROM PROGRAMAS WHERE UPPER(NOMBRE)=?");
        // Contar el número de ventas que existen en la BBDD de un comercio y un programa (máximo 1)
        sentenciasSQL.put("3", "SELECT COUNT(*) FROM VENTAS_PROGRAMAS WHERE UPPER(CIF)=? AND UPPER(COD)=?");
        // Para insertar una nueva venta
        sentenciasSQL.put("4", "INSERT INTO VENTAS_PROGRAMAS VALUES (?,?,?)");
        // Para actualizar una venta
        sentenciasSQL.put("5", "UPDATE VENTAS_PROGRAMAS SET CANTIDAD=? WHERE UPPER(CIF)=? AND UPPER(COD)=?");
        // Cargar toda la colecicón de programas para visualizarla en la venta
        sentenciasSQL.put("6", "SELECT * FROM PROGRAMAS");
        
    }

}
