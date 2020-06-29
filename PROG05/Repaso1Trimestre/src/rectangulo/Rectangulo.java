package rectangulo;

public class Rectangulo {

    private int alto;
    private int largo;
    private boolean relleno;

    public Rectangulo(int alto, int largo, boolean relleno) {
        this.alto = alto;
        this.largo = largo;
        this.relleno = relleno;
    }

    public Rectangulo() {
        this.alto = 0;
        this.largo = 0;
        this.relleno = false;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public int perimetro() {
        return largo * 2 + alto * 2;
    }

    public int area() {
        return largo * alto;
    }

    public void pintarRectangulo() {
        for (int i = 1; i <= alto; i++) {
            for (int j = 1; j <= largo; j++) {
                if ((i == 1) || (j == 1) || (i == alto) || (j == largo)) {
                    System.out.print("* ");
                } else if (relleno) {
                            System.out.print("* ");
                        } else {
                                 System.out.print("  ");
                        }
            }
            System.out.println("\n");
        }
    }
}
