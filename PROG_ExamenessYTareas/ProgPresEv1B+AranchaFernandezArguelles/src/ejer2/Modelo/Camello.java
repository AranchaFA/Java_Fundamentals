package ejer2.Modelo;

public class Camello {

    private Dado dado;
    private int posicionActual;
    private String nombre;

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    @Override
    public String toString() {
        return "Camello{" + "dado=" + dado + ", posicionActual=" + posicionActual + '}';
    }

    public Camello(String nombre) {
        this.nombre=nombre;
        this.dado = new Dado();
    }

    // Devuelve la posicion tras haber tirado
    public int tirarDado() {
        this.posicionActual += this.dado.tirarDado();
        return this.posicionActual;
    }

    // Método para dibujar con asteriscos la posición actual
    public void pintarPosicion() {
        System.out.print(this.nombre+"avanza un total de "+this.posicionActual+" metros: ");
        for (int i = 0; i < this.posicionActual; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}
