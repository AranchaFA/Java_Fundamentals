package Modelo;

public class Carta implements Comparable<Carta>{

    // ATIBUTOS
    private String dibujo;
    private char palo;
    private int valor;
    private String nombreFicheroImagen;

    // MÉTODOS
    // Getters + Setters
    public String getDibujo() {
        return dibujo;
    }

    public void setDibujo(String dibujo) {
        this.dibujo = dibujo;
    }

    public char getPalo() {
        return palo;
    }

    public void setPalo(char palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombreFicheroImagen() {
        return nombreFicheroImagen;
    }

    public void setNombreFicheroImagen(String nombreFicheroImagen) {
        this.nombreFicheroImagen = nombreFicheroImagen;
    }

    // Constructos
    public Carta(char palo, String dibujo) {
        this.dibujo = dibujo;
        this.palo = palo;
        asignarValor();
        asignarNombreFicheroImagen(palo,dibujo);
    }

    public void asignarValor() {
        if (dibujo.equals("AS")) {
            valor = 1;
        } else if (dibujo.equals("J")) {
            valor = 11;
        } else if (dibujo.equals("Q")) {
            valor = 12;
        } else if (dibujo.equals("K")) {
            valor = 13;
        } else {
            valor = Integer.parseInt(dibujo);
        }
    }

    public void asignarNombreFicheroImagen(char palo,String dibujo) {
        switch (this.palo) {
            case '♦':
                this.nombreFicheroImagen = "diamantes_";
                break;
            case '♠':
                this.nombreFicheroImagen = "picas_";
                break;
            case '♥':
                this.nombreFicheroImagen = "corazones_";
                break;
            case '♣':
                this.nombreFicheroImagen = "treboles_";
                break;
        }
        if (dibujo!="AS") {
            this.nombreFicheroImagen += dibujo;
        } else {
            this.nombreFicheroImagen += "1";
        }
        this.nombreFicheroImagen+=".jpg";
    }

    // toString
    @Override
    public String toString() {
        return dibujo + palo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.valor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.valor != other.valor) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Carta o) {
        if (this.valor>o.valor) {
            return 1;
        } else if (this.valor<o.valor){
            return -1;
        }
        return 0;
    }

}
