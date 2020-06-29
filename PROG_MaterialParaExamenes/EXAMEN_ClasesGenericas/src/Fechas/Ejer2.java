package Fechas;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Ejer2 {

    public static void main(String[] args) {
        
        
        Scanner teclado = new Scanner(System.in);
        // Creamos un obj. GregorianCalendar con la fecha del sistema que será la fecha de envasado
        Calendar fechaEnvasado1=GregorianCalendar.getInstance();
        // Creamos un obj. clon de la fecha de envasado para no modificar ésta primera al añadir el
        // nº de días que tarda en caducar
        GregorianCalendar fechaCaducidad1=(GregorianCalendar) fechaEnvasado1.clone();
        // Añadimos 
        fechaCaducidad1.add(Calendar.DATE, 100);
        
        System.out.println("Fecha de caducidad: ");
        System.out.println(fechaCaducidad1.get(Calendar.DATE) + " / " + (fechaCaducidad1.get(Calendar.MONTH) + 1) + " / " + fechaCaducidad1.get(Calendar.YEAR));
        
        System.out.println("\n\nMete fecha de envasado: ");
        Calendar fechaEnvasado2=GregorianCalendar.getInstance();
        
        
    }
    
}
