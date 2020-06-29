package desgloseCantidad;

import paqueteLeerDatos.Leer;

public class MainDesgloseCantidad {

    public static void main(String[] args) {
        int centimos,b500, b200, b100, b50, b20, b10, b5, m50, m20, m10, m5, m2, m1;
        float euros;
        System.out.print("\n   Introduzca cantidad entera (euros): ");
        euros = Leer.datoFloat();

        if (euros > 0) {
            /* Billetes de 500 */
            if (euros >= 500) {
                b500 = (int) euros / 500;
                euros %= 500.0;
            } else {
                b500 = 0;
            }

            /* Billetes de 200 */
            if (euros >= 200) {
                b200 = (int) euros / 200;
                euros %= 200.0;
            } else {
                b200 = 0;
            }

            /* Billetes de 100 */
            if (euros >= 100) {
                b100 = (int) euros / 100;
                euros %= 100.0;
            } else {
                b100 = 0;
            }

            /* Billetes de 50 */
            if (euros >= 50) {
                b50 = (int) euros / 50;
                euros %= 50.0;
                
            } else {
                b50 = 0;
            }

            /* Billetes de 20 */
            if (euros >= 20) {
                b20 = (int) euros / 20;
                euros %= 20.0;
            } else {
                b20 = 0;
            }

            /* Billetes de 10 */
            if (euros >= 10) {
                b10 = (int) euros / 10;
                euros %= 10.0;
            } else {
                b10 = 0;
            }

            /* Billetes de 5 */
            if (euros >= 5) {
                b5 = (int) euros / 5;
                euros %= 5.0;
            } else {
                b5 = 0;
            }

            /* Monedas de 2 */
            if (euros >= 2) {
                m2 = (int) euros / 2;
                euros %= 2.0;
            } else {
                m2 = 0;
            }

            /* Monedas de 1 */
            if (euros >= 1) {
                m1 = (int) euros;

            } else {
                m1 = 0;
            }
            System.out.println("Quedan " + euros);
             centimos =  (int)Math.round(euros * 100);
            System.out.println("Quedan en centimos " + centimos);

            /* monedas de 0.5 */
            if (centimos >= 50) {
                m50 = (centimos / 50);
                centimos %= 50;
                System.out.println("50 "+ centimos);
            } else {
                m50 = 0;
            }
            /* monedas de 0.2 */
            if (centimos >= 20) {
                m20 = (centimos / 20);
                centimos %= 20;
                System.out.println("20 "+ centimos);

            } else {
                m20 = 0;
            }
            /* monedas de 0.1 */
            if (centimos >= 10) {
                m10 = (centimos / 10);
                centimos %= 10;
                System.out.println("10 "+ centimos);

            } else {
                m10 = 0;
            }
            /* monedas de 0.05 */
            if (centimos >= 5) {
                m5 = (centimos / 5);
                centimos %= 5;
                System.out.println("5 "+ centimos);
            } else {
                m5 = 0;
            }
            /* monedas de 0.02 */
            if (centimos >= 2) {
                m2 = (int) (centimos / 2);
                centimos %= 2;
                System.out.println("2 "+ centimos);

            } else {
                m2 = 0;
            }
            /* monedas de 0.01 */
            if (centimos >= 1) {
                m1 = centimos ;
                System.out.println("1 "+ centimos);
            } else {
                m1 = 0;
            }
            System.out.println("    billete(s) de 500: " + b500);
            System.out.println("    billete(s) de 200: " + b200);
            System.out.println("    billete(s) de 100: " + b100);
            System.out.println("    billete(s) de 50: " + b50);
            System.out.println("    billete(s) de 20: " + b20);
            System.out.println("    billete(s) de 10: " + b10);
            System.out.println("    billete(s) de 5: " + b5);
            System.out.println("    moneda(s) de 2: " + m2);
            System.out.println("    moneda(s) de 1: " + m1);            
            System.out.println("    moneda(s) de 0,50: " + m50);
            System.out.println("    moneda(s) de 0,20: " + m20);
            System.out.println("    moneda(s) de 0,10: " + m10);
            System.out.println("    moneda(s) de 0,05: " + m5);
            System.out.println("    moneda(s) de 0,02: " + m2);
            System.out.println("    moneda(s) de 0,01: " + m1);
        } else {
            System.out.println("   ERROR: Cantidad incorrecta, debe ser mayor que cero.");
        }

    }
}
