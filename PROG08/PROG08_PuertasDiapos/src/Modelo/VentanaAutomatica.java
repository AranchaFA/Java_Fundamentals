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
public class VentanaAutomatica extends Ventana implements Automatizable{

    public VentanaAutomatica(int id) {
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
    
    // Bloquear o desbloquear de manera automática y selectiva
    public void timeOut(){
        if (bloqueada) {
            desbloquear();
        } else {
            bloquear();
        }
    }
}
