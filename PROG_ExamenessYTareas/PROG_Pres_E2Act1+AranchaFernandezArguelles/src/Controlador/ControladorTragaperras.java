/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Leer;
import Modelo.Tragaperras;
import Vista.VistaTragaperras;

/**
 *
 * @author Arancha
 */
public class ControladorTragaperras {

    public void ejecutarTragaperras(Tragaperras tragaperras) {

        Leer teclado = new Leer();
        boolean auxMinParaPremio = true;
        String auxVolverAJugar;

        do {
            // Pedimos importe a jugar
            VistaTragaperras.meterDinero();
            tragaperras.meterDinero(teclado.datoInt());

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
            do {
                VistaTragaperras.volverATirar();
                auxVolverAJugar = teclado.leerDato();
            } while (!auxVolverAJugar.equalsIgnoreCase("s") && !auxVolverAJugar.equalsIgnoreCase("S") && !auxVolverAJugar.equalsIgnoreCase("n") && !auxVolverAJugar.equalsIgnoreCase("N"));

            System.out.println("");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println("");

        } while (auxVolverAJugar.equalsIgnoreCase("s") || auxVolverAJugar.equalsIgnoreCase("S"));
    }

}
