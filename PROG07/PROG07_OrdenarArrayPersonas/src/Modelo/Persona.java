package Modelo;

import java.io.Serializable;

public class Persona implements Serializable,Comparable<Persona> {

    // ATRIBUTOS
    private String nombre;
    private String apellidos;
    private int edad;

    // MÉTODOS
    // Getters + Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Constructor
    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    // toString
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }

    // compareTo sobreescrito para comparar por orden alfabético de apellidos y nombre ignorando mayúsculas/minúsculas
    @Override
    public int compareTo(Persona persona) {
        String apellidosNombre1 = apellidos + nombre;
        String apellidosNombre2 = persona.apellidos + persona.nombre;
        // compareTo de ambos strings devolverá -1,0,1 en función de si el stirng1
        // es menor,igual,mayor que el string 2. compareTo del objeto Persona hará los mismo
        int comparacion=apellidosNombre1.compareToIgnoreCase(apellidosNombre2);
        System.out.println("Comparación: "+comparacion
        );
        return comparacion;
    }
    
    // equals
    @Override
    public boolean equals(Object persona) {
        if (this == persona) {
            return true;
        }
        if (persona == null) {
            return false;
        }
        if (getClass() != persona.getClass()) {
            return false;
        }
        final Persona other = (Persona) persona;
        String apellidosNombre1 = apellidos + nombre;
        String apellidosNombre2 = other.getApellidos() + other.getNombre();
        
        return apellidosNombre1.equals(apellidosNombre2);
    }
    

}
