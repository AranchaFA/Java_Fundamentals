package Modelo;

public class DescomponerNumero {

    private int numero;
    private int millares;
    private int centenas;
    private int decenas;
    private int unidades;

    // Getter+Setter
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMillares() {
        return millares;
    }

    public void setMillares(int millares) {
        this.millares = millares;
    }

    public int getCentenas() {
        return centenas;
    }

    public void setCentenas(int centenas) {
        this.centenas = centenas;
    }

    public int getDecenas() {
        return decenas;
    }

    public void setDecenas(int decenas) {
        this.decenas = decenas;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    // toString
    @Override
    public String toString() {
        return "DescomponerNumero{" + "numero=" + numero + ", millares=" + millares + ", centenas=" + centenas + ", decenas=" + decenas + ", unidades=" + unidades + '}';
    }

    // Constructor
    public DescomponerNumero() {
    }

    // Método para comprobar que el número no sobrepasa 4 cifras (si tiene menos
    // suponemos 0s a la izquierda
    public boolean numeroMenor9999(int numero) {
        boolean auxReturn;
        if (numero - 9999 > 0) {
            auxReturn = false;
        } else {
            this.numero = numero;
            auxReturn = true;
        }
        return auxReturn;
    }

    // Método para descomponer el número en millares/centenas/decenas/unidades
    public void descomponerNumero() {
        int auxNumero = this.numero;
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 3:
                    this.millares = auxNumero % 10;
                    break;
                case 2:
                    this.centenas = auxNumero % 10;
                    break;
                case 1:
                    this.decenas = auxNumero % 10;
                    break;
                case 0:
                    this.unidades = auxNumero % 10;
                    break;
            }
            auxNumero /= 10;

        }
    }
}
