package Modelo;

public class Rectangulo {

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
        return "Rectangulo{" + "base=" + base + ", altura=" + altura + '}';
    }

    // Constructor pasando altura y base
    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    // Dibujar rectángulo relleno
    public void relleno() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    // Dibujar rectándulo hueco
    public void hueco() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                if (i == 0 || i == (altura - 1)) {
                    System.out.print("*");
                } else {
                    if (j == 0 || j == (base - 1)) {
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
