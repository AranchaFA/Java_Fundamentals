package Modelo;

public class Calculadora {

    // ATRIBUTOS
    private float x, y;
    private MenuCalculadora menu;

    // MÉTODOS
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public MenuCalculadora getMenu() {
        return menu;
    }

    public void setMenu(MenuCalculadora menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Calculadora{" + "x=" + x + ", y=" + y + '}';
    }

    // Constructores
    // Inicializando atributos a 0 y crea el menú
    public Calculadora() {
        this.menu = new MenuCalculadora();
    }

    // Pasando atributos como parámetros y crea el menú
    public Calculadora(float x, float y) {
        this.x = x;
        this.y = y;
        this.menu = new MenuCalculadora();
    }

    // Métodos para realizar las operaciones matemáticas 
    public float suma() {
        float resultado;
        resultado = this.x + this.y;
        return resultado;
    }

    public float resta() {
        float resultado;
        resultado = this.x - this.y;
        return resultado;
    }

    public float multiplicacion() {
        float resultado;
        resultado = this.x * this.y;
        return resultado;
    }

    public float division() {
        float resultado;
        resultado = this.x / this.y;
        return resultado;
    }

    /**
     * Método que recibe como parámetros el caracter de la operación y el
     * resultado, y nos muestra el resultado por pantalla en un sout
     * (pasando el operando como char me daba problemas al operar)
     */
    public void mostrarResultado(String operando, float resultado) {
        System.out.println(this.x + operando + this.y + "=" + resultado);
    }

    /*
    * Método para mostrar el menú, nos devuelve el valor de la opción elegida
     */
    public int mostrarMenu() {
        return this.menu.mostrarMenuCalculadora();
    }
}
