package Modelo;

public class Jugador {

    // ATRIBUTOS
    private String nombre;
    private int apuesta; // Apuesta CARA o CRUZ para la modena
    private int resultado; // Resultado de la tirada de dado
    private Dado dado;  // Dado de cada jugador en el Ej 4

    // MÉTODOS
    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getApuesta() {
        return apuesta;
    }

    public int getResultado() {
        return resultado;
    }

    public Dado getDado() {
        return dado;
    }

    // Setter para la apuesta y el resultado (Ejs 2 y 3)
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    // Setter para el dado (Ej 4)

    public void setDado(Dado dado) {
        this.dado = dado;
    }
    
    // toString
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", apuesta=" + apuesta + ", resultado=" + resultado + ", dado=" + dado + '}';
    }  

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Método para comprobar las apuestas con la moneda
    public boolean apostar(Moneda moneda) {
        if (this.apuesta == moneda.getValor()) {
            return true;
        } else {
            return false;
        }
    }
    // Método para comprobar las tiradas con el dado
    // Devolverá 1 si es mayor 
    //          -1 si es menor
    //           0 si es igual
    public int comprobarTiradaDados(Jugador jugador) {
        int n = 0;
        if (this.resultado > jugador.getResultado()) {
            n = 1;
        }
        if (this.resultado == jugador.getResultado()) {
            n = 0;
        }
        if (this.resultado < jugador.getResultado()) {
            n = -1;
        }
        return n;
    }
}
