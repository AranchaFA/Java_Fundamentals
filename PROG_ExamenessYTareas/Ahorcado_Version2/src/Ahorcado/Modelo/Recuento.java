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
    // El array tendrá tantas posiciones como el número máximo de fallos + número máximo de letras de la palabra a acertar
    // Introduciremos el máximo de fallos  por parámetro (habrá los mismos fallos restantes iniciales)
    public Recuento(int maxFallos, String palabraAAcertar) {
        arrayElegidas = new char[maxFallos + palabraAAcertar.length()];
        this.maxFallos = maxFallos;
        fallosRestantes = maxFallos;
    }

    // Método para mostrar el array por pantalla
    public void mostrarArray() {
        for (int i = 0; i < arrayElegidas.length; i++) {
            // Mostramos las posiciones ocupadas
            System.out.print(arrayElegidas[i] + " ");
        }
    }

    // Método para comprobar si una letra está ya elegida (EN MAYÚSCULAS)
    public boolean comprobarSiLetraElegida(char letra) {
        letra = Character.toUpperCase(letra);
        boolean elegida = false;
        int j=0;
        // Buscamos la letra en el array de elegidas
        while (elegida==false && j<arrayElegidas.length) {
             if (arrayElegidas[j] == letra) {
                elegida = true;
            }
             j++;
        }
        /*
        for (int i = 0; i < arrayElegidas.length; i++) {
            if (arrayElegidas[i] == letra) {
                elegida = true;
            }
        }
*/
        return elegida;
    }

    // Método para añadir una letra (EN MAYÚSCULAS) elegida acertada o no acertada
    public void grabarLetraAcertada(char letra) {
        letra = Character.toUpperCase(letra);
        int primeraPosicionVacia=-1;
        int j=0;
        // Añadimos en la primera posición vacía
        // Controlamos que no se haya encontrado ya una posición vacía si posicionVacía=-1 
        // (o sea, aún no se le ha asignado el valor de ninguna posición encontrada)
        while (primeraPosicionVacia<0 && j<arrayElegidas.length) {
             if (arrayElegidas[j] == '\0') {
                primeraPosicionVacia=j;
            }
             j++;
        }
        /*
        for (int i = 0; i < arrayElegidas.length; i++) {
            if (arrayElegidas[i]=='\0' && primeraPosicionVacia<0) {
                primeraPosicionVacia=i;
            }
        }
*/
        arrayElegidas[primeraPosicionVacia] = letra;
        // No hay que descontar intentos porque es acertada
    }

    public void grabarLetraFallada(char letra) {
        letra = Character.toUpperCase(letra);
        int primeraPosicionVacia=-1;
        int i=0;
        // Añadimos en la primera posición vacía
        while (primeraPosicionVacia<0) {
            if (arrayElegidas[i]=='\0') {
                primeraPosicionVacia=i;
            }
            i++;
        }
        arrayElegidas[primeraPosicionVacia] = letra;
        // Sí hay que descontar un intento porque es fallada
        fallosRestantes--;
    }
}
