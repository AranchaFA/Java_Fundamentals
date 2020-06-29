
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

public class Ejer1 {
/*
    Calcular el número de la suerte a partir de la fecha de nacimiento (de dos formas diferentes)
    FORMA 1: Sumar dd+mm+yyyy=abcd --> a+b+c+d=nº de la suerte
    FORMA 2: Sumar d+d+m+m+y+y+y+y=nº de la suerte
*/

// Método para descomponer un número en dígitos y añadirlos a una lista de manera que queden ordenados (1|7|0|2|1|9|8|8)
public static LinkedList<Integer> descomponerEnDigitos(int numeroADescomponer){
    LinkedList<Integer> digitos=new LinkedList<>();
    // Vamos sacando cada dígito hasta que no queden más unidades
    while (numeroADescomponer>0) {
            digitos.addLast(Integer.valueOf(numeroADescomponer%10));
            numeroADescomponer/=10;
        }
    return digitos;
}
// Método para sumar los valores de una lista de Integers
public static int sumaListIntegers(List<Integer> listIntegers){
    int suma=0;
    
    for (Integer integer : listIntegers) {
        suma+=integer.intValue();
    }
    // Si la suma tiene más de un dígito seguimos descomponiendo y sumando hasta que 
    // nos quede un número de un sólo dígito
    while (suma>9) {
        suma=sumaListIntegers(descomponerEnDigitos(suma));
    }
    return suma;
}

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        // Pedimos fecha de nacimiento por teclado (con un determinado formato)
        System.out.println("Introduce tu fecha de nacimiento (dd/mm/yyyy): ");
        String fechaString = teclado.nextLine();
        // Creamos un FORMATEADOR para trabajar con fechas en este formato en concreto
        // Hay que poner el patrón dd/MM/yyyy, si ponemos /mm/ son MINUTOS, /MM/ son MESES
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

        // A partir del STRING con la fecha, creamos un objeto DATE parseando con el FORMATEADOR
        // Un obj. Date NO SE PUEDE MODIFICAR (se usa como apoyo para "compartir" fechas como en este aso)
        Date fechaDate = null;
        try {
            fechaDate = formateador.parse(fechaString);
        } catch (ParseException ex) {
            Logger.getLogger(Ejer1.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Creamos un objeto CALENDAR (GregorianCalendar) con la fecha actual (luego la modificaremos)
        // Un obj. Calendar guarda como constantes los valores de dia, mes, año, horas, mins, segs,...
        // Un obj. Calendar SE PUEDE MODIFICAR
        Calendar fechaGregorian = Calendar.getInstance();
        // Asignamos al obj. Calendar la fecha contenida en el obj. Date
        fechaGregorian.setTime(fechaDate);

        // Mostramos las constantes DATE (o DAY_OF_MONTH), MONTH, YEAR del obj. Calendar
        // Los meses empiezan en 0, así que hay que sumar 1 para mostrar u operar con el número real
        System.out.println(fechaGregorian.get(Calendar.DATE) + " / " + (fechaGregorian.get(Calendar.MONTH) + 1) + " / " + fechaGregorian.get(Calendar.YEAR));
        

        // FORMA Nº 1

        // Calculamos la suma de dd+mm+yyyy
        int numero1 = fechaGregorian.get(Calendar.DAY_OF_MONTH) + fechaGregorian.get(Calendar.MONTH) + 1 + fechaGregorian.get(Calendar.YEAR);
        System.out.println(numero1);
        // Calculamos la suma de cada dígito del número resultante del paso anterior
        // Para ello lo descomponemos en dígitos guardándolos en una lista, y sumamos esos valores guardados
        int numeroSuerte1 = sumaListIntegers(descomponerEnDigitos(numero1));
        // Número de la suerte por el primer método
        System.out.println("Tu número de la suerte es el "+numeroSuerte1+"\n\n");
        
        
        
        // FORMA Nº 2
        
        // Descomponemos en dígitos DAY_OF_MONTh, MONTH y YEAR y vamos añadiendo las listas 
        // obtenitas a una lista que contendrá todos los dígitos
        LinkedList<Integer> digitos=new LinkedList<>();
        // Añadimos en la posición 0 para que lo añada al principio y queden en orden ¿?
        // (añadir en este orden YEAR->MONTH->DATE para que queden en orden inverso) ¿?
        digitos.addAll(0, descomponerEnDigitos(fechaGregorian.get(Calendar.YEAR)));
        digitos.addAll(0, descomponerEnDigitos(fechaGregorian.get(Calendar.MONTH)+1));
        digitos.addAll(0, descomponerEnDigitos(fechaGregorian.get(Calendar.DATE)));
        // Sumamos los dígitos de la lista obtenida
        int numeroSuerte2=sumaListIntegers(digitos);
        System.out.println("Tu número de la suerte es el "+numeroSuerte2);
    }

}
