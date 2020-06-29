import paqueteLeerDatos.Leer;

public class MainEntradaDatos {
    public static void main(String[] args) {
        
        short num1;
	 int num2;
	 long num3;
 	 float num4;
	 double num5;
        String cadena;
        
//leer una cadena
        System.out.println("Introducir una cadena:");
        cadena =Leer.leerDato();
        System.out.println("la cadena es: "+ cadena);
      
       
        //leer un entero corto
        System.out.println("Leer numero entero corto:");
        num1 =Leer.datoShort();
        System.out.println("has introducido un :"+num1);

        //leer un entero 
        System.out.println("Leer numero entero:");
        num2 =Leer.datoInt();
        System.out.println("has introducido un :"+num2);

        //leer un long 
        System.out.println("Leer numero entero long:");
        num3 =Leer.datoLong();
        System.out.println("has introducido un :"+num3);

        //leer un float 
        System.out.println("Leer numero real float:");
        num4 =Leer.datoFloat();
        System.out.println("has introducido un :"+num4);

        //leer un double 
        System.out.println("Leer numero real double:");
        num5 =Leer.datoDouble();
        System.out.println("has introducido un :"+num5);

    }    
}
