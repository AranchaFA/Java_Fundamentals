package Modelo;

public class Triangulo {

    // ATRIBUTOS
    private int base, altura;

    // MÉTODOS
    // Getters + Setters
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    // toString
    @Override
    public String toString() {
        return "Triangulo{" + "base=" + base + ", altura=" + altura + '}';
    }

    // Constructor pasando base y altura
    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    // Comprobar valores base y altura correctos
    public boolean valoresCorrectos(int base, int altura) {
        boolean auxReturn;
        if (base % 2 == 0) {
            auxReturn = false;
        } else {
            if (base == (altura + 1) / 2) {
                auxReturn = true;
            } else {
                auxReturn = false;
            }
        }
        return auxReturn;
    }

    // Dibujar triángulo relleno
    public void relleno() {

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                if (j < ((base / 2) - i) || j > ((base / 2) + i)) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }

    // Dibujar triángulo hueco
    public void hueco() {

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                if (i == altura - 1) {
                    System.out.print("*");
                } else {
                    if (j == ((base / 2) - i) || j == ((base / 2) + i)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }
}
