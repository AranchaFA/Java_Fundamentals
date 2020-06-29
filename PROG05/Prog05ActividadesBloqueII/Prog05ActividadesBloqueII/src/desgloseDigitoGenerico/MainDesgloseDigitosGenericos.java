package desgloseDigitoGenerico;

import paqueteLeerDatos.Leer;

public class MainDesgloseDigitosGenericos {

    public static void main(String[] args) {
        long numero, cociente, resto;
        long digitos = 1;
        String mensaje = "";
        do {
            System.out.println("Introduce un número entero:");
            numero = Leer.datoLong();
        } while (numero <= 0);
        
        do {
            digitos *= 10;
            resto = numero % 10;
            numero /= 10;
            mensaje += " " + resto*digitos/10+"+";
            
        } while (numero > 0);
        System.out.println("mensaje:"+mensaje );

    }
}
