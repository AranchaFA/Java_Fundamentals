/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CuentaBancaria;
import Modelo.Persona;
import java.util.Scanner;

/**
 *
 * @author Arancha
 */
public class Main_Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // CReamos dos personas titulares de las cuentas:
        Persona evaPorada;
        Persona jacintoCinete;
        evaPorada = new Persona("Eva", "Porada", "01234567A");
        jacintoCinete = new Persona("Jacinto", "Cinete", "98765432Z");

        // Creamos sus dos cuentas bancarias:
        CuentaBancaria cuentaEvaPorada;
        CuentaBancaria cuentaJacintoCinete;
        cuentaEvaPorada = new CuentaBancaria(evaPorada, "0123456789", 1000);
        cuentaJacintoCinete=new CuentaBancaria(jacintoCinete, "9876543210", 0);
        
        // Mostramos los valores iniciales de ambos:
        System.out.println("Datos de la cuenta de Eva: "+cuentaEvaPorada.toString());
        System.out.println("Datos de la cuenta de Jacinto: "+cuentaJacintoCinete.toString());
        
        // Eva retira una cantidad pedida por teclado:
        System.out.println("Eva quiere retirar una cantidad, ¿cuánto?: ");
        cuentaEvaPorada.retirarDinero(teclado.nextFloat());
        // Mostramos los datos de Eva tras la retirada:
        System.out.println("Datos de la cuenta de Eva tras retirar dinero: "+cuentaEvaPorada.toString());
        
        // Jacinto ingresa 300€:
        cuentaJacintoCinete.ingresarDinero(300);
        // Mostramos los datos de Eva tras la retirada:
        System.out.println("Datos de la cuenta de Jacinto tras ingresar 300€: "+cuentaJacintoCinete.toString());
        
        // Intentamos que Jacinto saque 500€ (más de lo que tiene):
        System.out.println("Jacinto intenta sacar 500€ (más de lo que tiene): ");
        cuentaJacintoCinete.retirarDinero(500);
        
        // Mostramos los valores finales de ambos:
        System.out.println("Datos de la cuenta de Eva al final: "+cuentaEvaPorada.toString());
        System.out.println("Datos de la cuenta de Jacinto al final: "+cuentaJacintoCinete.toString());
    }

}
