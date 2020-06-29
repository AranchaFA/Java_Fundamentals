package Controlador;

import Modelo.Leer;
import Modelo.Resultado;
import Modelo.Tragaperras;
import Vista.VistaTragaperras;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorTragaperras {

    public void ejecutarTragaperras(Tragaperras tragaperras) {

        Leer teclado = new Leer();
        boolean auxMinParaPremio = true;
        String auxVolverAJugar = "s";

        do {
            // Pedimos importe a jugar y nombre SÓLO SI NO HAY CRÉDITOS (realizaremos una jugada
            // completa con el importe inicial hasta terminar esa cantidad, sin meter 
            // más dinero durante la jugada")
            if (tragaperras.getContadorCreditos().getCantidadCreditos() == 0) {
                VistaTragaperras.pedirNombre();
                String nombre = teclado.leerDato();
                VistaTragaperras.meterDinero();
                int cantidadInicial = teclado.datoInt();
                tragaperras.meterDinero(cantidadInicial);
                tragaperras.getDaoResultado().setResultado(new Resultado(nombre, cantidadInicial));
            }

            // Realizamos una tirada:
            VistaTragaperras.activarPalanca(tragaperras);
            // Controlamos que la recaudación sea suficiente para dar premio
            if (tragaperras.getDepositoMonedas().getValorMonedas() <= 2 * tragaperras.getValorPremio1()) {
                // salta false cuando hay menos de 2*10=20 de recaudación
                auxMinParaPremio = false;
            } else if (tragaperras.getDepositoMonedas().getValorMonedas() >= 3 * tragaperras.getValorPremio1()) {
                // vuelve a true cuando alcanza 3*10=30 de recaudación
                auxMinParaPremio = true;
            }
            // Tirada de la tragaperras
            if (tragaperras.tirar()) {
                // Guardamos en var.aux. cuánto dinero ha tocado
                int auxPremio = tragaperras.comprobarSiPremio();
                // Si no se han alcanzado los 30€ de recaudación tras haber bajado
                // hasta 20€ repetimos tirada si saliera premio1 o premio2
                if (!auxMinParaPremio) {
                    while (auxPremio > 1) {
                        // Las monedas del premio se habrán descontado al comprobarSiPremio
                        // Se consumirá 1 crédito de la tirada que vamos a repetir
                        // Tendremos que volver a sumarlos de nuevo
                        // También descontamos el premio del objeto resultado del DAO
                        // para ello comprobamos si ha tocado el premio1 o el premio2
                        if (auxPremio == tragaperras.getValorPremio1()) {
                            tragaperras.getDaoResultado().getResultado().restarPremio1(auxPremio);
                        } else {
                            tragaperras.getDaoResultado().getResultado().restarPremio2(auxPremio);
                        }
                        tragaperras.getDepositoMonedas().meterMonedas(auxPremio);
                        tragaperras.tirar();
                        tragaperras.getContadorCreditos().sumarCreditos(1);
                        auxPremio = tragaperras.comprobarSiPremio();
                        tragaperras.terminarTirada();
                        // Me repite el bucle una vez de más
                    }
                }
                // Mostramos resultado
                VistaTragaperras.mostrarResultado(tragaperras);
                // Activamos alarma si toca premio
                if (auxPremio > 0) {
                    VistaTragaperras.sonarAlarma();
                }
                // Mostramos el valor del premio ganado, o si no ha tocado
                VistaTragaperras.mostrarPremio(auxPremio);
            } else if (!tragaperras.getPalanca().isDesbloqueada()) {
                // Si la palanca está bloqueada no se realiza la tirada por 
                // falta de créditos
                VistaTragaperras.sinCreditos();
            }
            // Tampoco se realizaría la tirada si la palanca ya estuviera activa
            // (tirada en marcha), pero para eso no ponemos mensaje porque es
            // evidente para el usuario.

            // Finalizamos la tirada
            tragaperras.terminarTirada();

            // Mostramos los créditos restantes y el dinero recaudado
            VistaTragaperras.creditosRestantes(tragaperras);
            VistaTragaperras.mostrarRecaudacion(tragaperras);

            // Preguntamos si se vuelve a jugar, comprobamos que se introduce s/n
            // Sólo se preguntará cuando se hayan acabado los créditos, y antes 
            // grabaremos el objeto resultado de esta jugada
            if (tragaperras.getContadorCreditos().getCantidadCreditos() == 0) {
                try {
                    VistaTragaperras.grabandoResultado();
                    tragaperras.getDaoResultado().grabarUnResultado();
                } catch (IOException ex) {
                    System.out.println("Error al grabar el resultado. " + ex.getMessage());
                    Logger.getLogger(ControladorTragaperras.class.getName()).log(Level.SEVERE, null, ex);
                }
                VistaTragaperras.mostrandoResultado();
                tragaperras.getDaoResultado().mostrarFicheroPorPantalla();
                do {
                    VistaTragaperras.volverATirar();
                    auxVolverAJugar = teclado.leerDato();
                } while (!auxVolverAJugar.equalsIgnoreCase("s") && !auxVolverAJugar.equalsIgnoreCase("S") && !auxVolverAJugar.equalsIgnoreCase("n") && !auxVolverAJugar.equalsIgnoreCase("N"));

                VistaTragaperras.saltoDeJugada();
            }

            // Ahora repetimos el do con toda la tirada cuando se responde que sí (en caso de que tocara preguntar)
            // o si el número de créditos es mayor que 0
        } while (auxVolverAJugar.equalsIgnoreCase("s") || tragaperras.getContadorCreditos().getCantidadCreditos() > 0);
    }

}
