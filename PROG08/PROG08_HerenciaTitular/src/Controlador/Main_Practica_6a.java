
package Controlador;

import Modelo.CuentaAhorro;
import Modelo.CuentaCorriente;
import Modelo.Titular;

public class Main_Practica_6a {

    public static void main(String[] args) {
        
        Titular titularNoe=new Titular("Noe", "Tira Donada", 39);
        System.out.println("Datos de Noe\n"+titularNoe.toString());
        CuentaCorriente cuentaNoe=new CuentaCorriente(titularNoe, "000001");
        System.out.println("Visualizar cuenta de Noe\n"+cuentaNoe.toString());
        cuentaNoe.ingreso(1000);
        System.out.println("Visualizar cuenta tras ingresar 1000€\n"+cuentaNoe.toString());
        cuentaNoe.reintegro(300);
        System.out.println("Visualizar cuenta tras sacar 300€\n"+cuentaNoe.toString());
        
        System.out.println("Creamos una cuenta de ahorro para Noe");
        CuentaAhorro 
    }
    
}
