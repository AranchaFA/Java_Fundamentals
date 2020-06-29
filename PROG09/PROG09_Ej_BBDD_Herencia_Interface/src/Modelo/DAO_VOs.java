package Modelo;

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
    // Constructor por defecto
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

    // GENERAR LOS DISTINTOS TIPOS DE OBJETOS CON QUE TRABAJAREMOS (UN OBJETO INDIVIDUAL)
    // A partir de un ResultSet obtenido de una consulta
    public VOLibro generarUnLibro(ResultSet resultSet) {
        VOLibro voLibro = null;
        try {
            String cod_libro = resultSet.getString("COD_LIBRO");
            String titulo = resultSet.getString("TITULO");
            String autor = resultSet.getString("AUTOR");
            String tema = resultSet.getString("TEMA");
            float precio = resultSet.getFloat("PRECIO");

            voLibro = new VOLibro(cod_libro, titulo, autor, tema, precio);
        } catch (SQLException ex) {
            System.out.println("Error al crear un libro. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voLibro;
    }

    public VOCD generarUnCD(ResultSet resultSet) {
        VOCD voCD = null;
        try {
            String id_cd = resultSet.getString("ID_CD");
            String nom_album = resultSet.getString("NOM_ALBUM");
            String artista = resultSet.getString("ARTISTA");
            Date anio = resultSet.getDate("ANIO");
            float precio = resultSet.getFloat("PRECIO");

            voCD = new VOCD(id_cd, nom_album, artista, anio, precio);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voCD;
    }

    public VODVD generarUnDVD(ResultSet resultSet) {
        VODVD voDVD = null;
        try {
            String id_dvd = resultSet.getString("ID_DVD");
            String nom_dvd = resultSet.getString("NOM_DVD");
            String director = resultSet.getString("DIRECTOR");
            String genero = resultSet.getString("GENERO");
            Date anio = resultSet.getDate("ANIO");
            float precio = resultSet.getFloat("PRECIO");

            voDVD = new VODVD(id_dvd, nom_dvd, director, genero, anio, precio);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voDVD;
    }

    public VOPeriodico generarUnPeriodico(ResultSet resultSet) {
        VOPeriodico voPeriodico = null;
        try {
            String cod_press = resultSet.getString("COD_PRESS");
            String nom_periodico = resultSet.getString("NOM_PERIODICO");
            float precio = resultSet.getFloat("PRECIO");

            voPeriodico = new VOPeriodico(cod_press, nom_periodico, precio);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voPeriodico;
    }
    // No lo uso al final
    public Producto generarUnProducto(ResultSet resultSet, String nombreTabla) {
        Producto productoGenerado = null;

        if (nombreTabla.equalsIgnoreCase("LIBROS")) {
            productoGenerado = generarUnLibro(resultSet);
        } else if (nombreTabla.equalsIgnoreCase("CD")) {
            productoGenerado = generarUnCD(resultSet);
        } else if (nombreTabla.equalsIgnoreCase("DVD")) {
            productoGenerado = generarUnDVD(resultSet);
        } else if (nombreTabla.equalsIgnoreCase("PERIÓDICOS")) {
            productoGenerado = generarUnPeriodico(resultSet);
        }

        return productoGenerado;
    }

    // GENERAR COLECCIONES A PARTIR DE LOS DISTINTOS RESULTSET CON TODOS LOS DATOS DE LOS REGISTROS DE CADA TABLA DE LA BBDD
    public HashMap<String, Producto> coleccionDesdeResultSetLibros(ResultSet resultSetLibros) {
        HashMap<String, Producto> mapLibros = new HashMap<>();
        try {
            while (resultSetLibros.next()) {
                VOLibro libro = generarUnLibro(resultSetLibros);
                mapLibros.put(libro.getCod_libro(), libro);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de libros desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapLibros;
    }

    public HashMap<String, Producto> coleccionDesdeResultSetCDs(ResultSet resultSetCDs) {
        HashMap<String, Producto> mapCDs = new HashMap<>();
        try {
            while (resultSetCDs.next()) {
                VOCD cd = generarUnCD(resultSetCDs);
                mapCDs.put(cd.getId_cd(), cd);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de CDs desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapCDs;
    }

    public HashMap<String, Producto> coleccionDesdeResultSetDVDs(ResultSet resultSetDVDs) {
        HashMap<String, Producto> mapDVDs = new HashMap<>();
        try {
            while (resultSetDVDs.next()) {
                VODVD dvd = generarUnDVD(resultSetDVDs);
                mapDVDs.put(dvd.getId_dvd(), dvd);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de DVDs desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapDVDs;
    }

    public HashMap<String, Producto> coleccionDesdeResultSetPeriodicos(ResultSet resultSetPeriodicos) {
        HashMap<String, Producto> mapPeriodicos = new HashMap<>();
        try {
            while (resultSetPeriodicos.next()) {
                VOPeriodico periodico = generarUnPeriodico(resultSetPeriodicos);
                mapPeriodicos.put(periodico.getCod_press(), periodico);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de periodicos desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapPeriodicos;
    }
    // No lo uso al final
    public HashMap<String, Producto> coleccionDesdeResultSetProductos(ResultSet resultSetProductos, String nombreTabla) {
        HashMap<String, Producto> mapProductos = new HashMap<>();

        if (nombreTabla.equalsIgnoreCase("LIBROS")) {
            mapProductos = coleccionDesdeResultSetLibros(resultSetProductos);
        } else if (nombreTabla.equalsIgnoreCase("CD")) {
            mapProductos = coleccionDesdeResultSetCDs(resultSetProductos);
        } else if (nombreTabla.equalsIgnoreCase("DVD")) {
            mapProductos = coleccionDesdeResultSetDVDs(resultSetProductos);
        } else if (nombreTabla.equalsIgnoreCase("PERIÓDICOS")) {
            mapProductos = coleccionDesdeResultSetPeriodicos(resultSetProductos);
        }
        
        return mapProductos;
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
