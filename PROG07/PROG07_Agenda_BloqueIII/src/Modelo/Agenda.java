package Modelo;

import java.util.Map;
import java.util.TreeMap;

public class Agenda {

    // ATRIBUTOS
    private Map<String, Contacto> agenda;

    
    // MÉTODOS
    // Getter + Setter
    public void setAgenda(Map<String, Contacto> agenda) {
        this.agenda = agenda;
    }

    public Map<String, Contacto> getAgenda() {
        return agenda;
    }
    
    // toString

    @Override
    public String toString() {
        return "Agenda{" + "agenda=" + agenda + '}';
    }
    

    // Constructor
    public Agenda() {
        agenda = new TreeMap<>();
    }

    // AÑADIR un contacto, devuelve el contacto que había asociado a esa key 
    // en caso de existir, null si no existía
    public Contacto anhadirUnContacto(Contacto contactoAAnhadir){
        return agenda.put(contactoAAnhadir.getNombrePila(), contactoAAnhadir);
    }
    
    // BORRAR un contacto
    public void borrarUnContacto(Contacto contactoABorrar){
        // Remove pasando por parámetro el ÍNDICE, que puede ser de cualquier
        // tipo, por eso en la API aparece como Object key!!!
        agenda.remove(contactoABorrar.getNombrePila());
    }
    public void borrarUnContactoPorNombre(String nombrePila){
        // Remove pasando por parámetro el ÍNDICE, que puede ser de cualquier
        // tipo, por eso en la API aparece como Object key!!!
        agenda.remove(nombrePila);
    }
    
    // BUSCAR un contacto (null si no existe en la colección)
    // Es KEY SENSITIVE porque busca y compara la clave, que es un String,
    // y usa para ello el equals de la clase String que diferencia mayúsc./minúsc.
    public Contacto buscarUnContacto(Contacto contactoABuscar){
        // GET pasando por parámetro el ÍNDICE, que puede ser de cualquier
        // tipo, por eso en la API aparece como Object key!!!
        return agenda.get(contactoABuscar.getNombrePila());
    }
     public Contacto buscarUnContactoPorNombre(String nombrePila){
        // GET pasando por parámetro el ÍNDICE, que puede ser de cualquier
        // tipo, por eso en la API aparece como Object key!!!
        return agenda.get(nombrePila);
    }
     
     // TAMAÑO de la colección
    public int tamanhoColeccion(){
        return agenda.size();
    }
}
