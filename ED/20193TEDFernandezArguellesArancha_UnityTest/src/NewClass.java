/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;

/**
 *
 * @author 
 */
public class NewClass {

       public static float impuestos(float capital) {

              if (capital <= 12450) {
                     float impuestos = 0;
                     impuestos = (float) (capital * 0.19);
                     return impuestos;
              }

              if (capital >= 12450 && capital <= 12450 + 7750) {
                     float impuestos = 0;
                     impuestos = (float) (12450 * 0.19 + (capital - 12450) * 0.24);
                     return impuestos;
              }

              if (capital >= 20200 && capital <= 35200) {
                     float impuestos = 0;
                     impuestos = (float) (2365.5 + 1860 + (capital - 20200) * 0.30);
                     return impuestos;
              }

              if (capital >= 35200 && capital <= 60000) {
                     float impuestos = 0;
                     impuestos = (float) (2365.5 + 1860 + 4500  + (capital - 35200) * 0.37);
                     return impuestos;
              }
              
              if (capital >= 60000 && capital >= 60000) {
                     float impuestos = 0;
                     impuestos = (float) (2365.5 + 1860 + 4500 + 9166 + (capital - 60000) * 0.45);
                     return impuestos;
              }

              return 1000;

       }
}
