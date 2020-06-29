package Modelo;

import java.util.Date;

public class VOPeriodico implements Producto{

    // ATRIBUTOS
    private String cod_press;
    private String nom_periodico;
    private float precio;

    // MÉTODOS
    // Getters + Setters
    public String getCod_press() {
        return cod_press;
    }

    public void setCod_press(String cod_press) {
        this.cod_press = cod_press;
    }

    public String getNom_periodico() {
        return nom_periodico;
    }

    public void setNom_periodico(String nom_periodico) {
        this.nom_periodico = nom_periodico;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // toString
    @Override
    public String toString() {
        return "Periodico{" + "cod_press=" + cod_press + ", nom_periodico=" + nom_periodico + ", precio=" + precio + '}';
    }

    // Constructores
    public VOPeriodico(String cod_press, float precio) {
        this.cod_press = cod_press;
        this.precio = precio;
    }

    public VOPeriodico(String cod_press, String nom_periodico, float precio) {
        this.cod_press = cod_press;
        this.nom_periodico = nom_periodico;
        this.precio = precio;
    }

    @Override
    public float calcularCoste() {
        return this.precio;
    }

}
