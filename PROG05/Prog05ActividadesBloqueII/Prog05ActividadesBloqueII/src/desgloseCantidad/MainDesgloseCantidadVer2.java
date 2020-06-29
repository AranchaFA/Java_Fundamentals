package desgloseCantidad;

import paqueteLeerDatos.Leer;

public class MainDesgloseCantidadVer2 {

    public static float calcularEImprimir(float euros, int moneda) {
        int cash;
        if (euros >= moneda) {
            cash = (int) euros / moneda;
            euros %= moneda;
        } else {
            cash = 0;
        }
        System.out.println("    billete/Monedas(s) de" + moneda + " : " + cash);
        return euros;
    }

    public static void main(String[] args) {
        int centimos, b500, b200, b100, b50, b20, b10, b5, m50, m20, m10, m5, m2, m1;
        float euros;
        do {
            System.out.print("\n   Introduzca cantidad entera (euros): ");
            euros = Leer.datoFloat();
        } while (euros < 0 );

        /* Billetes de 500 */
        if (euros >= 500) {
            euros = calcularEImprimir(euros, 500);
        }
        /* Billetes de 200 */
        if (euros >= 200) {
            euros = calcularEImprimir(euros, 200);
        }
        /* Billetes de 100 */
        if (euros >= 100) {
            euros = calcularEImprimir(euros, 100);
        }

        /* Billetes de 50 */
        if (euros >= 50) {
            euros = calcularEImprimir(euros, 50);
        }

        /* Billetes de 20 */
        if (euros >= 20) {
            euros = calcularEImprimir(euros, 20);
        }

        /* Billetes de 10 */
        if (euros >= 10) {
            euros = calcularEImprimir(euros, 10);
        }

        /* Billetes de 5 */
        if (euros >= 5) {
            euros = calcularEImprimir(euros, 5);
        }

        /* Monedas de 2 */
        if (euros >= 2) {
            euros = calcularEImprimir(euros, 1);
        }

        /* Monedas de 1 */
        if (euros >= 1) {
            euros = calcularEImprimir(euros, 1);
        }

        System.out.println("Quedan " + euros);
        centimos = (int) Math.round(euros * 100);
        System.out.println("Quedan en centimos " + centimos);

        /* monedas de 0.5 */
        if (centimos >= 50) {
            centimos = (int) calcularEImprimir(centimos, 50);
        }

        /* monedas de 0.2 */
        if (centimos >= 20) {
            centimos = (int) calcularEImprimir(centimos, 20);
        }

        /* monedas de 0.1 */
        if (centimos >= 10) {
            centimos = (int) calcularEImprimir(centimos, 10);
        }

        /* monedas de 0.05 */
        if (centimos >= 5) {
            centimos = (int) calcularEImprimir(centimos, 5);
        }

        /* monedas de 0.02 */
        if (centimos >= 2) {
            centimos = (int) calcularEImprimir(centimos, 2);
        }

        /* monedas de 0.01 */
        if (centimos >= 1) {
            centimos = (int) calcularEImprimir(centimos, 1);
        }

    }
}
