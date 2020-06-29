
package Controlador;

public class MainJuegoAcertarNumero {

    public static void main(String[] args) {
        
        // Creamos un controlador del juego
        ControladorJuegoAcertarNumero controladorJuego=new ControladorJuegoAcertarNumero();
        // Generamos un número a adivinar
        controladorJuego.getJuego().generarNumero();
        // Adivinamos el número y mostramos el resultado
        System.out.println("Número de intentos: "+controladorJuego.adivinarNumero());

    }
    
}
