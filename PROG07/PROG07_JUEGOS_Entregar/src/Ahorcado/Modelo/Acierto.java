package Ahorcado.Modelo;

public class Acierto {

    // ATRIBUTOS
    private char[] arrayAciertos;

    // MÉTODOS
    // Getters + Setters
    public char[] getArrayAciertos() {
        return arrayAciertos;
    }

    public void setArrayAciertos(char[] arrayAciertos) {
        this.arrayAciertos = arrayAciertos;
    }

    // Constructor, pasaremos la dimensión del array como parámetro
    public Acierto(int numLetras) {
        arrayAciertos = new char[numLetras];
    }

    // Método para comprobar si se ha acertado la palabra (si faltan 0 posiciones por acertar)
    public boolean comprobarPalabraAcertada(){
        boolean palabraAcertada=false;
        int posicionesNoAcertadas=0;
        for (int i = 0; i < arrayAciertos.length; i++) {
            if (arrayAciertos[i]=='\0') {
                posicionesNoAcertadas++;
            }
        }
        if (posicionesNoAcertadas==0) {
            palabraAcertada=true;
        }
        return palabraAcertada;
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
