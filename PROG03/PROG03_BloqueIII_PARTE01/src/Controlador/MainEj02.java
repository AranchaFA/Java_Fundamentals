/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Mascota;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class MainEj02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Creamos un objeto con los valores tomados por teclado:
        Mascota mascota1;

        System.out.println("Nombre del animal: ");
        String nombre1 = teclado.nextLine();
        System.out.println("Tipo de animal: ");
        String tipo1 = teclado.nextLine();

        mascota1 = new Mascota(nombre1, tipo1);

        System.out.println("Raza del animal: ");
        mascota1.setRaza(teclado.nextLine());
        System.out.println("Año de nacimiento del animal: ");
        mascota1.setAñoNacimiento(teclado.nextInt());

        // Mostramos los atributos por pantalla:
        System.out.println("Los datos del animal son: " + mascota1.toString());
        
        // Ej04 : Mostrar también los años de la mascota:
        System.out.println("La edad actual de la mascota es: "+(2018-mascota1.getAñoNacimiento()));
    }

}
