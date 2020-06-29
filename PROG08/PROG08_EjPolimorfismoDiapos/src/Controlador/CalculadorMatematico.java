
package Controlador;

import Modelo.Figura;
import Vista.Vista;

public class CalculadorMatematico {
    
    public void calculadorFormulas(Figura figura){
        Vista.verFigura(figura);
        Vista.verMensaje("Área: "+figura.calcularArea());
        Vista.verMensaje("Parímetro: "+figura.calcularPerimetro());
    }
    
}
