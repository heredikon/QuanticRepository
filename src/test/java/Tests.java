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
    Complex x, y;

    @BeforeAll
    public static void setUpClass() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }

    public void deberiaCompararDosComplejosTest() {
        Complex c1 = new Complex(50, 35);
        Complex c2 = new Complex(50, 35);
        assertTrue(c1.equals(c2));

        Complex c3 = new Complex(50, 35);
        Complex c4 = new Complex(50, -35);
        assertFalse(c3.equals(c4));
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

    public void testDeberiaRestarDosNumeroComplejos() {
        Complex c1 = new Complex(6, 10);
        Complex c2 = new Complex(8, 6);
        Complex result1 = basic.subs(c1, c2);
        Complex resultToCompare1 = new Complex(-2, 4);
        assertTrue(resultToCompare1.equals(result1));

        Complex c3 = new Complex(80.5, 65);
        Complex c4 = new Complex(9.8, 78);
        Complex result2 = basic.subs(c3, c4);
        Complex resultToCompare2 = new Complex(70.7, -13);
        assertTrue(resultToCompare2.equals(result2));

        Complex c5 = new Complex(9.2, 47.4);
        Complex c6 = new Complex(12.7, 8.2);
        Complex result3 = basic.subs(c5, c6);
        Complex resultToCompare3 = new Complex(-3.5, 39.2);
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

    public void testDeberiaDividirDosNumeroComplejos1() {
        Complex c1 = new Complex(5, 0);
        Complex c2 = new Complex(0, 2);
        Complex result1 = basic.divide(c1, c2);
        Complex resultToCompare1 = new Complex(0, -2.5);
        assertTrue(resultToCompare1.equals(result1));

        Complex c3 = new Complex(0, 5);
        Complex c4 = new Complex(2, 0);
        Complex result2 = basic.divide(c3, c4);
        Complex resultToCompare2 = new Complex(0, 2.5);
        assertTrue(resultToCompare2.equals(result2));

        Complex c5 = new Complex(0, 3);
        Complex c6 = new Complex(-1, -1);
        Complex result3 = basic.divide(c5, c6);
        Complex resultToCompare3 = new Complex(-1.5, -1.5);
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
        Complex[] v1 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        Complex[] v2 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        assertTrue(basic.equalsV(v1, v2));

        Complex[] v3 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        Complex[] v4 = {new Complex(2, 5), new Complex(1, 1)};
        assertFalse(basic.equalsV(v3, v4));

        Complex[] v5 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        Complex[] v6 = {new Complex(2, 5), new Complex(8, 1), new Complex(4, 3)};
        //assertFalse(basic.equalsV(v5, v6));
    }

    public void testDeberiaSumarDosVectoresDeComplejos() {
        Complex[] v1 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        Complex[] v2 = {new Complex(1, 1), new Complex(2, 2), new Complex(3, 3)};
        Complex[] result = basic.sumV(v1, v2);
        Complex[] resultToCompare = {new Complex(3, 6), new Complex(3, 3), new Complex(7, 6)};
        assertTrue(basic.equalsV(result, resultToCompare));

        Complex[] v3 = {new Complex(1, 5), new Complex(26, 9.8), new Complex(50.1, 6.7)};
        Complex[] v4 = {new Complex(7, 3), new Complex(2.6, 43), new Complex(47.9, 5.8)};
        Complex[] result2 = basic.sumV(v3, v4);
        Complex[] resultToCompare2 = {new Complex(8, 8), new Complex(28.6, 52.8), new Complex(98, 12.5)};
        assertTrue(basic.equalsV(result2, resultToCompare2));
    }

    public void testDeberiaObtenerElInversoDeUnVectorDeComplejos() {
        Complex[] v1 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        Complex[] result1 = basic.inverseV(v1);
        Complex[] resultToCompare1 = {new Complex(-2, -5), new Complex(-1, -1), new Complex(-4, -3)};
        assertTrue(basic.equalsV(result1, resultToCompare1));

        Complex[] v2 = {new Complex(1, -5), new Complex(-26, 9.8), new Complex(50.1, 6.7)};
        Complex[] result2 = basic.inverseV(v2);
        Complex[] resultToCompare2 = {new Complex(-1, 5), new Complex(26, -9.8), new Complex(-50.1, -6.7)};
        assertTrue(basic.equalsV(result2, resultToCompare2));

        Complex[] v3 = {new Complex(3, -6), new Complex(3, 3), new Complex(-7, -6)};
        Complex[] result3 = basic.inverseV(v3);
        Complex[] resultToCompare3 = {new Complex(-3, 6), new Complex(-3, -3), new Complex(7, 6)};
        assertTrue(basic.equalsV(result3, resultToCompare3));
    }

    public void testDeberiaObtenerElConjugadoDeUnVectorDeComplejos() {
        Complex[] v1 = {new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)};
        Complex[] result1 = basic.conjugadoV(v1);
        Complex[] resultToCompare1 = {new Complex(2, -5), new Complex(1, -1), new Complex(4, -3)};
        assertTrue(basic.equalsV(result1, resultToCompare1));

        Complex[] v2 = {new Complex(1, -5), new Complex(-26, 9.8), new Complex(50.1, 6.7)};
        Complex[] result2 = basic.conjugadoV(v2);
        Complex[] resultToCompare2 = {new Complex(1, 5), new Complex(-26, -9.8), new Complex(50.1, -6.7)};
        assertTrue(basic.equalsV(result2, resultToCompare2));

        Complex[] v3 = {new Complex(3, -6), new Complex(3, 3), new Complex(-7, -6)};
        Complex[] result3 = basic.conjugadoV(v3);
        Complex[] resultToCompare3 = {new Complex(3, 6), new Complex(3, -3), new Complex(-7, 6)};
        assertTrue(basic.equalsV(result3, resultToCompare3));
    }

    public void testDeberiaRealizarLaMultiplicacionEscalarConVector() {
        Complex[][] v1 = {{new Complex(2, 3), new Complex(4, 5), new Complex(3.7, 0)}};
        Complex c1 = new Complex(2, 4);
        Complex[][] result1 = basic.scalarMult(c1, v1);
        Complex[][] resultToCompare1 = {{new Complex(-8, 14), new Complex(-12, 26), new Complex(7.4, 14.8)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

    }

    public void testDeberiaCompararDosMatrices() {
        Complex[][] m1 = {{new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)}, {new Complex(1, 8), new Complex(7, 10), new Complex(0, 3)}};
        Complex[][] m2 = {{new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)}, {new Complex(1, 8), new Complex(7, 10), new Complex(0, 3)}};
        assertTrue(basic.equalsM(m1, m2));

        Complex[][] m3 = {{new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)}, {new Complex(1, 8), new Complex(7, 10), new Complex(0, 3)}};
        Complex[][] m4 = {{new Complex(2, 5), new Complex(1, 1)}, {new Complex(7, 10), new Complex(0, 3)}};
        assertFalse(basic.equalsM(m3, m4));

        Complex[][] m5 = {{new Complex(2, 5), new Complex(1, 1), new Complex(4, 3)}, {new Complex(1, 8), new Complex(7, 10), new Complex(0, 3)}};
        Complex[][] m6 = {{new Complex(2, 7), new Complex(-1, 1), new Complex(4, 3)}, {new Complex(1, 8), new Complex(7, 10), new Complex(45, 3)}};
        assertFalse(basic.equalsM(m5, m6));
    }

    public void testDeberiaRealizarLaSumaDeMatrices() {
        Complex[][] m1 = {{new Complex(2, 3), new Complex(4, 5)}, {new Complex(3, 0), new Complex(1, 5)}};
        Complex[][] m2 = {{new Complex(2, 3), new Complex(4, 5)}, {new Complex(3, 1), new Complex(1, 5)}};
        Complex[][] result1 = basic.sumM(m1, m2);
        Complex[][] resultToCompare1 = {{new Complex(4, 6), new Complex(8, 10)}, {new Complex(6, 1), new Complex(2, 10)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

        Complex[][] m3 = {{new Complex(2, 3), new Complex(4, 5)}, {new Complex(3, 0), new Complex(1, -5)}};
        Complex[][] m4 = {{new Complex(2, -3.5), new Complex(7, 10)}, {new Complex(3, -1.5), new Complex(1, 5)}};
        Complex[][] result2 = basic.sumM(m3, m4);
        Complex[][] resultToCompare2 = {{new Complex(4, -0.5), new Complex(11, 15)}, {new Complex(6, -1.5), new Complex(2, 0)}};
        assertTrue(basic.equalsM(result2, resultToCompare2));
    }

    public void testDeberiaCalcularElInversoDeUnaMatriz() {
        Complex[][] m1 = {{new Complex(2, 3), new Complex(4, 5)}, {new Complex(3, 0), new Complex(1, 5)}};
        Complex[][] result1 = basic.inverseM(m1);
        Complex[][] resultToCompare1 = {{new Complex(-2, -3), new Complex(-4, -5)}, {new Complex(-3, 0), new Complex(-1, -5)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

        Complex[][] m2 = {{new Complex(8, -3), new Complex(-4, 5.5)}, {new Complex(3, 75), new Complex(-105, 5)}};
        Complex[][] result2 = basic.inverseM(m2);
        Complex[][] resultToCompare2 = {{new Complex(-8, 3), new Complex(4, -5.5)}, {new Complex(-3, -75), new Complex(105, -5)}};
        assertTrue(basic.equalsM(result2, resultToCompare2));
    }

    public void testDeberiaRealizarLaMultiplicacionEscalarConMatriz() {
        Complex[][] m1 = {{new Complex(4, 4), new Complex(5, 7)}, {new Complex(3.5, 25.5), new Complex(1, 5)}};
        Complex c1 = new Complex(2, 4);
        Complex[][] result1 = basic.scalarMult(c1, m1);
        Complex[][] resultToCompare1 = {{new Complex(-8, 24), new Complex(-18, 34)}, {new Complex(-95, 65), new Complex(-18, 14)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

        Complex[][] m2 = {{new Complex(1, 4), new Complex(5, 3)}, {new Complex(3.5, 5.5), new Complex(1, 2)}};
        Complex c2 = new Complex(3, 5);
        Complex[][] result2 = basic.scalarMult(c2, m2);
        Complex[][] resultToCompare2 = {{new Complex(-17, 17), new Complex(0, 34)}, {new Complex(-17, 34), new Complex(-7, 11)}};
        assertTrue(basic.equalsM(result2, resultToCompare2));
    }

    public void testDeberiaCalcularElConjugadoDeUnaMatriz() {
        Complex[][] m1 = {{new Complex(4, 4), new Complex(5, 7)}, {new Complex(3.5, 25.5), new Complex(1, 5)}};
        Complex[][] result1 = basic.conjugadoM(m1);
        Complex[][] resultToCompare1 = {{new Complex(4, -4), new Complex(5, -7)}, {new Complex(3.5, -25.5), new Complex(1, -5)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

        Complex[][] m2 = {{new Complex(1, -4), new Complex(-5, 3)}, {new Complex(-3.5, -5.5), new Complex(1, 2)}};
        Complex[][] result2 = basic.conjugadoM(m2);
        Complex[][] resultToCompare2 = {{new Complex(1, 4), new Complex(-5, -3)}, {new Complex(-3.5, 5.5), new Complex(1, -2)}};
        assertTrue(basic.equalsM(result2, resultToCompare2));
    }

    public void testDeberiaCalcularLaTranspuestaDeUnaMatriz() {
        Complex[][] m1 = {{new Complex(4, 4), new Complex(5, 7)}, {new Complex(3.5, 25.5), new Complex(1, 5)}};
        Complex[][] result1 = basic.transpM(m1);
        Complex[][] resultToCompare1 = {{new Complex(4, 4), new Complex(3.5, 25.5)}, {new Complex(5, 7), new Complex(1, 5)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

        Complex[][] m2 = {{new Complex(1, -4), new Complex(-5, 3)}, {new Complex(-3.5, -5.5), new Complex(1, 2)}};
        Complex[][] result2 = basic.transpM(m2);
        Complex[][] resultToCompare2 = {{new Complex(1, -4), new Complex(-3.5, -5.5)}, {new Complex(-5, 3), new Complex(1, 2)}};
        assertTrue(basic.equalsM(result2, resultToCompare2));

        Complex[][] m3 = {{new Complex(1, 4), new Complex(8, 10), new Complex(5, 3)}, {new Complex(3.5, 5.5), new Complex(6, 12), new Complex(1, 2)}};
        Complex[][] result3 = basic.transpM(m3);
        Complex[][] resultToCompare3 = {{new Complex(1, 4), new Complex(3.5, 5.5)}, {new Complex(8, 10), new Complex(6, 12)}, {new Complex(5, 3), new Complex(1, 2)}};
        assertTrue(basic.equalsM(result3, resultToCompare3));
    }

    public void testDeberiaCalcularLaAdjuntaDeUnaMatriz() {
        Complex[][] m1 = {{new Complex(4, 4), new Complex(5, 7)}, {new Complex(3.5, 25.5), new Complex(1, 5)}};
        Complex[][] result1 = basic.attachedM(m1);
        Complex[][] resultToCompare1 = {{new Complex(4, -4), new Complex(3.5, -25.5)}, {new Complex(5, -7), new Complex(1, -5)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

        Complex[][] m2 = {{new Complex(1, -4), new Complex(-5, 3)}, {new Complex(-3.5, -5.5), new Complex(1, 2)}};
        Complex[][] result2 = basic.attachedM(m2);
        Complex[][] resultToCompare2 = {{new Complex(1, 4), new Complex(-3.5, 5.5)}, {new Complex(-5, -3), new Complex(1, -2)}};
        assertTrue(basic.equalsM(result2, resultToCompare2));

        Complex[][] m3 = {{new Complex(1, 4), new Complex(8, 10), new Complex(5, 3)}, {new Complex(3.5, 5.5), new Complex(6, 12), new Complex(1, 2)}};
        Complex[][] result3 = basic.attachedM(m3);
        Complex[][] resultToCompare3 = {{new Complex(1, -4), new Complex(3.5, -5.5)}, {new Complex(8, -10), new Complex(6, -12)}, {new Complex(5, -3), new Complex(1, -2)}};
        assertTrue(basic.equalsM(result3, resultToCompare3));
    }

    public void testDeberiaMultiplicarMatrices() {
        Complex[][] m1 = {{new Complex(1, 2), new Complex(3, 4)}, {new Complex(2, 1), new Complex(4, 5)}};
        Complex[][] m2 = {{new Complex(1, 2), new Complex(3, 4), new Complex(1, 1)}, {new Complex(2, 1), new Complex(4, 5), new Complex(4, 6)}};

        Complex[][] result1 = basic.multM(m1, m2);
        Complex[][] resultToCompare1 = {{new Complex(-1, 15), new Complex(-13, 41), new Complex(-13, 37)}, {new Complex(3, 19), new Complex(-7, 51), new Complex(-13, 47)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

        Complex[][] m3 = {{new Complex(1, 2), new Complex(3, 4)}, {new Complex(2, 1), new Complex(4, 5)}, {new Complex(1, 1), new Complex(2, 2)}};
        Complex[][] m4 = {{new Complex(1, 2), new Complex(3, 4)}, {new Complex(2, 1), new Complex(4, 5)}};
        Complex[][] result2 = basic.multM(m3, m4);
        Complex[][] resultToCompare2 = {{new Complex(-1, 15), new Complex(-13, 41)}, {new Complex(3, 19), new Complex(-7, 51)}, {new Complex(1, 9), new Complex(-3, 25)}};
        assertTrue(basic.equalsM(result2, resultToCompare2));

    }

    public void testDeberiaCalcularLaAccion() {
        Complex[][] m1 = {{new Complex(1, 0), new Complex(0, 0), new Complex(1, 0)}, {new Complex(0, 0), new Complex(1, 0), new Complex(0, 0)}, {new Complex(1, 0), new Complex(0, 0), new Complex(1, 0)}};
        Complex[] v1 = {new Complex(1, 0), new Complex(0, 0), new Complex(1, 0)};

        Complex[] result1 = basic.accion(m1, v1);
        Complex[] resultToCompare1 = {new Complex(2, 0), new Complex(0, 0), new Complex(2, 0)};
        assertTrue(basic.equalsV(result1, resultToCompare1));

        Complex[][] m2 = {{new Complex(1, 1), new Complex(0, -3), new Complex(1, 0)}, {new Complex(0, 2), new Complex(0, 0), new Complex(0, 0)}, {new Complex(0, 0), new Complex(1, 3), new Complex(5, 1)}};
        Complex[] v2 = {new Complex(-1, -1), new Complex(0, -5), new Complex(2, 3)};
        Complex[] result2 = basic.accion(m2, v2);
        Complex[] resultToCompare2 = {new Complex(-13, 1), new Complex(2, -2), new Complex(22, 12)};
        assertTrue(basic.equalsV(result2, resultToCompare2));

    }

    public void testDeberiaCalcularElProductoInternoEntreVectores() {
        Complex[] v1 = {new Complex(1, 1), new Complex(0, 2), new Complex(1, 0)};
        Complex[] v2 = {new Complex(1, 0), new Complex(1, 0), new Complex(1, 3)};

        Complex result1 = basic.internalProV(v1, v2);
        Complex resultToCompare1 = new Complex(2, 0);
        assertTrue(result1.equals(resultToCompare1));

        Complex[] v3 = {new Complex(0, -3), new Complex(0, 0), new Complex(1, 3)};
        Complex[] v4 = {new Complex(1, 0), new Complex(0, 0), new Complex(5, 1)};

        Complex result2 = basic.internalProV(v3, v4);
        Complex resultToCompare2 = new Complex(8, -11);
        assertTrue(result2.equals(resultToCompare2));

        Complex[] v5 = {new Complex(1, 2), new Complex(0, 2), new Complex(-6, -3)};
        Complex[] v6 = {new Complex(0, 5), new Complex(4, -6), new Complex(5, 1)};

        Complex result3 = basic.internalProV(v5, v6);
        Complex resultToCompare3 = new Complex(-35, 6);
        assertTrue(result3.equals(resultToCompare3));

        Complex[] v7 = {new Complex(1, 2), new Complex(0, 2), new Complex(-6, -3)};
        Complex[] v8 = {new Complex(1, 2), new Complex(0, 2), new Complex(-6, -3)};
            Complex result4 = basic.internalProV(v7, v8);
            Complex resultToCompare4 = new Complex(54, 0);
            assertTrue(result4.equals(resultToCompare4));
    }

    public void testDeberiaCalcularLaTrazaDeUnaMatrizCompleja() {
        Complex[][] m1 = {{new Complex(1, 2), new Complex(3, 4)}, {new Complex(2, 1), new Complex(4, 5)}};
        Complex result1 = basic.trace(m1);
        Complex resultToCompare1 = new Complex(5, 7);
        assertTrue(result1.equals(resultToCompare1));

        Complex[][] m2 = {{new Complex(1, 0), new Complex(0, 0), new Complex(1, 0)}, {new Complex(0, 0), new Complex(1, 0), new Complex(0, 0)}, {new Complex(1, 0), new Complex(0, 0), new Complex(1, 0)}};
        Complex result2 = basic.trace(m2);
        Complex resultToCompare2 = new Complex(3, 0);
        assertTrue(result2.equals(resultToCompare2));

        Complex[][] m3 = {{new Complex(1, -4), new Complex(-5, 3)}, {new Complex(-3.5, -5.5), new Complex(1, 2)}};
        Complex result3 = basic.trace(m3);
        Complex resultToCompare3 = new Complex(2, -2);
        assertTrue(result3.equals(resultToCompare3));
    }

//    public void testDeberiaCalcularElProductoInternoEntreMatricesComplejas() {
//        Complex[][] m1 = {{new Complex(1, 2), new Complex(3, 4)}, {new Complex(2, 1), new Complex(4, 5)}};
//        Complex[][] m2 = {{new Complex(1, 2), new Complex(3, 4)}, {new Complex(2, 1), new Complex(4, 5)}};
//
//            Complex result1 = basic.internalprodM(m1, m2);
//            Complex resultToCompare1 = new Complex(76, 0);
//            assertTrue(result1.equals(resultToCompare1));
//
//
//        Complex[][] m3 = {{new Complex(1, 0), new Complex(0, -2)}, {new Complex(0, -5), new Complex(3, 0)}};
//        Complex[][] m4 = {{new Complex(0, -4), new Complex(-3, 0)}, {new Complex(2, 1), new Complex(3, -2)}};
//
//            Complex result2 = basic.internalprodM(m3, m4);
//            Complex resultToCompare2 = new Complex(4, -6);
//            assertTrue(result2.equals(resultToCompare2));
//
//    }

    public void testDeberiaCalcularLaNormaDeUnVectorComplejo() {
        Complex[] v1 = {new Complex(1, 1), new Complex(0, 2), new Complex(1, 0)};

            double result1 = basic.normV(v1);
            double resultToCompare1 = Math.sqrt(7);
            assertTrue(result1 == resultToCompare1);


        Complex[] v2 = {new Complex(0, -3), new Complex(0, 0), new Complex(1, 3)};

            double result2 = basic.normV(v2);
            double resultToCompare2 = Math.sqrt(19);
            assertTrue(result2 == resultToCompare2);


        Complex[] v3 = {new Complex(1, 0), new Complex(0, 0), new Complex(5, 1)};

            double result3 = basic.normV(v3);
            double resultToCompare3 = Math.sqrt(27);
            assertTrue(result3 == resultToCompare3);

        Complex[] v4 = {new Complex(4, 3), new Complex(6, -4), new Complex(12, -7), new Complex(0, 13)};
            double result4 = basic.normV(v4);
            double resultToCompare4 = Math.sqrt(439);
            assertTrue(result4 == resultToCompare4);

    }

    public void testDeberiaCalcularLaDistanciaEntreDosVectoresComplejos() {
        Complex[] v1 = {new Complex(3, 0), new Complex(1, 0), new Complex(2, 0)};
        Complex[] v2 = {new Complex(2, 0), new Complex(2, 0), new Complex(-1, 0)};

            double result1 = basic.distanceV(v1, v2);
            double resultToCompare1 = Math.sqrt(11);
            assertTrue(result1 == resultToCompare1);

    }

    public void testDeberiaDeterminarSiUnaMatrizCuadradaEsHermitiana() {
        Complex[][] m1 = {{new Complex(5, 0), new Complex(4, 5), new Complex(6, -16)}, {new Complex(4, -5), new Complex(13, 0), new Complex(7, 0)}, {new Complex(6, 16), new Complex(7, 0), new Complex(-2.1, 0)}};
            boolean result1 = basic.isHermitian(m1);
            assertTrue(result1);


        Complex[][] m2 = {{new Complex(7, 0), new Complex(6, 5)}, {new Complex(6, -5), new Complex(-3, 0)}};
            boolean result2 = basic.isHermitian(m2);
            assertTrue(result2);

        Complex[][] m3 = {{new Complex(1, 2), new Complex(3, 4)}, {new Complex(2, 1), new Complex(4, 5)}};
            boolean result3 = basic.isHermitian(m3);
            assertFalse(result3);
    }

    public void testDeberiaCalcularLaMatrizIdentidad() {
        Complex[][] result1 = basic.identityM(2);
        Complex[][] resultToCompare1 = {{new Complex(1, 0), new Complex(0, 0)}, {new Complex(0, 0), new Complex(1, 0)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));

        Complex[][] result2 = basic.identityM(3);
        Complex[][] resultToCompare2 = {{new Complex(1, 0), new Complex(0, 0), new Complex(0, 0)}, {new Complex(0, 0), new Complex(1, 0), new Complex(0, 0)}, {new Complex(0, 0), new Complex(0, 0), new Complex(1, 0)}};
        assertTrue(basic.equalsM(result2, resultToCompare2));
    }

    public void testDeberiaDeterminarSiUnaMatrizCuadradaEsUnitaria() {
        Complex[][] m1 = {{new Complex(0.5, 0.5), new Complex(0.5, -0.5)}, {new Complex(0.5, -0.5), new Complex(0.5, 0.5)}};
            boolean result1 = basic.isUnitary(m1);
            assertTrue(result1);
    }

    public void testDeberiaCalcularElProductoTensorEntreMatrices() {
        Complex[][] m1 = {{new Complex(1, 0), new Complex(2, 0)}, {new Complex(3, 0), new Complex(4, 0)}};
        Complex[][] m2 = {{new Complex(5, 0), new Complex(6, 0)}, {new Complex(7, 0), new Complex(8, 0)}};
        Complex[][] result1 = basic.tensorProduct(m1, m2);
        Complex[][] resultToCompare1 = {{new Complex(5, 0), new Complex(6, 0), new Complex(10, 0), new Complex(12, 0)}, {new Complex(7, 0), new Complex(8, 0), new Complex(14, 0), new Complex(16, 0)}, {new Complex(15, 0), new Complex(18, 0), new Complex(20, 0), new Complex(24, 0)}, {new Complex(21, 0), new Complex(24, 0), new Complex(28, 0), new Complex(32, 0)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));
    }
}
