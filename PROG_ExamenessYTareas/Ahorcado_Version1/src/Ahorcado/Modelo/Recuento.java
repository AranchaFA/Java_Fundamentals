package Ahorcado.Modelo;

public class Recuento {

    // ATRIBUTOS
    private char[] arrayElegidas;
    private int maxFallos;
    private int fallosRestantes;

    // MÉTODOS
    // Getters + Setters
    public char[] getArrayElegidas() {
        return arrayElegidas;
    }

    public void setArrayElegidas(char[] arrayElegidas) {
        this.arrayElegidas = arrayElegidas;
    }

    public int getMaxFallos() {
        return maxFallos;
    }

    public void setMaxFallos(int maxFallos) {
        this.maxFallos = maxFallos;
    }

    public int getFallosRestantes() {
        return fallosRestantes;
    }

    public void setFallosRestantes(int fallosRestantes) {
        this.fallosRestantes = fallosRestantes;
    }

    // Constructor
    // El array tendrá 27 posiciones (tantas como letras del alfabeto)
    // Introduciremos el máximo de fallos  por parámetro (habrá los mismos fallos restantes iniciales)
    public Recuento(int maxFallos) {
        arrayElegidas = new char[27];
        this.maxFallos = maxFallos;
        fallosRestantes = maxFallos;
    }

    // Método para mostrar el array por pantalla
    public void mostrarArray() {
        for (int i = 0; i < arrayElegidas.length; i++) {
            // Sólo mostramos las posiciones ocupadas (las letras contenidas en el array)
            if (arrayElegidas[i] != '\0') {
                System.out.print(arrayElegidas[i]+" ");
            }
        }
    }

    // Método para calcular la posición de una letra en el array (EN MAYÚSCULAS)
    public int posicionAlfabetica(char letra) {
        letra = Character.toUpperCase(letra);
        int posicion = (int) letra - 65; // A=65 -> posicion=0
        if (posicion == 165-65) { // Ñ=165 (ya le habremos restado 65) a la última posición
            posicion = arrayElegidas.length - 1;
        }
        return posicion;
    }

    // Método para comprobar si una letra está ya elegida (EN MAYÚSCULAS)
    public boolean comprobarSiLetraElegida(char letra) {
        letra = Character.toUpperCase(letra);
        boolean elegida;
        // Buscamos la letra POR SU POSICIÓN
        if (arrayElegidas[posicionAlfabetica(letra)] == '\0') {
            elegida = false;
        } else {
            elegida = true;
        }

        return elegida;
    }

    // Método para añadir una letra (EN MAYÚSCULAS) elegida acertada o no acertada
    public void grabarLetraAcertada(char letra) {
        letra = Character.toUpperCase(letra);
        // Añadimos en la posición que le corresponde alfabéticamente
        arrayElegidas[posicionAlfabetica(letra)] = letra;
        // No hay que descontar intentos porque es acertada
    }
    
    public void grabarLetraFallada(char letra) {
        letra = Character.toUpperCase(letra);
        // Añadimos en la posición que le corresponde alfabéticamente
        arrayElegidas[posicionAlfabetica(letra)] = letra;
        // Sí hay que descontar un intento porque es fallada
        fallosRestantes--;
    }
}
