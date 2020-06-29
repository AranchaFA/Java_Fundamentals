package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
            System.out.println("Error al cerrar el ResultSet. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Generar un objeto individual desde un ResultSet
    public VOLibro generarUnVOLibro(ResultSet resultSet) {
        VOLibro voLibro = null;
        try {
            String cod_libro = resultSet.getString("COD_LIBRO");
            String titulo = resultSet.getString("TITULO");
            String autor = resultSet.getString("AUTOR");
            String tema = resultSet.getString("TEMA");
            double unidades = resultSet.getDouble("UNIDADES");

            voLibro = new VOLibro(cod_libro, titulo, autor, tema, unidades);
        } catch (SQLException ex) {
            System.out.println("Error al crear un libro. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voLibro;
    }

    public VOCD generarUnVOCD(ResultSet resultSet) {
        VOCD voCD = null;
        try {
            String cod_cd = resultSet.getString("COD_CD");
            String titulo = resultSet.getString("TITULO");
            String artista = resultSet.getString("ARTISTA");
            double anio = resultSet.getDouble("ANIO");

            voCD = new VOCD(cod_cd, titulo, artista, anio);
        } catch (SQLException ex) {
            System.out.println("Error al crear un cd. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voCD;
    }

    public VOSocio generarUnVOSocio(ResultSet resultSet) {
        VOSocio voSocio = null;
        try {
            double cod_socio = resultSet.getDouble("COD_SOCIO");
            String nombre = resultSet.getString("NOMBRE");
            String direccion = resultSet.getString("DIRECCION");
            String provincia = resultSet.getString("PROVINCIA");
            double tlf = resultSet.getDouble("TLF");

            voSocio = new VOSocio(cod_socio, nombre, direccion, provincia, tlf);
        } catch (SQLException ex) {
            System.out.println("Error al crear un socio. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voSocio;
    }

    
    // METEREMOS RESULTSET DE UNA CONSULTA TIPO SELECT * FROM PRESTAMOS
    // Del resultSet sacamos los códigos para generar los VO atributos y para
    // obtener el juego de resultados con todas las fechas para ese prestable-socio
    public VOPrestamo generarUnVOPrestamo(ResultSet resultSet) {
        VOPrestamo voPrestamo = null;
        PreparedStatement pStmt = null;
        ResultSet resultadoConsulta = null;
        // Necesitamos un DAO_BBDD para hacer las consultas y sacar los atributos objetos
        DAO_BBDD daoBBDD = new DAO_BBDD();
        VOSocio socioAtributo = generarUnVOSocio(resultSet);
        Prestable prestableAtributo = null;
        LinkedList<Date> fechasPrestamosAtributo=new LinkedList<>();
        
        try {
            double cod_socio = resultSet.getDouble("COD_SOCIO");
            String cod_elemento_prestado = resultSet.getString("COD_ELEMENTO_PRESTADO");

            // Tenemos que generar los atributos de tipo VO (Socio y Prestable),
            // para obtener sus datos tendremos que hacer dos consultas a la BBDD (claves "3X")
            
            // SOCIO
            pStmt = daoBBDD.obtenerPrepareStatement("33");
            // Asignamos el cod_socio al ? de la PreparedStatement
            pStmt.setDouble(1, cod_socio);
            resultadoConsulta = daoBBDD.ejecutarPrepareStatementSELECT(pStmt);

            // PRESTABLE
            // Hay que ver de qué tipo es según su cod
            if (cod_elemento_prestado.substring(0, 2).equalsIgnoreCase("IG")) {
                // LIBRO
                pStmt = daoBBDD.obtenerPrepareStatement("31");
                // Asignamos el cod_elemento_prestado al ? de la PreparedStatement
                pStmt.setString(1, cod_elemento_prestado);
                resultadoConsulta = daoBBDD.ejecutarPrepareStatementSELECT(pStmt);
                prestableAtributo = generarUnVOLibro(resultSet);
            } else {
                // CD
                pStmt = daoBBDD.obtenerPrepareStatement("32");
                // Asignamos el cod_elemento_prestado al ? de la PreparedStatement
                pStmt.setString(1, cod_elemento_prestado);
                resultadoConsulta = daoBBDD.ejecutarPrepareStatementSELECT(pStmt);
                prestableAtributo = generarUnVOCD(resultSet);
            }

            // Tenemos que generar el atributo tipo List (fechas_prestamos),
            // para obtenerlas hacemos una consulta a la BBDD (clave "41")
            
            pStmt = daoBBDD.obtenerPrepareStatement("41");
            // Asignamos el cod_socio y cod_elemento_prestado a las ? de la PreparedStatement
            pStmt.setDouble(1, cod_socio);
            pStmt.setString(2, cod_elemento_prestado);
            resultadoConsulta = daoBBDD.ejecutarPrepareStatementSELECT(pStmt);
            
            // Vamos leyendo los registros del ResultSet y añadiendo las fechas a la List
            while (resultadoConsulta.next()) {
                fechasPrestamosAtributo.add(resultadoConsulta.getDate(1));
            }
            
            voPrestamo = new VOPrestamo(socioAtributo, prestableAtributo, fechasPrestamosAtributo);
        } catch (SQLException ex) {
            System.out.println("Error al crear un préstamo. " + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        cerrarResultSet(resultSet);
        daoBBDD.cerrarPrepareStatement(pStmt);
        daoBBDD.cerrarConexion();
        
        return voPrestamo;
    }

     // Generar una colección con todos los registros de una tabla
    public HashMap<String, Prestable> coleccionDesdeResultSetLibro(ResultSet resultSet) {
        HashMap<String, Prestable> mapVOLibros = new HashMap<>();
        try {
            while (resultSet.next()) {
                VOLibro voLibro = generarUnVOLibro(resultSet);
                // Guardamos la clave EN MAYÚSCULAS
                mapVOLibros.put(voLibro.getCod_libro().toUpperCase(), voLibro);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de VOs desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapVOLibros;
    }
   
    public HashMap<String, Prestable> coleccionDesdeResultSetCD(ResultSet resultSet) {
        HashMap<String, Prestable> mapVOCD = new HashMap<>();
        try {
            while (resultSet.next()) {
                VOCD voCD = generarUnVOCD(resultSet);
                // Guardamos la clave EN MAYÚSCULAS
                mapVOCD.put(voCD.getCod_cd().toUpperCase(), voCD);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de VOs desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapVOCD;
    }
    
    public HashMap<String, VOPrestamo> coleccionDesdeResultSetPrestamo(ResultSet resultSet) {
        HashMap<String, VOPrestamo> mapVOPrestamo = new HashMap<>();
        try {
            while (resultSet.next()) {
                VOPrestamo voPrestamo= generarUnVOPrestamo(resultSet);
                // Guardamos la clave EN MAYÚSCULAS
                // De clave concatenamos cod_socio+cod_prestable
                String clave=String.valueOf(voPrestamo.getSocio().getCod_socio())+voPrestamo.getPrestable().obtenerCodigo().toUpperCase();
                mapVOPrestamo.put(clave, voPrestamo);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de VOs desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapVOPrestamo;
    }
 
    public HashMap<String, VOSocio> coleccionDesdeResultSetSocio(ResultSet resultSet) {
        HashMap<String, VOSocio> mapVOSocios = new HashMap<>();
        try {
            while (resultSet.next()) {
                VOSocio voSocio = generarUnVOSocio(resultSet);
                // Guardamos la clave EN MAYÚSCULAS
                mapVOSocios.put(String.valueOf(voSocio.getCod_socio()), voSocio);
            }
        } catch (SQLException ex) {
            System.out.println("Error al generar una colección de VOs desde un ResultSet." + ex.getMessage());
            Logger.getLogger(DAO_VOs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return mapVOSocios;
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
