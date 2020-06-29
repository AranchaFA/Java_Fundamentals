/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06ficherosCaracteres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjemploLecturaTecladoInputStreamReader {

    public static void main(String[] args) throws IOException {
        //Notar que readLine() nos obliga a declarar IOException
        //creamos el objeto teclado para leer las teclas del teclado como byte
        InputStreamReader teclado = new InputStreamReader(System.in);

        //creamos ahora el lector del teclado a través de un buffer
        BufferedReader lectorTeclado = new BufferedReader(teclado); //Ya tenemos el "lector"

        System.out.println("Por favor ingrese su nombre");//Se pide un dato al usuario

        String nombre = lectorTeclado.readLine(); //Se lee el nombre con readLine() que retorna un String con el dato

        System.out.println("Bienvenido " + nombre + ". Por favor ingrese su edad");//Se pide otro dato al usuario

        String entrada = lectorTeclado.readLine(); //Se guarda la entrada (edad) en una variable

        //Nótese que readLine siempre retorna String y la clase BufferedReader...
        //no tiene un método para leer enteros, así que debemos convertirlo.
        int edad = Integer.parseInt(entrada);//Se transforma la entrada anterior en un entero
        //Si el usuario ingresó solo números funcionará bien, de lo contrario generará una excepción

        System.out.println("Gracias " + nombre + " en 10 años usted tendrá " + (edad + 10) + " años."); //Operacion numerica con la edad

    }
}
