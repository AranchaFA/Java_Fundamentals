package desgloseDigitos;

import paqueteLeerDatos.Leer;

public class MainDesgloseDigitos {

    public static void main(String[] args)  {
        int numero, cociente,  digito = 1000;
        String mensaje = null;
        do {
            System.out.println("Introduce un número máximo de 4 digitos:");
            numero = Leer.datoInt();            
        } while (numero < 0 || numero > 9999);
        while (numero > 0) {
            cociente = numero / digito;
            switch (digito) {
                case 1:
                    mensaje = "Unidades ";
                    break;
                case 10:
                    mensaje = "decenas ";
                    break;
                case 100:
                    mensaje = "Centenas ";
                    break;
                case 1000:
                    mensaje = "Unidades de millar ";
                    break;
            }
            System.out.println(mensaje + cociente * digito);
            numero %= digito;
            digito /= 10;
        }
    }

}
