

import com.mycompany.cuanticrepository.Basic;
import com.mycompany.cuanticrepository.BasicQuantic;
import com.mycompany.cuanticrepository.Complex;
import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

/**
 * Pruebas unitarias para la clase QuantumExperiments.
 *
 * @author Carlos Andres Medina Rivas
 */
public class QuantumExperimentsTest extends TestCase {

    private final BasicQuantic quantumExperiments = new BasicQuantic();
    private final Basic basic = new Basic();

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuantumExperimentsTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(QuantumExperimentsTest.class);
    }

    public void testExperimentoConMarblesBooleano() {
        int[][] matrizAdyacencia = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0}
        };
        int[] estadoInicial = {6, 2, 1, 5, 3, 10};

        int[] estadoFinalResultToCompare1 = {0, 0, 12, 5, 1, 9};

        int[] estadoFinalResult1 = quantumExperiments.experimentoConMarblesBooleano(matrizAdyacencia, estadoInicial, 1);
        Assert.assertArrayEquals(estadoFinalResultToCompare1, estadoFinalResult1);

        int[] estadoFinalResultToCompare2 = {0, 0, 9, 5, 12, 1};

        int[] estadoFinalResult2 = quantumExperiments.experimentoConMarblesBooleano(matrizAdyacencia, estadoInicial, 2);
        Assert.assertArrayEquals(estadoFinalResultToCompare2, estadoFinalResult2);

        int[] estadoFinalResultToCompare3 = {0, 0, 1, 5, 9, 12};

        int[] estadoFinalResult3 = quantumExperiments.experimentoConMarblesBooleano(matrizAdyacencia, estadoInicial, 3);
        Assert.assertArrayEquals(estadoFinalResultToCompare3, estadoFinalResult3);

    }

    public void testExperimentoConMarblesFracciones() {
        double[][] matrizAdyacencia = {
            {0, 1.0 / 2.0, 1.0 / 2.0, 0},
            {1.0 / 2.0, 0, 0, 1.0 / 2.0},
            {1.0 / 2.0, 0, 0, 1.0 / 2.0},
            {0, 1.0 / 2.0, 1.0 / 2.0, 0}
        };
        double[] estadoInicial = {1.0, 0, 0, 0};
        double[] estadoFinalResultToCompare1 = {0, 1.0 / 2.0, 1.0 / 2.0, 0};

        double[] estadoFinalResult1 = quantumExperiments.experimentoConMarblesFracciones(matrizAdyacencia, estadoInicial, 1);
        Assert.assertArrayEquals(estadoFinalResultToCompare1, estadoFinalResult1, 0);

        double[] estadoFinalResultToCompare2 = {1.0 / 2.0, 0, 0, 1.0 / 2.0};

        double[] estadoFinalResult2 = quantumExperiments.experimentoConMarblesFracciones(matrizAdyacencia, estadoInicial, 2);
        Assert.assertArrayEquals(estadoFinalResultToCompare2, estadoFinalResult2, 0);

    }

    public void testExperimentoConFotonesComplejos() {
        Complex[][] matrizAdyacencia = {
            {new Complex(1.0 / Math.sqrt(2), 0), new Complex(1.0 / Math.sqrt(2), 0), new Complex(0, 0)},
            {new Complex(0, -1.0 / Math.sqrt(2)), new Complex(0, 1.0 / Math.sqrt(2)), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(0, 0), new Complex(0, 1)}
        };
        Complex[] estadoInicial = {
            new Complex(1.0 / Math.sqrt(3), 0),
            new Complex(0, 2.0 / Math.sqrt(15)),
            new Complex(Math.sqrt(2.0 / 5.0), 0)
        };
        Complex[] estadoFinalResultToCompare1 = {
            new Complex(Math.sqrt(5) / Math.sqrt(30), 2.0 / Math.sqrt(30)),
            new Complex(-2.0 / Math.sqrt(30), -Math.sqrt(5) / Math.sqrt(30)),
            new Complex(0, Math.sqrt(2.0 / 5.0))
        };
        Complex[] estadoFinalResult1 = quantumExperiments.experimentoConFotonesComplejos(matrizAdyacencia, estadoInicial, 1);
        assertFalse(basic.equalsV(estadoFinalResultToCompare1, estadoFinalResult1));

    }

    public void testExperimentoMultirendijasBalas() {
        double[][] probabilidades = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1.0 / 3.0, 0, 0, 0, 0, 0, 0},
            {0, 1.0 / 3.0, 0, 0, 0, 0, 0, 0},
            {0, 1.0 / 3.0, 1.0 / 3.0, 0, 0, 0, 0, 0},
            {0, 0, 1.0 / 3.0, 0, 0, 0, 0, 0},
            {0, 0, 1.0 / 3.0, 0, 0, 0, 0, 0}
        };
        double[][] matrizToCompare = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1.0 / 6.0, 1.0 / 3.0, 0, 1.0, 0, 0, 0, 0},
            {1.0 / 6.0, 1.0 / 3.0, 0, 0, 1.0, 0, 0, 0},
            {1.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0, 0, 0, 1.0, 0, 0},
            {1.0 / 6.0, 0, 1.0 / 3.0, 0, 0, 0, 1.0, 0},
            {1.0 / 6.0, 0, 1.0 / 3.0, 0, 0, 0, 0, 1.0}
        };
        double[] vectorToCompare = {0, 0, 0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 3.0, 1.0 / 6.0, 1.0 / 6.0};
        String matrizToCompareS = "[";
        for (int i = 0; i < matrizToCompare.length; i++) {
            if (i + 1 == matrizToCompare.length) {
                matrizToCompareS += Arrays.toString(matrizToCompare[i]) + "]";
            } else {
                matrizToCompareS += Arrays.toString(matrizToCompare[i]) + ", ";
            }
        }
        String[] matrizVector = quantumExperiments.experimentoMultirendijasBalas(2, 5, probabilidades);
        assertTrue(matrizToCompareS.equals(matrizVector[0]));
        assertTrue(Arrays.toString(vectorToCompare).equals(matrizVector[1]));

    }

    public void testExperimentoMultirendijasFotones() {
        Complex[][] probabilidades = {
            {new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(-1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(-1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new Complex(-1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(0, 0), new Complex(-1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(0, 0), new Complex(1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)}
        };
        Complex[][] matrizToCompare = {
            {new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(-1.0 / Math.sqrt(12), 1.0 / Math.sqrt(12)), new Complex(-1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(1, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(-1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)), new Complex(-1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(1, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(0, 0), new Complex(1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new Complex(-1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(1, 0), new Complex(0, 0), new Complex(0, 0)},
            {new Complex(-1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)), new Complex(0, 0), new Complex(-1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(1, 0), new Complex(0, 0)},
            {new Complex(1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)), new Complex(0, 0), new Complex(1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(0, 0), new Complex(1, 0)}
        };
        Complex[] vectorToCompare = {
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(0, 0),
            new Complex(-1.0 / Math.sqrt(12), 1.0 / Math.sqrt(12)),
            new Complex(-1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)),
            new Complex(0, 0),
            new Complex(-1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)),
            new Complex(1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12))
        };
        String matrizToCompareS = "[";
        for (int i = 0; i < matrizToCompare.length; i++) {
            for (int j = 0; j < matrizToCompare[0].length; j++) {
                if (i + 1 == matrizToCompare.length) {
                    matrizToCompareS += matrizToCompare[i][j].prettyPrintFormaNormalNumeroComplejo();
                } else {
                    matrizToCompareS += matrizToCompare[i][j].prettyPrintFormaNormalNumeroComplejo() + ", ";
                }
            }
            matrizToCompareS += "]";
        }
        String vectorToCompareS = "{";
        for (int i = 0; i < vectorToCompare.length; i++) {
            if (i + 1 == vectorToCompare.length) {
                vectorToCompareS += vectorToCompare[i].prettyPrintFormaNormalNumeroComplejo();
            } else {
                vectorToCompareS += vectorToCompare[i].prettyPrintFormaNormalNumeroComplejo() + ", ";
            }
        }
        vectorToCompareS = "}";
        String interferencias = "interferencias: [5,0] ";
        String[] matrizVector = quantumExperiments.experimentoMultirendijasFotones(2, 5, probabilidades);
        assertTrue(matrizToCompareS.equals(matrizVector[0]));
        assertTrue(vectorToCompareS.equals(matrizVector[1]));
        assertTrue(interferencias.equals(matrizVector[2]));
        System.out.println(matrizVector[2]);

    }

}
