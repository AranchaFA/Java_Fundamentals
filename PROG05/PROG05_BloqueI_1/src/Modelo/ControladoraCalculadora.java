package Modelo;

public class ControladoraCalculadora {

    //ATRIBUTOS
    Calculadora calculadora;
    int opcionSeleccionada;
    
    // MÉTODOS
    public Calculadora getCalculadora() {
        return calculadora;
    }

    public void setCalculadora(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public int getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccionada(int opcionSeleccionada) {    
        this.opcionSeleccionada = opcionSeleccionada;
    }
    
    // Constructor
    public ControladoraCalculadora() {
        this.calculadora = new Calculadora();
    }
    
    // toString
    @Override
    public String toString() {
        return "ControladoraCalculadora{" + "calculadora=" + calculadora + ", opcionSeleccionada=" + opcionSeleccionada + '}';
    }
    
    // Método para la opción 1 introducir valores
    public void introducirValores() {
        Leer teclado = new Leer();
        System.out.println("Primer número: ");
        this.calculadora.setX(teclado.datoFloat());
        System.out.println("Segundo número: ");
        this.calculadora.setY(teclado.datoFloat());
    }

    // Método para realizar las operaciones seleccionadas por el usuario
    public float realizarOperacion() {
        float resultado = 0;
        do {
            this.opcionSeleccionada = this.calculadora.getMenu().mostrarMenuCalculadora();

            switch (this.opcionSeleccionada) {
                case 1:
                    this.introducirValores();
                    break;
                case 2:
                    resultado = this.calculadora.suma();
                    this.calculadora.mostrarResultado("+", resultado);
                    break;
                case 3:
                    resultado = this.calculadora.resta();
                    this.calculadora.mostrarResultado("-", resultado);
                    break;
                case 4:
                    resultado = this.calculadora.multiplicacion();
                    this.calculadora.mostrarResultado("*", resultado);
                    break;
                case 5:
                    resultado = this.calculadora.division();
                    this.calculadora.mostrarResultado("/", resultado);
                    break;
                case 6:
                    System.out.println("¡ADIÓS!");
                    break;
                default:
                    System.out.println("Introduce un valor entre 1 y 6 por favor.");
                    break;
            }
            System.out.println("");
        } while (this.opcionSeleccionada != 6);
        return resultado;
    }
    
    
}
