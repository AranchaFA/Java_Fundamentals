package Modelo;

public class Boligrafo {

    // ATRIBUTOS
    private Tinta tinta1;
    private Tinta tinta2;
    private Tinta tinta3;
    private Tinta tinta4;
    private Goma goma;
    private Tinta tintaSeleccionada;

    // MÉTODOS
    public Tinta getTinta1() {
        return tinta1;
    }

    public void setTinta1(Tinta tinta1) {
        this.tinta1 = tinta1;
    }

    public Tinta getTinta2() {
        return tinta2;
    }

    public void setTinta2(Tinta tinta2) {
        this.tinta2 = tinta2;
    }

    public Tinta getTinta3() {
        return tinta3;
    }

    public void setTinta3(Tinta tinta3) {
        this.tinta3 = tinta3;
    }

    public Tinta getTinta4() {
        return tinta4;
    }

    public void setTinta4(Tinta tinta4) {
        this.tinta4 = tinta4;
    }

    public Goma getGoma() {
        return goma;
    }

    public void setGoma(Goma goma) {
        this.goma = goma;
    }

    public Tinta getTintaSeleccionada() {
        return tintaSeleccionada;
    }

    public void setTintaSeleccionada(Tinta tintaSeleccionada) {
        this.tintaSeleccionada = tintaSeleccionada;
    }

    @Override
    public String toString() {
        return "Goma{" + "tinta1=" + tinta1 + ", tinta2=" + tinta2 + ", tinta3=" + tinta3 + ", tinta4=" + tinta4 + ", goma=" + goma + ", tintaSeleccionada=" + tintaSeleccionada + '}';
    }

    public Boligrafo() {
        Color color1 = new Color("red");
        Color color2 = new Color("blue");
        Color color3 = new Color("green");
        Color color4 = new Color("black");

        this.tinta1 = new Tinta(color1, 100);
        this.tinta2 = new Tinta(color2, 100);
        this.tinta3 = new Tinta(color3, 100);
        this.tinta4 = new Tinta(color4, 100);
    }

    public Boligrafo(float cantidadInicial) {
        Color color1 = new Color("red");
        Color color2 = new Color("blue");
        Color color3 = new Color("green");
        Color color4 = new Color("black");

        this.tinta1 = new Tinta(color1, cantidadInicial);
        this.tinta2 = new Tinta(color2, cantidadInicial);
        this.tinta3 = new Tinta(color3, cantidadInicial);
        this.tinta4 = new Tinta(color4, cantidadInicial);
    }

    public Boligrafo(Tinta tinta1, Tinta tinta2, Tinta tinta3, Tinta tinta4) {
        this.tinta1 = tinta1;
        this.tinta2 = tinta2;
        this.tinta3 = tinta3;
        this.tinta4 = tinta4;
    }

    public Boligrafo(Tinta tinta1, Tinta tinta2, Tinta tinta3, Tinta tinta4, float cantidadInicial) {
        this.tinta1 = tinta1;
        this.tinta2 = tinta2;
        this.tinta3 = tinta3;
        this.tinta4 = tinta4;

        this.tinta1.setCantidadInicial(cantidadInicial);
        this.tinta2.setCantidadInicial(cantidadInicial);
        this.tinta3.setCantidadInicial(cantidadInicial);
        this.tinta4.setCantidadInicial(cantidadInicial);
    }

    public boolean deseleccionarTinta() {
        if (this.tintaSeleccionada == null) {
            return false;
        } else {
            this.tintaSeleccionada = null;
            return true;
        }
    }

    public String escribir(String texto, Papel papel, int posicionInicio) {
        // Todavía no se puede programar :)
        return texto;
    }
    
    // Método para seleccionar una tinta pasándole por parámetro la que queremos
    // Sólo seleccionará una tinta si no se encuentra ninguna ya seleccionada
    // (habría que deseleccionar primero) y si el color deseado está entre los 4 del boli
    public Tinta seleccionarTinta(Color color) {
        if (this.tintaSeleccionada == null) {
            if (this.tinta1.getColor() == color) {
                this.tintaSeleccionada = this.tinta1;
            }
            if (this.tinta2.getColor() == color) {
                this.tintaSeleccionada = this.tinta2;
            }
            if (this.tinta3.getColor() == color) {
                this.tintaSeleccionada = this.tinta3;
            }
            if (this.tinta4.getColor() == color) {
                this.tintaSeleccionada = this.tinta4;
            }
        }
        return this.tintaSeleccionada;
    }

}
