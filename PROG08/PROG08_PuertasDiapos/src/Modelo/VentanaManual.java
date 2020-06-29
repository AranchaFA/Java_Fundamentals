/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Arancha
 */
public class VentanaManual extends Ventana{

    
    
    public VentanaManual(int id) {
        super(id);
    }

    @Override
    public void bloquear() {
        bloqueada=true;
    }

    @Override
    public void desbloquear() {
        bloqueada=false;
    }

    
}
