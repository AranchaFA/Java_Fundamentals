package Controlador;

import Modelo.*;
import java.util.HashMap;

public class Main_PuertasAutomaticas {

    public static void main(String[] args) {

        // Creamos un temporizador y 3 puertas
        Temporizador t = new Temporizador();
        PuertaAutomatica p1, p3;
        PuertaManual p2;
        p1 = new PuertaAutomatica(1);
        p2 = new PuertaManual(2);
        p3 = new PuertaAutomatica(3);

        // Guardamos las puertas en una collection para gestionar en el bucle for
        // el acceso a cada una cuando corresponda.
        // Se puede hacer con un switch para tan pocas puertas, pero si fueran muchas no
        HashMap<String, Puerta> puertas = new HashMap();
        puertas.put("1", p1);
        puertas.put("2", p2);
        puertas.put("3", p3);

        // Mostramos los estados iniciales de las 3 puertas
        System.out.println("Estado inicial de las 3 puertas:");
        System.out.println(p1.toString() + "\n" + p2.toString() + "\n" + p3.toString() + "\n");

        // Generamos 10 nº aleatorios entre 1-5, si sale 1,2,3 activamos la puerta
        // que corresponda, si sale 4,5 no hacemos nada
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 5 + 1);
            String stringKey=String.valueOf(num);
            System.out.println("Ha salido el número " + num);

            if (puertas.containsKey(stringKey)) {
                System.out.println("Estado inicial de la puerta "+num+":\n" + puertas.get(stringKey).toString());
                t.monitorizarPuerta(p1);
                System.out.println("Estado final de la puerta "+num+":\n" + puertas.get(stringKey).toString());
                System.out.println("");
            } else {
                System.out.println("No hacemos nada.....");
                System.out.println("");
            }

            /*
            switch (num) {
                case 1:
                    System.out.println("Estado inicial de la puerta 1:\n"+p1.toString());
                    t.monitorizarPuerta(p1);
                    System.out.println("Estado final de la puerta 1:\n"+p1.toString());
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Estado inicial de la puerta 2:\n"+p2.toString());
                    if (p2.isBloqueada()) {
                        p2.desbloquear();
                    } else {
                        p2.bloquear();
                    }
                    System.out.println("Estado final de la puerta 2:\n"+p2.toString());
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Estado inicial de la puerta 3:\n"+p3.toString());
                    t.monitorizarPuerta(p3);
                    System.out.println("Estado final de la puerta 3:\n"+p3.toString());
                    System.out.println("");
                    break;
                default:
                    System.out.println("No hacemos nada.....");
            }
             */
        }

        // Mostramos los estados finales de las 3 puertas
        System.out.println("Estado final de las 3 puertas:");
        System.out.println(p1.toString() + "\n" + p2.toString() + "\n" + p3.toString() + "\n");
    }

}
