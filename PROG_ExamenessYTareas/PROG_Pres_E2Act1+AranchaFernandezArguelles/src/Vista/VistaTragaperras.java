/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Tragaperras;

/**
 *
 * @author Arancha
 */
public class VistaTragaperras {
    
    // MÉTODOS
    public static void sonarAlarma(){
        System.out.println("* * T I R I R I I I I * *");
        System.out.println("* * ¡  P R E M I O  ! * *");
    }
    
    public static void mostrarPremio(int valorPremio){
        if (valorPremio>0) {
           System.out.println("¡ Has ganado "+valorPremio+" euros !"); 
        } else {
            System.out.println("No hay premio.");
        }
        
    }
    
    public static void sinCreditos(){
        System.out.println("¡ No tienes créditos !");
        System.out.println("Por favor, introduce dinero.");
    }
    
    public static void creditosRestantes(Tragaperras tragaperras){
        System.out.println("Créditos disponibles: "+tragaperras.getContadorCreditos().getCantidadCreditos());
    }
    
    public static void meterDinero(){
        System.out.println("Introduce importe a jugar: ");
    }
    
    public static void activarPalanca(Tragaperras tragaperras){
        if (tragaperras.getPalanca().isDesbloqueada()) {
            System.out.println("Palanca activada.");
        } else {
            System.out.println("Palanca bloqueada.");
        }
        
    }
    
    public static void mostrarResultado(Tragaperras tragaperras){
        System.out.println("Combinación:   "+tragaperras.getSlot1().getDibujo()+" "+tragaperras.getSlot2().getDibujo()+" "+tragaperras.getSlot3().getDibujo());
    }
    
    public static void mostrarRecaudacion(Tragaperras tragaperras){
        System.out.println("Dinero recaudado: "+tragaperras.getDepositoMonedas().getValorMonedas());
    }
    
    public static void volverATirar(){
        System.out.println("¿Tirar de nuevo? (S / N): ");
    }
}
