/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication82;

/**
 *
 * @author victoriarodriguez
 */
public class JavaApplication82 {

       /**
        * @param args the command line arguments
        */
       public static void main(String[] args) {
              // TODO code application logic here
              float p1 = NewClass.impuestos((float) 35000);
              System.out.println(p1);
              
              float p2 = NewClass.impuestos(65000);
              System.out.println(p2);
              
       }
       
}
