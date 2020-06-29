/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;

/**
 *
 * @author Arancha
 */
public class MainDepositos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Creamos dos depósitos de tipos distintos
        Deposito deposito=new Deposito("Perico", 1000, 10, 365);
        DepositoEstructurado depositoE=new DepositoEstructurado("Priscila", 2000, 10, 365, 50, 5);
        
        // Liquidamos ambos depósitos
        System.out.println("Depósito 1 antes de liquidar:\n"+deposito.toString());
        System.out.println("Los intereses del depósito 1 son: "+deposito.calcularIntereses());
        System.out.println("La liquidación del depósito 1 es: "+deposito.liquidarDeposito());
        System.out.println("Depósito 1 después de liquidar:\n"+deposito.toString());
        System.out.println("");
        System.out.println("Depósito 2 antes de liquidar:\n"+depositoE.toString());
        System.out.println("Los intereses del depósito 2 son: "+depositoE.calcularIntereses());
        System.out.println("La liquidación del depósito 2 es: "+depositoE.liquidarDeposito());
        System.out.println("Depósito 2 después de liquidar:\n"+depositoE.toString());
    }
    
}
