/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.cuanticrepository.Basic;
import com.mycompany.cuanticrepository.Complex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fabia
 */
public class Tests {
    
    public Tests() {
    }
    Basic basic = new Basic();
    Complex x,y;
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }
    public void testDeberiaSumarDosNumeroComplejos() {
        Complex c1 = new Complex(1, 5);
        Complex c2 = new Complex(7, 3);
        Complex result1 = basic.sum(c1, c2);
        Complex resultToCompare1 = new Complex(8, 8);
        assertTrue(resultToCompare1.equals(result1));

        Complex c3 = new Complex(26, 9.8);
        Complex c4 = new Complex(2.6, 43);
        Complex result2 = basic.sum(c3, c4);
        Complex resultToCompare2 = new Complex(28.6, 52.8);
        assertTrue(resultToCompare2.equals(result2));

        Complex c5 = new Complex(50.1, 6.7);
        Complex c6 = new Complex(47.9, 5.8);
        Complex result3 = basic.sum(c5, c6);
        Complex resultToCompare3 = new Complex(98, 12.5);
        assertTrue(resultToCompare3.equals(result3));
    }
    
    public void testDeberiaMultiplicarDosNumeroComplejos() {
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(4, 5);
        Complex result1 = basic.mult(c1, c2);
        Complex resultToCompare1 = new Complex(-7, 22);
        assertTrue(resultToCompare1.equals(result1));

        Complex c3 = new Complex(3.7, 0);
        Complex c4 = new Complex(14.1, 4.7);
        Complex result2 = basic.mult(c3, c4);
        Complex resultToCompare2 = new Complex(52.17, 17.39);
        assertTrue(resultToCompare2.equals(result2));

        Complex c5 = new Complex(-5, -2);
        Complex c6 = new Complex(0, 0);
        Complex result3 = basic.mult(c5, c6);
        Complex resultToCompare3 = new Complex(0, 0);
        assertTrue(resultToCompare3.equals(result3));
    }
    
    public void deberiaObtenerElConjugadoDeUnComplejo() {
        Complex c1 = new Complex(5, 9);
        Complex result1 = c1.conjugado();
        Complex resultToCompare1 = new Complex(5, -9);
        assertTrue(result1.equals(resultToCompare1));

        Complex c2 = new Complex(10, -84.5);
        Complex result2 = c2.conjugado();
        Complex resultToCompare2 = new Complex(10, 84.5);
        assertTrue(result2.equals(resultToCompare2));
    }

    public void testDeberiaCompararDosVectores() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        Complex[] v1 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        Complex[] v2 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        assertTrue(basic.equalsV(v1, v2));
        System.out.println("--------------------------------------------------");

        Complex[] v3 = {new Complex(2, 5), new Complex(1, 1)};
        Complex[] v4 = {new Complex(2, 5), new Complex(1, 1)};
        assertTrue(basic.equalsV(v3, v4));

        Complex[] v5 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        Complex[] v6 = {new Complex(2, 5), new Complex(8, 1), new Complex(4, 3)};
        assertFalse(basic.equalsV(v5, v6));
    }
    
    public void testDeberiaCalcularElProductoTensorEntreMatrices() {
        Complex[][] m1 = {{new Complex(1, 0), new Complex(2, 0)}, {new Complex(3, 0), new Complex(4, 0)}};
        Complex[][] m2 = {{new Complex(5, 0), new Complex(6, 0)}, {new Complex(7, 0), new Complex(8, 0)}};
        Complex[][] result1 = basic.tensorProduct(m1, m2);
        Complex[][] resultToCompare1 = {{new Complex(5, 0), new Complex(6, 0), new Complex(10, 0), new Complex(12, 0)}, {new Complex(7, 0), new Complex(8, 0), new Complex(14, 0), new Complex(16, 0)}, {new Complex(15, 0), new Complex(18, 0), new Complex(20, 0), new Complex(24, 0)}, {new Complex(21, 0), new Complex(24, 0), new Complex(28, 0), new Complex(32, 0)}};
        System.out.println(".........................."+result1[1][0]);
        assertTrue(basic.equalsM(result1, resultToCompare1));
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void s1(){
        
        System.out.println(basic.sum(new Complex(1,2), new Complex(1,2)));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Tests. For example:
    //
    // @Tests
    // public void hello() {}
}
