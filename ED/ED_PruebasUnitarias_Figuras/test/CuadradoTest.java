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
public class CuadradoTest {

    public CuadradoTest() {
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

    /**
     * Test of calcularArea method, of class Cuadrado.
     * Comprobamos que el área se calcula bien comprobando un resultado ACERTADO.
     */
    @Test
    public void testCalcularArea() {
        System.out.println("calcularArea");
        Cuadrado instance = new Cuadrado(3);
        float expResult = (float) 9.0;
        float result = instance.calcularArea();
        assertEquals(expResult, result, 0.01);
        assertNotEquals(expResult, 5);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

     /**
     * Test of calcularArea2 method, of class Cuadrado.
     * Comprobamos que el área se calcula bien comprobando un resultado ERRÓNEO.
     */
    @Test
    public void testCalcularArea2() {
        System.out.println("calcularArea2");
        Cuadrado instance = new Cuadrado(5);
        float expResult = 20.0F;
        float result = instance.calcularArea();
        assertEquals(25.0, result,0.01);
        assertNotEquals(expResult, result, 0.01); // ¡¡¡ X-X en floats puede no dar 0.0 !!!
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
