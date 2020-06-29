
package EJER1;

import java.util.Scanner;


public class Maquina_dispensadora {
    private Agua agua;
    private Refresco refresco;
    private Chocolatina chocolatina;

    public Maquina_dispensadora() {
       this.agua=new Agua("AGUA",1.99);
       this.chocolatina=new Chocolatina("CHOCOLATINA",3.55);
       this.refresco=new Refresco("REFRESCO",2.55);
    }
    
    
    public void vender(){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("introduzca dinero");
        double cantidad=sc.nextDouble();
        System.out.println("seleccione producto...");
        String tipo=sc.next();
        sc.nextLine();
        System.out.println(tipo);
        if(tipo.equalsIgnoreCase("agua")){
            agua.mensaje();
            System.out.println("su cambio es de :"+agua.retorna_cambio(cantidad));
            agua=null;
        }else if(tipo.equalsIgnoreCase("chocolatina")){
            chocolatina.mensaje();
            System.out.println("su cambio es de: "+ chocolatina.retorna_cambio(cantidad));
            chocolatina=null;
        }else if (tipo.equalsIgnoreCase("refresco")){
             refresco.mensaje();
             System.out.println("su cambio es de : "+refresco.retorna_cambio(cantidad));
             refresco=null;
        }
        
        
        
    }
    
    
}
