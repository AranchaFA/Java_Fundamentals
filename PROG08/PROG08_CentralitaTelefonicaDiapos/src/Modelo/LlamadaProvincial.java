package Modelo;

public class LlamadaProvincial extends Llamada {

    // ATRIBUTOS
    private int precio1;
    private int precio2;
    private int precio3;
    private int franjaHoraria;

    public int getPrecio1() {
        return precio1;
    }

    // MÉTODOS
    // Getters + Setters
    public void setPrecio1(int precio1) {
        this.precio1 = precio1;
    }

    public int getPrecio2() {
        return precio2;
    }

    public void setPrecio2(int precio2) {
        this.precio2 = precio2;
    }

    public int getPrecio3() {
        return precio3;
    }

    public void setPrecio3(int precio3) {
        this.precio3 = precio3;
    }

    public int getFranjaHoraria() {
        return franjaHoraria;
    }

    public void setFranjaHoraria(int franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\nLlamadaProvincial{" + "precio1=" + precio1 + ", precio2=" + precio2 + ", precio3=" + precio3 + ", franjaHoraria=" + franjaHoraria + '}';
    }

    // Constructores
    public LlamadaProvincial(String numeroOrigen, String numeroDestino, int duracion, int franjaHoraria) {
        super(numeroOrigen, numeroDestino, duracion);
        this.franjaHoraria = franjaHoraria;
        this.precio1 = 20;
        this.precio2 = 25;
        this.precio3 = 30;
    }

    // Calcular coste (en céntimos)
    @Override
    public int calcularCoste() {
        int coste = 0;
        switch (this.franjaHoraria) {
            case 1:
                coste = precio1 * super.getDuracion() / 60;
                break;
            case 2:
                coste = precio2 * super.getDuracion() / 60;
                break;
            case 3:
                coste = precio3 * super.getDuracion() / 60;
                break;
        }
        return coste;
    }
}
