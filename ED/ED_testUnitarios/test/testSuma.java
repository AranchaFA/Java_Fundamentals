/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arancha
 */
public class testSuma {
    
    public testSuma() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass");
    }
    
    @Before
    public void setUp() {
        System.out.println("Before");
    }
    
    @After
    public void tearDown() {
        System.out.println("After");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSuma(){
        // VAMOS A PROBAR SUMANDO 2 Y 3
        // Ponemos un sout para ver que está empezando a ejecutar el método test
        System.out.println("Vaya perdío que toy");
        // Creamos un objeto de la clase que tiene el método que vamos a testear
        Suma suma=new Suma();
        // Variable con los resultados esperados ACERTADO y FALLIDO
        int resultadoEsperadoCorrecto=5;
        int resultadoEsperadoIncorrecto=6;
        // Variable con el resultado que dwevuelve el método
        int resultadoObtenido=suma.sumar(2, 3);
        // Comprobamos que coincide el resultado CORRECTO
        assertEquals(resultadoEsperadoCorrecto, resultadoObtenido);
        // Comprobamos que no coincide con el resultado INCORRECTO
        assertNotEquals(resultadoEsperadoIncorrecto, resultadoObtenido);
    }
    
    @Test
    public void testSuma2(){
        // VAMOS A PROBAR SUMANDO 2 Y 3
        // Ponemos un sout para ver que está empezando a ejecutar el método test
        System.out.println("Vaya perdío que toy... 2");
        // Creamos un objeto de la clase que tiene el método que vamos a testear
        Suma suma=new Suma();
        // Variable con los resultados esperados ACERTADO y FALLIDO
        int resultadoEsperadoCorrecto=50;
        int resultadoEsperadoIncorrecto=60;
        // Variable con el resultado que dwevuelve el método
        int resultadoObtenido=suma.sumar(20, 30);
        // Comprobamos que coincide el resultado CORRECTO
        assertEquals(resultadoEsperadoCorrecto, resultadoObtenido);
        // Comprobamos que no coincide con el resultado INCORRECTO
        assertNotEquals(resultadoEsperadoIncorrecto, resultadoObtenido);
    }
}
