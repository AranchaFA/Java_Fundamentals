package numeros;

public class Entero {

    int valor;
    
    public Entero(int valor) {
        this.valor = valor;
    }

    /**
     * Suma dos enteros
     *
     * @param a sumando1
     * @param b sumando2
     * @return suma sumando1+sumando2
     */
    public static Entero suma(Entero a, Entero b) {
        // return new Entero(a.valor+b.valor);
        int suma = a.valor + b.valor;
        Entero enteroSuma = new Entero(suma);
        return enteroSuma;
    }

    /**
     * Resta dos enteros
     *
     * @param a sumando1
     * @param b substraendo
     * @return suma sumando1+sumando2
     */
    public static Entero resta(Entero a, Entero b) {
        // return new Entero(a.valor-b.valor);
        int resta = a.valor - b.valor;
        Entero enteroResta = new Entero(resta);
        return enteroResta;
    }

    /**
     * Producto de dos enteros
     *
     * @param a
     * @param b
     * @return producto a*b
     */
    public static Entero multiplicacion(Entero a, Entero b) {
        Entero producto = new Entero(0);
        for (int i = 0; i < b.valor; i++) {
         //   producto.valor += a.valor;
         // Usando nuestro método
         producto=Entero.suma(producto, a);
        }
        return producto;
    }
    
    public static Entero potencia(Entero base,Entero exponente){
        Entero potencia=new Entero(1);
        for (int i = 0; i < exponente.valor; i++) {
            potencia=Entero.multiplicacion(potencia, base);
        }
        return potencia;
    }
    
    public static Entero factorial(Entero a){
        Entero factorial=new Entero(a.valor);
        factorial=multiplicacion(factorial,(a.valor-1));
        return null;
    }
}
