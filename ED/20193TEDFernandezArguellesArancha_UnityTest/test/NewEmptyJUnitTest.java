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
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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
    public void testImpuestos1(){
        // Ponemos un sout para ver que está empezando a ejecutar el método test
        System.out.println("Primer test.");
        // No necesitamos crear un objeto de la clase que tiene el método que vamos a testear porque es static
        // Variable con el resultado esperado ACERTADO
        float resultadoEsperado=(float) 4177.5;
        // Variable con el resultado que dwevuelve el método
        float resultadoObtenido=NewClass.impuestos(20000);
        // Comprobamos que coincide el resultado CORRECTO 
        // (le damos un margen de error de 0.01 porque al ser float pueden no coincidir los resultados 100% exactos)
        assertEquals(resultadoEsperado, resultadoObtenido,0.01);
    }
    @Test
    public void testImpuestos2(){
        // Ponemos un sout para ver que está empezando a ejecutar el método test
        System.out.println("Segundo test.");
        // No necesitamos crear un objeto de la clase que tiene el método que vamos a testear porque es static
        // Variable con el resultado esperado ACERTADO
        float resultadoEsperado=(float) 8665.5;
        // Variable con el resultado que dwevuelve el método
        float resultadoObtenido=NewClass.impuestos(35000);
        // Comprobamos que coincide el resultado CORRECTO 
        // (le damos un margen de error de 0.01 porque al ser float pueden no coincidir los resultados 100% exactos)
        assertEquals(resultadoEsperado, resultadoObtenido,0.01);
    }
    @Test
    public void testImpuestos3(){
        // Ponemos un sout para ver que está empezando a ejecutar el método test
        System.out.println("Tercer test.");
        // No necesitamos crear un objeto de la clase que tiene el método que vamos a testear porque es static
        // Variable con el resultado esperado ACERTADO
        float resultadoEsperado=(float) 14201.5;
        // Variable con el resultado que dwevuelve el método
        float resultadoObtenido=NewClass.impuestos(50000);
        // Comprobamos que coincide el resultado CORRECTO 
        // (le damos un margen de error de 0.01 porque al ser float pueden no coincidir los resultados 100% exactos)
        assertEquals(resultadoEsperado, resultadoObtenido,0.01);
    }
    @Test
    public void testImpuestos4(){
        // Ponemos un sout para ver que está empezando a ejecutar el método test
        System.out.println("Cuarto test.");
        // No necesitamos crear un objeto de la clase que tiene el método que vamos a testear porque es static
        // Variable con el resultado esperado ACERTADO
        float resultadoEsperado=(float) 20151.5;
        // Variable con el resultado que dwevuelve el método
        float resultadoObtenido=NewClass.impuestos(65000);
        // Comprobamos que coincide el resultado CORRECTO 
        // (le damos un margen de error de 0.01 porque al ser float pueden no coincidir los resultados 100% exactos)
        assertEquals(resultadoEsperado, resultadoObtenido,0.01);
    }
}
