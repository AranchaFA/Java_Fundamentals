package Modelo;

import java.io.Serializable;

public class Opositor implements Serializable {

    // ATRIBUTOS
    private Persona persona;
    private int r1, r2, r3, r4, r5, r6, r7; // Se medirá sobre 100, así que pongo int

    // MÉTODOS
    // Getters + Setters
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public int getR3() {
        return r3;
    }

    public void setR3(int r3) {
        this.r3 = r3;
    }

    public int getR4() {
        return r4;
    }

    public void setR4(int r4) {
        this.r4 = r4;
    }

    public int getR5() {
        return r5;
    }

    public void setR5(int r5) {
        this.r5 = r5;
    }

    public int getR6() {
        return r6;
    }

    public void setR6(int r6) {
        this.r6 = r6;
    }

    public int getR7() {
        return r7;
    }

    public void setR7(int r7) {
        this.r7 = r7;
    }

    // Constructor (como vamos a crear el objeto con todos sus resultados pasaré
    // todos los atributos por parámetro para este caso, pero sería más lógico
    // pasar sólo la persona y poder asignar los resultados con setters)

    public Opositor(Persona persona, int r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        this.persona = persona;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.r5 = r5;
        this.r6 = r6;
        this.r7 = r7;
    }

    @Override
    public String toString() {
        return "Opositor{" + "persona=" + persona + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3 + ", r4=" + r4 + ", r5=" + r5 + ", r6=" + r6 + ", r7=" + r7 + '}';
    }
    
    public int calcularMedia(){
        // La devolvemos redondeada como entero
        int media=(r1+r2+r3+r4+r5+r6+r7)/7;
        return media;
    }
    
}
