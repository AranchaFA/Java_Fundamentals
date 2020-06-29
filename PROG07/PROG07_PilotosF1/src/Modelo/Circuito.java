package Modelo;

import java.util.List;

public class Circuito {

    // ATRIBUTOS
    private String nombre;
    private String locacalidad;
    private List<Piloto> listPilotos;

    // MÉTODOS
    // Setters + Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocacalidad() {
        return locacalidad;
    }

    public void setLocacalidad(String locacalidad) {
        this.locacalidad = locacalidad;
    }

    public List<Piloto> getListPilotos() {
        return listPilotos;
    }

    public void setListPilotos(List<Piloto> listPilotos) {
        this.listPilotos = listPilotos;
    }

    // toString

    @Override
    public String toString() {
        return "Circuito{" + "nombre=" + nombre + ", locacalidad=" + locacalidad + ", setPilotos=" + listPilotos + '}';
    }
    
    //Constructor
    public Circuito(String nombre, String locacalidad, List<Piloto> listPilotos) {
        this.nombre = nombre;
        this.locacalidad = locacalidad;
        this.listPilotos = listPilotos;
    }
    
}
