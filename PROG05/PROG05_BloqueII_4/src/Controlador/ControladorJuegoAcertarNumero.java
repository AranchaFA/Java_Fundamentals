package Controlador;

import Modelo.JuegoAcertarNumero;
import Modelo.Leer;

public class ControladorJuegoAcertarNumero {

    // Atributos
    private JuegoAcertarNumero juego;
    private int numIntentos;

    public JuegoAcertarNumero getJuego() {
        return juego;
    }

    // Getter+Setters
    public void setJuego(JuegoAcertarNumero juego) {
        this.juego = juego;
    }

    public int getNumIntentos() {
        return numIntentos;
    }

    public void setNumIntentos(int numIntentos) {
        this.numIntentos = numIntentos;
    }

    // toString
    @Override
    public String toString() {
        return "ControladorJuegoAcertarNumero{" + "juego=" + juego + ", numIntentos=" + numIntentos + '}';
    }

    //Constructor
    public ControladorJuegoAcertarNumero() {
        this.juego = new JuegoAcertarNumero();
    }

    // Método para adivinar el número
    public int adivinarNumero() {
        Leer teclado = new Leer();
        int numeroIntroducido;
        boolean acierto;

        do {
            Vista.VistaJuegoAcertarNumero.pedirNumero();
            System.out.println(this.juego.getMinimo() + " y " + this.juego.getMaximo());
            numeroIntroducido = teclado.datoInt();

            if (juego.comprobarNumero(numeroIntroducido)) {
                Vista.VistaJuegoAcertarNumero.acertaste();
                acierto = true;
            } else {
                if (this.juego.getNumero() < numeroIntroducido) {
                    Vista.VistaJuegoAcertarNumero.numeroMenor();
                } else {
                    Vista.VistaJuegoAcertarNumero.numeroMayor();
                }
                acierto = false;
            }

            this.numIntentos++;

        } while (!acierto);

        return numIntentos;
    }
}
