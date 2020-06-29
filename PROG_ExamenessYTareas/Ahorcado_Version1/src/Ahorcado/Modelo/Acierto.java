package Ahorcado.Modelo;

public class Acierto {

    // ATRIBUTOS
    private char[] arrayAciertos;
    private boolean palabraAcertada;

    // MÉTODOS
    // Getters + Setters
    public char[] getArrayAciertos() {
        return arrayAciertos;
    }

    public void setArrayAciertos(char[] arrayAciertos) {
        this.arrayAciertos = arrayAciertos;
    }

    public boolean isPalabraAcertada() {
        return palabraAcertada;
    }

    public void setPalabraAcertada(boolean palabraAcertada) {
        this.palabraAcertada = palabraAcertada;
    }

    // Constructor, pasaremos la dimensión del array como parámetro
    public Acierto(int numLetras) {
        arrayAciertos = new char[numLetras];
    }

    // Método para comprobar si se ha acertado la palabra (si faltan 0 posiciones por acertar)
    public void comprobarPalabraAcertada(){
        int posicionesNoAcertadas=0;
        for (int i = 0; i < arrayAciertos.length; i++) {
            if (arrayAciertos[i]=='\0') {
                posicionesNoAcertadas++;
            }
        }
        if (posicionesNoAcertadas==0) {
            palabraAcertada=true;
        }
    }
    
    // Método para mostrar el array por pantalla
    public void mostrarArray(){
        for (int i = 0; i < arrayAciertos.length; i++) {
            if (arrayAciertos[i]=='\0') {
                System.out.print("_ ");
            }
            else {
                System.out.print(arrayAciertos[i]);
            }
        }
    }
    
    // Método para guardar una letra en una posición (EN MAYÚSCULAS)
    public void grabarLetra(int posicion,char letra){
        letra=Character.toUpperCase(letra);
        arrayAciertos[posicion]=letra;
    }
    
}
