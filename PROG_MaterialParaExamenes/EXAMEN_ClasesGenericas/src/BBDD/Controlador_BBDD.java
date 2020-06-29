package BBDD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_BBDD {

    // ATRIBUTOS
    private DAO_BBDD daoBBDD;
    private DAO_VOs daoVO;
    private HashMap<String, Clase> coleccion; // Si la manda hacer
    private HashMap<String, HashMap> coleccion2; // Si la manda hacer

    // MÉTODOS
    // Getter + Setter
    public DAO_BBDD getDaoBBDD() {
        return daoBBDD;
    }

    public void setDaoBBDD(DAO_BBDD daoBBDD) {
        this.daoBBDD = daoBBDD;
    }

    public DAO_VOs getDaoVO() {
        return daoVO;
    }

    public void setDaoVO(DAO_VOs daoVO) {
        this.daoVO = daoVO;
    }

    public HashMap<String, Clase> getColeccion() {
        return coleccion;
    }

    public void setColeccion(HashMap<String, Clase> coleccion) {
        this.coleccion = coleccion;
    }

    // toString
    @Override
    public String toString() {
        return "Controlador_BBDD{" + "daoBBDD=" + daoBBDD + ", daoVO=" + daoVO + ", coleccion=" + coleccion + '}';
    }

    // Constructor
    public Controlador_BBDD() {
        this.daoBBDD = new DAO_BBDD();
        this.daoVO = new DAO_VOs();
        this.coleccion = new HashMap<>();
        this.coleccion2 = new HashMap<>();
        // Cargamos toda la información de la BBDD al arrancar la aplicación
        generarColeccion();
        generarColeccion2();
    }

    
    ///////////////////////////////////////////////////////////
    // CARGAR COLECCIÓN DESDE BBDD
    ///////////////////////////////////////////////////////////
    
    // Cargar colección desde la BBDD (se carga automáticamente al crear el Controlador)
    // (Map sencillo)
    public void generarColeccion() {
        // 1) Sacamos ResultSets de cada tabla con las consultas del Map de sentencias SQL (DAO_BBDD)
        // 2) Generamos un map con cada ResultSet (DAO_VOs) y los añadimos al Map del controlador

        // Vamos a usar:
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;

        // Las PreparedStmt para sacar todos los datos de las tablas son las "1X"       
        // Vamos asignando la psmts para cada tabla, generando la coleccion a partir de cada ResultSet
        // y cargando cada colección generada a la colección del controlador
        pstmtSQL = this.daoBBDD.obtenerPrepareStatement(CLAVE_QUE_TOQUE); // METER CLAVE
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        // En este caso, la colección añadida actúa como UN CONJUNTO DE OBJETOS añadidos al Map
        this.coleccion.putAll(daoVO.coleccionDesdeResultSetVOObjeto(resultSet));

        // Repetimos lo anterior para todos los diferentes tipos de VOObjetos
        
        
        daoVO.cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pstmtSQL);
    }

    // Cargar colección desde la BBDD (se carga automáticamente al crear el Controlador)
    // (Map con subMaps)
    public void generarColeccion2() {
        // 1) Sacamos ResultSets de cada tabla con las consultas del Map de sentencias SQL (DAO_BBDD)
        // 2) Generamos un map con cada ResultSet (DAO_VOs) y los añadimos al Map del controlador

        // Vamos a usar:
        PreparedStatement pstmtSQL = null;
        ResultSet resultSet = null;

        // Las PreparedStmt para sacar todos los datos de las tablas son las "1X"       
        // Vamos asignando la psmts para cada tabla, generando la coleccion a partir de cada ResultSet
        // y cargando cada colección generada a la colección del controlador
        pstmtSQL = this.daoBBDD.obtenerPrepareStatement(CLAVE_QUE_TOQUE); // METER CLAVE
        resultSet = daoBBDD.ejecutarPrepareStatementSELECT(pstmtSQL);
        // En este caso, la colección añadida actúa como UN ÚNICO OBJETO añadido al Map
        this.coleccion.put(CLAVE_ParaEstaSubColeccion, daoVO.coleccionDesdeResultSetVOObjeto(resultSet));

        // Repetimos lo anterior para todos los diferentes tipos de VOObjetos
        
        
        daoVO.cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pstmtSQL);
    }

    
    ///////////////////////////////////////////////////////////
    // CONTAR OBJETOS DE CADA TIPO
    ///////////////////////////////////////////////////////////
    
    // Contar cuántos objetos hay de un tipo  (HAY QUE HACER UNO PARA CADA TIPO DE VO)
    // (Map sencillo)
    public int cantidadDeVOObjetosUnTipo() {
        int cantidad = 0;
        for (VOObjeto voObjeto : coleccion) {
            if (voObjeto instanceof TipoVOObjetoQueCorresponda) {
                cantidad++;
            }
        }
        return cantidad;
    }
    
    // Contar cuántos objetos hay de un tipo  (HAY QUE HACER UNO PARA CADA TIPO DE VO)
    // (Map de subMaps)
    // PODRÍAMOS PASAR LA CLAVE_DEL_MAP_DEL_TIPO_DE_VO_QUE_PROCEDA POR PARÁMETRO
    public int cantidadDeVOObjetosUnTipo2() {
        return coleccion2.get(CLAVE_DEL_MAP_DEL_TIPO_DE_VO_QUE_PROCEDA).size(); 
    }

    
    ///////////////////////////////////////////////////////////
    // BUSCAR UN REGISTRO EN LA BBDD
    ///////////////////////////////////////////////////////////
    // Hecho en la máquina expendedora, no lo copio porque sería más
    // cómodo sacarlo de la colección: public VOObjeto buscarUnVOObjeto(keyDelVOObjeto)
    
    
    ///////////////////////////////////////////////////////////
    // BORRAR UN REGISTRO DE LA BBDD / MAP
    ///////////////////////////////////////////////////////////
    
    // Borrar un registro de la BBDD
    // Hay que hacer un método por cada tipo de VO que tengamos
    public int borrarUnVOObjetoBBDD(String codigo) {
        PreparedStatement pstmt = null;
        int filasEliminadas = 0;

        // Para borrar un VOObjeto el PStmt es el "XXXX"
        pstmt = daoBBDD.obtenerPrepareStatement(CLAVE_QUE_TOQUE);
        // Hay que "cargar" la PStmt con el codigo elegido
        // Si no es de tipo String en la tabla hay que castearlo
        pstmt.setString(posicion, codigo.toUpperCase());
        pstmt.setFloat(posicion, codigo.toUpperCase());
        // Es una PStmt NO SELECT
        filasEliminadas = daoBBDD.ejecutarPrepareStatementNOSELECT(pstmt);
         
        daoBBDD.cerrarPrepareStatement(pstmt);
        return filasEliminadas;
    }
    
    
    // Borrar un registro de la colección general (es común a todos los tipos de VO)
    // (Map sencillo)
    public VOObjeto borrarUnVOObjetoMap(String codigo) {
        VOObjeto voObjetoEliminado = null;

        voObjetoEliminado = coleccion.remove(codigo.toUpperCase());
        
        return voObjetoEliminado;
    }
    
    // Borrar un registro de la colección general (es común a todos los tipos de VO)
    // (Map con subMaps)
    public VOObjeto borrarUnVOObjetoMap(String codigoVO,String codigoMap) {
        VOObjeto voObjetoEliminado = null;

        voObjetoEliminado = coleccion2.get(codigoMap).remove(codigoVO.toUpperCase());
        
        return voObjetoEliminado;
    }
    
    
    // COMPROBAR SI EXISTE UN REGISTRO EN LA BBDD
    public boolean existeRegistro(String codigo){
        boolean existe;
        int numRegistros=0;
        
        PreparedStatement pstmt = null;
        ResultSet resultSet=null;
            
        // Usaremos, de la colección de sentenciasSQL, una de tipo 
        // SELECT COUNT(*) FROM tabla WHERE codigo=?
        pstmt=daoBBDD.obtenerPrepareStatement(CLAVE_QUE_CORRESPONDA);
        // Asignamos los valores del ?
        pstmt.setString(1, codigo);
        resultSet=daoBBDD.ejecutarPrepareStatementSELECT(pstmt);
        numRegistros=daoVO.extraerValorNumericoConsulta(resultSet);
        if (numRegistros>0) {
            existe=true;
        } else {
            existe=false;
        }
            
        daoVO.cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pstmt);
        
        return existe;
    }
    
    
    // MÉTODO PARA HACER UN INSERT INTO .....
    // Irían en el cntrolador si pedimos los datos a insertar por teclado,
    // si se pusiera en el DAO_BBDD habría que pasar los datos por parámetro   
    public void insertarRegistroEnBBDD(ParametrosNecesariosParaLos_???) {
        // Si hay que devolver el nº de filas insertadas
        // int filasModificadas=0;

        PreparedStatement pStmt = null;

        try {
            // Usamos la sentenciaSQL "XX"
            pStmt = daoBBDD.obtenerPrepareStatement(CLAVE_QUE_CORRESPONDA);
            // Asignamos los valores a insertar a las ? de la pStmt
            pStmt.setDouble(posicion, parametroDouble);
            pStmt.setString(posicion, parametroString);
            // Si pasamos una fecha como parámetro, o la obtenemos de otro sitio
            pStmt.setDate(posicion, parametroDate);
            // Si tenemos que insertar la fecha del sistema
            // El objeto Date al crearse ya coge el valor de la fecha del sistema en ese momento
            pStmt.setDate(3, (java.sql.Date) new Date());

            daoBBDD.ejecutarPrepareStatementNOSELECT(pStmt);
        } catch (SQLException ex) {
            System.out.println("Error al insertar un registro en la BBDD. "+ex.getMessage());
            Logger.getLogger(Controlador_BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        daoBBDD.cerrarPrepareStatement(pStmt);
        
        return nuevo;
    }
    
    
    // MÉTODO PARA HACER UN UPDATE .....
    // Irían en el cntrolador si pedimos los datos a insertar por teclado,
    // si se pusiera en el DAO_BBDD habría que pasar los datos por parámetro,
    // también iría en el DAO_BBDD si fuera una actualización "fija"
}

