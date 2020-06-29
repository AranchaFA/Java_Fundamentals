package modelo;

public class Carta implements Comparable<Carta> {

    private String dibujoCarta;  //si es AS,2,3,...,,J,K,Q
    private char paloCarta; //
    private int valorCarta;//valor numerico de la carta

    //metodos constructores
    public Carta(String dibujoCarta, char paloCarta) {
        this.dibujoCarta = dibujoCarta;
        this.paloCarta = paloCarta;
        this.valorCarta=asignarValorNumericoCarta(dibujoCarta); //asigna su valor numerico
      }

    //metodos getter y setter
    public String getDibujoCarta() {
        return dibujoCarta;
    }

    public void setDibujoCarta(String dibujoCarta) {
        this.dibujoCarta = dibujoCarta;
    }

    public char getPaloCarta() {
        return paloCarta;
    }

    public void setPaloCarta(char paloCarta) {
        this.paloCarta = paloCarta;
    }

    public int getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    //metodo asignacion valor
    private int asignarValorNumericoCarta(String dibujoCarta) {
        int valorNumerico=0;
        switch (dibujoCarta) {
            case "AS":
                valorNumerico = 1;
                break;
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                valorNumerico = Integer.parseInt(dibujoCarta);
                break;
            case "J":
                valorNumerico = 11;
                break;
            case "Q":
                valorNumerico = 12;
                break;
            case "K":
                valorNumerico = 13;
                break;
        }
        return valorNumerico;
    }

    //comparar dos cartas y lo hago por el valorCarta
    /* 
    ojo, el AS vale 1, con lo cual es la más pequeña, si quisieramos modificar su valor para 
    que fuera la mayor, en el programa tendríamos que tratar dicha carta de forma especial
    o modificar una vez generada la baraja, buscar los ASes de cada palo y ponerle el valorCarta=14
    utilizando para ello el método setValorCarta( numEntero)
     */
    @Override
    public int compareTo(Carta carta) {
        if (valorCarta > carta.valorCarta) {
            return 1;
        } else if (valorCarta < carta.valorCarta) {
            return -1;
        } else {
            return 0;
        }
    }

    //ver si dos cartas son iguales y lo hago usando en mi caso el valorCarta
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.valorCarta;
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
        if (this.valorCarta != other.valorCarta) {
            return false;
        }
        return true;
    }

    
    public String toString() {   // Abre metodo toString
        return dibujoCarta + paloCarta + " ";
    }

}
