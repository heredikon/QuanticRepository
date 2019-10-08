
import com.mycompany.cuanticrepository.Basic;
import com.mycompany.cuanticrepository.Complex;
import com.mycompany.cuanticrepository.QuantumSystem;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fabia
 */
public class QuantumSystemTest extends TestCase {
    Basic basic = new Basic();
    QuantumSystem quantumSystem = new QuantumSystem();

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuantumSystemTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(QuantumSystemTest.class);
    }

    public void testDeberiaCalculaLaNormaDeUnKet() {
        Complex[] ket1 = {
            new Complex(-3, -1),
            new Complex(0, -2),
            new Complex(0, 1),
            new Complex(2, 0)
        };
        double result1 = basic.normaKet(ket1);
        double resultToCompare1 = Math.sqrt(19);
        assertTrue(result1 == resultToCompare1);
    }

    public void testProbabilidadDeQueUnaParticulaEsteEnUnaPosicionEnParticular() {
        Complex[] ket1 = {
            new Complex(-3, -1),
            new Complex(0, -2),
            new Complex(0, 1),
            new Complex(2, 0)
        };
        double result1 = quantumSystem.probabilidadEnUnaPosicionParticular(4, ket1, 2);
        double resultToCompare1 = Math.pow(1, 2) / Math.pow(Math.sqrt(19), 2);
        assertTrue(result1 == resultToCompare1);

        Complex[] ket2 = {
            new Complex(2, -1),
            new Complex(0, 2),
            new Complex(-1, -1),
            new Complex(1, 0),
            new Complex(0, -2),
            new Complex(2, 0)
        };
        double result2 = quantumSystem.probabilidadEnUnaPosicionParticular(6, ket2, 2);
        double resultToCompare2 = Math.pow(Math.sqrt(2), 2) / Math.pow(Math.sqrt(20), 2);
        assertTrue(result2 == resultToCompare2);

        double result3 = quantumSystem.probabilidadEnUnaPosicionParticular(6, ket2, 0);
        double resultToCompare3 = Math.pow(Math.sqrt(5), 2) / Math.pow(Math.sqrt(20), 2);
        assertTrue(result3 == resultToCompare3);
    }

    public void testDeberiaNormalizarUnVectorKet() {
        Complex[] ket1 = {
            new Complex(2, -3),
            new Complex(1, 2)
        };
        Complex[] vectorNormalizado1 = basic.normalizeV(ket1);
        double result1 = basic.normaKet(vectorNormalizado1);
        double resultToCompare1 = 1.0;
        assertTrue(result1 == resultToCompare1);

        Complex[] ket2 = {
            new Complex(3, -1),
            new Complex(2, 6),
            new Complex(7, -8),
            new Complex(6.5, 4.9),
            new Complex(0, 13),
            new Complex(0, 0),
            new Complex(21.1, 0)
        };
        Complex[] vectorNormalizado2 = basic.normalizeV(ket2);
        double result2 = basic.normaKet(vectorNormalizado2);
        double resultToCompare2 = 1.0;
        assertTrue(result2 == resultToCompare2);
    }

    public void testCalcularLaAmplitudTransicionalBraKet() {
        Complex[] ket1 = {
            new Complex(Math.sqrt(2) / 2.0, 0),
            new Complex(0, Math.sqrt(2) / 2.0)
        };
        Complex[] ket2 = {
            new Complex(0, Math.sqrt(2) / 2.0),
            new Complex(-Math.sqrt(2) / 2.0, 0)
        };
            Complex result = quantumSystem.calcularAmplitudTransicional(ket1, ket2);
            Complex result1 = new Complex(Math.round(result.getReal() * 100.0) / 100.0, Math.round(result.getImaginary() * 100.0) / 100.0);
            Complex resultToCompare1 = new Complex(0, -1.00);
            assertTrue(result1.equals(resultToCompare1));

    }

    public void testCalcularMediaDeUnObservableSobreUnVectorEstado() {
        Complex[][] m1 = {
            {new Complex(1, 0), new Complex(0, -1)},
            {new Complex(0, 1), new Complex(2, 0)}
        };
        Complex[] ket1 = {
            new Complex(Math.sqrt(2) / 2.0, 0),
            new Complex(0, Math.sqrt(2) / 2.0)
        };
            Complex result = quantumSystem.mediaDeUnObservableSobreUnVectorEstado(m1, ket1);
            Complex result1 = new Complex(Math.round(result.getReal() * 100.0) / 100.0, Math.round(result.getImaginary() * 100.0) / 100.0);
            Complex resultToCompare1 = new Complex(2.50, 0);
            assertTrue(result1.equals(resultToCompare1));
    }

    public void testDeberiaCalcularLaVarianzaDeUnOperador() {
        Complex[][] m1 = {
            {new Complex(1, 0), new Complex(0, -1)},
            {new Complex(0, 1), new Complex(2, 0)}
        };
        Complex[] ket1 = {
            new Complex(Math.sqrt(2) / 2.0, 0),
            new Complex(0, Math.sqrt(2) / 2.0)
        };
            Complex result = quantumSystem.varianzaDeUnOperador(m1, ket1);
            Complex result1 = new Complex(Math.round(result.getReal() * 100.0) / 100.0, Math.round(result.getImaginary() * 100.0) / 100.0);
            Complex resultToCompare1 = new Complex(0.25, 0);
            assertTrue(result1.equals(resultToCompare1));

    }

}
